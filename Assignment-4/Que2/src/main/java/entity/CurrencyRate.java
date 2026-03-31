package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency_rate")
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String from_currency;
    private String to_currency;
    private double rate;

    // Getters and Setters
}