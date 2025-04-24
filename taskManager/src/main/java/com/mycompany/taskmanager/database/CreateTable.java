/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class CreateTable {
     public static void createTable(Connection connection){
    String sql = "CREATE TABLE IF NOT EXISTS tasks("
                + "id int AUTO_INCREMENT PRIMARY KEY ,"
                + "title VARCHAR(100) NOT NULL,"
                + "description TEXT ,"
                + "expiration_date DATE,"
                + "status VARCHAR(100) DEFAULT 'pending')";
    
    try(Statement stmt = connection.createStatement()){
    stmt.execute(sql);
    
   }catch(SQLException e){
    throw new RuntimeException("Erron in table creation"+ e.getMessage());

}
    
    }




      public static void createTableUser(Connection connection){
         String sql = "CREATE TABLE IF NOT EXISTS user("
                + "id_User int AUTO_INCREMENT PRIMARY KEY ,"
                + "name VARCHAR(100) NOT NULL,"
                + "email VARCHAR(100) NOT NULL ,"
                + "password VARCHAR(250) NOT NULL )";
         
          try(Statement stmt = connection.createStatement()){
    stmt.execute(sql);
    
   }catch(SQLException e){
        throw new RuntimeException("Erron in table creation"+ e.getMessage());
   }
   
 
     }
     
}
