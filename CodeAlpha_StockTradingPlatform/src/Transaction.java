import java.io.Serializable;

public class Transaction implements Serializable {
    float share,price;
    Stock stock;


    public Transaction(float share, Stock stock,float price) {
        this.share = share;
        this.stock = stock;
        this.price = price;
    }

    public float getShare() {
        return share;
    }

    public Stock getStock() {
        return stock;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "stock name : " + stock.getName() +"\n" + "stock price paid : "+ price +"\n" + "shares bought : "+share;
    }
}
