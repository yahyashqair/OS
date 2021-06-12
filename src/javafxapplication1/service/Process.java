/*
 * Feel free to use anything : )  */
package javafxapplication1.service;

import lombok.Data;

/**
 * @author YahyaShqair
 */
@Data
public class Process {
    public static int PICC = 0;
    public int PIC;
    public int AraivalTime;
    public int BurstTime;
    public int Deadline;

    public Process(int pic, int AraivalTime, int BurstTime, int Deadline) {
        PICC++;
        this.PIC = pic;
        this.AraivalTime = AraivalTime;
        this.BurstTime = BurstTime;
        this.Deadline = Deadline;
    }


}
