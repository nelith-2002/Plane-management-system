public class Person {
    // Person attributes
    String name;
    String surname;
    String email;

    // Constructor to initialize person attributes
    Person(String name,String surname,String email){
        // Initialize person attributes
        this.name=name;
        this.surname=surname;
        this.email=email;
        // save();
        //ticket_info();
    }
    public String getName(){  // Getter methods for person attributes

        return name;
    }
    public String getSurname(){  // Getter methods for person attributes

        return surname;
    }
    public String getEmail(){  // Getter methods for person attributes

        return email;
    }
    public void setName(String name){  // Setter methods for person attributes

        this.name=name;
    }
    public void setSurname(String surname){  // Setter methods for person attributes

        this.surname=surname;
    }
    public void setEmail(String email){  // Setter methods for person attributes

        this.email=email;
    }
    public void ticket_info(){    // Method to print person information
        System.out.println("Name: "+name);
        System.out.println("Surname: "+surname);
        System.out.println("E-mail: "+email);
    }
    public String toString(){
        return "Name: "+name +"\nSurname: "+surname+"\nE-mail: "+email;
    }
}

