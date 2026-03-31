package ejb;

import entity.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class BookServiceBean {

    @PersistenceContext(unitName = "bookPU")
    private EntityManager em;

    public Book getBook(int id) {
        return em.find(Book.class, id);
    }
}