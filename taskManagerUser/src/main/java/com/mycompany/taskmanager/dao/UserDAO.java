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
}
