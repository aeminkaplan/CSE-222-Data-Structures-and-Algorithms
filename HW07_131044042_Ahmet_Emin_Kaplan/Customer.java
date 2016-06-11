/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw07_131044042_ahmeteminkaplan;

import java.util.Comparator;

/**
 *
 * @author aek
 */
public class Customer implements Comparable<Object>{
    
    private int ArrivalTime;
    private int TransactionDuration;
    private int CustomerType;

    /**
     * Constructor
     * @param _Ar ArrivalTime
     * @param _Tr Transaction
     * @param _Ct CustomerType
     */
    public Customer(int _Ar,int _Tr,int _Ct) {
    
        ArrivalTime=_Ar;
        TransactionDuration=_Tr;
        CustomerType=_Ct;
    }
    
    /**
     * Returns arrival time of customer
     * @return int
     */
    public int getArrivalTime()
    {
        return ArrivalTime;
    }
    
    /**
     * Returns customer type of customer
     * @return int
     */
    public int getCustomerType()
    {
        return CustomerType;
    }

    
    /**
     * Returns transaction duration of customer
     * @return int
     */
    public int getTransactionDuration(){
        return TransactionDuration;
    }
    
    /**
     * Compares two customer
     * @param o object
     * @return int
     */
    @Override
    public int compareTo(Object o) {
       
        Customer temp=(Customer)o;
        
        if(ArrivalTime>temp.ArrivalTime)
            return 1;
    
        else if(CustomerType>temp.CustomerType && ArrivalTime==temp.ArrivalTime)
            return 1;
    
        else if(temp.CustomerType==CustomerType && temp.ArrivalTime==ArrivalTime)
            return 0;
        
        else 
            return -1;
    }

    /**
     * Returns customer information with string format
     * @return 
     */
    @Override
    public String toString() {
    
        return String.format("%d:%d %d %d\n",ArrivalTime/60,ArrivalTime%60,TransactionDuration,CustomerType);
    }
    
    
    
    
    
}

