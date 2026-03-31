@Entity
public class Item {

    @Id @GeneratedValue
    private int id;

    private String name;
    private double price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Supplier supplier;
}