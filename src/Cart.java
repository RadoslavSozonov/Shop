import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Purchase> list;

    public Cart(){
        list = new ArrayList<>();
    }

    public boolean add(Purchase purchase){
        return list.add(purchase);
    }

    public List<Purchase> getList() {
        return list;
    }

    public void setList(List<Purchase> list) {
        this.list = list;
    }
}
