/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.XeDap;
import Model.XeDapDB;
import Model.XeDapIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        XeDap xd = (XeDap) req.getAttribute("xd");
        
        XeDapDB.insertProduct(xd);
        
        String url = "/action_success.jsp";
        
        ServletContext sc = req.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        XeDap xd = (XeDap) req.getAttribute("xd");
        
        XeDapDB.updateProduct(xd);
        
        String url = "/action_success.jsp";
        
        ServletContext sc = req.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    
}
