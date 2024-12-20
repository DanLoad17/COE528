/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author zelen
 */
public abstract class Passenger {
    private int age;
    private String name;
    
    public Passenger(String n, int a)
    {
        this.name = n;
        this.age = a;
    }
      public void setName(String n)
    {
        this.name = n;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setAge (int a)
    {
        this.age = a;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    abstract double applyDiscount(double p);
  
}
