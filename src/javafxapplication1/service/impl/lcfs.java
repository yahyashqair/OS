/*
 * Feel free to use anything : )  */
package javafxapplication1.service.impl;

import java.util.Arrays;

import javafx.util.Pair;
import javafxapplication1.service.Process;
import javafxapplication1.service.Algorithm;
import javafxapplication1.service.ProcessInWork;

/**
 * @author YahyaShqair
 */
public class lcfs extends Algorithm {

    //processInWork arr[];
    public Process[] pro;
    int timelimit;

    public lcfs(Process[] pro, int timelimit) {
        this.timelimit = timelimit;
        processResultList = new ProcessInWork[pro.length];
        for (int i = 0; i < pro.length; i++) {//int pic,int AraivalTime, int BurstTime, int Deadline
            processResultList[i] = new ProcessInWork(pro[i].PIC, pro[i].AraivalTime, pro[i].BurstTime, pro[i].Deadline);
        }
    }

    public void run() {
        ProcessInWork.sortBy = 2;
        Arrays.sort(processResultList);
        rec(0);
        System.out.println("javafxapplication1.service.impl.Priority.run()");
    }

    void rec(int i) {
        if (i >= timelimit) return;
        System.out.println("javafxapplication1.service.impl.Priority.rec()");
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
        ProcessInWork.sortBy = 2;
        Arrays.sort(processResultList);
        int start = 0;
        for (int j = processResultList.length - 1; j >= 0; j--) {
            if (processResultList[j].ArrivalTime <= i && processResultList[j].BurstTime > 0) {
                k = -1;
                start = j;
                break;
            }
        }
        if (k != -1) {
            rec(i + 1);
            return;
        }
        int adding = processResultList[start].BurstTime;
        for (int j = 0; j < processResultList.length; j++) {
            if (j != start && processResultList[j].ArrivalTime <= i && processResultList[j].BurstTime > 0) {
                processResultList[j].waiting += adding;
                processResultList[j].turnaround += adding;
                processResultList[j].waitingIntervals.add(new Pair(i, i + adding));
            } else if (j == start) {
                processResultList[j].turnaround += adding;
                processResultList[j].workingIntervals.add(new Pair(i, i + processResultList[start].BurstTime));
                processResultList[j].BurstTime = 0;
            } else if (processResultList[j].ArrivalTime <= i + adding && processResultList[j].BurstTime > 0) {
                processResultList[j].waiting += adding + i - processResultList[j].ArrivalTime;
                processResultList[j].turnaround += adding + i - processResultList[j].ArrivalTime;
                processResultList[j].waitingIntervals.add(new Pair(processResultList[j].ArrivalTime, adding + i));
            }


        }
        rec(i + adding);
        return;

    }

}
