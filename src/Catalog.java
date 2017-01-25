// Thelma Andrews,CSC526,Homework1 (Catalog)
import java.util.*;
/**
 *This Catalog class represents all the items available to be purchased putting them into a list.
 */

public class Catalog implements Iterable<Item>{
    // Its saves the catalog storename
    String myStoreName;
    // Its saves the Catalog Items into the Stack List
    List<Item> mycatalogItems=new Stack<Item>();
    // constructor saves storename into defined variable
    public Catalog(String storeName){
        myStoreName=storeName;
    }
    // It performs the addition operation by adding the items to the list
    public void add(Item item){
        mycatalogItems.add(item);
    }
    // get item from List matched with passed item name
    public Item getItem(String name){
        Item item=null;
        for(Item listitem : mycatalogItems){
            if(listitem.itemname.equalsIgnoreCase(name)){ item=listitem; }
        }
        return item;
    }
    // returns name of catalog store name
    public String getStoreName(){
        return myStoreName;
    }

    //  Using iterator we gets all items from the List
    @Override
    public Iterator<Item> iterator(){
        return (mycatalogItems.iterator());
    }
}
