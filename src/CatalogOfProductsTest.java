import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CatalogOfProductsTest {

    CatalogOfProducts catalog = new CatalogOfProducts();
    Product apple = new Food("apples","BrandA",1.50, Date.valueOf("2021-06-14"));
    Product milk = new Beverage("milk","BrandM",0.99,Date.valueOf("2022-02-02"));
    Product clothes = new Clothes("T-shirt","BrandT",15.99,"M","violet");
    Product laptop = new Appliance("laptop","BrandL",2345,"ModelL",Date.valueOf("2021-03-03"),1.125);

    Purchase purchase1 = new Purchase("Apples x 2.45 kg");
    Purchase purchase2 = new Purchase("Cocos x 3 bottles");
    Purchase purchase3 = new Purchase("T-shirts x 2");
    Purchase purchase4 = new Purchase("Laptop x 1");

    @BeforeEach
    public void setUp(){
        catalog.add(apple);
        catalog.add(milk);
        catalog.add(clothes);
        catalog.add(laptop);
    }

    @Test
    public void testReadPurchase(){
        String str = "apples - BrandA\n" +
                "2.45 x $1.5 = $3.68\n" +
                "#discount 50%  -$1.84\n";
        String[] productInfoActual = catalog.readPurchase(purchase1,Date.valueOf("2021-06-14"));
        assertEquals(str,productInfoActual[0]);
        assertEquals("3.68",productInfoActual[1]);
        assertEquals("1.84",productInfoActual[2]);
    }

    @Test
    public void testFindProductInListEquals(){
        assertEquals(apple,catalog.findProductInList(purchase1.getDescription().split("\\s")));
    }

    @Test
    public void testFindProductInListNotEquals(){
        assertNotEquals(milk,catalog.findProductInList(purchase1.getDescription().split("\\s")));
    }

    @Test
    public void testFindProductNull(){
        assertNull(catalog.findProductInList(purchase2.getDescription().split("\\s")));
    }

}