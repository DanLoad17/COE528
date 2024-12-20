/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
/**
 *
 * @author zelen
 */


public class FoodCategory extends FoodComponent {
    
    int i = 0;
    private final ArrayList<FoodCategory> categories = new ArrayList<>();
    private final ArrayList<FoodItem> items = new ArrayList<>();
    

    public FoodCategory(String name) {
        super(name);
    }

    public void add(FoodComponent component) {
        if (component instanceof FoodCategory) {
            categories.add((FoodCategory) component);
        } else if (component instanceof FoodItem) {
            items.add((FoodItem) component);
        }

    }

    double cumulativePrice = cumulativePrice();
    
    public double getPrice() {
        double price = 0;
        price = items.stream().map((x) -> x.getPrice()).reduce(price, (accumulator, _item) -> accumulator + _item);
        return price;
    }

    public double cumulativePrice() {
        double cumulativePrice = 0;
        cumulativePrice = items.stream().map((x) -> x.getPrice()).reduce(cumulativePrice, (accumulator, _item) -> accumulator + _item);
       
        cumulativePrice = categories.stream().map((x) -> x.cumulativePrice()).reduce(cumulativePrice, (accumulator, _item) -> accumulator + _item);
        
         return cumulativePrice;
    }

    public void print(int level) {
        String space = "";
        while(i < level){
            space += "\t";
            i = i + 1;
        }

        System.out.printf("%s FoodCategory (%s, %.1f) contains: \n",space, getName(), cumulativePrice());

        items.forEach((x) -> {
            x.print(level+1);
        });
        
        categories.forEach((x) -> {
            x.print(level + 1);
        });
        
    }

}