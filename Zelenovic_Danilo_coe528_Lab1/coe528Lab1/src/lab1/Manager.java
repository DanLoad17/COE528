/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author zelen
 */
public class Manager {
    ArrayList<Flight>flight;
    ArrayList<Ticket>tickets = new ArrayList<>();

    public Manager() {
        this.flight = new ArrayList<>();
    }
    
    public void createFlights()
    {
        flight.add(new Flight(345, "Toronto", "Pittsburgh", "Oct 7, 12 pm", 800, 350));
        flight.add(new Flight(459, "Montreal", "Vancouver", "March 30, 8 am", 280, 400));
        flight.add(new Flight(683, "Calgary", "Nova Scotia", "Aug 18, 3 pm", 440, 220));
    }
    
    public void displayAvailableFlights(String origin, String destination)
    {
        for (Flight f:this.flight)
        {
            if(f.getOrigin().equals(origin)&&f.getDestination().equals(destination)&&f.getNumberofSeats()>0)
                System.out.println(f.toString());
        }
    }
    
    public Flight getFlight(int num)
    {
        for(Flight f:this.flight)
        {
            if(f.getFlightNumber() == num)
                return f;
        }
        return null;
    }
    
    public void bookSeat(int num, Passenger p)
    {
        for(Flight flight: this.flight)
        {
            if(flight.getFlightNumber() == num)
            {
                if(flight.bookASeat())
                {
                    Ticket ticket = new Ticket(p,flight, p.applyDiscount(flight.getOriginalPrice()));
                    tickets.add(ticket);
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
       Passenger p = new NonMember("Sarah", 40);
        Manager manager = new Manager();
        manager.createFlights();
        manager.displayAvailableFlights("Toronto", "Pittsburgh");
        manager.bookSeat(320, p);
        System.out.println("The following are all flights created:");
        System.out.println(manager.flight.toString()); 
    }
}
