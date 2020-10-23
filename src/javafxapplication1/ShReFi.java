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
public class ShReFi extends algo {
        Process pro[];
        int timelimit; 

    ShReFi(Process[] pro, int timelimit) {
        this.pro = pro;
        this.timelimit = timelimit;
        arr=new processInWork[pro.length];
        for (int i = 0; i < pro.length; i++) {//int pic,int AraivalTime, int BurstTime, int Deadline
            arr[i] = new processInWork(pro[i].PIC, pro[i].AraivalTime, pro[i].BurstTime, pro[i].Deadline);
        }
    }

  
    void run (){
        rec(0);
    }
    void rec(int i){
        if(i>=timelimit)return ;
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
        processInWork.sortas = 3;
        Arrays.sort(arr);
        int start = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].AraivalTime == i && arr[j].BurstTime > 0) {
                k = -1;
                start = j;
                break;
            }
        }
        if (k != -1) {
            rec(i + 1);
            return ; 
        }
         for (int j = 0; j < arr.length; j++) {
            if (j != start&&arr[j].AraivalTime<= i&&arr[j].BurstTime>0) {
                arr[j].waitlist.add(new Pair(i, i + 1));
                arr[j].waiting++;
                arr[j].turnaround++;

            } else if(j==start) {
                                arr[j].turnaround++;

                arr[j].worklist.add(new Pair(i, i + 1));
                arr[j].BurstTime -= 1;
                if (arr[j].BurstTime < 0) {
                    arr[j].BurstTime = 0;
                }
            }
            if(arr[j].AraivalTime<= i ){arr[j].AraivalTime = i + 1;
            arr[j].age--;
            if (arr[j].age < 0) {
                    arr[j].age = 0;
                }}
        }
        rec(i + 1);
        return ; 
        
        
    }
}
