import java.util.Date;

public abstract class PerishableProduct extends Product implements Discount{
    private Date date;

    public PerishableProduct(String name, String brand, double price, Date date) {
        super(name, brand, price);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    @Override
//    public abstract String toString(String quantity);
//
//    public abstract String[] productInfo(String quantity, Date date);


    public String[] productInfo(String quantity, Date date) {
        String[] information = new String[3];

        information[0] = this.toString(quantity);
        information[1] = String.valueOf(estimatePrice(quantity));
        information[2] = String.valueOf(discount(this.getDate(),date,Double.parseDouble(information[1])));
        if(!information[2].equals("0.0")){
            if(Math.round(Double.parseDouble(information[1])*0.1*100.0)/100.0==Double.parseDouble(information[2])){
                information[0] = information[0]+"#discount 10%  -$"+information[2]+"\n";
            }
            else if(Math.round(Double.parseDouble(information[1])*0.5*100.0)/100.0==Double.parseDouble(information[2])){
                information[0] = information[0]+"#discount 50%  -$"+information[2]+"\n";
            }

        }
        return information;
    }

    @Override
    protected String toString(String quantity) {
        double weight = Double.parseDouble(quantity);
        return this.getName()+" - "+this.getBrand()+"\n"
                +weight+" x $" +this.getPrice() +" = $"+estimatePrice(quantity)+"\n";
    }

    @Override
    public double discount(Date thisDate, Date providedDate, double price) {
        if(thisDate.equals(providedDate)){
            return Math.round(price*0.5*100.0)/100.0;
        }
        if (Math.abs(thisDate.getDay() - providedDate.getDay()) > 5) {
            return Math.round(price*0.1*100.0)/100.0;
        }
        return 0.0;
    }

}
