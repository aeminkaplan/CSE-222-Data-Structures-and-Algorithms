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
public class Register {

    private Operand data;
    private boolean isFree;
    private String registercode;
    /**
     * 
     * @param rcode-String
     * Register kodunu initialize eden constructor
     */
    public Register(String rcode) {

        registercode = rcode;
        isFree = true;
        data = new Operand(-1);
    }
    
    /**
     * 
     * @return Operand
     * Registerda kayitli operand verisini return eder
     */
    public Operand getData() {

        return data;
    }

    /**
     * 
     * @param _newData-Operand 
     * OAldigi operand tipindeki veriyi registerin icine kaydeder
     */
    public void setData(Operand _newData) {

        data.setValue(_newData.getValue());

        isFree = false;
    }

    /**
     *  Registeri free leyen metoddur
     */
    public void makeFree() {

        if (isFree == false) {
            isFree = true;
        }
    }

    /**
     * 
     * @return boolean - Registerin free olup olmadigini dondurur
     */
    public boolean IsFree() {
        return isFree;
    }
    /**
     * 
     * @return String - registerCode return eder 
     */
    public String getRcode(){
        return registercode;
    }
    /**
     * 
     * @param obj-object
     * @return boolean 
     */
    @Override
    public boolean equals(Object obj) {
    
        Register temp= (Register)obj;
        if(temp!=null)
        {   
            if(temp.getRcode().compareTo(registercode)==0)
                   return true;
            return false;
        }
        return false; 
               
    }

    
    /**
     *
     * @return String - Register in ismini ekrana yazdiran toString metodu
     */
    @Override
    public String toString() {
        return String.format("$%s", registercode);
    }

}
