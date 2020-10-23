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
public class Fcfs extends algo {

    //processInWork arr[];
    Process pro[];
    int timelimit ; 
    Fcfs(Process pro[],int timelimit) {
        this.timelimit= timelimit;
        arr=new processInWork[pro.length];
        for (int i = 0; i < pro.length; i++) {//int pic,int AraivalTime, int BurstTime, int Deadline
            arr[i] = new processInWork(pro[i].PIC, pro[i].AraivalTime, pro[i].BurstTime, pro[i].Deadline);
        }
    }

    void run() {
        processInWork.sortas = 2;
        Arrays.sort(arr);
        rec(0);
        System.out.println("javafxapplication1.Priority.run()");
    }

    void rec(int i) {
        if(i>=timelimit)return ;
        System.out.println("javafxapplication1.Priority.rec()");
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
        processInWork.sortas = 2;
        Arrays.sort(arr);
        int start = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].AraivalTime <= i && arr[j].BurstTime > 0) {
                k = -1;
                start = j;
                break;
            }
        }
        if (k != -1) {
            rec(i + 1);
            return ; 
        }
        int adding = arr[start].BurstTime ;
        for (int j = 0; j < arr.length; j++) {
            if (j != start&&arr[j].AraivalTime<= i&&arr[j].BurstTime>0) {
                arr[j].waiting+=adding;
                arr[j].turnaround+=adding;
                arr[j].waitlist.add(new Pair(i,i+adding));
            } else if(j==start) {
                arr[j].turnaround+=adding;
                arr[j].worklist.add(new Pair(i, i +arr[start].BurstTime));
                arr[j].BurstTime = 0;
            }else if (arr[j].AraivalTime<=i+adding&&arr[j].BurstTime>0){
                arr[j].waiting+=adding+i-arr[j].AraivalTime;
                arr[j].turnaround+=adding+i-arr[j].AraivalTime;
                arr[j].waitlist.add(new Pair(arr[j].AraivalTime,adding+i));
            }
            
            
        }
        rec(i + adding);
        return ; 

    }

}
