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
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String code = req.getParameter("code");
        Integer prodCode;
        try {
            prodCode = Integer.parseInt(code);
        } catch (NumberFormatException e) {
            System.out.println("Error converting product code");
            return;
        }
        
        
        String path = req.getServletContext().getRealPath("/WEB-INF") + "/products.txt";
        ArrayList<XeDap> xds = XeDapIO.read(path);

        for(int i = 0; i < xds.size(); i++){
            if (xds.get(i).getCode().equals(prodCode)){
                xds.remove(i);
            }
        }
        
        XeDapIO.writeAll(xds, path);
        
        String url = "/action_success.jsp";
        
        ServletContext sc = req.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

}
