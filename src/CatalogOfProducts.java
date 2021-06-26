import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatalogOfProducts {
    List<Product> products;

    public CatalogOfProducts() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean add(Product product){
        return this.products.add(product);
    }

    public String[] readPurchase(Purchase purchase, Date date){
        String[] description = purchase.getDescription().split("\\s");
        Product product = findProductInList(description);
        //if(product==null)return "Product does not exist in the list of products";
        return product.productInfo(description[2],date);
    }

    public Product findProductInList(String[] description){
        for(Product product:products){
            if(description[0].toLowerCase().equals(product.getName().toLowerCase())||
                    description[0].toLowerCase().equals(product.getName().toLowerCase()+"s")||
                    description[0].toLowerCase().equals(product.getName().toLowerCase()+"ies")){
                return product;
            }
        }
        return null;
    }
}
