import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User implements Serializable {
    private String name;
    private float balance;
    private ArrayList<Transaction> transactions;
    public User(float balance, String name) {
        this.balance = balance;
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public float getBalance() {
        return balance;
    }

    public void buy(Stock stock, float share)
    {
        if(balance >= share * stock.getPrices().getLast())
        {
            transactions.add(new Transaction(share,stock,stock.getPrices().getLast()));
            balance -= share * stock.getPrices().getLast();
            System.out.println("you current balance is : "+ balance);
        }
        else
            System.out.println("balance is not enough !");
    }
    public void sell(Transaction transaction)
    {
        balance += transaction.getStock().getPrices().getLast() * transaction.getShare();
        transactions.remove(transaction);
        System.out.println("you current balance is : "+ balance);
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
    public void viewprotfolio(ArrayList<Transaction> transactions,ArrayList<Stock> stocks)
    {
        for(Transaction transaction: transactions)
            for(Stock stock : stocks)
                if(stock.getName().equals(transaction.getStock().getName()))
            {
                System.out.println("stock name : " +transaction.getStock().getName());
                System.out.println("shares bought : " + transaction.getShare());
                System.out.println("stock price paid : " + transaction.getPrice());
                System.out.println("stock price now : "+transaction.getStock().getPrices().getLast());
                System.out.println();
            }
    }
}
