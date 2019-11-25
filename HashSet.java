/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harshset;

/**
 * HashSet class is to store the data into a Hash table.
 * This class also contains a method that use to compress the hashcode for each element
 * @author votha
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   This class implements a hash set using separate chaining.
*/
public class HashSet
{
   private Node[] buckets;
   private int currentSize;
 /**
* This is the method that compress the hashcode for an element.
    * Implement the MAD (multiply-add-divide) method.
    * @param obj The object that need a hashcode.
    * @return double h- the value of the hashcode for the object.
    */
   public int HashCodeCompression(Object obj){
       int h=obj.hashCode();
       System.out.println("Hashcode: "+h);
       int L=buckets.length;
       int p=PrimeNumber(L);
       int a=getRandomDoubleBetween(1,p-1);
       int b=getRandomDoubleBetween(1,p-1);
       h=Math.abs(((a*h + b) % p) % L);
       System.out.println("Reduce Hashcode: ");
       return h;
       
   }
   /**
    * The method to find a random number that has a certain limit
    * @param min The minimum that a random number can be
    * @param max The maximum that a random number can be
    * @return The random number that has been generated. 
    */
   public static int getRandomDoubleBetween(int min, int max){
    int x = (int) ((Math.random()*((max-min)+1))+min);
    return x;
}
   /**
    * The method is to check if a number is a prime number 
    * @param x The number that need to check
    * @return true if the number is prime and false if the number is not
    */
   public boolean isPrime(int x){
       if(x%2==0){return false;}
       for(int i=3;i*i<x;i+=2){
           if(x%i==0){return false;}
           
       }
       return true;
   }
   /**
    * The PrimeNumber method is to generate a prime number that next to the given number
    * @param number The number that need finding prime number that next to it
    * @return The prime number that has been generated.
    */
   public int PrimeNumber(int number){
       while(!isPrime(number)){
           ++number;
       }
       return number;
   }
   /**
      Constructs a hash table.
      @param bucketsLength the length of the buckets array
   */
   public HashSet(int bucketsLength)
   {
      buckets = new Node[bucketsLength];
      currentSize = 0;
   }
   @Override
   public String toString() {
       Iterator i = iterator();
       String temp="";
       while (i.hasNext()) {
           temp=temp+" "+i.next().toString();
       }
     return temp;
   }


   /**
      Tests for set membership.
      @param x an object
      @return true if x is an element of this set
   */
   public boolean contains(Object x)
   {
      int h = x.hashCode();
      if (h < 0) { h = -h; }
      h = h % buckets.length;

      Node current = buckets[h];
      while (current != null)
      {
         if (current.data.equals(x)) { return true; }
         current = current.next;
      }
      return false;
   }

   /**
      Adds an element to this set.
      @param x an object
      @return true if x is a new object, false if x was
      already in the set
   */
   public boolean add(Object x)
   {
      int h = x.hashCode();
      if (h < 0) { h = -h; }
      h = h % buckets.length;

      Node current = buckets[h];
      while (current != null)
      {
         if (current.data.equals(x)) { return false; }
            // Already in the set
         current = current.next;
      }
      Node newNode = new Node();
      newNode.data = x;
      newNode.next = buckets[h];
      buckets[h] = newNode;
      currentSize++;
      return true;
   }

   /**
      Removes an object from this set.
      @param x an object
      @return true if x was removed from this set, false
      if x was not an element of this set
   */
   public boolean remove(Object x)
   {
      int h = x.hashCode();
      if (h < 0) { h = -h; }
      h = h % buckets.length;

      Node current = buckets[h];
      Node previous = null;
      while (current != null)
      {
         if (current.data.equals(x))
         {
            if (previous == null) { buckets[h] = current.next; }
            else { previous.next = current.next; }
            currentSize--;
            return true;
         }
         previous = current;
         current = current.next;
      }
      return false;
   }

   /**
      Returns an iterator that traverses the elements of this set.
      @return a hash set iterator
   */
   public Iterator iterator()
   {
      return new HashSetIterator();
   }

   /**
      Gets the number of elements in this set.
      @return the number of elements
   */
   public int size()
   {
      return currentSize;
   }
   /**
    * the union method that will combine all element of two HashSet into one set.
    * @param anyset The HashSet that will be combined with the original HashSet of this class.
    * @return HashSet temp- The HashSet that contain all of the elements of the two HashSet.
    * If there are duplicate element, the HashSet temp will only has one of them. 
    */
   public HashSet union(HashSet anyset)
   {
       int a=buckets.length;
       int b=anyset.buckets.length;
       HashSet temp=new HashSet(a+b);
       
      for(int i=0;i<buckets.length;i++){
           if(buckets[i]!=null){
           temp.buckets[i]=buckets[i];}
            for(int j=0;j<anyset.buckets.length;j++){
                if(anyset.buckets[j]!=null){
                    temp.buckets[j]=anyset.buckets[j];
                }
            }
       }
       
       return temp;
   }
   /**
    * This method is use to find the intersection of two HashSet
    * @param anyset The HashSet that need to find the intersection with the original HashSet of this class
    * @return HashSet temp- The HashSet that contain intersection of two HashSet.
    * If the HashSet contain more than one element in one memory location, 
    * that memory location will be run through a while loop to find all of the elements
    */
   public HashSet intersect(HashSet anyset) {
       int a=buckets.length;
       int b=anyset.buckets.length;
       int tempsize;
       if (a<b){tempsize=b;}
       else{tempsize=a;}
    HashSet temp=new HashSet(tempsize);
       for (Node bucket1 : buckets) {
           if (bucket1 != null) {
               for (Node bucket : anyset.buckets) {
                   if (bucket != null && bucket1.data == bucket.data) {
                       temp.add(bucket1.data);
                       if (bucket1.next != null && bucket.next!=null) {
                           Node tempbucket=bucket1;
                           while(tempbucket.next!=null){
                               if (bucket1.next.data == bucket.next.data) {
                                   temp.add(bucket1.next.data);
                                   tempbucket=tempbucket.next;
                                   if(tempbucket.next!=null){
                                       Node tempbucket2=bucket.next;
                                       if(tempbucket2.next!=null){
                                           if (tempbucket.next.data == tempbucket2.next.data) {
                                               temp.add(tempbucket.next.data);
                                               tempbucket=tempbucket.next;
                                           }
                                       }
                                   }
                               }
                           }
                       }
                   }
               }
           }
       }
        
    
    return temp;
}
   /**
    * The method to find only unique element of 
    * @param anyset The HashSet that we need to compare with
    * @return The value that not contains in the HashSet anyset
    * the elements that are different only come from the original buckets of this HashSet, not the anyset.
    * using the Method A-B 
    */
   public HashSet difference(HashSet anyset){
       int a=buckets.length;
       int b=anyset.buckets.length;
       HashSet temp=new HashSet(a+b);
       temp.buckets=Arrays.copyOf(buckets, buckets.length);
       for (Node bucket1 : temp.buckets) {
           if (bucket1 != null) {
               for (Node bucket : anyset.buckets) {
                   if (bucket != null) {
                       if (bucket1.data == bucket.data) {
                           temp.remove(bucket1.data);
                           if (bucket1.next != null) {
                               if (bucket.next!=null) {
                                   Node tempbucket=bucket1;
                                   while(tempbucket.next!=null){
                                   if (bucket1.next.data == bucket.next.data) {
                                       temp.remove(bucket1.next.data);
                                       tempbucket=tempbucket.next;
                                       if(tempbucket.next!=null){
                                           Node tempbucket2=bucket.next;
                                           if(tempbucket2.next!=null){
                                                if (tempbucket.next.data == tempbucket2.next.data) {
                                                    temp.remove(tempbucket.next.data);
                                                    tempbucket=tempbucket.next;
                                       }
                                       }
                                       }
                                   }
                                   }
                               }
                           }
                       }
                   }
               }
           }
       }
 return temp;
  
}

   
   /**
    * The node that contains the object data 
    * and the Node next attribute.
    */
   class Node
   {
      public Object data;
      public Node next;
   }

   class HashSetIterator implements Iterator
   {
      private int bucketIndex;
      private Node current;

      /**
         Constructs a hash set iterator that points to the
         first element of the hash set.
      */
      public HashSetIterator()
      {
         current = null;
         bucketIndex = -1;
      }

      @Override
      public boolean hasNext()
      {
         if (current != null && current.next != null) { return true; }
         for (int b = bucketIndex + 1; b < buckets.length; b++)
         {
            if (buckets[b] != null) { return true; }
         }
         return false;
      }

      @Override
      public Object next()
      {
         if (current != null && current.next != null)
         {
            current = current.next; // Move to next element in bucket
         }
         else // Move to next bucket
         {
            do
            {
               bucketIndex++;
               if (bucketIndex == buckets.length)
               {
                  throw new NoSuchElementException();
               }
               current = buckets[bucketIndex];
            }
            while (current == null);
         }
         return current.data;
      }

      @Override
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
      
   }
}
