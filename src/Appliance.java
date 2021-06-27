import java.util.Calendar;
import java.util.Date;

public class Appliance extends Product implements Discount{

    private String model;
    private Date date;
    private double weight;

    public Appliance(String name, String brand, double price, String model, Date date, double weight) {
        super(name, brand, price);
        this.model = model;
        this.date = date;
        this.weight = weight;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String[] productInfo(String quantity, Date date) {
        String[] information = new String[3];

        information[0] = this.toString(quantity);
        information[1] = String.valueOf(estimatePrice(quantity));
        information[2] = String.valueOf(discount(null,date,Double.parseDouble(information[1])));
        if(!information[2].equals("0.0")){
            if(Math.round(Double.parseDouble(information[1])*0.05*100.0)/100.0==Double.parseDouble(information[2])){
                information[0] = information[0]+"#discount 5%  -$"+information[2]+"\n";
            }
        }
        return information;
    }
    @Override
    public String toString(String quantity) {
        int numProducts = Integer.parseInt(quantity);
        return this.getName()+" "+this.getBrand()+" "+this.getModel()+"\n"
                +numProducts+" x $" +this.getPrice() +" = $"+estimatePrice(quantity)+"\n";
    }

    @Override
    public double discount(Date thisDate, Date providedDate, double price) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(providedDate);
        if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            return Math.round(price*0.05*100.0)/100.0;
        }
        return 0.0;
    }

}
