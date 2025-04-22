/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.database;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class CreateTable {
 
    private static void createtable(){
    String sql = "CREATE TABLE IF NOT EXISTS tasks("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title VARCHAR(100) NOT NULL,"
                + "description TEXT NOT NULL,"
                + "expiration_date DATE,"
                + "status ENUM('pendente', 'concluido') DEFAULT 'pendente')";
    
    try(Statement stmt = connection.createStatement()){
    stmt.execute(sql);
    
   }catch(SQLException e){
    throw new RuntimeException("Erro ao criar a tabela", e);

}
    
    }
   

        
    

}
    

