/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.model.Task;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class TaskController {

    private static TaskDAO taskDAO = new TaskDAO();

    public static boolean registerTask(String title, String description, String expireted_data, String status) {
        Task newTask = new Task(title, description, expireted_data, status);
        
        if(status == "pending" || status == "completed"){
            return taskDAO.RegisterTask(newTask);
        }else{
            JOptionPane.showMessageDialog(null, "the status field must be pending or completed");
            return false;
        }
        
    }

    public static void deleteTask(String stringId) {
        TaskDAO taskDAO = new TaskDAO();
        int id = Integer.parseInt(stringId);
        
        taskDAO.deleteTask(id);
    }

    public static void searchTask(DefaultTableModel modelTable) {
        ArrayList<Task> task1 = TaskDAO.listTask();
        modelTable.setRowCount(0);

        for (Task task : task1) {
            modelTable.addRow(new Object[]{task.getId(), task.getTitle(),task.getDescription(),task.getExpireted_data(),task.getStatus()});
        }
    }
    public static boolean updateTask(int id,String newTitle,String newDescription,String newExpirateDate,String newStatus){
        TaskDAO taskDAO = new TaskDAO();
        
        return taskDAO.updateTask(id, newTitle, newDescription, newExpirateDate, newStatus);
    }
    public static boolean updateStatus(int id,String status){
        if(taskDAO.updateStatus(id, status) == true){
            return taskDAO.updateStatus(id, status);
        }else {
            JOptionPane.showMessageDialog(null, "Failed to update status");
            return false;
        }
    }
}
