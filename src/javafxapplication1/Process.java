/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author YahyaShqair
 */
public class Process {
     static int PICC=0 ; 
     int PIC;
     int AraivalTime;
     int BurstTime;
     int Deadline;

    public static int getPICC() {
        return PICC;
    }

    public static void setPICC(int PICC) {
        Process.PICC = PICC;
    }

    public int getPIC() {
        return PIC;
    }

    public void setPIC(int PIC) {
        this.PIC = PIC;
    }

    public int getAraivalTime() {
        return AraivalTime;
    }

    public void setAraivalTime(int AraivalTime) {
        this.AraivalTime = AraivalTime;
    }

    public int getBurstTime() {
        return BurstTime;
    }

    public void setBurstTime(int BurstTime) {
        this.BurstTime = BurstTime;
    }

    public int getDeadline() {
        return Deadline;
    }

    public void setDeadline(int Deadline) {
        this.Deadline = Deadline;
    }

    public Process(int pic,int AraivalTime, int BurstTime, int Deadline) {
        PICC++;
        this.PIC=pic;
        this.AraivalTime = AraivalTime;
        this.BurstTime = BurstTime;
        this.Deadline = Deadline;
    }
     
    
    
}
