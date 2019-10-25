/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thang
 */
public class XeDapIO {
    public static void append(XeDap xd, String path){
        File file = new File(path);
        BufferedWriter os = null;
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(XeDapIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            os = new BufferedWriter(new OutputStreamWriter(
                   new FileOutputStream(file, true)));
            
            os.write(xd.toString());
            os.newLine();
            os.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XeDapIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XeDapIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(XeDapIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
//    public static void 
    
    public static ArrayList<XeDap> read(String path){
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        ArrayList<XeDap> xds = new ArrayList<>();
        BufferedReader is = null;
        try {
            is = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file)));
            String line;
            while((line = is.readLine()) != null) {
                String[] attributes = line.split("\\|");
                try{
                   XeDap xedap = new XeDap(Integer.parseInt(attributes[0]), attributes[1],
                        Integer.parseInt(attributes[2]), Float.parseFloat(attributes[3]));
                System.out.println(xedap.toString());
                xds.add(xedap);
                } catch (Exception e ) {
                    System.out.println(e.getMessage());
                }
                
            }
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XeDapIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XeDapIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ex) {
                Logger.getLogger(XeDapIO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xds;
        }
    }
    
    public static void main(String[] args) {
        String[] parts = "12 | thang dinh | 1021 | 12.02".split("\\|");
        for (String part: parts) {
            System.out.println(part);
        }
    }
}
