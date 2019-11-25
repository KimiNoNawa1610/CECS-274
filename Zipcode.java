package zipcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author votha
 */
public class Zipcode {
    boolean exit;
    public static void main( String args[]){
        Zipcode menu=new Zipcode();
        menu.RunMenu();
        
        
        
    }
    //This method will print out the header of the menu
    private void Header(){
        System.out.println("+--------------------------------------------+");
        System.out.println("|   Welcome to the encoding zipcode program  |");
        System.out.println("+--------------------------------------------+");
    
}
    //This method will pring out the selections of the menu
    private void PrintMenu(){
        System.out.println("\nPlease make your choice");
        System.out.println("1.Create a new barcode from zipcode");
        System.out.println("2.Convert from barcode to zipcode");
        System.out.println("3.Exit");
        
        
    }
    //This method will run the menu, make action according to the user choice
    public void RunMenu(){
        Header();
        while(!exit){
            PrintMenu();
            int choice =getInput();
            Action(choice);
        }
    
}
    //This method will run the action according to the user's choice
    private void Action(int i){
        if(i==1){
            System.out.println(PrintBarcode());
        }
        if(i==2){
            System.out.println(PrintZipcode(Zipcode()));
        }
        if(i==3){
            exit=true;
            System.out.println("Thank you for using the program");
        }
     }
    //This method will get input from the user and return the choice
    private int getInput(){
        
        int choice=-1;
        
        Scanner input=new Scanner(System.in);
        
            while (choice<0 || choice>3){
                
                try{
                    System.out.println("Please enter your choice with number from 1 to 3:");
                    
                    choice = Integer.parseInt(input.nextLine());
                
                }
                catch(NumberFormatException e){
                    
                    System.out.println("Invalid selection please try another one:");
                
            }
        }
        return choice;
    }
    //This method will get the zipcode from the user and convert them to ArrayList
    private List Barcode(){
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the zipcode: ");
        String n=input.next();
        while(Validatezipcode(n)==false||n.length()!=5){
            System.out.println("Invalid input.\nPlease try again");
            n=input.next();
                    
        }
        ArrayList<String> barcode=new ArrayList<>();
            for(char c:n.toCharArray()){
                barcode.add(String.valueOf(c));
        }
        
        barcode.add(CheckMultipleof10(barcode));
        
        return barcode;
    }
    //This method will transform the zipcode to the encoded barcode
    private String PrintBarcode(){
        List n=Barcode();
        String x="";
        for (int i=0;i<n.size();i++){
            if ("0".equals(String.valueOf(n.get(i)))){
                x=x+"||:::";  
            }
            else if ("1".equals(String.valueOf(n.get(i)))){
                x=x+":::||";
            }
            else if ("2".equals(String.valueOf(n.get(i)))){
                x=x+"::|:|";
            }
            else if ("3".equals(String.valueOf(n.get(i)))){
                x=x+"::||:";
            }
            else if ("4".equals(String.valueOf(n.get(i)))){
                x=x+":|::|";
            }
            else if ("5".equals(String.valueOf(n.get(i)))){
                x=x+":|:|:";
            }
            else if ("6".equals(String.valueOf(n.get(i)))){
                x=x+":||::";
            }
            else if ("7".equals(String.valueOf(n.get(i)))){
                x=x+"|:::|";
            }
            else if ("8".equals(String.valueOf(n.get(i)))){
                x=x+"|::|:";
            }
            else if ("9".equals(String.valueOf(n.get(i)))){
                x=x+"|:|::";
            }
               
            }
        return "|"+x+"|";     
    }
    //This method will check to add the last digit to the bardcode
    private String CheckMultipleof10(List n){
        int sum=0;
        int x=1;
        int a=0;
        for(int i=0;i<n.size();i++){
            sum=sum+Integer.valueOf((String) n.get(i));
            
        }
        while (sum%10!=0){
            sum=sum+x;  
            //System.out.println(sum);
            a++;
        }
        //System.out.println(a);
        
        return String.valueOf(a);
       
    }
    //This method will validate the zipcode that the user inputs
    private boolean Validatezipcode(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
	}
    //This method will validate the barcode that the user inputs
    private boolean Validatebarcode(String n){
        Pattern pattern=Pattern.compile("[^:|]");
        Matcher matcher= pattern.matcher(n);
        return matcher.matches();
    }
    //This method will take the barcode from the user and transform it to an Arraylist
    private List Zipcode(){
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the barcode: ");
        String n=input.next();
        while(Validatebarcode(n)==true||n.length()!=32){
            System.out.println("Invalid input.\nPlease try again");
            n=input.next();
                    
        }
        ArrayList<String> zipcode=new ArrayList<>();
            for(int i=1;i+4<(n.length()-6);i=i+5){
                zipcode.add(n.substring(i, i+5));
        }
        //System.out.println(zipcode);
        return zipcode;
    }
    //This method will transform the barcode to zipcode
    private String PrintZipcode(List n){
        String x="";
        for (int i=0;i<n.size();i++){
            
            if ("||:::".equals(String.valueOf(n.get(i)))){
                x=x+"0";  
            }
            else if (":::||".equals(String.valueOf(n.get(i)))){
                x=x+"1";
            }
            else if ("::|:|".equals(String.valueOf(n.get(i)))){
                x=x+"2";
            }
            else if ("::||:".equals(String.valueOf(n.get(i)))){
                x=x+"3";
            }
            else if (":|::|".equals(String.valueOf(n.get(i)))){
                x=x+"4";
            }
            else if (":|:|:".equals(String.valueOf(n.get(i)))){
                x=x+"5";
            }
            else if (":||::".equals(String.valueOf(n.get(i)))){
                x=x+"6";
            }
            else if ("|:::|".equals(String.valueOf(n.get(i)))){
                x=x+"7";
            }
            else if ("|::|:".equals(String.valueOf(n.get(i)))){
                x=x+"8";
            }
            else if ("|:|::".equals(String.valueOf(n.get(i)))){
                x=x+"9";
            }
                  
         
        }
        return x; 
    }
    }


        
                
    
        
    
    
    


    
    
    

