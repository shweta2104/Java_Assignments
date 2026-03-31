package jms;

import jakarta.annotation.Resource;
import jakarta.jms.*;
import jakarta.ejb.Stateless;

@Stateless
public class jmsproducer {

    @Resource(lookup = "jms/BookQueue")
    private Queue queue;

    @Resource(lookup = "jms/ConnectionFactory")
    private ConnectionFactory factory;

    public void sendMessage(int bookId) {

        try (JMSContext context = factory.createContext()) {
            context.createProducer().send(queue, String.valueOf(bookId));
        }
    }
}