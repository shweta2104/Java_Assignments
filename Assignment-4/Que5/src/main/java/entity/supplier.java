@Stateless
public class MallFacade {

    @PersistenceContext
    private EntityManager em;

    public void addItem(Item i) {
        em.persist(i);
    }

    public void updateItem(Item i) {
        em.merge(i);
    }

    public void deleteItem(int id) {
        Item i = em.find(Item.class, id);
        em.remove(i);
    }

    public List<Item> getItems() {
        return em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }
}