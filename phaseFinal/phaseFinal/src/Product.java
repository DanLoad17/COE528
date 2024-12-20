import javafx.scene.control.CheckBox;

public class Product {

    private String bookName; //initialize
    private double price;
    private int quantity;
    private CheckBox select;

    public Product (String bookName, double price, int quantity){
        this.select = new CheckBox();
        this.bookName = bookName;
        this.price = price;
        this.quantity = quantity;
    }

        public double getPrice(){ //getters and setters below
        return price;
    }
    
    public void setPrice (double price){
        this.price = price;
    }
    
    public String getBookName(){
        return bookName;
    }
    
    public void setBookName (String bookName){
        this.bookName = bookName;
    }

    public CheckBox getSelect(){
        return select;
    }

    public void setSelect(CheckBox select){
        this.select = select;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity (int quantity){
        this.quantity = quantity;
    }


}