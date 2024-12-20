import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class GUI extends Application {

    TableView<Product> bookTable;
    TextField addTitle, addPrice, addQuantity, addUsername, addPassword, addPoints;
    public ObservableList<Product> bookBuy;
    public ObservableList<Customer> ownerCus;

    @Override
    public void start(Stage primaryStage){ 

        primaryStage.setTitle("Bookstore App"); //setting main stage
        GridPane grid;
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(031, 031, 031, 031));
        
        Text scenetitle;
        scenetitle = new Text("Welcome to our bookstore!\n\n"); //title
        grid.add(scenetitle, 0, 0, 1, 1);

        Label UserName;
        UserName = new Label("User Name:"); //username enter field
        grid.add(UserName, 0, 1);
        TextField userbox;
        userbox = new TextField();
        grid.add(userbox, 1, 1);

        Label Password;
        Password = new Label("Password:"); //password enter field
        grid.add(Password, 0, 2);
        PasswordField passbox;
        passbox = new PasswordField();
        grid.add(passbox, 1, 2);

        Label invalid;
        invalid = new Label("Invalid Login"); //appears if invalid login

        Button btn;
        btn = new Button("Sign in"); //the button to press in order to log in
        HBox hbBtn;
        hbBtn = new HBox(10);
        GridPane.setConstraints(hbBtn, 3, 2);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        Handler handler;
        handler = new Handler();
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = userbox.getText();
                String password = passbox.getText();
                
                if (username.equals("admin") && password.equals("admin")){ //this checks to login admin - entered user and pass must be admin
                    ownerScWindow(primaryStage, handler); //switches scene to the owner
                    System.out.println("Admin successfully logged in."); //display that owner logged in
                }
                
                else if (!handler.verify(username, password)){ //if handler cannot verify credentials
                    System.out.println("Invalid Login."); //invalid login
                    System.out.println(username); // prints user and password entered to system output.
                    System.out.println(password);
                    grid.add(invalid, 1, 3);
                }
                else{
                    customerWindow(primaryStage, handler); //if verifies customer info, switch to customer window
                    System.out.println("Customer successfully logged in."); //logged in message
                }
            }
        });
        
        Scene scene;
        scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void ownerScWindow(Stage primaryStage, Handler a){ //owner screen

        Handler handler;
        handler = new Handler();

        Text scenetitle;
        scenetitle = new Text("Welcome, Owner"); //title and buttons for books, customers and logout
        Button books;
        books = new Button("Books");
        Button customers;
        customers = new Button("Customers");
        Button logout;
        logout = new Button("Logout");

        GridPane ownerScPane;
        ownerScPane = new GridPane();
        
        ownerScPane.setAlignment(Pos.CENTER); //centers
        ownerScPane.setHgap(5);
        ownerScPane.setVgap(10);
        ownerScPane.setPadding(new Insets(25, 25, 25, 25));
        
        ownerScPane.add(books, 0, 2);
        ownerScPane.add(customers, 0, 3); //adds options to pane
        ownerScPane.add(logout, 0, 4);
        
        ownerScPane.add(scenetitle, 0x0, 0x0, 0x1, 0x1);
        
        books.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ownerScBooks(primaryStage, handler); //set to books screen
            }
        });
        
        customers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ownerScCustomers(primaryStage, handler); //set to customers screen
            }
        });
       
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                start(primaryStage); //logout, so go to primary screen
            }
        });
        
        Scene scene;
        scene = new Scene(ownerScPane, 360, 260);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public void customerWindow(Stage primaryStage, Handler a){ //customer window
        
        Handler handler;
        handler = new Handler();
        Text scenetitle;
        scenetitle = new Text("Welcome");
        String statusCheck;
        int poinTemp = handler.pointCount;
        // int poinTemp = 1000; //test case
        if (poinTemp >= 1000){ //points for status
           statusCheck = "Gold";}
        else{
            statusCheck = "Silver"; }
        Text statusOut = new Text("Status: " + statusCheck); //displays for status and points of user         
        Text pointsOut = new Text("Points: " + poinTemp);

      
        TableView<Product> bookTable;
        
        //Title Column
        TableColumn<Product, String> nameColumn; //book table 
        nameColumn = new TableColumn<>("Title"); //title of book title
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName")); //book name

        //Price Column
        TableColumn<Product, String> priceColumn;
        priceColumn = new TableColumn<>("Price"); // price column
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); //book price

        //Quantity Column
        TableColumn<Product, String> quantityColumn;
        quantityColumn = new TableColumn<>("Quantity"); //quantity column
        quantityColumn.setMinWidth(75);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity")); //how many

       
        Button buy;
        buy = new Button("Buy"); //buy, redeem and but and logout buttons
        Button redBuy;
        redBuy = new Button("Redeem & Buy");
        Button logout;
        logout = new Button("Logout");

        GridPane customerPane;
        customerPane = new GridPane();
        
        customerPane.setAlignment(Pos.BOTTOM_CENTER); //pane alignment
        customerPane.setHgap(5);
        customerPane.setVgap(10);
        customerPane.setPadding(new Insets(25, 25, 25, 25));

        bookTable = new TableView<>();
        bookTable.setItems(handler.getProduct()); //select book product
        bookTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
        buy.setOnAction(new EventHandler<ActionEvent>() { //if selects a book to buy
            @Override
            public void handle(ActionEvent e) {
                bookBuy = bookTable.getSelectionModel().getSelectedItems(); //purchase selected item
                
                try {
                    customerCostScreen(primaryStage, handler, handler.purchaseBook(bookBuy.get(0))); //try to buy but 0
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex); //exception
                }
            }
        });
        
       
        logout.setOnAction(new EventHandler<ActionEvent>() { //logout
            @Override
            public void handle(ActionEvent e) {
                start(primaryStage);
            }
        });

        VBox vBox;
        vBox = new VBox();
        vBox.getChildren().addAll(scenetitle, bookTable, buy, redBuy, logout, statusOut, pointsOut);
        vBox.setPadding(new Insets(25, 25, 25, 25));
        vBox.setSpacing(10);

        Scene scene;
        scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void ownerScBooks(Stage primaryStage, Handler a){ //owner books
        
        Handler handler;
        handler = new Handler();
        
        //Title input
        addTitle = new TextField(); //add a book title
        addTitle.setPromptText("Title");
        addTitle.setMinWidth(100);

        //Price Input
        addPrice = new TextField(); //add a book price
        addPrice.setPromptText("Price");
        addPrice.setMinWidth(80);

        //Quantity Input
        addQuantity = new TextField(); //book quantity
        addQuantity.setPromptText("Quantity");
        addQuantity.setMinWidth(40);
        
        //Title Column
        TableColumn<Product, String> nameColumn; //book columns
        nameColumn = new TableColumn<>("Book Name"); //book name title
        nameColumn.setMinWidth(400);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName")); //book name

        //Price Column
        TableColumn<Product, String> priceColumn; //same as above, but with price
        priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        bookTable = new TableView<>();
        bookTable.setItems(handler.getProduct());
        bookTable.getColumns().addAll(nameColumn, priceColumn); //adds the book and price to the appropriate columns

        Button delete; //buttons to delete a selected book, go back or to add the book
        delete = new Button("Delete");
        Button back;
        back = new Button("Back");
        Button add;
        add = new Button("Add");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                handler.addBook(addTitle.getText(),Double.parseDouble(addPrice.getText()), 1); //if add is clicked, the entered title and price are added
                addTitle.clear(); //clears the inputs
                addPrice.clear();
                addQuantity.clear();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() { //if back is clicked, goes to previous stage
            @Override
            public void handle(ActionEvent e) {
                ownerScWindow(primaryStage, handler);
            }
        });

        HBox hBox;
        hBox = new HBox();

        hBox.setSpacing(10);
        hBox.getChildren().addAll(addTitle, addPrice, add);
        
        VBox vBox;
        vBox = new VBox();
        vBox.getChildren().addAll(bookTable, hBox, delete, back);
        vBox.setPadding(new Insets(25, 25, 25, 25));
        vBox.setSpacing(10);

        Scene scene;
        scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        delete.setOnAction(new EventHandler<ActionEvent>() { //if delete is clicked
            @Override
            public void handle(ActionEvent e) {
                bookBuy = bookTable.getSelectionModel().getSelectedItems(); //delete selected book (row)
                try {
                    handler.deleteBook(bookBuy.get(0)); //if there is no book
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex); //exception
                }
                bookBuy.forEach(handler.product::remove); //for each seleted book, delete it
            }
        });   
    }
    
    public void ownerScCustomers(Stage primaryStage, Handler a){ //owner customers
        
        TableView<Customer> custTable;
        Handler handler;
        handler = new Handler();
        
        //Username input
        addUsername = new TextField();
        addUsername.setPromptText("Username");
        addUsername.setMinWidth(100);

        //Password Input
        addPassword = new TextField();
        addPassword.setPromptText("Password");
        addPassword.setMinWidth(80);

        //Points Input
        addPoints = new TextField();
        addPoints.setPromptText("Points");
        addPoints.setMinWidth(40);
        
        //Username Column
        TableColumn<Customer, String> usernameColumn;
        usernameColumn = new TableColumn<>("Username"); //username column title
        usernameColumn.setMinWidth(200);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username")); //usernames

        //Password Column
        TableColumn<Customer, String> passwordColumn;
        passwordColumn = new TableColumn<>("Password"); //pasword column title
        passwordColumn.setMinWidth(200);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password")); //passwords

        //Points Column
        TableColumn<Customer, String> pointsColumn;
        pointsColumn = new TableColumn<>("Points"); //points column title
        pointsColumn.setMinWidth(100);
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points")); //set user's points

        custTable = new TableView<>();
        custTable.setItems(handler.getCustomers()); //sets the items of the getCustomers (their indo)
        custTable.getColumns().addAll(usernameColumn, passwordColumn, pointsColumn); //adds the info gotten above

        Button delete; //buttons
        delete = new Button("Delete");
        Button back;
        back = new Button("Back");
        Button add;
        add = new Button("Add");
        add.setOnAction(new EventHandler<ActionEvent>() { //if add is clicked
            @Override
            public void handle(ActionEvent e) {
                handler.addCustomer(addUsername.getText(),addPassword.getText(), 0); //adds customer info to table
                addUsername.clear(); //clears entered info
                addPassword.clear();
                addPoints.clear();
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>() { //if back clicked
            @Override
            public void handle(ActionEvent e) {
                ownerScWindow(primaryStage, handler); //go back
            }
        });
        
        delete.setOnAction(new EventHandler<ActionEvent>() { //if delete is selected
            @Override
            public void handle(ActionEvent e) {
                ownerCus = custTable.getSelectionModel().getSelectedItems(); //tags selected row
                try {
                    handler.deleteCustomer(ownerCus.get(0)); //if no info selected
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex); //exception
                }
                ownerCus.forEach(handler.customers::remove); //removes selected customer from list
            }
        });   

        HBox hBox;
        hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(addUsername, addPassword, add); //adds user, pass, and associated add button
        
        VBox vBox;
        vBox = new VBox();
        vBox.getChildren().addAll(custTable, hBox, delete, back); //adds tables and buttons
        vBox.setPadding(new Insets(35, 35, 35, 35));
        vBox.setSpacing(10);

        Scene scene;
        scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void customerCostScreen(Stage primaryStage, Handler a, double total) //if customer bought a book
    {

        Text transactionCost;
        transactionCost = new Text("Your charge was : $" + total); //transaction summary
        
       
        Button logout;
        logout = new Button("Logout"); //logout button

        GridPane customerPane;
        customerPane = new GridPane();
        
        customerPane.setAlignment(Pos.BOTTOM_CENTER);
        customerPane.setHgap(5);
        customerPane.setVgap(10);
        customerPane.setPadding(new Insets(25, 25, 25, 25));
       
        logout.setOnAction(new EventHandler<ActionEvent>() { //if logout is pressed
            @Override
            public void handle(ActionEvent e) {
                start(primaryStage); //sets to default stage
            }
        });

        VBox vBox;
        vBox = new VBox();
        vBox.getChildren().addAll(transactionCost, logout); 
        vBox.setPadding(new Insets(25, 25, 25, 25));
        vBox.setSpacing(10);

        Scene scene1;
        scene1 = new Scene(vBox);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}