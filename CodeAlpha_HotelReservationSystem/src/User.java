import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class User implements Serializable {
    private String name;
    private ArrayList<Booking> bookings;
    private static int bookingcounter = 1000;
    public User(String name) {
        this.bookings = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    private static int generateBookingNumber() {
        return bookingcounter++;
    }
    public String getName() {
        return name;
    }
    public void book(ArrayList<Room> rooms,String cateogry,String payment)
    {
        boolean found = false;
        int bookno = generateBookingNumber();
        for (Room room : rooms)
            if(cateogry.equalsIgnoreCase(room.getCategory()) && room.isIsavailable()) {
                Booking booking = new Booking(bookno, payment, room);
                bookings.add(booking);
                room.setIsavailable(false);
                System.out.println("your reservation number : " + booking.getBookingno());
                System.out.println("your room number : " + booking.getRoom().getId());
                found = true;
                break;
            }
                if (!found) {
                    System.out.println("No available rooms in the selected category!");
                }
    }
    public void cancel(int id){
        boolean found = false;
        for(Booking booking : bookings)
        {
            if(booking.getBookingno() == id)
            {
                found = true;
                booking.getRoom().setIsavailable(true);
                System.out.println("reservation removed successfully !");
                bookings.remove(booking);
                break;
            }
        }
        if(!found)
            System.out.println("reservation doesn't exsist !");
    }
   public void print()
   {
       for(Booking booking : bookings)
       {
           System.out.println("reservation number : " +booking.getBookingno());
           System.out.println("Room category : "+booking.getRoom().getCategory());
           System.out.println("Room number : "+booking.getRoom().getId());
           System.out.println("Payment : "+booking.getPayment());
           System.out.println();
       }
   }
}
