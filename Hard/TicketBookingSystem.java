import java.util.*;

class TicketBookingSystem {
    private int availableSeats;

    public TicketBookingSystem(int seats) {
        this.availableSeats = seats;
    }

    public synchronized boolean bookTicket(String name, int seats) {
        if (seats <= availableSeats) {
            System.out.println(name + " booked " + seats + " seat(s).");
            availableSeats -= seats;
            return true;
        } else {
            System.out.println(name + " booking failed. Not enough seats.");
            return false;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String user;
    private int seats;

    public BookingThread(TicketBookingSystem system, String user, int seats, int priority) {
        this.system = system;
        this.user = user;
        this.seats = seats;
        setPriority(priority);
    }

    public void run() {
        system.bookTicket(user, seats);
    }
}

public class TicketBookingMain {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10); // Total available seats

        BookingThread vip1 = new BookingThread(system, "VIP User 1", 2, Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(system, "VIP User 2", 3, Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(system, "Regular User 1", 4, Thread.NORM_PRIORITY);
        BookingThread regular2 = new BookingThread(system, "Regular User 2", 2, Thread.NORM_PRIORITY);
        BookingThread late = new BookingThread(system, "Late User", 3, Thread.MIN_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        late.start();
    }
}
