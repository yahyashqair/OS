/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.Arrays;
import javafx.util.Pair;

/**
 *
 * @author YahyaShqair
 */
public class Roben extends algo{
    
    //processInWork arr[];
    Process pro[];
    int timelimit ; 
    int Robcon;// ms 

    Roben(Process pro[],int RobCon,int timelimit) {
        this.Robcon=RobCon;
        this.timelimit= timelimit ; 
        arr=new processInWork[pro.length];
        for (int i = 0; i < pro.length; i++) {//int pic,int AraivalTime, int BurstTime, int Deadline
            arr[i] = new processInWork(pro[i].PIC, pro[i].AraivalTime, pro[i].BurstTime, pro[i].Deadline);
        }
        this.Robcon=RobCon;
    }
    
    void run() {
        rec(0,0);
        System.out.println("javafxapplication1.Priority.roben()");
    }
    
    
    void rec(int time,int idx) {
        if(time>=timelimit)return ;
        System.out.println("javafxapplication1.Roben.rec() -- > time "+time+"  idx -- >> "+idx);
        // test if no more processes need cpu ;
        int k = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].BurstTime != 0) {
                k++;
                break;
            }
        }
        if (k == 0) {
            return;
        }
        //test if in this moment there is a prosecces waiting or not ; 
        int start = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].AraivalTime <= time && arr[j].BurstTime > 0) {
                k = -1;
            //    start = j;
                break;
            }
        }
        if (k != -1) {
            rec(time + 1,0);
            return ; 
        }
        start=-1;
        
        for (int i = 0; i < 2*arr.length; i++) {
            if(arr[(idx)%arr.length].AraivalTime<=time&&arr[(idx)%arr.length].BurstTime>0){
                start =(idx)%arr.length ; 
                arr[(idx)%arr.length].AraivalTime=time;
                break ; 
            }
            idx++;
        }
        if(start==-1){
             rec(time + 1,(idx)%arr.length );
            return ; 
        }
        //
        k=Robcon;
        if(arr[start].BurstTime<Robcon){
            k=Robcon;
            Robcon = arr[start].BurstTime ;
        }
        for (int j = 0; j < arr.length; j++) {
            if (j != start&&arr[j].AraivalTime<= time&&arr[j].BurstTime>0) {
                arr[j].waitlist.add(new Pair(time, time +Robcon ));
                arr[j].waiting++;
                arr[j].turnaround++;
            } else if(j==start) {
                arr[j].turnaround++;
                arr[j].worklist.add(new Pair(time, time + Robcon));
                arr[j].BurstTime -= Robcon;
                if (arr[j].BurstTime < 0) {
                    arr[j].BurstTime = 0;
                }
            }
            if(arr[j].AraivalTime<= time ){arr[j].AraivalTime = time + Robcon;
            }
        }
        int temp = Robcon;
        Robcon=k;
        rec(time + temp,(idx+1)%arr.length);
        return ; 

    }

    
    
}





