import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatalogOfProducts {
    List<Product> products;

    /**
     * Constructor for the class
     */
    public CatalogOfProducts() {
        this.products = new ArrayList<>();
    }

    /**
     *
     * @return - return the list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     *
     * @param products - set a new list of products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Add a product to the list
     * @param product - the product
     * @return true if the product is added successfully
     */
    public boolean add(Product product){
        return this.products.add(product);
    }

    /**
     * Read the purchase description
     * @param purchase - the product description
     * @param date - the date of the created cart
     * @return - return an array of strings containing the product description -
     * description of the purchase,
     * the price of the purchase,
     * discount of the purchase
     */
    public String[] readPurchase(Purchase purchase, Date date){
        String[] description = purchase.getDescription().split("\\s");  //Receive the purchase description as string, split it by space
        Product product = findProductInList(description);                       //Find the product in the product list if available
        return product.productInfo(description[2],date);
    }

    /**
     * Find the product in the list of products by its name
     * @param description - an array containing the purchase name
     * @return - the object of the product if it is available
     *          else - null
     */
    public Product findProductInList(String[] description){
        for(Product product:products){          //Go through all products(objects) in the list
            if(description[0].toLowerCase().equals(product.getName().toLowerCase())||
                    description[0].toLowerCase().equals(product.getName().toLowerCase()+"s")||
                    description[0].toLowerCase().equals(product.getName().toLowerCase()+"ies")){
                return product;
            }
        }
        return null;
    }
}
