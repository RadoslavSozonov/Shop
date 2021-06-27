import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {


    @Test
    public void testPrintReceipt(){
        CatalogOfProducts catalog = new CatalogOfProducts();
        Product apple = new Food("apples","BrandA",1.50,Date.valueOf("2021-06-14"));
        Product milk = new Beverage("milk","BrandM",0.99,Date.valueOf("2022-02-02"));
        Product clothes = new Clothes("T-shirt","BrandT",15.99,"M","violet");
        Product laptop = new Appliance("laptop","BrandL",2345,"ModelL",Date.valueOf("2021-03-03"),1.125);
        catalog.add(apple);
        catalog.add(milk);
        catalog.add(clothes);
        catalog.add(laptop);
        Cart cart = new Cart();
        Purchase purchase1 = new Purchase("Apples x 2.45 kg");
        Purchase purchase2 = new Purchase("Milk x 3 bottles");
        Purchase purchase3 = new Purchase("T-shirts x 2");
        Purchase purchase4 = new Purchase("Laptop x 1");
        cart.add(purchase1);
        cart.add(purchase2);
        cart.add(purchase3);
        cart.add(purchase4);
        Cashier cashier = new Cashier(catalog);
        cashier.printReceipt(cart,Date.valueOf("2021-06-14"),Time.valueOf("12:34:56"));
    }

    @Test
    public void testBeginningOfReceipt(){
        Cashier cashier = new Cashier(new CatalogOfProducts());
        cashier.beginningOfReceipt(Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()));
    }

    @Test
    public void testBodyOfReceipt(){
        CatalogOfProducts catalog = new CatalogOfProducts();
        Product apple = new Food("apples","BrandA",1.50,Date.valueOf("2021-06-14"));
        Product milk = new Beverage("milk","BrandM",0.99,Date.valueOf("2022-02-02"));
        Product clothes = new Clothes("T-shirt","BrandT",15.99,"M","violet");
        Product laptop = new Appliance("laptop","BrandL",2345,"ModelL",Date.valueOf("2021-03-03"),1.125);
        catalog.add(apple);
        catalog.add(milk);
        catalog.add(clothes);
        catalog.add(laptop);
        Cart cart = new Cart();
        Purchase purchase1 = new Purchase("Apples x 2.45 kg");
        Purchase purchase2 = new Purchase("Milk x 3 bottles");
        Purchase purchase3 = new Purchase("T-shirts x 2");
        Purchase purchase4 = new Purchase("Laptop x 1");
        cart.add(purchase1);
        cart.add(purchase2);
        cart.add(purchase3);
        cart.add(purchase4);
        Cashier cashier = new Cashier(catalog);
        cashier.bodyOfReceipt(cart,Date.valueOf("2021-06-14"));
    }

    @Test
    public void testEndOfReceipt(){
        Cashier cashier = new Cashier(new CatalogOfProducts());
        cashier.endOfReceipt(6,4);
    }

}