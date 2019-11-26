/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

/**
 *
 * @author votha
 */
public class TowerofHanoi {
    private int Disksnumber;
    public void TowerofHanoi(int disk){
        Disksnumber=disk;
    }
    public void solve(){
        movetower(Disksnumber,1,2,3);
    }
    private void movetower(int disk,int start, int end, int temp){
        if (disk==1){
            moveonedisk(start,end);
        }
        else{
            movetower(disk-1,start,temp,end);
            moveonedisk(start,end);
            movetower(disk-1,temp,end,start);
            
        }
    }
    private void moveonedisk(int s, int e){
        System.out.println("Move disk from "+s+" to "+e);
    }
    
}
