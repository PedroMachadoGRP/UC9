/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class TaskDAO {

    public boolean RegisterTask(Task task) {
        String sql = "INSERT INTO tasks (title,description,expiration_date,status) VALUES(?,?,?,?)";

        try (Connection conn = ConnectionSQL.conect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getExpireted_data());
            stmt.setString(4, task.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    public boolean deleteTask(int id) {
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

    public boolean updateTask(int id, String newTitle, String newDescription, String newExpireted_data, String newStatus) {
        String sql = "UPDATE tasks SET title = ?, description = ?, expiration_date = ?, status = ? Where id = ?  ";
        try (Connection con = ConnectionSQL.conect()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, newTitle);
            stmt.setString(2, newDescription);
            stmt.setString(3, newExpireted_data);
            stmt.setString(4, newStatus);
            stmt.setInt(5, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException error) {

            error.printStackTrace();
            return false;

        }
    }

    public boolean updateStatus(int id, String newStatus) {
        String sql = "UPDATE tasks SET status = ? where id = ?";
        try (Connection con = ConnectionSQL.conect()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, newStatus);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Task> listTask() {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT id, title,description,expiration_date,status FROM tasks ORDER BY status ASC ";

        try (Connection conn = ConnectionSQL.conect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getString("expiration_date"), rs.getString("status"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
