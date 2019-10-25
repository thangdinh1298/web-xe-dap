/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.XeDap;
import Model.XeDapIO;
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
        
        Integer prodCode = 0;
        Integer prodYearManufactured = 0;
        Float prodPrice = 0f;
        
        
        String msg1 = "";
        String msg2 = "";
        String msg3 = "";
        String msg4 = "";
        String url;
       
        
        if (code == ""){
            msg1 = "Please fill out the product code";
        } else {
            try {
                prodCode = Integer.parseInt(code);
                req.setAttribute("code", code);
            } catch (NumberFormatException e) {
                msg1 = "Product code is not a valid Integer";
            }
        }
        
        if (desc == ""){
            msg2 = "Please fill out the description";
        } else {
            req.setAttribute("des", desc);
        }
        
        if (price == ""){
            msg3 = "Please fill out the price";
        } else {
            try {
                prodPrice = Float.parseFloat(price);
                req.setAttribute("price", price);
            } catch (NumberFormatException e) {
                msg3 = "Price is not a valid float";
            }
        }
        
        if (yearManufactured == ""){
            msg4 = "Please fill out the year manufactured";
        } else {
            try {
                prodYearManufactured = Integer.parseInt(yearManufactured);
                req.setAttribute("yearManufactured", yearManufactured);
            } catch (NumberFormatException e) {
                msg4 = "Year Manufactured is not a valid integer";
            }
        }
        
        if (msg1 != "" || msg2 != "" || msg3 != "" || msg4 != ""){
            url = "/add_product_page.jsp";
        } else {
            XeDap xd = new XeDap(prodCode, desc, prodYearManufactured, prodPrice);
            String path = req.getServletContext().getRealPath("/WEB-INF") + "/products.txt";
//            System.out.println("Path of file is: " + path);
            XeDapIO.append(xd, path);
            url = "/product_update_success.jsp";
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
