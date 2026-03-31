package utill;


public class xml_uill {

    public static String convertToXML(book b) {

        return "<book>" +
                "<id>" + b.getId() + "</id>" +
                "<title>" + b.getTitle() + "</title>" +
                "<author>" + b.getAuthor() + "</author>" +
                "<price>" + b.getPrice() + "</price>" +
               "</book>";
    }
}