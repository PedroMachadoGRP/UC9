/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.model;

/**
 *
 * @author PEDROMACHADODASILVA
 */
public class Task {
    private int id;
    private String title;
    private String description;
    private int expireted_data;
    private String status;

    public Task(String title, String description, int expireted_data, String status) {
        this.title = title;
        this.description = description;
        this.expireted_data = expireted_data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExpireted_data() {
        return expireted_data;
    }

    public void setExpireted_data(int expireted_data) {
        this.expireted_data = expireted_data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
