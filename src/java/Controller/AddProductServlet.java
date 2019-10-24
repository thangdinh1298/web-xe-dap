/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thang
 */
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String desc = req.getParameter("description");
        String price = req.getParameter("price");
        String yearManufactured = req.getParameter("yearManufactured");
        
        String msg1 = "";
        String msg2 = "";
        String msg3 = "";
        String msg4 = "";
        String url;
        
        if (code == ""){
            msg1 = "Please fill out the product code";
        } else {
            try {
                Integer.parseInt(code);
            } catch (NumberFormatException e) {
                msg1 = "Product code is not a valid Integer";
            }
        }
        
        if (desc == ""){
            msg2 = "Please fill out the description";
        } 
        
        if (price == ""){
            msg3 = "Please fill out the price";
        } else {
            try {
                Float.parseFloat(price);
            } catch (NumberFormatException e) {
                msg3 = "Price is not a valid float";
            }
        }
        
        if (yearManufactured == ""){
            msg4 = "Please fill out the year manufactured";
        } else {
            try {
                Integer.parseInt(yearManufactured);
            } catch (NumberFormatException e) {
                msg4 = "Year Manufactured is not a valid integer";
            }
        }
        
        if (msg1 != "" || msg2 != "" || msg3 != "" || msg4 != ""){
            url = "/add_product_page.jsp";
        } else {
            url = "index.jsp";
        }
        
        req.setAttribute("msg1", msg1);
        req.setAttribute("msg2", msg2);
        req.setAttribute("msg3", msg3);
        req.setAttribute("msg4", msg4);
        
        ServletContext sc = req.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

}
