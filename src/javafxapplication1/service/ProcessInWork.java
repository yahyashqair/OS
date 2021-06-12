/*
 * Feel free to use anything : )  */
package javafxapplication1.service;

import java.util.ArrayList;

import javafx.util.Pair;
import lombok.Data;

@Data
public class ProcessInWork implements Comparable<ProcessInWork> {

    public int running;
    public int age;
    public int PIC;
    public int ArrivalTime;
    public int BurstTime;
    public int Deadline;
    public int turnaround;
    public int waiting;
    public static int sortBy = 0;// 0 pic ,, 1 age ,, 2 arrival // 3 BurstTime
    public ArrayList<Pair<Integer, Integer>> waitingIntervals;
    public ArrayList<Pair<Integer, Integer>> workingIntervals;

    public ProcessInWork(int pic, int ArrivalTime, int BurstTime, int Deadline) {
        this.ArrivalTime = ArrivalTime;
        this.BurstTime = BurstTime;
        this.Deadline = Deadline;
        this.PIC = pic;
        this.running = 0;
        this.turnaround = 0;
        this.waiting = 0;
        this.age = pic;
        waitingIntervals = new ArrayList<Pair<Integer, Integer>>();
        workingIntervals = new ArrayList<Pair<Integer, Integer>>();
    }

    @Override
    public int compareTo(ProcessInWork o) {
        //Integer.compare(age, user.age)
        if (sortBy == 0) {
            return Integer.compare(PIC, o.PIC);
        } else if (sortBy == 1) {
            return Integer.compare(age, o.age);
        } else if (sortBy == 2) {
            return Integer.compare(ArrivalTime, o.ArrivalTime);
        } else if (sortBy == 3) {
            return Integer.compare(BurstTime, o.BurstTime);
        }
        return 0;
    }
}
