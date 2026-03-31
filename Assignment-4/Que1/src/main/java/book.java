package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    private int id;

    private String title;
    private String author;
    private double price;

    // Getters & Setters
}