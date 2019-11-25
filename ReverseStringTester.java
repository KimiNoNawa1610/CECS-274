package reversestring;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *User interface of the the ReverseString class
 * Interact with the user
 * take input
 * and give back output
 * @author votha
 */
public class ReverseStringTester {
    /**
     * Ask the user for the string they want to reverse the word. 
     * Output the reversed-words string as the result
     * then check if the user want to continue with a new string
     * if not, output an closing statement.
     * @param args 
     */

    public static void main(String[] args){
        ReverseString reverse=new ReverseString();
        Scanner scan=new Scanner(System.in);
        boolean choice=true;
        while(choice!=false){
            System.out.println("Please enter the string you want to reverse");
            String input=scan.nextLine();
            System.out.println("The reverse String is: ");
            reverse.ReverseString(input);
            System.out.println(" ");
            choice=promptEnterKey();
            
        }
        }
   /**
    * prompt the user's choice 
    * 
     * @return true if the user want to continue using the program, and return false if the user want to close the program
     * Then out put the return statement
     * 
    */
   public static boolean promptEnterKey(){
   System.out.println("Press ENTER to continue and -1 to close program");
   Scanner scanner = new Scanner(System.in);
   String input=scanner.nextLine();
   if("-1".equals(input)){
       System.out.println("Thank for using the program \nHave a good day");
       return false;
   }
   else{return true;}
  
}
   
    }
