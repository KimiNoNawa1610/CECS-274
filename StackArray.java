package reversestring;


import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The stack is a last in first out data structure
 * The stack class is use to store and operate element as the user implementation
 * @author votha
 */
public class StackArray
{ 
   private Object[] item; // The array where elements are stored
   private int open = 0;  // The index of the first empty location in the stack
   private int size = 2;  // The current number of item locations in the stack

   /**
      Constructs an empty stack.
   */
   public StackArray()
   {
      item = new Object[size];
   }
   /**
    * add an element into the stack and count the size of the new stack
    * @param element the element that the user want to add to the stack
    */
   public void push(Object element)
   {
      
       if (open == item.length) {
           Object[] temp = new Object[size + size];
           for (int i = 0; i < size; i++){
               temp[i] = item[i];
            }
           item = temp;
           size = size*2;
           
   }
   item[open] = element;
   open++;
   }
   /**
    * use to remove the last element of the stack. 
    * @return the removed element
    * If the stack is empty, the method will return an exception 
    */
   public Object pop()
   {
      
       if (open == 0){
           throw new NoSuchElementException("Stack is empty");}
       Object element = item[open -1];
       item[open-1] = null;
       open = open -1;
       return element;
   }
   
   /**
    * Check if the stack is empty 
    * @return ture if the stack if empty. Return false if the stack is not
    */
   public boolean isEmpty()
   {
      return open == 0;
   }
   /**
    * to display the stack
    * @return the stack and with its elements
    * override method used to prevent unexpected output
    * 
    */
   @Override
   public String toString()
   {
      if (open == 0) { return "[]"; }
      String temp = "[" + item[0];
      int i = 1;
      while (i < open)
      {
         temp = temp + ", " + item[i];
         i = i + 1;
      }
      temp = temp + "]";
      return temp;
   }  
}


