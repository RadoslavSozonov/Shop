import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Purchase> list;

    /**
     * Constructor of the class
     */
    public Cart(){
        list = new ArrayList<>();
    }

    /**
     * Add a new purchase to the list
     * @param purchase - the new purchase
     * @return - true if the purchase is added successfully
     */
    public boolean add(Purchase purchase){
        return list.add(purchase);
    }

    /**
     * Get all purchases
     * @return - all purchases
     */
    public List<Purchase> getList() {
        return list;
    }

    /**
     * Set a new list of purchases
     * @param list - list of purchases
     */
    public void setList(List<Purchase> list) {
        this.list = list;
    }
}
