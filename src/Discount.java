import java.util.Date;

public interface Discount {
    public double discount(Date thisDate,Date providedDate, double price);
}
