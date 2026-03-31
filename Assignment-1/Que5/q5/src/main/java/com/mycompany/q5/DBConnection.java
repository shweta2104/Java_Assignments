/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q5;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author root
 */
public class DBConnection {
   private static final String URL =
        "jdbc:mysql://localhost:3306/retail_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully");
            return con;
        } catch (Exception e) {
            System.out.println("❌ Database connection failed");
            e.printStackTrace();
            return null;
        }
    }
}
