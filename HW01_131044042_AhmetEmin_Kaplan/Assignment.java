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
public interface Assignment {
    
    public String getNameOfAssignment();
    
    public int getSizeOfAssignment();
    
    public int getDeadLine();
    public int getLateDeadLine();
    public void setDeadLine(int dl);
    public void setLateDeadLine(int ldl);
    public void setNameOfAssignment(String _name);
    public ArrayList<User> getSubmissions();
    public void setSizeOfAssignment(int _size);

    
}
