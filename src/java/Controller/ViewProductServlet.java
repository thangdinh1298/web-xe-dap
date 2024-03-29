/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.XeDap;
import Model.XeDapDB;
import Model.XeDapIO;
import java.io.File;
import java.io.IOException;
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
public class ViewProductServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<XeDap> products = /*XeDapIO.read(path);*/ XeDapDB.read();
        for(XeDap product: products){
            System.out.println(product);
        }
        
        String url;

        req.setAttribute("products", products);
        url = (String) req.getParameter("url");
        
        ServletContext sc = req.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
    