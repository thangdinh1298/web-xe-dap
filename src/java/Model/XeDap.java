package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thang
 */
public class XeDap {
    private int code;
    private String des;
    private int yearManufactured;
    private float price; //USD

    public XeDap() {
    }

    public XeDap(int code, String des, int yearManufactured, float price) {
        this.code = code;
        this.des = des;
        this.yearManufactured = yearManufactured;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(int yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getCode() + "|" + this.getDes() + "|" 
               + this.getYearManufactured()+ "|" + this.getPrice();
    }
    
    
    
}
