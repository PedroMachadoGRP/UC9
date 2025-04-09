/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliomvc2;



import com.mycompany.bibliomvc2.dao.BooksDAO;
import com.mycompany.bibliomvc2.database.ConnectSQLite;
import com.mycompany.bibliomvc2.database.CreateTables;
import com.mycompany.bibliomvc2.model.Book;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class Bibliomvc {

    public static void main(String[] args) {
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
        Book myBook = new Book("Livro bom","Autor Bom",100.00,1829);
        
        CreateTables.createTables(connection);
        BooksDAO.addBook(myBook);
        //BooksDAO.updateBook(connection, 2, "Livro muito bom", "Seu pai", 2050, 4500);
        //BooksDAO.deleteBook(connection, 1);
//        String[] info = BooksDAO.findBook(connection, 2);
//        String[] info2 = BooksDAO.findBook(connection, 3);
//        
//        System.out.println(info[0] +"  "+ info[1]+"  " + info[2]+ " "+info[3]);
//        System.out.println(info2[0] +"  "+ info2[1]+"  " + info2[2]+ " "+info2[3]);
//        ArrayList<Book> infoBooks = BooksDAO.findBooks();
//        
//        for(Book book: infoBooks){
//            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice() + " " + book.getYear());
//        }
    }
}
