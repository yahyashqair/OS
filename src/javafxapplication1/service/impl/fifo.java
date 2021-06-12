/*
 * Feel free to use anything : )  */
package javafxapplication1.service.impl;

import java.util.Arrays;
import javafx.util.Pair;
import javafxapplication1.service.Process;
import javafxapplication1.service.ProcessInWork;

/**
 *
 * @author YahyaShqair
 */
public class fifo {
    public ProcessInWork[] arr;
    public Process[] pro;
    fifo(Process[] arr){
                
    }
    
    public ProcessInWork[] run(ProcessInWork[] arr){
        Arrays.sort(arr);
        int start=0,end=arr[0].BurstTime;
        for (int i = 0; i < arr.length; i++) {
            end= arr[i].BurstTime+start;
            arr[i].workingIntervals.add(new Pair(start,end));
            for(int j = 0 ; j < arr.length;j++){
                if(j!=i){
                    arr[i].waitingIntervals.add(new Pair(start,end));
                }
            }
            start=arr[i].BurstTime+start;
            
        }
        return arr;
    }
    
    
    
    
}
