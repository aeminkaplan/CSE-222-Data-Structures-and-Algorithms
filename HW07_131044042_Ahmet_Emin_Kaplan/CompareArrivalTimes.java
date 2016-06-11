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

public class CompareArrivalTimes implements Comparator<Customer>{

    @Override
    public int compare(Customer o1, Customer o2) {
        if(o1.getArrivalTime()<o2.getArrivalTime())
            return 1;
        else if(o1.getArrivalTime()>o2.getArrivalTime())
            return -1;
        else
            return 0;
    }



}