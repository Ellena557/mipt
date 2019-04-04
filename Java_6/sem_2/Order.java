package shop;
import java.util.Date;

public class Order {
    private final int id;
    private final Date date;
    private final double price;
    private final double amount;
    public final double sum;

    //конструктор, 2 способа
    //public Order(Order o) {
      //  this.(o.getId(), o.getDate(), o.getPrice(), o.getAmount(), o.getSum());
    //}

    public Order(int id, Date date, double price, double amount, double sum) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.amount = amount;
        this.sum = sum = price * amount;;
    }

    public void printinfo(){
        System.out.println(id + " " + date + " " + price);
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public double getSum() {
        return sum;
    }
}
