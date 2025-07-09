import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int choice;
    static Scanner scanner = new Scanner(System.in);
   static ArrayList<User> users;
   static ArrayList<Room> rooms;
    static void save() throws FileNotFoundException {
        ObjectOutputStream save = null;
        try {
            save = new ObjectOutputStream(new FileOutputStream("users.txt"));
            save.writeObject(users);
            save.close();
        } catch (IOException e) {
        }
        try {
            save = new ObjectOutputStream(new FileOutputStream("rooms.txt"));
            save.writeObject(rooms);
            save.close();
        } catch (IOException e) {
        }

    }
    static void load() throws FileNotFoundException
    {
        ObjectInputStream load = null;
        try {
            load = new ObjectInputStream(new FileInputStream("users.txt"));
            users = (ArrayList<User>) load.readObject();
            load.close();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
        try {
            load = new ObjectInputStream(new FileInputStream("rooms.txt"));
            rooms = (ArrayList<Room>) load.readObject();
            load.close();
        } catch (IOException | ClassNotFoundException e) {
            initRooms();
        }

    }
    static void book(User user)
    {
        String payment = null;
        System.out.println("1 - Standard " +"\n"+"2 - Deluxe"+"\n"+"3 - Suite");
        System.out.print("choose a room categorization : ");
        choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("1 - cash " +"\n"+"2 - visa");
        System.out.print("payment :  ");
        int choice1 = scanner.nextInt();
        scanner.nextLine();
        switch (choice1)
        {
            case 1 :
                payment = "cash";
                break;
            case 2 :
                payment = "visa";
                break;
        }
        switch (choice)
        {
            case 1 :
                user.book(rooms,"standard",payment);
                break;
            case 2:
                user.book(rooms,"Deluxe",payment);
                break;
            case 3:
                user.book(rooms,"Suite",payment);
        }
    }
    static void initRooms() {
        rooms = new ArrayList<>();
        for (int i = 0; i < 5; i++) rooms.add(new Room("standard", i));
        for (int i = 5; i < 10; i++) rooms.add(new Room("Deluxe", i));
        for (int i = 10; i < 15; i++) rooms.add(new Room("Suite", i));
    }

    public static void main(String[] args) throws FileNotFoundException {
        load();
        while (true) {
            System.out.println("1 - new user " + "\n" + "2 - current user ");
            System.out.print("enter a choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("enter your username : ");
                    String name = scanner.nextLine();
                    users.add(new User(name));
                    break;
                case 2:
                    boolean found = false;
                    System.out.print("enter your username : ");
                    name = scanner.nextLine();
                    for (User user : users)
                        if (name.equals(user.getName())) {
                            found = true;
                            System.out.println("1 - make a reservation " + "\n" + "2 - cancel a reservation" + "\n" + "3 - view reservations");
                            System.out.print("enter a choice : ");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1:
                                    book(user);
                                    save();
                                    break;
                                case 2:
                                    System.out.print("enter your reservation id : ");
                                    int id = scanner.nextInt();
                                    user.cancel(id);
                                    save();
                                    break;
                                case 3:
                                    user.print();

                            }
                        }
                    if (!found)
                        System.out.println("user not found !");
            }
        }
    }
}