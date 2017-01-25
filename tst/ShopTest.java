import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.*;

public class ShopTest {
    @Test
    public void TestCases(){
        Item testitem=new Item("Computer Science pen",3.40);
        Item testdiscounteditem=new DiscountedItem("Silly Putty",3.95,10,19.99);
        assertEquals("Computer Science pen", testitem.getName());
        assertEquals("Computer Science pen, $"+String.format("%.2f",testitem.itemprice), testitem.toString());
        assertEquals("31.84", String.format("%.2f",testdiscounteditem.priceFor(13)));
        Catalog mycatalog=new Catalog("Shopping");
        mycatalog.add(testitem);
        mycatalog.add(testdiscounteditem);
        assertSame(testdiscounteditem,mycatalog.getItem("Silly Putty"));
        assertNotSame(testitem,mycatalog.getItem("Mario Computer Science Party"));
        Item testitem1=new Item("Bottle o' Bubbles",0.99);
        Purchase purchase=new Purchase(testitem1,0);
        assertTrue(purchase.isEmpty());
        purchase=new Purchase(testitem,6);
        assertEquals(6, purchase.getQuantity());
        purchase=new Purchase(testdiscounteditem,12);
        assertEquals("27.89", String.format("%.2f",purchase.getPrice()));
        purchase.updateQuantity(16);
        assertEquals("43.69", String.format("%.2f",purchase.getPrice()));
        ShoppingCart myShoppingCart=new ShoppingCart();
        purchase=new Purchase(testitem,6);
        myShoppingCart.add(purchase);
        purchase=new Purchase(testdiscounteditem,12);
        myShoppingCart.add(purchase);
        purchase=new Purchase(testitem1,12);
        myShoppingCart.add(purchase);
        assertEquals("60.17", String.format("%.2f",myShoppingCart.getTotal()));
        assertFalse(myShoppingCart.hasDiscount());
        purchase=new Purchase(testitem,12);
        myShoppingCart.add(purchase);
        myShoppingCart.setDiscount(true);
        assertEquals("72.51", String.format("%.2f",myShoppingCart.getTotal()));
        assertEquals(36,myShoppingCart.totalQuantity());
    }
}
