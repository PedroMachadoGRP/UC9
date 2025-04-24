/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class UserDAO {
    public boolean registerUser(User user){
        
        String sql = "INSERT INTO user (name,emai,password) VALUES (?,?,?)";
        
        String cryPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
        
        try(Connection conn = ConnectionSQL.conect()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, cryPassword);
            stmt.executeUpdate();
            return true;
        }catch(SQLException error){
            error.printStackTrace();
            return false;
        }
    }

    
     public boolean deleteUser(String email) {
        String sql = "DELETE FROM user WHERE email = ?";
        try (Connection conn = ConnectionSQL.conect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean UpdateUser(String email,String newName,String newPassword, String newEmail){
        String sql = "UPDATE user SET name = ?, password = ?, email = ? WHERE email = ?";
        String cryPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        
        try(Connection con = ConnectionSQL.conect()){
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, newName);
            stmt.setString(2,cryPassword);
            stmt.setString(3, newEmail);
            stmt.setString(4, email);
            return stmt.executeUpdate() > 0;
        }catch(SQLException error){
            error.printStackTrace();
            return false;
        }
    }
     public static ArrayList<User> listUser() {
          ArrayList<User> users = new ArrayList<>();
    String sql = "SELECT email FROM users ORDER BY email ASC";

    try (Connection conn = ConnectionSQL.conect(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            User user = new User(rs.getString("name"), rs.getString("email")); // senha não exibida
            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;


    
}
