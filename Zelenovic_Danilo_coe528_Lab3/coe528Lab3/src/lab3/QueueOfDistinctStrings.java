/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author zelen
 */
import java.util.ArrayList; 
public class QueueOfDistinctStrings { 
    
// Overview: QueueOfDistinctStrings are mutable, bounded         
// collection of distinct strings that operate in      
// FIFO (First-In-First-Out) order.
//
// The abstraction function is:     
// a) Write the abstraction function here 
//      AbsFn function: AF(myQueue) = { myQueue.items[0] = q0
//     myQueue.items[items.size() - 1] = qn | for queue = {q0, q1, ... qn}}
//     
//     
// The rep invariant is:      
// b) Write the rep invariant here 
//      myQueue.items != null && myQueue.items.size() = n
//      -> n item is queued to myQueue
//      
//      
//       
//the rep 
    private ArrayList<String> items;  
    
// constructor     
    public QueueOfDistinctStrings () {         
// EFFECTS: Creates a new QueueOfDistinctStrings object         
        items = new ArrayList<>();     
    }
    
// MODIFIES: this     
// EFFECTS: Appends the element at the end of the queue      
//          if the element is not in the queue, otherwise     
//          does nothing.     
    public void enqueue(String element) throws Exception {         
        if(element == null) throw new Exception();         
        if(false == items.contains(element))              
            items.add(element);     
    }       
    
    public String dequeue() throws Exception {         
// MODIFIES: this         
// EFFECTS: Removes an element from the front of the queue          
        if (items.size() == 0) throw new Exception();         
        return items.remove(0);     
    }
    
    public boolean repOK() throws Exception{         
// EFFECTS: Returns true if the rep invariant holds for this            
//          object; otherwise returns false            
// c) Write the code for the repOK() here 
        QueueOfDistinctStrings myQueue = new QueueOfDistinctStrings();
        if (!myQueue.items.isEmpty() || myQueue.items == null)
            return false;
        myQueue.enqueue("ab");
        myQueue.enqueue("cd");
        myQueue.enqueue("ef");
        
        return myQueue.items.size() == 3 && myQueue.items.get(0).equals("ab") && myQueue.items.get(1).equals("cd") && myQueue.items.get(2).equals("ef");
          }       
    
    @Override
    public String toString() {         
// EFFECTS: Returns a string that contains the strings in the          
//          queue, the front element and the end element.          
//          Implements the abstraction function.           
// d) Write the code for the toString() here 
        String strReturn = "";
        if(items == null)
            return "Queue has nothing";
        for (String element: items){
            strReturn = strReturn + " " + element;   
        }
        return strReturn;
     } 
} 