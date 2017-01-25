// Thelma Andrews,CSC526,Homework1 (Purchase)
/**
 * This Purchase class represents the items available for the user to purchase
 */
public class Purchase {
    // It saves item information
    Item purchaseItem;
    // It saves item quantity
    int purchaseQuantity;
    // constructor to do saves purchase data into defined variables
    public Purchase(Item item,int quantity){
        purchaseItem=item;
        purchaseQuantity=quantity;
    }
    // calculates the total item price
    public double getPrice(){
        return (purchaseItem.priceFor(purchaseQuantity));
    }
    // returns the quantity of the purchase item
    public int getQuantity(){
        return purchaseQuantity;
    }
    // To test the purchase item quantity is equal to zero or not
    public boolean isEmpty(){
        boolean isQuantityZero=false;
        if(purchaseQuantity==0){
            isQuantityZero=true;
        }
        return isQuantityZero;
    }
    public boolean matches(Purchase purchase){
        return true;
    }
    // updates purchase items quantity
    public void updateQuantity(int quantity){
        purchaseQuantity=quantity;
    }
}
