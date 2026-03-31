@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @EJB
    CartBean cart;

    @EJB
    ProductBean productBean;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Product p = productBean.find(id);
        cart.addToCart(p);

        res.getWriter().println("Total: " + cart.getTotal());
    }
}