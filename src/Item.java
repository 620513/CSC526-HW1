// Thelma Andrews,CSC526,Homework1 (Item)
/**
 * This Item class saves the item information
 */
public class Item {
    // saves the item name
    String itemname;
    // saves the  item price
    double itemprice;
    // class constructor
    public Item(){}
    // constructor is used to save the item data into defined variables
    public Item(String name,double price){
        itemname=name;
        itemprice=price;
    }
    // returns item name
    public String getName(){
        return itemname;
    }
    // calculates  item total, item price with passed quantity and item price
    public double priceFor(int quantity){
        return (itemprice*quantity);
    }
    // prints the string format to display the text on ShoppingCart GUI
    public String toString(){
        return (itemname+", $"+String.format("%.2f",itemprice));
    }
}
