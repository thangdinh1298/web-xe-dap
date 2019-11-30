/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cart;
import Model.XeDap;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thang
 */
public class ShopCartServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String desc = request.getParameter("description");
        String price = request.getParameter("price");
        String yearManufactured = request.getParameter("yearManufactured");
        String imgLink = request.getParameter("imgLink");
        
        XeDap xd = new XeDap(Integer.parseInt(code), desc,
                    Integer.parseInt(yearManufactured), Float.parseFloat(price));
        xd.setImgLink(imgLink);
        
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } 
        System.out.println(xd);
        cart.addItemToCart(xd, 1);
        
        cart = (Cart)session.getAttribute("cart");
        System.out.println("====================");
        System.out.println("Cart has: " + cart.getProductList().size());
        
        String url = "/user/shopping_cart.jsp";
        
        ServletContext sc = request.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
