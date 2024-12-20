import java.io.*;
import javafx.collections.FXCollections; //imports
import javafx.collections.ObservableList;


public class Handler {
    private String username; //initialize
    private String password;
    private double points;
    private String bookName;
    private double bookPrice;
    private int bookQuantity;
    public int pointCount;
    public User current;
    public Customer c1;
    public Customer poinTemp; //temporary 
    public ObservableList<Customer> customers = FXCollections.observableArrayList();
    public ObservableList<Product> product = FXCollections.observableArrayList();
    
    
    public boolean verify(String user, String pw) {
        boolean verification;
        verification = false;   //make sure no one can login without verfiying credentials first (initialized)
               
        try{
            try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) { //read from customers file
                String line;
                line = reader.readLine(); //read input
                while (line != null) {
                    String cussInf[];
                    cussInf = line.split(", ");
                    username = cussInf[0];
                    password = cussInf[1];
                    points = Integer.parseInt(cussInf[2]);
                    c1 = new Customer(username, password, points);
                    pointCount = (int) points;
                    if(user.equals(username)){ //if entered user equals same username in file
                        if (pw.equals(password)) { //and if password enters is same as password in file that matches associated user
                            verification = true; //allows access to bookstore now
                            current = c1;
                            System.out.println(current.getUsername()); //prints user's info to system output
                            System.out.println(current.getPassword());
                            System.out.println(current.getPoints());
                            
                        }
                    }
                    line = reader.readLine();
                }
            }
        } catch (IOException | NumberFormatException e){ // if error
            System.out.println("User does not exist"); //error exception message and verfication returns false
        } return verification;

    } 
    
    public ObservableList<Product> getProduct (){ 
        
        try{
            try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) { //books file
                String line;
                line = reader.readLine(); //read input
                while (line != null) {
                    String cussInf[] = line.split(", ");
                    bookName = cussInf[0];
                    bookPrice = Double.parseDouble(cussInf[1]);
                    bookQuantity = Integer.parseInt(cussInf[2]);
                    
                    product.add(new Product(bookName, bookPrice, bookQuantity)); //adds book info to file
                    
                    line = reader.readLine();
                }
            }
            
        } catch (IOException | NumberFormatException e){ //if error, exception and print message to system  output
            System.out.println("Invalid");
        } 

        return product;
    }
    
    public void addBook(String title, double price, int quantity) { //adding a book to file
        product.add(new Product(title, price, quantity));
        try { 
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("books.txt", true)))) { //write to books.txt
                out.println(title + ", " + price + ", " + quantity); //out print the title, price and quantity, separated by commas
                out.flush(); //clear adding
            }
        }
        catch (IOException e) {  //exception, print exception to system output
          System.out.println(e);
        }
    }
    
    public double purchaseBook(Product book) throws IOException //purchase a book
    {
        double total;
        total = book.getPrice(); //cost is price of book
        deleteBook(book); //delete book
        
        return total; //return the cost
    }
    
   
    public void deleteBook(Product book) throws FileNotFoundException, IOException{ //delete a book
        File inputFile;
        inputFile = new File("books.txt"); //original file
        File tempFile;
        tempFile = new File("tempBook.txt"); //temporary overwriting file

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String lineToRemove = book.getBookName(); //read and find which line is to be removed
            
            String currentLine;
            
            while((currentLine = reader.readLine()) != null) { //if line corresponds to selected line
                String trimmedLine = currentLine.trim(); //set them
                if(trimmedLine.contains(lineToRemove)) continue; //if line is line to be removed
                writer.write(currentLine + System.getProperty("line.separator"));
                System.out.println(currentLine); //prints line to system
            }
        }
        inputFile.delete(); //remove file
        boolean successful;
        successful = tempFile.renameTo(inputFile); //replace file that actual fixes with the temporary file that stores all names/values
    }   
    
    public void addCustomer(String username, String password, int points) { //adding a customer
        customers.add(new Customer(username, password, points)); //information on each customer
        try { 
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("customers.txt", true)))) { //write to customers file
                out.println(username + ", " + password + ", " + points); //info separated by commas
                out.flush(); //flush the info
            }
        }
        catch (IOException e) {  //exception handling
          System.out.println(e);
        }
    }
    
    public void deleteCustomer(Customer customer) throws FileNotFoundException, IOException{ //deleting a customer
        File inputFile = new File("customers.txt"); //customers file
        File tempFile = new File("tempCust.txt"); //temporary file that will be used to overwrite

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String lineToRemove; 
            lineToRemove = customer.getUsername(); //find line to be removed by username
            
            String currentLine;
            
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim(); //set
                if(!trimmedLine.contains(lineToRemove)) {
                } else {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator")); //current line overwritten
                System.out.println(currentLine);
            }
        }
        inputFile.delete(); //delete input file
        boolean successful;
        successful = tempFile.renameTo(inputFile); //rename temporary file to new real file
    }   
    
    public ObservableList<Customer> getCustomers (){

        try{
            try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) { //reading customers file
                String line;
                line = reader.readLine();
                while (line != null) { //if there is something in that line (customer info)
                    String cussInf[];
                    cussInf = line.split(", "); //sees customer info split with commas
                    username = cussInf[0];
                    password = cussInf[1];
                    points = Double.parseDouble(cussInf[2]);
                    
                    customers.add(new Customer(username, password, points)); //add required info
                    line = reader.readLine(); 
                }
            }
            
        } catch (IOException | NumberFormatException e){ //exception handling
            System.out.println("Invalid");
        } 

        return customers;
    }
    public int getCount (){
        try{
            try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) { //read customers
                String line;
                line = reader.readLine();
                while (line != null) { //if there is something written on the line
                    String cussInf[];
                    cussInf = line.split(", "); //get their info, split by comma
                    username = cussInf[0];
                    password = cussInf[1]; 
                    points = Integer.parseInt(cussInf[2]);
                    poinTemp = new Customer(username, password, points);
                    pointCount = (int) points; //get customers points
                    line = reader.readLine();
                }
            }
        } catch (IOException | NumberFormatException e){ //exception handling
            System.out.println("Read error- No points");
        } return pointCount;

    }
    
}