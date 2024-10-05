import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

public class Ticket {
    // Ticket attributes
    String row;
    int seat;
    int price;
    Person person;

    // Constructor to initialize ticket attributes
    Ticket(String row, int seat, int price, Person person) {
        // Initialize ticket attributes
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String getRow() {  // Getter methods for ticket attributes

        return row;
    }
    public int getSeat() {  // Getter methods for ticket attributes

        return seat;
    }
    public int getPrice() {  // Getter methods for ticket attributes
        return price;
    }

    public Person getPerson() {  // Getter methods for ticket attributes
        return person;
    }
    public void setRow (String row){    // Setter methods for ticket attributes
        this.row = row;
    }
    public void setSeat ( int seat){    // Setter methods for ticket attributes
        this.seat = seat;
    }
    public void setPrice ( int price){    // Setter methods for ticket attributes
        this.price = price;
    }
    public void setPerson (Person person){    // Setter methods for ticket attributes
        this.person = person;
    }
    public void print_ticket_info () {  // Method to print ticket information

        System.out.println(person);
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " +"£"+ price);

    }

    public void save() {    // Method to save ticket information to a file
        try {
            FileWriter writer = new FileWriter(row + seat + " .txt");
            writer.append(String.format("Row: %s\nSeat: %d\nPrice:£ %d\nName: %s\nSurname: %s\nEmail: %s", row, seat, price, person.getName(), person.getSurname(), person.getEmail()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


