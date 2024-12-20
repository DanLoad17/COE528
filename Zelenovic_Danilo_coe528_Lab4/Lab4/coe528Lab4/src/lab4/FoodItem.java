/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author zelen
 */
public class FoodItem extends FoodComponent {
    
    int i = 0;
    private final double price;

    public FoodItem(String name , double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void print(int level) {
        String spaces = "";
        while(i < level){
            spaces += "\t";
            i = i + 1;
        }
        System.out.printf("%s FoodItem : %s, %.1f\n", spaces, getName(), getPrice());

    }

}