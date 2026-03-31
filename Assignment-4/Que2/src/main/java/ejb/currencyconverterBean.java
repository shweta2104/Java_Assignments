package ejb;

import entity.CurrencyRate;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class CurrencyConverterBean {

    @PersistenceContext(unitName = "currencyPU")
    private EntityManager em;

    public double convert(String from, String to, double amount) {

        try {
            TypedQuery<CurrencyRate> query = em.createQuery(
                "SELECT c FROM CurrencyRate c WHERE c.from_currency = :f AND c.to_currency = :t",
                CurrencyRate.class
            );

            query.setParameter("f", from);
            query.setParameter("t", to);

            CurrencyRate rate = query.getSingleResult();

            return amount * rate.getRate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}