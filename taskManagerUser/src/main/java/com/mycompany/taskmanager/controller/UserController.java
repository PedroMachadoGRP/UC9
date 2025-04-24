/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class UserController {

     public static ArrayList<User> listarUsuarios( DefaultTableModel model){
       ArrayList<User> users = UserDAO.listUser();
       model.setColumnCount(0);
       for (User user : users){
       model.addRow(new Object[]{ user.getId(), user.getEmail()});
       }
         return null;
    }
        public static void deleteUser(String stringID) {
        UserDAO userDAO = new UserDAO();
        int id = Integer.parseInt(stringID);
 
        
        userDAO.deleteUser(id);
    
}
