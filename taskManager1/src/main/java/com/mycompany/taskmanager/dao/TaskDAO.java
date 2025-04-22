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
     public boolean RegisterTask(Task task){
        String sql = "INSERT INTO tasks (title,description,expiration_date,status) VALUES(?,?,?,?)";
        
        try(Connection conn = ConnectionSQL.conect()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3,task.getExpireted_data());
            stmt.setString(4,task.getStatus());
            stmt.executeUpdate();
            return true;
        }catch(SQLException error){
            error.printStackTrace();
            return false;
        }
    }
   public boolean deleteTask(int id){
    String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = ConnectionSQL.conect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
            
        } 
}
