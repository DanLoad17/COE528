import javafx.scene.control.CheckBox;


public class Customer extends User {

    private String username;
    private final String password; //initialize
    private double points;
    private CheckBox select = new CheckBox();
    private String status;

    public Customer (String username, String password, double points){
        this.username = username;
        this.password = password;
        this.points = points;
    }
    
    @Override
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    @Override
    public String getPassword(){
        return password;
    }
    
    @Override
    public double getPoints(){
        return points;
    }           
    
    public CheckBox getSelect(){
        return select;
    }

    public void setSelect(CheckBox select){
        this.select = select;
    }
    
    public String getStatus(){ //setting status, by number of points
        if(points > 1000){
            status = "Gold";
        }else{
            status = "Silver";
        }
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
}