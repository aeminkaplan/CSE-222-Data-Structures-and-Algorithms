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
public interface Document {
    

    public int getFileSize();
    public String getFileName();
    public void setFileName(String _name);
    public void setFileSize(int _size);
}
