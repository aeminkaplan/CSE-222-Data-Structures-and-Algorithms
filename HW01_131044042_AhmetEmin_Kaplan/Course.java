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
public class Course {
    
    private ArrayList<User> List;
    private ArrayList<Document> allDocuments;
    private ArrayList<Assignment> allAssignments;
    private String courseTerm;
    private String courseName;
    
    /**
     * Derse kayitli kisilerin bulundugu listeyi return eder
     * @return ArrayList User
     */
    public ArrayList<User> getList(){
        return List;
    }
    /**
     * Teacher tarafindan eklenmis butun dokumanlarin bulundugu listeyi return eder
     * @return ArrayList Document
     */
    public ArrayList<Document> getAllDocuments(){
        return allDocuments;
    }
    /**
     * Teacher tarafindan eklenmis butun assignmentlarin bulundugu listeyi return eder
     * @return ArrayList Assignment
     */
    public ArrayList<Assignment> getAllAssignment(){
        return allAssignments;
    }
    /**
     * Course objeleri icin constructor
     * @param _name String
     * @param _term String
     */
    public Course(String _name,String _term){
    
        courseName=_name;
        courseTerm=_term;
        allDocuments=new ArrayList<Document>();
        List=new ArrayList<User>();
        allAssignments=new ArrayList<Assignment>();
    }
    /**
     * Course objelerinin isimlerini return eder
     * @return String
     */
    public String getCourseName(){
    
        return courseName;
    }
    /**
     * Course objelerinin isimlerini set eder
     * @param _name String
     */
    public void setCourseName(String _name){
    
        courseName=_name;
    }
    /**
     * Course objelerinin yeni veya eski kurs olup olamadigi bilgisini return eder
     * @return String 
     */
    public String getCourseTerm(){
        return courseTerm;
    }
    /**
     * Course objelerinin term memberlarini set eder
     * @param _newTerm String
     */
    public void setCourseTerm(String _newTerm)
    {
        courseTerm=_newTerm;
    }
/**
 * Course objelerini string formatinda ifade eder
 * @return String
 */
    @Override
    public String toString() {
       
        return String.format("%s-%s term",courseName,courseTerm);
    }

    
}
