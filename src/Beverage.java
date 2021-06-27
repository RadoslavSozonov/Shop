import java.util.Date;

public class Beverage extends PerishableProduct implements Discount{
    public Beverage(String name, String brand, double price, Date date) {
        super(name, brand, price, date);
    }

}
//    public String[] productInfo(String quantity, Date date) {
//        String[] information = new String[3];
//
//        information[0] = this.toString(quantity);
//        information[1] = String.valueOf(estimatePrice(quantity));
//        information[2] = String.valueOf(discount(this.getDate(),date,Double.parseDouble(information[1])));
//        if(!information[2].equals("0.0")){
//            if(Integer.parseInt(information[1])*0.1==Integer.parseInt(information[2])){
//                information[0] = information[0]+"#discount 10%  -$"+information[2];
//            }
//            else if(Integer.parseInt(information[1])*0.5==Integer.parseInt(information[2])){
//                information[0] = information[0]+"#discount 50%  -$"+information[2];
//            }
//
//        }
//        return information;
//    }
//    private double estimatePrice(String quantity){
//        double weight = Double.parseDouble(quantity.substring(1));
//        return weight* this.getPrice();
//    }
//
//    @Override
//    public double discount(Date thisDate,Date providedDate, double price) {
//        if(thisDate.equals(providedDate)){
//            return 0.5*price;
//        }
//        if (Math.abs(thisDate.getDay() - providedDate.getDay()) > 5) {
//            return 0.1*price;
//        }
//        return 0.0;
//    }

//    public String[] productInfo(String quantity, Date date) {
//        String[] information = new String[3];
//
//        information[0] = this.toString(quantity);
//        information[1] = String.valueOf(estimatePrice(quantity));
//        information[2] = String.valueOf(discount(this.getDate(),date,Double.parseDouble(information[1])));
//        if(!information[2].equals("0.0")){
//            if(Math.round(Double.parseDouble(information[1])*0.1*100.0)/100.0==Double.parseDouble(information[2])){
//                information[0] = information[0]+"#discount 10%  -$"+information[2]+"\n";
//            }
//            else if(Math.round(Double.parseDouble(information[1])*0.5*100.0)/100.0==Double.parseDouble(information[2])){
//                information[0] = information[0]+"#discount 50%  -$"+information[2]+"\n";
//            }
//
//        }
//        return information;
//    }
//
//    @Override
//    public String toString(String quantity) {
//        double numProducts = Double.parseDouble(quantity);
//        return this.getName()+" "+this.getBrand()+"\n"
//                +numProducts+" x $" +this.getPrice() +" = $"+super.estimatePrice(quantity)+"\n";
//    }