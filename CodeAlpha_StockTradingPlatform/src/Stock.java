import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Stock implements Serializable {
    private String name;
    private ArrayList<Float> prices = new ArrayList<>();

    public Stock(String name,float price) {
        this.name = name;
        this.prices.add(price);
    }

    public ArrayList<Float> getPrices() {
        return prices;
    }
    public void updateprice(float price)
    {
        prices.add(price);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name : " +  name + "  prices : " + prices;
    }
}
