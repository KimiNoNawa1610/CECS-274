/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursiveproject;

/**
 *
 * @author votha
 */
public class RecursiveProject {//Create a class header
    
    private int x=0;//create a static global variable
    
   
    public void PrintTriangle(int x){//method header, contains a parameter variable to out put the pascal triangle
        
        for (int i=1;i<=x;i++){//make the first loop for the method
            
            System.out.println("");//print out a empty line to separate the following lines
            
            for(int j=1;j<=i;j++){//make the second loop inside of the first loop
                
                System.out.print(PascalTriangle(i,j));
//output the result as the conditions are correct the the loop in loop
                System.out.print(" ");
               
        }
            }
        
    }
    public Integer PascalTriangle(int row, int column){// method header, contains 2 parameter variables to compute the pascal triangle.
       
        if (column<=1)//first base case
        {
            return 1;// return 1 if the first base case is correct
        }
        if(column==row){//second base case
            
            return 1;// return 1 if the second base case is correct
        }
        else// if the 2 base cases are not correct
        {
            return (PascalTriangle(row-1, column-1) + PascalTriangle(row - 1, column));// return the recursive calculation of the method
        }       
       
    }
    
    public void setValue(int i){//method to access the static variable
        x=i;// the static variable equal the new input
    }
}
