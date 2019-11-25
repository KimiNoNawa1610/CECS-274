package reversestring;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *A class to reverse each word inside a string
 * This class will have method to process input and return output
 * each word will be reversed using stack
 * @author votha
 */
public class ReverseString {
    
    /**
     * take a user's string and reverse each word of it by using stack
     * @param sentence the string that user want to use
     * This will make the string becomes an array and pass each word to reverseWord method to reverse
     * This method will also out put the result
     */
    public void ReverseString(String sentence){
    String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            
            System.out.print(reverseWord(words[i]));
            if(i!=words.length-1)
                System.out.print(" ");
        }
          
        }
    
    /**
     * The method to reverse the string by using stack class
     * @param sentence the word that need reversing
     * @return the word that already be reversed
     * By using the pop method of the stack, each character of a word will be removed and put in reversed order
     */
    private static String reverseWord(String sentence) {
        StackArray stack = new StackArray();
        for (int i= 0; i< sentence.length(); i++) {
            stack.push(sentence.charAt(i));
        }
        String out = "";
        while (stack.isEmpty()== false) {
            out=out+ stack.pop();
            //System.out.println(out);
        }
        
        return out;
    }
    
    }
    
    
     

