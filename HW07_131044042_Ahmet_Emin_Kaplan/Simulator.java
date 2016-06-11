/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw07_131044042_ahmeteminkaplan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aek
 */
public class Simulator {
    
    private AEKPriorityQueue<Customer> AllCustomers;
    private AEKPriorityQueue<Customer> ProcessQueue;
    private int SimulatorTime=0;
    private int Transaction=1;
    private String outputStr;
    private FileWriter output;
    private BufferedWriter myBufferedWriter;
    private int ServedC1=0;
    private int ServedC2=0;
    private int ServedC3=0;
    public static int a=0;
    /**
     * Constructor
     * @param CustomerList 
     */
    public Simulator(AEKPriorityQueue<Customer> CustomerList) throws IOException {
            AllCustomers=CustomerList;
            ProcessQueue=new AEKPriorityQueue<Customer>(new CompareCustomerTypes());
            outputStr="";
            output = new FileWriter("output.txt");
            myBufferedWriter = new BufferedWriter(output);
    }
    
    
    /**
     *  Updates process queue . Adds customers which arrival times is between simulator time and simulator time+transaction to process queue
     * 
     */
    public void UpdateProcessQueue() throws IOException{
        
        Customer tempRef;
        
        while( SimulatorTime<=1440 && AllCustomers.size()>0){
            //System.out.printf("debug3\n");
        for(;;)
        {
            //System.out.printf("debug2");
            tempRef=AllCustomers.peek();
            if( tempRef!=null && tempRef.getArrivalTime()<=SimulatorTime+Transaction)
            {  // System.out.printf("::::::::%s\n",tempRef);
                AllCustomers.dequeue();
                ProcessQueue.enqueue(tempRef);
            }
            else
                break;
        }
        
           ProcessCustomer();
           if(SimulatorTime==1200)
               printResults();
        }
        int n=ProcessQueue.size();
        for(int i=0;i<n;++i)
        {      
          ProcessCustomer();
        }
            printResults();
             myBufferedWriter.close();
             System.out.printf("Number of Served Customer1 :%d\n",ServedC1);
             System.out.printf("Number of Served Customer2 :%d\n",ServedC2);
             System.out.printf("Number of Served Customer3 :%d\n",ServedC3);
    }
    
    /**
     * Processes a customer and updates transaction and simulator time 
     */
    public void ProcessCustomer(){
    
        
        Customer tempRef;
       // System.out.printf("size:%d\n",ProcessQueue.size());
            tempRef=ProcessQueue.peek();
            
        if(tempRef!=null/* && tempRef.getArrivalTime()<SimulatorTime+Transaction*/){
        tempRef=ProcessQueue.dequeue();

        if(tempRef!=null){
            
         // System.out.printf("Service Time-> %d:%d   ",SimulatorTime/60,SimulatorTime%60);

           // System.out.printf("%s",tempRef);
           
            if(tempRef.getCustomerType()==1)
            {
                ++ServedC1;
            }
            else if(tempRef.getCustomerType()==2)
            {
                ++ServedC2;
            }
            else if(tempRef.getCustomerType()==3)
            {
                ++ServedC3;
            }
            
    
        }
        //  SimulatorTime+=Transaction;
            //System.out.printf("%s\n\n",ProcessQueue);
            //Transaction=tempRef.getTransactionDuration();
        // tempRef=ProcessQueue.peek();
        }
        
         SimulatorTime+=Transaction;
         
         if(tempRef!=null){   
         Transaction=tempRef.getTransactionDuration();
         
                      outputStr+=String.format("Service Time-> %d:%d   ",SimulatorTime/60,SimulatorTime%60);
          outputStr+=String.format("%s",tempRef);
         
         }
         else
             Transaction=1;
    }

    
    /**
     * Simulator method 
     * @throws java.io.IOException
     */
    public void Simulate() throws IOException{
        UpdateProcessQueue();
        System.out.printf("All results in output.txt\n");
    }

    /**
     * prints service and customer informations to file "output.txt"
     * @throws IOException 
     */
    private void printResults() throws IOException{
        
        

        myBufferedWriter.write(outputStr);
        outputStr="";
   
    
    }
}
