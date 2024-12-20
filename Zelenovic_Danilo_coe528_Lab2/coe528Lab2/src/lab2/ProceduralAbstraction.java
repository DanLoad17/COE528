/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author zelen
 */
public class ProceduralAbstraction {
    //Requires: None 
    //Modifies: None 
    //Effects: Returns the smallest positive integer n for which n!  
    //         (i.e. 1*2*3*...*n) is greater than or equal to x, for positive  
    //         integer x. Otherwise returns 1.
    public static int reverseFactorial(int x)
    {
        int z = 1;
        int fact = 1;
        
        if (x <= 0)
            return 1;
        
        while (fact < x)
        {
           z = z + 1;
           fact = fact*z;
        }
        return z;
    }
    //Requires: None 
    //Modifies: None 
    //Effects: If the matrix arr satisfies Nice property, prints the sum and  
    //         returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr)
    {
        if (arr == null || arr.length == 0)
            return false;
        
        int sum = 0;
        int d1 = 0;
        int d2 = 0;
        
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].length != arr.length)
                return false;
            
            int q = 0;
            
            for (int j = 0; j < arr[i].length; j++)
                q += arr[i][j];
            
            if (i ==0)
                sum = q;
            
            else if (sum != q)
                return false;
        }
        
        for (int i =0; i < arr.length; i++)
        {
            int q = 0;
            
            for (int[] arr1 : arr) {
                q += arr1[i];
            }
            
            if (q != sum)
                return false;
            
        }

        
        for (int i = 0; i < arr.length; i++)
        {
            d1 += arr[i][i];
            d2 += arr[arr.length - 1 - i][i];
        }
        
        if (d2 == sum || d1 == sum)
        {
            System.out.println(sum);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println("reverseFactorial(24): " + reverseFactorial(24));
        System.out.println("reverseFactorial(119): " + reverseFactorial(119));
        
        int m1[][] = {{2,7,6},{9,5,1},{4,3,8}};
        int m2[][] = {{-3,1,0},{4,-3,4},{7,-9,0}};
     
        
        if(isMatrixNice(m1))
            System.out.println("Matrix {{2,7,6},{9,5,1},{4,3,8}} is nice");
        else
            System.out.println("Matrix {{2,7,6},{9,5,1},{4,3,8}} is not nice");
        
        if(isMatrixNice(m2))
            System.out.println("Matrix {{-3,1,0},{4,-3,4},{7,-9,0}} is nice");
        else
            System.out.println("Matrix {{-3,1,0},{4,-3,4},{7,-9,0}} is not nice");
        
    }
}
