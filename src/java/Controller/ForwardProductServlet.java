/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.XeDap;
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
public class ForwardProductServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String code = request.getParameter("code");
        String desc = request.getParameter("description");
        String price = request.getParameter("price");
        String yearManufactured = request.getParameter("yearManufactured");
        String imgLink = request.getParameter("imgLink");
        String url = request.getParameter("url");
        
        XeDap xd = new XeDap(Integer.parseInt(code), desc,
                    Integer.parseInt(yearManufactured), Float.parseFloat(price));
        xd.setImgLink(imgLink);
        
        request.setAttribute("xd", xd);
        
//        String url = "/add_product_page.jsp";
        
        ServletContext sc = request.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }

}
