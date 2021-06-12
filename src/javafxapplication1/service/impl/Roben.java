/*
 * Feel free to use anything : )  */
package javafxapplication1.service.impl;

import javafx.util.Pair;
import javafxapplication1.service.Process;
import javafxapplication1.service.Algorithm;
import javafxapplication1.service.ProcessInWork;

/**
 * @author YahyaShqair
 */
public class Roben extends Algorithm {

    //processInWork arr[];
    Process[] pro;
    int timelimit;
    int Robcon;// ms 

    public Roben(Process[] pro, int RobCon, int timelimit) {
        this.Robcon = RobCon;
        this.timelimit = timelimit;
        processResultList = new ProcessInWork[pro.length];
        for (int i = 0; i < pro.length; i++) {//int pic,int AraivalTime, int BurstTime, int Deadline
            processResultList[i] = new ProcessInWork(pro[i].PIC, pro[i].AraivalTime, pro[i].BurstTime, pro[i].Deadline);
        }
        this.Robcon = RobCon;
    }

    public void run() {
        rec(0, 0);
        System.out.println("javafxapplication1.service.impl.Priority.roben()");
    }


    void rec(int time, int idx) {
        if (time >= timelimit) return;
        System.out.println("javafxapplication1.service.impl.Roben.rec() -- > time " + time + "  idx -- >> " + idx);
        // test if no more processes need cpu ;
        int k = 0;
        for (int j = 0; j < processResultList.length; j++) {
            if (processResultList[j].BurstTime != 0) {
                k++;
                break;
            }
        }
        if (k == 0) {
            return;
        }
        //test if in this moment there is a prosecces waiting or not ; 
        int start = 0;
        for (int j = 0; j < processResultList.length; j++) {
            if (processResultList[j].ArrivalTime <= time && processResultList[j].BurstTime > 0) {
                k = -1;
                //    start = j;
                break;
            }
        }
        if (k != -1) {
            rec(time + 1, 0);
            return;
        }
        start = -1;

        for (int i = 0; i < 2 * processResultList.length; i++) {
            if (processResultList[(idx) % processResultList.length].ArrivalTime <= time && processResultList[(idx) % processResultList.length].BurstTime > 0) {
                start = (idx) % processResultList.length;
                processResultList[(idx) % processResultList.length].ArrivalTime = time;
                break;
            }
            idx++;
        }
        if (start == -1) {
            rec(time + 1, (idx) % processResultList.length);
            return;
        }
        //
        k = Robcon;
        if (processResultList[start].BurstTime < Robcon) {
            k = Robcon;
            Robcon = processResultList[start].BurstTime;
        }
        for (int j = 0; j < processResultList.length; j++) {
            if (j != start && processResultList[j].ArrivalTime <= time && processResultList[j].BurstTime > 0) {
                processResultList[j].waitingIntervals.add(new Pair(time, time + Robcon));
                processResultList[j].waiting++;
                processResultList[j].turnaround++;
            } else if (j == start) {
                processResultList[j].turnaround++;
                processResultList[j].workingIntervals.add(new Pair(time, time + Robcon));
                processResultList[j].BurstTime -= Robcon;
                if (processResultList[j].BurstTime < 0) {
                    processResultList[j].BurstTime = 0;
                }
            }
            if (processResultList[j].ArrivalTime <= time) {
                processResultList[j].ArrivalTime = time + Robcon;
            }
        }
        int temp = Robcon;
        Robcon = k;
        rec(time + temp, (idx + 1) % processResultList.length);
        return;

    }


}





