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
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    
    public Ticket(Passenger p, Flight flight, double price)
    {
        this.passenger = p;
        this.flight = flight;
        this.price = price;
    }
    
      public void setPassenger (Passenger p)
    {
        this.passenger = p;
    }
    
    public Passenger getPassenger()
    {
        return this.passenger;
    }
    
    public void setFlight(Flight f)
    {
        this.flight = f;
    }
    
    public Flight getFlight()
    {
        return this.flight;
    }
    
    public void setPrice(double p)
    {
        this.price = p;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    @Override
    public String toString()
    {
        return(passenger.getName()+"Flight "+flight.getFlightNumber()+", "+flight.getOrigin()+" to "+flight.getDestination()+", "+flight.getDepartureTime()+", Original price: $"+flight.getOriginalPrice()+", Ticket price: $"+this.price);
    }
}
