// Thelma Andrews,CSC526,Homework1 (ShoppingCart)
import javax.swing.*;
import java.util.*;

/**
 * This ShoppingCart class contains users all purchased items
 */
public class ShoppingCart implements Iterable<Purchase>{
    // This saves the purchased items
    List<Purchase> shoppingCartItems=new Stack<Purchase>();
    // It tests the cart discounts
    boolean cartDiscount=false;
    // Discount percentage is applicable when 10 items or multiple of 10 items are purchased
    public static int getDiscountPercentage(){ return 10; }
    // Discount quantity is applicable when more than or 20 items of quantities
    public static int getDiscountQuantity(){
        return 10;
    }
    // Empty the class constructor
    public ShoppingCart(){}
    // It saves purchased items into the Stack List
    public void add(Purchase purchase){
        boolean isItemExist=false;
        if(shoppingCartItems!=null){
            for(Purchase cartItem : shoppingCartItems){
                if(cartItem.purchaseItem.itemname.equalsIgnoreCase(purchase.purchaseItem.itemname)){
                    cartItem.updateQuantity(purchase.purchaseQuantity);
                    isItemExist = true;
                    break;
                }
            }
            if(isItemExist==false){
                shoppingCartItems.add(purchase);
            }
        }
    }
    // clears the ShoppingCart, this time no items are in the List
    public void clearAll(){
        shoppingCartItems.clear();
    }
    // calculate the total amount of cart
    public double getTotal(){
        double cartTotal=0.00;
        if(shoppingCartItems!=null && shoppingCartItems.size()!=0){
            for(Purchase cartItem : shoppingCartItems){
                cartTotal=(cartTotal+cartItem.getPrice());
            }
        }
        if(cartDiscount==true){
            cartTotal=(cartTotal-((10*cartTotal)/100));
        }
        return cartTotal;
    }
    // it sets false for the first time
    public boolean hasDiscount(){
        return false;
    }
    // when user checks for the discount, it will be applicable
    public void setDiscount(boolean value){
        if(value==false){
            cartDiscount=false;
        }else if(totalQuantity()>=20 || shoppingCartItems.size()>=10){
            cartDiscount=true;
        }else{
            JOptionPane.showMessageDialog (null, "Discount apply to Shopping Cart when buy more than or equal to 10 items or quantity of all items more than or equal to 20", "Title", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // calculate all item quantities in the cart
    public int totalQuantity(){
        int cartAllItemQuantities=0;
        if(shoppingCartItems!=null){
            for (Purchase cartItem : shoppingCartItems){
                cartAllItemQuantities=(cartAllItemQuantities+cartItem.getQuantity());
            }
        }
        return cartAllItemQuantities;
    }
    // get all the items from the List using iterator
    @Override
    public Iterator<Purchase> iterator(){
        return (shoppingCartItems.iterator());
    }
}
