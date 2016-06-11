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
public class Operand extends Expression {

    private int value;
    private char variable;

    /**
     * 
     * @param _value -int
     * Nonvariable olan operand olusturan constructor
     */
    public Operand(int _value) {
        value = _value;
        variable = '1';
    }
    
    /**
     * 
     * @param _var-char 
     * Variable dan operand olusturan metoddur
     */
    
    public Operand(char _var) {
        variable = _var;
        value = 1;
    }

    /**
     *
     * @return int
     * Operandin degerini return eden metoddur
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @return char Operand in degisken ismini return eden metoddur
     */
    public char getVariable() {
        return variable;
    }

    /**
     *
     * @param _value-int Operandin degerini degistiren metoddur
     */
    public void setValue(int _value) {
        value = _value;
    }

    /**
     *
     * @param _var -char Operandin variable ismini degistiren metoddur
     */
    public void setVariable(char _var) {
        variable = _var;
    }

    /**
     *
     * @return String Operand variable ise variable ismini degilse operand
     * degerini ekrana basar
     */
    @Override
    public String toString() {
        if (variable == '1') {
            return String.format(" %d", value);
        } else {
            return String.format(" %c", variable);
        }
    }

    /**
     *
     * @param obj - object
     * @return iki operand i karsilastiran metoddur eger
     */
    @Override
    public boolean equals(Object obj) {

        Operand temp = (Operand) obj;

        if (temp != null && temp.getVariable() == getVariable() && getVariable() != '1') {
            return true;
        } else if (temp != null && temp.getValue() == getValue() && getVariable() == '1' && temp.getVariable() == '1') {
            return true;
        }

        return false;
    }

}
