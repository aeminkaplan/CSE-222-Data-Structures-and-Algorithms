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
public abstract  class AbstractDocument implements Document {

    private int fileSize;
    private String fileName;
    /**
     * AbstractDocument icin Constructor subclasslarda kullanilabilir
     * @param _name String
     * @param _size int
     */
    public AbstractDocument(String _name,int _size){
    
        fileSize=_size;
        fileName=_name;
    
    }
    
    /**
     * Document in size ini set eder
     * @param _size int
     */
    @Override
    public void setFileSize(int _size) {
        fileSize=_size;
    }

    /**
     * Documentin ismini set eder
     * @param _name String
     */
    @Override
    public void setFileName(String _name) {
        fileName=_name;
    }

    /**
     * Document in ismini return eder
     * @return String 
     */
    @Override
    public String getFileName() {
        return fileName;
    }

    /**
     * Document in sizenini return eder
     * @return int
     */
    @Override
    public int getFileSize() {
        return fileSize;
    }

    /**
     * Documentleri string formatinda ifade eder
     * @return String 
     */
    @Override
    public String toString() {
    
        return String.format("%s Description:%s\n",getFileName(),getFileSize());
    }
    
    
    
    
}
