/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bancodedados;

import java.sql.Connection;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class BancoDeDados {

    public static void main(String[] args) {
        //Instanciando um objeto da classe ConexaoSQLite
        ConexaoSQLite conectar = new ConexaoSQLite();
        //Chamando o método conectar e armazenando ele para usar depois
        Connection conexao = conectar.conectar();
        CriarTabela.criarTabelaUsuarios(conexao);
//        InserirUsuario.inserirUsuario(conexao,"Pedro","JuninDoCapa@outlook.com");
//    AtualizarUsuario.atualizarUsuarios(conexao, 1, "Liu", "Kang@mail.com");
//  DeletarUsuario.deletarUsuario(conexao, 1);
    System.out.println(ListarUsuarios.listarUsuarios(conexao));
    }
}
