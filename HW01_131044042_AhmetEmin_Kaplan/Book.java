/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044042_ahmetemin_kaplan;

/**
 *
 * @author aek
 */
public class Book extends AbstractDocument {
    
    private int numberOfPage;
    /**
     * Book objeleri icin constructor
     * @param _name String
     * @param size int 
     * @param _numberOfPage int 
     */
    public Book(String _name,int size,int _numberOfPage){
    
        super(_name, size);
        numberOfPage=_numberOfPage;
    
    }
    /**
     * Objenin sayfa sayisini return eder
     * @return int
     */
    public int getNumberOfPage(){
    
        return numberOfPage;
    }
/**
 * Objenin sayfa sayisini set eder
 * @param _newNumber int
 */
    public void setNumberOfPage(int _newNumber){
    
        numberOfPage=_newNumber;
    }
}
