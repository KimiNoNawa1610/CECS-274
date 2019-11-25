/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extracredit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author votha
 */


   
   public class Palindromes
{
   public static void main(String[] args)
   {
      String sentence1 = "Madam, I'm Adam!";      
      System.out.println(sentence1);
      System.out.println("Palindrome: " + isPalindrome(sentence1));
      String sentence2 = "Sir, I'm Eve!";      
      System.out.println(sentence2);
      System.out.println("Palindrome: " + isPalindrome(sentence2));
      String sentence3="AVAVA0123456";
      System.out.println(sentence3);
      System.out.println("Palindrome: " + isPalindrome(sentence3));
      //System.out.println(CheckInput("0123456"));
      //System.out.println(CheckInput("AVAVA0123456"));
   }
   //remove special character and spaces
   private static String CheckInput(String i){
       
        Pattern string1 = Pattern.compile("[^a-zA-Z0-9]");//Create a pattern for the string that contains alphabetical characters and number
        
        Pattern string2=Pattern.compile("[0-9]");//Create a pattern for the string that contain only number
        
        Matcher match1= string1.matcher(i);//Compare the 1st pattern  with the new user's input
        
        
        Matcher match2=string2.matcher(i);//Compare the 2nd pattern with the new user's input
        i=i.toLowerCase();// convert all of the string to lower case
        
        while(match1.find()||match2.find())/* if the user's input matchs the 1st pattern or the user input match the 2nd pattern, 
            the while loop will execute to polish the string */
        {
            i=i.replaceAll("[^a-zA-Z]", "");//remove all of the special characters and spaces, numbers and only keep alphabetical characters 
        }
        //System.out.println(i);
        
        
        return i;// return the finished string

   }

   
   public static boolean isPalindrome(String text)
   {
      text=CheckInput(text);
      int length = text.length();

      // Separate case for shortest strings. 
      if (length <= 1) { return true; }
      else
      {
         // Get first and last characters, converted to lowercase. 
          
         //char first = Character.toLowerCase(text.charAt(0)); This step will be done by the new CheckInput method
          
         //char last = Character.toLowerCase(text.charAt(length - 1)); This step will be done by the new CheckInput method
          
         char first= text.charAt(0);
         char last=text.charAt(length-1);

         if (Character.isLetter(first) && Character.isLetter(last))
         {
            // Both are letters. 
            if (first == last)
            {
               // Remove both first and last character. 
               String shorter = text.substring(1, length - 1);
               return isPalindrome(shorter);
            }
            else
            {
               return false;
            }
         }
         else if (!Character.isLetter(last))
         {
            // Remove last character. 
            String shorter = text.substring(0, length - 1); 
            return isPalindrome(shorter);
         }
         else
         {
            // Remove first character. 
            String shorter = text.substring(1); 
            return isPalindrome(shorter);
         }
      }
   }   
  
   
}
    
