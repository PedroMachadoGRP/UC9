/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliomvc2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class ConnectSQLite {
    public Connection connect(){
        Connection connection = null;
        String url = "jdbc:sqlite:library.db";
        try{
            System.out.println("Succesefully connected to database.");  
            
            connection = DriverManager.getConnection(url);
        }catch(SQLException error){
            
            
            System.out.println("Error: " + error.getMessage());
        }
        return connection;
    }
    
    public void disconnect(Connection connection){
    if(connection != null){
        
        try{
            connection.close();
            System.out.println("Connection closed.");  
        }catch(SQLException error){
         System.out.println("Error: " + error.getMessage());
        }
        
    }else{
        System.out.println("Connection not found.");
    }
  }
}
