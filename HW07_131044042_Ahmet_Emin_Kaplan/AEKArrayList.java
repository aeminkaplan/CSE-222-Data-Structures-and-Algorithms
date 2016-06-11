/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw07_131044042_ahmeteminkaplan;

/**
 *
 * @author aek
 * @param <E>
 */
public class AEKArrayList<E> {
 
    private E[] theData;
    private int size;
    private int capacity;
    
    /**
     * No Parameter constructor
     */
    public AEKArrayList(){
        
    theData=(E[]) new Object[10];
    capacity=10;
    size=0;
    
    }
    
    /**
     * Adds element to end of array list
     * @param param 
     */
    public void add(E param){
    
        if(size==capacity)
        {
            reAllocate();
        }
    
        theData[size]=param;
        ++size;
    }
    
    /**
     * Returns the item which in the parameter index
     * @param index
     * @return E-element
     */
    public E get(int index){
        return theData[index];
    }
    
    /**
     * Reallocates the data area when the all array full 
     */
    private void reAllocate(){
    
        E[] temp= (E[]) new Object[capacity*2];
        
        for(int i=0;i<size;++i)
        {
            temp[i]=theData[i];
        }
        theData=temp;
        capacity=capacity*2;
    }
    
    /**
     * Returns the size of array list
     * @return int - size
     */
    public int size(){
        return size;
    }
    
    /**
     * Sets the item which in the parameter index
     * @param index-index (int) 
     * @param object-a new object(E)
     */
    public void set(int index,E object){
    
        theData[index]=object;
    }
    
    /**
     *Returns the index of any object.If element doesnt exist , it returns -1 
     * @param object
     * @return index(int)
     */
    public int indexOf(E object){
        
            for(int i=0;i<size;++i)
            {
                if(theData[i].equals(object))
                    return i;
            }
    
            return -1;
    }
    
    /**
     * Removes the item which in given index and returns the removed item
     * @param index-int
     * @return E element
     */
    public E remove(int index){
    
    if(size==0)
        return null;
        
     E[] temp= (E[]) new Object[capacity];
     E temp2=theData[index];
     
     int counter=0;
     for(int i=0;i<size;++i)
     {
         if(i!=index){
             temp[counter]=theData[i];
             ++counter;
         }
   
     }
     --size;
     theData=temp;
     return temp2;
    }
    
    /**
     * Adds item to specific index of array list
     * @param index int 
     * @param param E 
     */
    public void add(int index,E param){
    

        int i;
        E temp;
        if(size==capacity)
            reAllocate();
    
        for(i=size-1;i>=index;--i)
        {
            theData[i+1]=theData[i];
        
        }
    
        
        theData[index]=param;
        ++size;
    }

    /**
     * Returns all items of array list with string format
     * @return String 
     */
    @Override
    public String toString() {
    
        int i;
        String temp="";
        for(i=0;i<size;++i)
        {
            temp+=String.format("%s ", theData[i]);
        }
        return temp;
    }
    
    
    
    
}
