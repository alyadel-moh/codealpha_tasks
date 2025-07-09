import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int choice;
    static ArrayList<Stock> stocks;
    static ArrayList<User> users;
    static String name;

    static void menu2() {
        float share;
        float balance;
        System.out.println("1 - new user " + "\n" + "2 - current user ");
        System.out.print("Enter choice : ");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("enter username : ");
                name = scanner.nextLine();
                System.out.print("enter balance : ");
                balance = scanner.nextFloat();
                users.add(new User(balance, name));
                break;
            case 2:
                boolean found = false;
                System.out.print("enter username : ");
                name = scanner.nextLine();
                for (User user : users)
                    if (name.equals(user.getName())) {
                        System.out.println("your current balance is : "+user.getBalance());
                        found = true;
                        System.out.println("1 - buy" + "\n" + "2 - sell" + "\n" + "3 - view portfolio");
                        System.out.print("Enter choice : ");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                found = false;
                                System.out.print("enter stock name : ");
                                name = scanner.nextLine();
                                for (Stock stock : stocks)
                                    if (name.equals(stock.getName())) {
                                        System.out.print("enter share : ");
                                        share = scanner.nextFloat();
                                        ;
                                        user.buy(stock, share);
                                        found = true;
                                        break;
                                    }
                                if (found == false)
                                    System.out.println("stock not found !");
                                break;
                            case 2:
                                found = false;
                                System.out.print("enter stock name : ");
                                name = scanner.nextLine();
                                for (Transaction transaction : user.getTransactions())
                                    if (name.equals(transaction.getStock().getName())) {
                                        user.sell(transaction);
                                        found = true;
                                        break;
                                    }
                                if (found == false)
                                    System.out.println("transcation not found ! ");
                                break;
                            case 3:
                                user.viewprotfolio(user.getTransactions(),stocks);
                                break;
                        }
                    }
                if (found == false)
                    System.out.println("user not found ! ");

        }

    }

    static void menu1() {
        System.out.println("1 - add stock " + "\n" + "2 - update stock price ");
        System.out.print("Enter choice : ");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("enter stock name : ");
                name = scanner.nextLine();
                System.out.print("enter stock price : ");
                float price = scanner.nextFloat();
                scanner.nextLine();
                stocks.add(new Stock(name, price));
                break;
            case 2:
                boolean found = false;
                System.out.print("enter stock name : ");
                String name = scanner.nextLine();
                for (Stock stock : stocks)
                    if (name.equals(stock.getName())) {
                       found = true;
                        System.out.print("enter new price : ");
                        price = scanner.nextInt();
                        scanner.nextLine();
                        stock.getPrices().add(price);
                    }
                if (found == false)
                    System.out.println("stock " + name + " not found !");
                break;
        }

    }

    static void save() throws FileNotFoundException {
        ObjectOutputStream save = null;
        try {
            save = new ObjectOutputStream(new FileOutputStream("stocks.txt"));
            save.writeObject(stocks);
            save.close();
            save = new ObjectOutputStream(new FileOutputStream("users.txt"));
            save.writeObject(users);
            save.close();
        }catch (IOException e) {
        }
    }
    static void load() throws FileNotFoundException
    {
        ObjectInputStream load = null;
        try {
            load = new ObjectInputStream(new FileInputStream("stocks.txt"));
            stocks = (ArrayList<Stock>) load.readObject();
            load.close();
        } catch (IOException | ClassNotFoundException e) {
            stocks = new ArrayList<>();
        }
        try {
            load = new ObjectInputStream(new FileInputStream("users.txt"));
            users = (ArrayList<User>) load.readObject();
            load.close();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        load();
        while (true) {
            System.out.println("available stocks : ");
            for (Stock stock : stocks)
                System.out.println(stock);
            System.out.println("1 - stock issuer " + "\n" + "2 - user ");
            System.out.print("Enter choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    menu1();
                    save();
                    break;
                case 2:
                    menu2();
                    save();

            }
        }
    }
}