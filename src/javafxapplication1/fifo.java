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
public class fifo {
    processInWork arr[];
    Process pro[];
    fifo(Process arr[]){
                
    }
    
    processInWork[] run(processInWork[] arr){
        Arrays.sort(arr);
        int start=0,end=arr[0].BurstTime;
        for (int i = 0; i < arr.length; i++) {
            end= arr[i].BurstTime+start;
            arr[i].worklist.add(new Pair(start,end));
            for(int j = 0 ; j < arr.length;j++){
                if(j!=i){
                    arr[i].waitlist.add(new Pair(start,end));
                }
            }
            start=arr[i].BurstTime+start;
            
        }
        return arr;
    }
    
    
    
    
}
