package jms;

import ejb.BookServiceBean;
import entity.Book;
import util.XMLUtil;

import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.jms.*;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/BookQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class bookmessageBean implements MessageListener {

    @Inject
    private BookServiceBean service;

    @Override
    public void onMessage(Message message) {

        try {
            String idStr = message.getBody(String.class);
            int id = Integer.parseInt(idStr);

            Book b = service.getBook(id);

            String xml = xml_uill.convertToXML(b);

            System.out.println("Generated XML:");
            System.out.println(xml);

            // You can send back response via another queue if needed

        } catch (JMSException | NumberFormatException e) {
        }
    }
}