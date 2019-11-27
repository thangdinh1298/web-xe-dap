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
public class ParseProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String desc = req.getParameter("description");
        String price = req.getParameter("price");
        String yearManufactured = req.getParameter("yearManufactured");
        String imgLink = req.getParameter("imgLink");
        
        Integer prodCode = null;
        Integer prodYearManufactured = null;
        Float prodPrice = 0f;
        
        
        String msg1 = "";
        String msg2 = "";
        String msg3 = "";
        String msg4 = "";
        String msg5 = "";
        String url;
       
        XeDap xd = new XeDap();
        
        if (code.equals("")) {
            msg1 = "Please fill out the product code";
        } else {
            try {
                prodCode = Integer.parseInt(code);
                xd.setCode(prodCode);
            } catch (NumberFormatException e) {
                msg1 = "Product code is not a valid Integer";
            }
        }
        
        if (desc.equals("")){
            msg2 = "Please fill out the description";
        } else {
            xd.setDes(desc);
        }
        
        if (price.equals("")){
            msg3 = "Please fill out the price";
        } else {
            try {
            prodPrice = Float.parseFloat(price);
            xd.setPrice(prodPrice);
            } catch (NumberFormatException e) {
                msg3 = "Price is not a valid float";
            }
        }
        
        if (yearManufactured.equals("") ){
            msg4 = "Please fill out the year manufactured";
        } else {
            try {
                prodYearManufactured = Integer.parseInt(yearManufactured);
                xd.setYearManufactured(prodYearManufactured);
            } catch (NumberFormatException e) {
                msg4 = "Year Manufactured is not a valid integer";
            }
        }
        
        if (imgLink.equals("")) {
            msg5 = "Please fill out the year manufactured";
        } else{
            xd.setImgLink(imgLink);
        }
        
        if (msg1 != "" || msg2 != "" || msg3 != "" || msg4 != "" || msg5 != ""){
            url = "/admin/add_product_page.jsp";
        } else {
            xd = new XeDap(prodCode, desc, prodYearManufactured, prodPrice);
            xd.setImgLink("img/" + imgLink);
            url = "/AddProductServlet";
            System.out.println("-------------------");
            System.out.println("In fowarding to add prod servlet");
            System.out.println("-------------------");
        }
        
        req.setAttribute("msg1", msg1);
        req.setAttribute("msg2", msg2);
        req.setAttribute("msg3", msg3);
        req.setAttribute("msg4", msg4);
        req.setAttribute("msg5", msg5);
        req.setAttribute("xd", xd);
        
        ServletContext sc = req.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
