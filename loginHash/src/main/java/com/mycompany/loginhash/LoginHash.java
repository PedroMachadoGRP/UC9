/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginhash;

import com.mycompany.loginhash.dao.UserDAO;
import com.mycompany.loginhash.database.ConnectionSQL;
import com.mycompany.loginhash.model.User;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class LoginHash {

    public static void main(String[] args) {
        ConnectionSQL.conectar();
        
        User usuario = new User("JuninGRP@mail","0123456789");
        UserDAO usuarioDAO = new UserDAO();
        
        
        usuarioDAO.validarLogin(usuario);
        System.out.println(usuarioDAO.buscarUsuarioPorEmail("JuninGRP@mail").getEmail());
    }
}
