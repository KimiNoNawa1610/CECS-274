/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theclaim;

/**
 *
 * @author votha
 */
class Cordinate{
    int x;
    int y;
}
public class FourPointsFormSquare {

    boolean isSquare(Cordinate[] cordinates){
        Cordinate startPoint = cordinates[0];
        int a1 = distanceSquare(startPoint, cordinates[1]);
        int a2 = distanceSquare(startPoint, cordinates[2]);
        int a3 = distanceSquare(startPoint, cordinates[3]);
        
        
        if(a1 == a2){ //then 0,3 is diagonal
            return compare(cordinates[3],cordinates[1],cordinates[2],a1,a3);
        }else if(a1 == a3){
            return compare(cordinates[2],cordinates[1],cordinates[3],a1,a2);
        }else if(a2 == a3){
            return compare(cordinates[1],cordinates[2],cordinates[3],a2,a1);
        }else{
            return false;
        }
    }
    
    private boolean compare(Cordinate startPoint, Cordinate point1, Cordinate point2,int len, int diag){
        if(2*len != diag){
            return false;
        }
        int a1 = distanceSquare(startPoint,point1);
        int a2 = distanceSquare(startPoint,point2);
        return !(a1 != len || a2 != len);
    }
    
    private int distanceSquare(Cordinate c1, Cordinate c2){
        return (int)(Math.pow(Math.abs(c1.x - c2.x) ,2) +
                Math.pow(Math.abs(c1.y-c2.y), 2));
    }
}

