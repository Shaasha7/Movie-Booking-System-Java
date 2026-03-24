# Movie-Booking-System-Java
To design and implement a Movie Ticket Booking System using Java that allows users  to view available movie shows and book tickets. The program demonstrates Object Oriented Programming concepts such as inheritance and Java collection  framework (HashMap). 
🎬 Movie Ticket Booking System using Java

A simple and interactive Movie Ticket Booking System built using Java, demonstrating Object-Oriented Programming (OOP) and Collections (HashMap) concepts.

🚀 Features
🎥 View available movie shows
🎟️ Book tickets for selected shows
📉 Real-time seat availability update
👤 Customer-based booking system
⚡ Fast show lookup using HashMap
📋 Menu-driven console interface
🛠️ Technologies Used
Java
OOP Concepts (Inheritance)
Collections Framework (HashMap)
Scanner (User Input Handling)
📌 How It Works
Predefined movie shows are stored in a HashMap
User selects an option from the menu
User can:
View all available shows
Book tickets by entering show ID
System checks seat availability
Seats are reduced after successful booking
Program runs until user exits
📂 Project Structure
📁 Project Folder
 ┗ 📄 MovieTicketBooking.java
▶️ How to Run
javac MovieTicketBooking.java
java MovieTicketBooking
💻 Source Code
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
<img width="1916" height="752" alt="Screenshot 2026-03-12 142858" src="https://github.com/user-attachments/assets/79303acd-114c-4bd9-b6a4-c40f1275f2ce" />
<img width="1913" height="803" alt="Screenshot 2026-03-12 142956" src="https://github.com/user-attachments/assets/d10e0df1-379c-4252-8a1e-78592c2004a8" />
<img width="1907" height="802" alt="Screenshot 2026-03-12 143019" src="https://github.com/user-attachments/assets/d6801c2f-7f92-43fe-a41d-139b4dbbd60c" />

📊 Sample Output
===== Movie Ticket Booking =====
1. View Shows
2. Book Ticket
3. Exit

Show ID: 1 | Movie: Avengers | Available Seats: 50
Show ID: 2 | Movie: SpiderMan | Available Seats: 40

Enter your name: Shalini
Enter Show ID: 1
Enter number of seats: 2

Booking Successful!
🎯 Learning Outcomes
Understanding HashMap for data storage
Applying OOP concepts (Inheritance)
Building menu-driven applications
Managing real-time data updates
Handling user input effectively
🙌 Conclusion

This project demonstrates how Java can be used to build a simple movie ticket booking system with real-time seat management and structured program design.
