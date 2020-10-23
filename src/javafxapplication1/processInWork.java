/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;
import javafx.util.Pair;

public class processInWork implements Comparable<processInWork> {

    int wait;
    int running;
    int age;
    int remainder;
    int PIC;
    int AraivalTime;
    int BurstTime;
    int Deadline;
    int remain;
    int turnaround;
    int waiting;
    int runn;
    static int sortas = 0;// 0 pic ,, 1 age ,, 2 arraival // 3 BurstTime
    ArrayList<Pair<Integer, Integer>> waitlist;
    ArrayList<Pair<Integer, Integer>> worklist;

    processInWork(int pic, int AraivalTime, int BurstTime, int Deadline) {
        this.AraivalTime = AraivalTime;
        this.BurstTime = BurstTime;
        this.Deadline = Deadline;
        this.PIC = pic;
        this.running = 0;
        this.turnaround = 0;
        this.waiting = 0;
        this.wait = 0;
        this.age = pic;
        waitlist = new ArrayList<Pair<Integer, Integer>>();
        worklist = new ArrayList<Pair<Integer, Integer>>();
    }

    @Override
    public int compareTo(processInWork o) {
        //Integer.compare(age, user.age)
        if (sortas == 0) {
            return Integer.compare(PIC, o.PIC);
        } else if (sortas == 1) {

            return Integer.compare(age, o.age);

        } else if (sortas == 2) {
            return Integer.compare(AraivalTime, o.AraivalTime);

        } else if (sortas == 3) {
            return Integer.compare(BurstTime, o.BurstTime);
        }
        return 0;
    }

    public int getPIC() {
        return PIC;
    }

    public int getAraivalTime() {
        return AraivalTime;
    }

    public int getBurstTime() {
        return BurstTime;
    }

    public int getTurnaround() {
        return turnaround;
    }

    public int getWaiting() {
        return waiting;
    }

}
