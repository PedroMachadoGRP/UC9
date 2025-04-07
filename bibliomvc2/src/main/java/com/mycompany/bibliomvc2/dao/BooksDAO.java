/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliomvc2.dao;

import com.mycompany.bibliomvc2.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class BooksDAO {
    public static void addBook(Book myBook, Connection con){
    
        String sql = "INSERT INTO books (title,author,price,year) VALUES (?,?,?,?)";
        try(PreparedStatement pstmt =   con.prepareStatement(sql)){
            pstmt.setString(1, myBook.getTitle());
            pstmt.setString(2, myBook.getAuthor());
            pstmt.setDouble(3, myBook.getPrice());
            pstmt.setInt(4, myBook.getYear());
            pstmt.executeUpdate();
            System.out.println("Book added to database");
            
        }catch(SQLException error){
            System.out.println("Error: " + error.getMessage());
        }
    }
    
    public static void updateBook(Connection con, int id, String newTitle, String newAuthor, double newPrice, int newYear)
    
    {
        String sql = "UPDATE books SET   title = ?, author = ?, price = ?, year = ? WHERE id = ?";
        
        try(PreparedStatement pstmt =   con.prepareStatement(sql)){
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newAuthor);
            pstmt.setDouble(3, newPrice);
            pstmt.setInt(4, newYear);
            pstmt.setInt(5, id);
                    
            
            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0){
            System.out.println("Book succefully updated");
            }else{
                System.out.println("ID not found. Please select a valid ID.");
            }
            
            
        }catch(SQLException error){
            System.out.println("Error: " + error.getMessage());
        }
        
        
    }
    public static void deleteBook(Connection con, int id){
        String sql = "DELETE  FROM books WHERE id = ?";
        
        try(PreparedStatement pstmt =  con.prepareStatement(sql)){
            
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if(rowsDeleted > 0){
                System.out.println("ID found. The book was deleted");
            }else{
                System.out.println("ID not found. Please select a valid id.");
            }
            
        }catch(SQLException error){
            System.out.println("Error: " + error.getMessage());
        }
    }
    
    
    public static String[] findBook(Connection con, int id){
        String sql = "SELECT * FROM books WHERE id = ?";
        String[] info = new String[4];
        
        
        try(PreparedStatement pstmt = con.prepareStatement(sql)){
        
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                info[0] = rs.getString("title");
                info[1] = rs.getString("author");
                info[2] = rs.getString("price");
                info[3] = rs.getString("year");
                
            }
                    
        }catch(SQLException error){
            System.out.println("Erro:" + error.getMessage());
        }
        return info;
    }
}

