// Thelma Andrews,CSC526,Homework1 (DiscountedItem)
/**
 * This DiscountedItem class comes into account,if we want to buy in bulk.
 * This class represents discounts to the items purchased in bulk quantity
 */
public class DiscountedItem extends Item{
    // saves item bulkprice
    double itemBulkPrice;
    // saves item bulkquantity
    private int itemBulkQuantity;

    // constructor saves item quantity and price to the defined variables
    public DiscountedItem(String name,double price,int bulkquantity,double bulkprice){
        itemBulkQuantity=bulkquantity;
        itemBulkPrice=bulkprice;
        super.itemname=name;
        super.itemprice=price;
    }
    // priceFor is to calculate the total price of item with passed qty and item price
    @Override
    public double priceFor(int quantity){
        if(quantity>=itemBulkQuantity){
            int bulkQty=(quantity/itemBulkQuantity);
            int qty=(quantity%itemBulkQuantity);
            return ((bulkQty*itemBulkPrice)+(qty*super.itemprice));
        }else{
            return (super.itemprice*quantity);
        }
    }
    // print the string format to display the text on ShoppingCart GUI
    public String toString(){
        return (super.itemname+", $"+String.format("%.2f",super.itemprice)+" ("+itemBulkQuantity+" for $"+itemBulkPrice+")");
    }
}
