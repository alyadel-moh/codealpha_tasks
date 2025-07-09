import java.io.Serializable;

public class Booking implements Serializable {
    private String payment;
    private Room room;
    private  int bookingno;

    public Booking(int bookingno, String payment, Room room) {
        this.bookingno = bookingno;
        this.payment = payment;
        this.room = room;
    }

    public String getPayment() {
        return payment;
    }

    public int getBookingno() {
        return bookingno;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingno=" + bookingno +
                ", payment='" + payment + '\'' +
                ", room=" + room +
                '}';
    }
}
