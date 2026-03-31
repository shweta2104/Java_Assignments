/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

/**
 *
 * @author HP
 */
public class student_servlet {
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
}
