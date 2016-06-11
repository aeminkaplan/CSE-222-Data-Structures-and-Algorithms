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
public class CompareCustomerTypes implements Comparator<Customer>{
        
    /**
     * Compares two customers , first scale is customer type . If two customers have same customer type , comparator scales arrival time
     * @param o1
     * @param o2
     * @return 
     */
        @Override

        public int compare(Customer o1, Customer o2) {
             
        if(o1.getCustomerType()>o2.getCustomerType())
            return 1;
    
        else if(o1.getCustomerType()==o2.getCustomerType() && o1.getArrivalTime()>o2.getArrivalTime())
            return 1;
    
        else if(o2.getCustomerType()==o1.getCustomerType() && o1.getArrivalTime()==o2.getArrivalTime())
            return 0;
        
        else 
            return -1;
        
    }
}
