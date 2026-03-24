import java.util.*; 
class Show { 
protected String movieName; 
protected int totalSeats; 
protected int availableSeats; 
public Show(String movieName, int totalSeats) { 
this.movieName = movieName; 
this.totalSeats = totalSeats; 
this.availableSeats = totalSeats; 
} 
    public void displayShow() { 
        System.out.println("Movie: " + movieName +  
                           " | Available Seats: " + availableSeats); 
    } 
 
    public boolean bookSeats(int seats) { 
        if (seats <= availableSeats) { 
            availableSeats -= seats; 
            return true; 
        } 
        return false; 
    } 
} 
 
class Customer extends Show { 
 
    String customerName; 
 
    public Customer(String name, String movieName, int totalSeats) { 
        super(movieName, totalSeats); 
        this.customerName = name; 
    } 
 
    public void bookTicket(int seats) { 
        if (bookSeats(seats)) { 
            System.out.println(customerName + 
            " successfully booked " + seats + " ticket(s) for " + movieName); 
        } else { 
            System.out.println("Sorry! Not enough seats available."); 
        } 
    } 
} 
 
public class MovieTicketBooking { 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        HashMap<Integer, Show> shows = new HashMap<>(); 
 
        shows.put(1, new Show("Avengers", 50)); 
        shows.put(2, new Show("SpiderMan", 40)); 
        shows.put(3, new Show("Batman", 30)); 
 
        while (true) { 
 
            System.out.println("\n===== Movie Ticket Booking ====="); 
            System.out.println("1. View Shows"); 
            System.out.println("2. Book Ticket"); 
            System.out.println("3. Exit"); 
 
            System.out.print("Enter choice: "); 
            int choice = sc.nextInt(); 
 
            switch (choice) { 
 
                case 1: 
                    for (Map.Entry<Integer, Show> entry : shows.entrySet()) { 
                        System.out.print("Show ID: " + entry.getKey() + " | "); 
                        entry.getValue().displayShow(); 
                    } 
                    break; 
 
                case 2: 
                    System.out.print("Enter your name: "); 
                    sc.nextLine(); 
                    String name = sc.nextLine(); 
 
                    System.out.print("Enter Show ID: "); 
                    int id = sc.nextInt(); 
 
                    if (!shows.containsKey(id)) { 
                        System.out.println("Invalid Show ID"); 
                        break; 
                    } 
 
                    System.out.print("Enter number of seats: "); 
                    int seats = sc.nextInt(); 
 
                    Show selectedShow = shows.get(id); 
 
                    Customer customer = new Customer( 
                            name, 
                            selectedShow.movieName, 
                            selectedShow.availableSeats 
                    ); 
 
                    if (selectedShow.bookSeats(seats)) { 
                        System.out.println("Booking Successful!"); 
                    } else { 
                        System.out.println("Seats not available!"); 
                    } 
                    break; 
 
                case 3: 
                    System.out.println("Thank you for using Movie Booking System"); 
                    return; 
 
                default: 
                    System.out.println("Invalid Choice"); 
            } 
        } 
    } 
}