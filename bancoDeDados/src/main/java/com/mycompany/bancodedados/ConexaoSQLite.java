/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class ConexaoSQLite {
    public Connection conectar(){
        //Criamos a variavel que recebe a conexão (é nula pois ainda não nos conectamos)
        Connection conexao = null;
        // A variavel url recebe o caminho para o banco de dados
        
        String url = "jdbc:sqlite:usuarios.db";
        
        //Tente se conectar
        try{
            //A classe DriverManager tem o método getConnection, que faz a conexão
            //e armazenamos isso dentro de variavel 'conexao'
            //Isso cria nosso banco, se ele não existir, ou se conecta com ele
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com SQLite estabelecida!");
        }catch(SQLException e){
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        //Se não conseguir, capture a excessão e me mostre
        return conexao;
    }
    
    public void desconectar(Connection conexao){
        try{
            if(conexao != null){
                conexao.close();
                System.out.println("Conexão fechada.");
            }
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
