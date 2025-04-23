/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanager;

import com.mycompany.taskmanager.controller.TaskController;
import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.view.MainView;

import java.util.ArrayList;



/**
 *
 * @author PEDROMACHADODASILVA
 */
public class TaskManager {

    public static void main(String[] args) {
        new MainView().setVisible(true);
    }
}
