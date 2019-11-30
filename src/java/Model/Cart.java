/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author thang
 */
public class Cart {
    ArrayList<XeDap> productList;
    ArrayList<Integer> quantity;

    public Cart() {
        this.productList = new ArrayList<>();
        this.quantity =  new ArrayList<>();
    }
    
    public void addItemToCart(XeDap prod, Integer quant){
        System.out.println("Already has it");
        if (quant <= 0) return;
        if (prod.getCode() == null) return; //product has no code, can't check
        int index = hasItemInCart(prod.getCode());
        //if currently in the cart, aggregate the quantity
        if (index != -1){
            
            Integer oldQuant = this.quantity.get(index);
            this.quantity.set(index, oldQuant + quant);
        } else{
            this.productList.add(prod);
            this.quantity.add(quant);  
        }
    }
    
    public void deleteItemFromCart(XeDap prod){
        if (prod.getCode() == null) return; //product has no code, can't check
        int prodCode = prod.getCode();
        int index = hasItemInCart(prodCode);
        //if not in the cart, return immediately
        if (index == -1) return;
        else{
            this.productList.remove(index);
            this.quantity.remove(index);
        }
    }
    
    private int hasItemInCart(Integer code){
        for (int i = 0; i < productList.size(); i++){
            if (productList.get(i).getCode() == code) return i;   
        }
        return -1;
    }

    public ArrayList<XeDap> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<XeDap> productList) {
        this.productList = productList;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }
    
    public double getTotal(){
        double total = 0;
        for(int i = 0; i < productList.size(); i++){
            total += productList.get(i).getPrice() * quantity.get(i);
        }
        return total;
    }
}
