/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw04_131044042_ahmetemin_kaplan;

/**
 *
 * @author aek
 */
public class Operator extends Expression {

    private char operatorType;
    private int priority;
    
    /**
     * 
     * @param _operatorType -char
     * character den operator ureten constructor
     * 
     */
    public Operator(char _operatorType)  {
        
        if(_operatorType=='+' || _operatorType=='-')
            priority=2;
        else if(_operatorType=='*' || _operatorType=='/')
            priority=3;
        else if(_operatorType=='=')
            priority=1;
        
        operatorType=_operatorType;
            
    }
    
    /**
     * 
     * @return char
     * Operatorun tipini return eden metoddur
     */
    public char getOperator(){
       return operatorType;
    }
    
    /**
     * 
     * @return int
     * Operatorun oncelik degerini return eden metoddur
     */
    public int getPriority(){
        return priority;
    }
    /**
     * 
     * @param obj-object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
    
        Operator temp=(Operator)obj;
        if(temp!=null)
        {
            if(temp.getOperator()==getOperator())
                return true;
            else
                return false;
        }
                return false;
    }

    
    /**
     * 
     * @return String
     * Operatoru string formunda ifade ettiren metoddur
     */
    @Override
    public String toString() {
        return String.format( " %c",operatorType); //To change body of generated methods, choose Tools | Templates.
    }
    
}
