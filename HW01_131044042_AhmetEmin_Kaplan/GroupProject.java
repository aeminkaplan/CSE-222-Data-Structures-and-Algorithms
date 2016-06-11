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
public class GroupProject extends AbstractAssignment {

    /**
     * GroupProjeect objeleri icin constructor
     * @param _aname String
     * @param dl int(deadline)
     * @param ldl int(late deadline) 
     */
    public GroupProject(String _aname,int dl,int ldl){
        
        deadLine=dl;
        lateDeadLine=ldl;
        assignmentName=_aname;
        Submissions=new ArrayList<>();
        
    }
    
    
}
