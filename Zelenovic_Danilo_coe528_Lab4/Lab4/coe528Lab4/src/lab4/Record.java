/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author zelen
 */
public class Record {
    private static Record r = new Record("record.txt");
    
    private String filename;
    
    public Record(String n){
        filename = n;
    }
    
    public void read(){
        try{
            Scanner sc = new Scanner(new File(filename));
            
            while(sc.hasNextLine())
                System.out.println(sc.nextLine());
            
        } catch(IOException e){
            System.out.println("An Error Occured");
            e.printStackTrace();
          }
    }
    
    public void write (String msg){
        try{
            FileWriter fw = new FileWriter(filename,true);
            fw.write(msg);
            fw.close();
            
        } catch(IOException e){
            System.out.println("An Error Occured");
            e.printStackTrace();
          }
    }
    
    public static void main(String[] args){
        r.write("Hello-1\n");
        r.write("Hello-2\n");
        System.out.println("Currently the file record.txt " + "contains the following lines:");
        r.read();
    }
    
}
