@Stateless
public class ProductBean {

    @PersistenceContext
    private EntityManager em;

    public Product find(int id) {
        return em.find(Product.class, id);
    }
}