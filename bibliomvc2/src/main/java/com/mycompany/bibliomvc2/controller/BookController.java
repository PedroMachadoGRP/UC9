/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliomvc2.controller;

import com.mycompany.bibliomvc2.dao.BooksDAO;
import com.mycompany.bibliomvc2.model.Book;
import java.util.ArrayList;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class BookController {

    
    private static ArrayList<Book> currentBooks = new ArrayList<>();
    
    public static void addBook(String title, String author, String priceStr, String yearStr) {
        
        double price = Double.parseDouble(priceStr);
        int year = Integer.parseInt(yearStr);
        
        Book myBook = new Book(title, author, price, year);
        
        BooksDAO.addBook(myBook);
        
        
    }
    
    public static void updateBook(int id, String newTitle, String newAuthor, String newPrice, String newYear){
        

        double price = Double.parseDouble(newPrice);
        int year = Integer.parseInt(newYear);
        
        Book myBook = new Book(newTitle, newAuthor, price, year);
        myBook.setId(id);
        
        BooksDAO.updateBook(myBook);
        
    }
    
    public static Book getBookByIndex(int index) {
        if(index >= 0 && index < currentBooks.size()){
            return currentBooks.get(index);
        }
        return null;
    }
    
    public static void deleteBook(String idStr){
        
        int id = Integer.parseInt(idStr);
        
        BooksDAO.deleteBook(id);
        
    }
    
    public static ArrayList<String> loadBooks() {
        ArrayList<String> formattedList = new ArrayList<>();
        
        currentBooks = BooksDAO.findBooks();
        
        for(Book book : currentBooks){
            String details = "ID: " + book.getId()+ " |  "  
                    +"Title: " + book.getTitle() + " | "
                    +"Author: " + book.getAuthor() + " | "
                    +"Price: $" + book.getPrice() + " | "
                    +"Year: " + book.getYear();
            formattedList.add(details);
        }
        return formattedList;
    }
    
    
}
