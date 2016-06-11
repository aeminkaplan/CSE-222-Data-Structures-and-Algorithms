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
public class File extends AbstractDocument {
    
    private String extension;
    /**
     * File objeleri icin constructor
     * @param _name String
     * @param _size int 
     * @param _extension String 
     */
    public File(String _name,int _size,String _extension){
    
        super(_name, _size);
        extension=_extension;
        
    }
    /**
     * Dosya uzuntisini degistirir
     * @param _newExtension String
     */
    public void set_extension(String _newExtension)
    {
        extension=_newExtension;
    
    }
/**
 * Dosya uzantisini string formatinda return eder
 * @return String
 */
    public String get_extension(){
        
        return extension;
    }

}
