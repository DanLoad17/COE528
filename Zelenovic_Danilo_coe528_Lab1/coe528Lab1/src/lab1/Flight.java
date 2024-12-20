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

public class Flight {
    private int flightNumber, capacity, numberOfSeatsLeft;
    private String origin, destination, departureTime;
    private double originalPrice;   
   
    public Flight(int fn, String or, String dn, String dt, int cp, double op){
        flightNumber = fn;
        origin = or;
        destination = dn;
        capacity = cp;
        departureTime =  dt;
        originalPrice = op;
        
        if (origin.equals(destination) ==true)
        {
            throw new IllegalArgumentException("Origin and final destination are the same. Invalid.");
        }
    }
     public int getFlightNumber()
    {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber)
    {
        this.flightNumber = flightNumber;
    }
    public String getOrigin()
    {
        return origin;
    }
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    public String getDestination()
    {
        return destination;
    }
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    public String getDepartureTime()
    {
        return departureTime;
    }
    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    public int getNumberofSeats()
    {
        return numberOfSeatsLeft;
    }
    public void setNumberofSeats(int numberOfSeatsLeft)
    {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    public double getOriginalPrice()
    {
        return originalPrice;
    }
    public void setOriginalPrice(double originalPrice)
    {
        this.originalPrice = originalPrice;
    }
    
    public boolean bookASeat()
    {
        if (numberOfSeatsLeft > 0)
        {
            numberOfSeatsLeft--;
            return true;
        }
            return false;
    }
    
    
    @Override
    public String toString()
    {
        return("Flight "+this.flightNumber+", "+this.origin+" to "+ this.destination+" departing "+this.departureTime+", Original pice: $"+this.originalPrice);
    }
    
}
