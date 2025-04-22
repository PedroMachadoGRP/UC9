/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class TaskDAO {
     public boolean deleteTask(int id){
    String sql = "DELETE FROM tasks WHERE id = ?";
 try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
            
        } 
    
}
