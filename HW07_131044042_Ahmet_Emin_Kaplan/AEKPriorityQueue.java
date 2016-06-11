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
public class AEKPriorityQueue<E> {
    
    private AEKArrayList<E> datas;
    private Comparator _comparator=null;
    
    
    /**
     * Constructor
     * @param cmptr Comparator 
     */
    public AEKPriorityQueue( Comparator cmptr) {
    
        datas=new AEKArrayList<E>();
        _comparator=cmptr;
      
    }
    
    /**
     * Returns the size of Priority Queue
     * @return int size 
     */
    public int size(){
        return datas.size();
    }
    
    /**
     * Adds element to queue with priority order
     * @param data 
     */
    public void enqueue(E data)
    {
        
        
        int i;
        boolean flag=false;
        
        if(size()==0){
            datas.add(data);

        }
        else
        {
            for(i=0;i<size();++i)
            {
                if(_comparator.compare(datas.get(i), data)>0)
                {
                    datas.add(i,data);
                    flag=true;
                    break;
                }
            }
        
                    if(flag==false)
                        datas.add(data);
        }
        

    }
    
    /**
     * Removes first element of Queue and returns it
     * @return E
     */
    public E dequeue(){
        
       return datas.remove(0);
    
    }
    
    /**
     * Returns first element without removing it
     * @return E
     */
    public E peek(){
        return datas.get(0);
   }

    /**
     * Returns all elements with string format
     * @return 
     */
    @Override
    public String toString() {
    
        return datas.toString();
    }
    
    
}
