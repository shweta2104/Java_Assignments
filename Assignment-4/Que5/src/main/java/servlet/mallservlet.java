@WebServlet("/item")
public class MallServlet extends HttpServlet {

    @EJB
    MallFacade facade;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");

        // Validation
        if(name == null || name.isEmpty()) {
            res.getWriter().println("Name required!");
            return;
        }

        double price = Double.parseDouble(priceStr);

        Item i = new Item();
        i.setName(name);
        i.setPrice(price);

        facade.addItem(i);

        res.getWriter().println("Item Added!");
    }
}