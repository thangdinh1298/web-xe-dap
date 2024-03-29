/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thang
 */
public class XeDapDB {
    public static ArrayList<XeDap> read(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<XeDap> xds = new ArrayList<>();
        PreparedStatement ps = null;
        
        if (conn != null){
            try {
                String query = "SELECT * FROM XeDap";
                
                ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String des = rs.getString("des");
                    int yearManufactured = rs.getInt("yearManufactured");
                    float price = rs.getFloat("price");
                    int code = rs.getInt("code");
                    String imgLink = rs.getString("img_url");
                    XeDap xd = new XeDap();
                    xd.setDes(des);
                    xd.setYearManufactured(yearManufactured);
                    xd.setPrice(price);
                    xd.setCode(code);
                    xd.setImgLink(imgLink);
                    xds.add(xd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(XeDapDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                pool.freeConnection(conn);
                DBUtil.closePreparedStatement(ps);
            }
        } 
        
        return xds;
    }
    
    public static void deleteProductByCode(int code){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<XeDap> xds = new ArrayList<>();
        PreparedStatement ps = null;
        
        if (conn != null) {
            try {
                String query = "DELETE FROM XeDap WHERE code=?";
                
                ps = conn.prepareStatement(query);
                ps.setInt(1, code);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(XeDapDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                pool.freeConnection(conn);
                DBUtil.closePreparedStatement(ps);
            }
        }
    }
    
    public static void updateProduct(XeDap newProd){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<XeDap> xds = new ArrayList<>();
        PreparedStatement ps = null;
        
        if (conn != null) {
            try {
                String query = "UPDATE XeDap "
                        + "SET des=?, yearManufactured=?, price=?, img_url=?"
                        + "WHERE code=?";
                
                ps = conn.prepareStatement(query);
                ps.setString(1, newProd.getDes());
                ps.setInt(2, newProd.getYearManufactured());
                ps.setFloat(3, newProd.getPrice());
                ps.setString(4, newProd.getImgLink());
                ps.setInt(5, newProd.getCode());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(XeDapDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                pool.freeConnection(conn);
                DBUtil.closePreparedStatement(ps);
            }
        }
    }
    
    public static void insertProduct(XeDap newProd){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<XeDap> xds = new ArrayList<>();
        PreparedStatement ps = null;
        
        if (conn != null) {
            try {
                String query = "INSERT INTO XeDap(code, des, yearManufactured, price, img_url)"
                        + "VALUES(?,?,?,?, ?)";
                
                ps = conn.prepareStatement(query);
                ps.setString(2, newProd.getDes());
                ps.setInt(3, newProd.getYearManufactured());
                ps.setFloat(4, newProd.getPrice());
                ps.setInt(1, newProd.getCode());
                ps.setString(5, newProd.getImgLink());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(XeDapDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                pool.freeConnection(conn);
                DBUtil.closePreparedStatement(ps);
            }
        }
    }
}
