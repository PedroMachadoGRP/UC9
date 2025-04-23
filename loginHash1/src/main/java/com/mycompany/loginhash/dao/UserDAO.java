/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginhash.dao;

import com.mycompany.loginhash.database.ConnectionSQL;
import com.mycompany.loginhash.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class UserDAO {
     public boolean registrarUsuario(User usuario) {
    String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
    String senhaHash = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, usuario.getEmail());
        stmt.setString(2, senhaHash);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
     public boolean validarLogin(User usuario) {
    String sql = "SELECT senha FROM usuarios WHERE usuario = ?";

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, usuario.getEmail());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String senhaHash = rs.getString("senha");
            boolean login = BCrypt.checkpw(usuario.getPassword(), senhaHash);
            System.out.println("Logado com sucesso!");
            return login;
        }   
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }
     public User buscarUsuarioPorEmail(String email) {
    String sql = "SELECT * FROM usuarios WHERE usuario = ?";

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            User usuario = new User(rs.getString("usuario"), rs.getString("senha"));
            usuario.setId(rs.getInt("id"));
            return usuario;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }
    public boolean atualizarSenha(String email, String novaSenha) {
    String sql = "UPDATE usuarios SET senha = ? WHERE usuario = ?";
    String senhaHash = BCrypt.hashpw(novaSenha, BCrypt.gensalt());

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, senhaHash);
        stmt.setString(2, email);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
    public boolean excluirUsuario(String email) {
    String sql = "DELETE FROM usuarios WHERE usuario = ?";

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public ArrayList<User> listarUsuarios() {
    ArrayList<User> usuarios = new ArrayList<>();
    String sql = "SELECT id, usuario FROM usuarios ORDER BY id ASC";

    try (Connection conn = ConnectionSQL.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            User usuario = new User(rs.getInt("id"),rs.getString("usuario")); // senha não exibida
            
            usuarios.add(usuario);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return usuarios;
    }
    
    
}
