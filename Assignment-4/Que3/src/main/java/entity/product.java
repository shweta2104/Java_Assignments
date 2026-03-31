@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private double price;
}