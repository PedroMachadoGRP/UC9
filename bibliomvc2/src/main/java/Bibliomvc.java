/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import com.mycompany.bibliomvc2.dao.BooksDAO;
import com.mycompany.bibliomvc2.database.ConnectSQLite;
import com.mycompany.bibliomvc2.database.CreateTables;
import com.mycompany.bibliomvc2.model.Book;
import java.sql.Connection;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class Bibliomvc {

    public static void main(String[] args) {
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
        //Book myBook = new Book("Livro bom","Autor Bom",100.00,1829);
        
        //CreateTables.createTables(connection);
        //BooksDAO.addBook(myBook, connection);
        //BooksDAO.updateBook(connection, 1, "Livro muito bom", "Seu pai", 2050, 4500);
        //BooksDAO.deleteBook(connection, 1);
        String[] info = BooksDAO.findBook(connection, 2);
        
        System.out.println(info[0] +"  "+ info[1]+"  " + info[2]+ " "+info[3]);
        
    }
}
