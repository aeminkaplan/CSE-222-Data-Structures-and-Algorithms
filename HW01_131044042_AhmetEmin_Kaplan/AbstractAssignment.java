/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044042_ahmetemin_kaplan;
import java.util.ArrayList;
/**
 *
 * @author aek
 */
public class AbstractAssignment implements Assignment{
    
    protected String assignmentName;
    protected int deadLine;
    protected int lateDeadLine;
    protected int assignmentSize;
    protected ArrayList<User> Submissions;
    /**
     * Assignment in ismini return eder.
     * @return String 
     */
    @Override
    public String getNameOfAssignment(){
         
         return assignmentName;
     }
     
    /**
     * Assignment in size inin return eder
     * @return int 
     */
    @Override
    public int getSizeOfAssignment(){
        
        return assignmentSize;
    }
    /**
     * Assignment in ismini set eder
     * @param _name  String
     */
    @Override
    public void setNameOfAssignment(String _name)
    {
        assignmentName=_name;
    }
    /**
     * 
     * @param _size int
     */
    @Override
    public void setSizeOfAssignment(int _size){
        assignmentSize=_size;
    }

    /**
     * Assignment in deadline ini return eder
     * @return int 
     */
    @Override
    public int getDeadLine() {
        return deadLine;
    }
    /**
     * Assignment in late deadline ini return eder
     * @return int 
     */
    @Override
    public int getLateDeadLine()
    {
        return lateDeadLine;
    }
    /**
     * Assignmentin deadlini set eder
     * @param _dl int
     */
    @Override
    public void setDeadLine(int _dl)
    {
        deadLine=_dl;
    }
    /**
     * Assignment in late deadline ini set eder
     * @param _ldl int 
     */
    @Override
    public void setLateDeadLine(int _ldl)
    {
        lateDeadLine=_ldl;
    }

    /**
     * Assignment a submit eden kisilerin listesini return eder
     * @return  ArrayList User
     */
    @Override
    public ArrayList<User> getSubmissions() {
    
        return Submissions;
    }

    /**
     * Assignmenti String formatinda ifade eder
     * @return String 
     */
    @Override
    public String toString() {
    
        return String.format("%s DeadLine:%d LateDeadLine:%d\n",getNameOfAssignment(),getDeadLine(),getLateDeadLine());
    }
    
    
    
    
    
}
