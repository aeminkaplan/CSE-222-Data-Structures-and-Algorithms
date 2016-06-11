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
public class CompareCustomers implements Comparator<Customer>{
    
    /**
     * Compares two customers , first scale is arrival time . If two customers have same arrival time , comparator scales customer type
     * @param o1 customer
     * @param o2 customer
     * @return int 
     */
    @Override
    public int compare(Customer o1, Customer o2) {
             
        if(o1.getArrivalTime()>o2.getArrivalTime())
            return 1;
    
        else if(o1.getCustomerType()>o2.getCustomerType() && o1.getArrivalTime()==o2.getArrivalTime())
            return 1;
    
        else if(o2.getCustomerType()==o1.getCustomerType() && o1.getArrivalTime()==o2.getArrivalTime())
            return 0;
        
        else 
            return -1;
        
    }
    
}
