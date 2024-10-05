
import java.util.Scanner;
public class W2051741_PlaneManagement {
    //Static arrays to represent seating rows
    static int[] row_a = {0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
    static int[] row_b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] row_c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] row_d = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static String[] rows = {"A", "B", "C", "D", "a", "b", "c", "d"};

    // Array to store ticket information
    static Ticket[] info = new Ticket[100];
    static int count = 0;
    private static boolean exit = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            menu(); // Display menu options
            System.out.println("Please select an option: ");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an number: ");
                sc.next();
            }
            int option = sc.nextInt();
            while (true) {
                if (option == 1) {
                    buy_seat(); // Option 1: Buy a seat
                    break;
                } else if (option == 2) {
                    cancel_seat(); // Option 2: Cancel a seat
                    break;
                } else if (option == 3) {
                    find_first_available(); // Option 3: Find first available seat
                    break;
                } else if (option == 4) {
                    show_seat_plan(); // Option 4: Show seating plan
                    break;
                } else if (option == 5) {
                    print_ticket_information_and_total_sales(); //Option 5: print ticket information
                    break;
                } else if (option == 6) {
                    search_ticket();  // Option 6: Search for a ticket
                    break;
                } else if (option == 0) {
                    quit = true;  // Option 0: Quit the program
                    System.out.println(" ");
                    System.out.println("Thank You Come Again!");
                    break;
                } else {
                    System.out.println("Your Entered number is in out of range!Please Try Again");
                    break;
                }
            }
        }
    }

    public static void buy_seat() { // Method to buy a seat
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a row letter: ");
            String row_letter = sc.next();
            while (!row_letter.matches("[a-dA-D]")) {
                System.out.println("Invalid Input!Enter a row letter: ");
                row_letter = sc.next();
            }
            while (true) {
                System.out.println("Enter a seat number: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Please Enter a number: ");
                    sc.next();
                }
                int seat_num = sc.nextInt();
                int price = 0;
                // Determine ticket price based on seat number
                if (seat_num < 6 && seat_num > 0) {
                    price = 200;
                } else if (seat_num >= 6 && seat_num < 10) {
                    price = 150;

                } else if (seat_num >= 10 && seat_num < 15) {
                    price = 180;
                }
                if (seat_num <= 14 && seat_num >= 1 && (row_letter.equals("A") || row_letter.equals("a"))) {
                    // Seat boking process for row A
                    if (row_a[seat_num - 1] == 0) {
                        row_a[seat_num - 1] = 1;
                        System.out.println("Your seat Successfully Booked!");
                        System.out.println("Your Booked " + row_letter.toUpperCase() + " Row " + seat_num + " Seat");
                        System.out.println("Enter your name: ");
                        String name = sc.next();
                        System.out.println("Enter Your Surname: ");
                        String surname = sc.next();
                        String email = null;
                        while (true) {
                            System.out.println("Enter Your E-mail: ");
                            email = sc.next();
                            boolean isValidEmail = email != null && email.contains("@") && email.contains(".");
                            if (isValidEmail) {
                                break;
                            } else {
                                System.out.println("Email is invalid!Try Again.");
                            }
                        }
                        Person p1 = new Person(name, surname, email);
                        Ticket t1 = new Ticket(row_letter, seat_num, price, p1);
                        info[count] = t1;
                        count++;
                        System.out.println(" ");
                        exit = true;
                        t1.save();
                        break;
                    } else {
                        System.out.println("Seat has alreay Booked!Please Enter Another Seat Number");
                    }
                } else if (seat_num <= 14 && seat_num >= 1 && (row_letter.equals("D") || row_letter.equals("d"))) {
                    // Seat booking process for row D
                    if (row_d[seat_num - 1] == 0) {
                        row_a[seat_num - 1] = 1;
                        System.out.println("Your seat Successfully Booked!");
                        System.out.println("Your Booked " + row_letter.toUpperCase() + " Row " + seat_num + " Seat");
                        System.out.println("Enter Your Name: ");
                        String name = sc.next();
                        System.out.println("Enter Your Surname: ");
                        String surname = sc.next();
                        String email = null;
                        while (true) {
                            System.out.println("Enter Your E-mail: ");
                            email = sc.next();
                            boolean isValidEmail = email != null && email.contains("@") && email.contains(".");
                            if (isValidEmail) {
                                break;
                            } else {
                                System.out.println("Email is invalid!Try Again.");
                            }
                        }
                        Person p1 = new Person(name, surname, email);
                        Ticket t1 = new Ticket(row_letter, seat_num, price, p1);
                        info[count] = t1;
                        count++;
                        System.out.println(" ");
                        exit = true;
                        t1.save();
                        break;
                    } else {
                        System.out.println("Seat has alreay Booked!Please Enter Another Seat Number");
                    }
                } else if (seat_num <= 12 && seat_num >= 1 && (row_letter.equals("B") || row_letter.equals("b"))) {
                    // Seat booking process for row B
                    if (row_b[seat_num - 1] == 0) {
                        row_b[seat_num - 1] = 1;
                        System.out.println("Your seat Successfully Booked!");
                        System.out.println("Your Booked " + row_letter.toUpperCase() + " Row " + seat_num + " Seat");
                        System.out.println("Enter Your Name: ");
                        String name = sc.next();
                        System.out.println("Enter Your Surname: ");
                        String surname = sc.next();
                        String email = null;
                        while (true) {
                            System.out.println("Enter Your E-mail: ");
                            email = sc.next();
                            boolean isValidEmail = email != null && email.contains("@") && email.contains(".");
                            if (isValidEmail) {
                                break;
                            } else {
                                System.out.println("Email is invalid!Try Again.");
                            }
                        }

                        Person p1 = new Person(name, surname, email);
                        Ticket t1 = new Ticket(row_letter, seat_num, price, p1);
                        info[count] = t1;
                        count++;
                        System.out.println(" ");
                        exit = true;
                        t1.save();
                        break;
                    } else {
                        System.out.println("Seat has alreay Booked!Please Enter Another Seat Number");
                    }
                } else if (seat_num <= 12 && seat_num >= 1 && (row_letter.equals("C") || row_letter.equals("c"))) {
                    // Seat booking process for row C
                    if (row_c[seat_num - 1] == 0) {
                        row_c[seat_num - 1] = 1;
                        System.out.println("Your seat Successfully Booked!");
                        System.out.println("Your Booked " + row_letter.toUpperCase() + " Row " + seat_num + " Seat");
                        System.out.println("Enter Your Name: ");
                        String name = sc.next();
                        System.out.println("Enter Your Surname: ");
                        String surname = sc.next();
                        String email = null;
                        while (true) {
                            System.out.println("Enter Your E-mail: ");
                            email = sc.next();
                            boolean isValidEmail = email != null && email.contains("@") && email.contains(".");
                            if (isValidEmail) {
                                break;
                            } else {
                                System.out.println("Email is invalid!Try Again.");
                            }
                        }
                        Person p1 = new Person(name, surname, email);
                        Ticket t1 = new Ticket(row_letter, seat_num, price, p1);
                        info[count] = t1;
                        count++;
                        System.out.println(" ");
                        t1.save();
                        exit = true;
                        break;
                    } else {
                        System.out.println("Seat has alreay Booked!Please Enter Another Seat Number");
                    }
                } else {
                    System.out.println("Your Entered number is out of range!Please enter another value");
                }
            }
            if (exit) {
                break;
            }
        }
    }

    private static void menu() {  // Display menu option

        System.out.println("                                                           ");
        System.out.println("        Welcome to the Plan Managment application          ");
        System.out.println("                                                           ");
        System.out.println("***********************************************************");
        System.out.println("*                MENU OPTIONS                             *");
        System.out.println("***********************************************************");
        System.out.println("                                                           ");
        System.out.println("        1) Buy a seat                                      ");
        System.out.println("        2) Cancel a seat                                   ");
        System.out.println("        3) Find first available seat                       ");
        System.out.println("        4) Show seating plan                               ");
        System.out.println("        5) Print tickets information and total sales       ");
        System.out.println("        6) Search ticket                                   ");
        System.out.println("        0) Quit                                            ");
        System.out.println("***********************************************************");
        System.out.println("                                                           ");
    }

    public static void cancel_seat() { // Cancel a seat booking process
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a row letter: ");
            String row_letter = sc.next();
            while (!row_letter.matches("[a-dA-D]")) {
                System.out.println("Invalid Input!Enter a row letter: ");
                row_letter = sc.next();
            }
            while (true) {
                System.out.println("Enter a seat number: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Please Enter a number: ");
                    sc.next();
                }
                int seat_num = sc.nextInt();
                if (seat_num <= 14 && seat_num >= 1 && (row_letter.equals("A") || row_letter.equals("a"))) {
                    if (row_a[seat_num - 1] == 1) {
                        row_a[seat_num - 1] = 0;
                        System.out.println("Your entered seat has been sucessfully cancled!");
                        System.out.println("Row " + row_letter.toUpperCase() + " Seat " + seat_num + " has been cancled.");
                        for (int i = 0; i < count; i++) {
                            Ticket ticket = info[i];
                            if ((ticket.getRow().equals("A") || ticket.getRow().equals("a")) && ticket.getSeat() == seat_num) {
                                for (int j = i; j < count; j++) {
                                    info[j] = info[j + 1];

                                }
                                break;
                            }
                        }
                        count--;

                        System.out.println(" ");
                        exit = true;
                        break;
                    } else {
                        System.out.println("Seat has alreay availabe!");
                        exit = true;
                        break;
                    }
                } else if (seat_num <= 14 && seat_num >= 1 && (row_letter.equals("D") || row_letter.equals("d"))) {
                    if (row_d[seat_num - 1] == 1) {
                        row_d[seat_num - 1] = 0;
                        System.out.println("Your entered seat has been sucessfully cancled!");
                        System.out.println("Row " + row_letter.toUpperCase() + " Seat " + seat_num + " has been cancled.");
                        for (int i = 0; i < count; i++) {
                            Ticket ticket = info[i];
                            if ((ticket.getRow().equals("D") || ticket.getRow().equals("d")) && ticket.getSeat() == seat_num) {
                                for (int j = i; j < count; j++) {
                                    info[j] = info[j + 1];
                                }
                                break;
                            }
                        }
                        count--;

                        System.out.println(" ");
                        exit = true;
                        break;
                    } else {
                        System.out.println("Seat has alreay availabe!");
                        exit = true;
                        break;
                    }
                } else if (seat_num <= 12 && seat_num >= 1 && (row_letter.equals("B") || row_letter.equals("b"))) {
                    if (row_b[seat_num - 1] == 1) {
                        row_b[seat_num - 1] = 0;
                        System.out.println("Your entered seat has been sucessfully cancled!");
                        System.out.println("Row " + row_letter.toUpperCase() + " Seat " + seat_num + " has been cancled.");
                        for (int i = 0; i < count; i++) {
                            Ticket ticket = info[i];
                            if ((ticket.getRow().equals("B") || ticket.getRow().equals("b")) && ticket.getSeat() == seat_num) {
                                for (int j = i; j < count; j++) {
                                    info[j] = info[j + 1];

                                }
                                break;
                            }
                        }
                        count--;
                        System.out.println(" ");
                        exit = true;
                        break;
                    } else {
                        System.out.println("Seat has alreay availabe!");
                        exit = true;
                        break;

                    }
                } else if (seat_num <= 12 && seat_num >= 1 && (row_letter.equals("C") || row_letter.equals("c"))) {
                    if (row_c[seat_num - 1] == 1) {
                        row_c[seat_num - 1] = 0;
                        System.out.println("Your entered seat has been sucessfully cancled!");
                        System.out.println("Row " + row_letter.toUpperCase() + " Seat " + seat_num + " has been cancled.");
                        for (int i = 0; i < count; i++) {
                            Ticket ticket = info[i];
                            if ((ticket.getRow().equals("C") || ticket.getRow().equals("c")) && ticket.getSeat() == seat_num) {
                                for (int j = i; j < count; j++) {
                                    info[j] = info[j + 1];

                                }
                                break;
                            }
                        }
                        count--;
                        System.out.println(" ");
                        exit = true;
                        break;
                    } else {
                        System.out.println("Seat has alreay availabe!");
                        exit = true;
                        break;
                    }
                } else {
                    System.out.println("Your Entered number is out of range!Please enter another value");
                }
            }
            if (exit) {
                break;
            }
        }
    }

    public static void find_first_available() { // // Find the first available seat in the seating plan
        boolean loop = false;
        while (true) {
            for (int count_1 = 0; count_1 < 14; count_1++) {
                if (row_a[count_1] == 0) {
                    System.out.println("Row A " + (count_1 + 1) + " Seat is available");
                    loop = true;
                    break;
                }
            }
            if (loop) {
                break;
            }
            for (int count_2 = 0; count_2 < 12; count_2++) {
                if (row_b[count_2] == 0) {
                    System.out.println("Row B " + (count_2 + 1) + " Seat is available");
                    loop = true;
                    break;
                }
            }
            if (loop) {
                break;
            }
            for (int count_3 = 0; count_3 < 12; count_3++) {
                if (row_c[count_3] == 0) {
                    System.out.println("Row C " + (count_3 + 1) + " Seat is availabel");
                    loop = true;
                    break;
                }
            }
            if (loop) {
                break;
            }
            for (int count_4 = 0; count_4 < 14; count_4++) {
                if (row_d[count_4] == 0) {
                    System.out.println("Row D " + (count_4 + 1) + " Seat is availabel");
                    loop = true;
                    break;
                }
            }
            if (loop) {
                break;
            }
            System.out.println("Sorry,All seats are booked!");
            break;
        }
    }

    public static void show_seat_plan() {  // Display the seating plan with booked and available seats

        for (int count_1 = 0; count_1 < 14; count_1++) {
            if (row_a[count_1] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
        for (int count_2 = 0; count_2 < 12; count_2++) {
            if (row_b[count_2] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
        for (int count_3 = 0; count_3 < 12; count_3++) {
            if (row_c[count_3] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
        for (int count_4 = 0; count_4 < 14; count_4++) {
            if (row_d[count_4] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
    }

    public static void print_ticket_information_and_total_sales() {  // Print ticket information for all booked tickets and calculate total sales
        int tot_price = 0;
        for (int i = 0; i < count; i++) {
            Ticket n = info[i];
            n.print_ticket_info();
            tot_price += n.getPrice();
            System.out.println(" ");
        }
        System.out.println("Total Price: " +"£"+ tot_price);
    }
    public static void search_ticket() { // Search for a ticket by row and seat number
        Scanner sc = new Scanner(System.in);
        boolean seatFound = false;

        while (true) {
            System.out.println("Enter a row letter: ");
            String row_letter = sc.next();
            while (!row_letter.matches("[a-dA-D]")) {
                System.out.println("Invalid Input! Enter a row letter: ");
                row_letter = sc.next();
            }

            while (true) {
                System.out.println("Enter a seat number: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Please Enter a number: ");
                    sc.next();
                }
                int seat = sc.nextInt();

                // Check if the entered seat number is within the valid range
                if (seat >= 1 && seat <= 14) {
                    boolean seatBooked = false;
                    for (int i = 0; i < count; i++) {
                        if (info[i].getRow().equalsIgnoreCase(row_letter) && info[i].getSeat() == seat) {
                            System.out.println("Sorry, This seat is not available");
                            System.out.println();
                            info[i].print_ticket_info();
                            seatBooked = true;
                            seatFound = true;
                            break;
                        }
                    }
                    if (!seatBooked) {
                        System.out.println("This seat is Available");
                        seatFound = true;
                    }
                } else {
                    System.out.println("Your Entered seat number is out of range! Please enter another value");
                    break;
                }

                break;
            }

            if (seatFound) {
                break;
            }
        }

    }
}






