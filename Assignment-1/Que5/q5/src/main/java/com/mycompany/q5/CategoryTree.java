/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q5;

/**
 *
 * @author root
 */
import java.sql.*;

public class CategoryTree {

    static Connection con;

    public static void main(String[] args) {

        con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Database connection failed");
            return;
        }

        try {
            // Start with root categories (parent is NULL)
            PreparedStatement ps = con.prepareStatement(
                "SELECT category_id, category_name FROM Category_Master WHERE parent_category_id IS NULL"
            );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");

                System.out.println(name);
                printChildren(id, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Recursive method
    static void printChildren(int parentId, int level) throws Exception {

        PreparedStatement ps = con.prepareStatement(
            "SELECT category_id, category_name FROM Category_Master WHERE parent_category_id = ?"
        );
        ps.setInt(1, parentId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("category_id");
            String name = rs.getString("category_name");

            // Indentation
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }

            System.out.println(name);

            // Recursive call
            printChildren(id, level + 1);
        }
    }
}

