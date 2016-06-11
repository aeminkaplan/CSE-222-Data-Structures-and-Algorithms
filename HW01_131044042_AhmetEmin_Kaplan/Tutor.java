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
public class Tutor extends Student {
    
    public Tutor(String _name,String _surname)
    {
        super(_name, _surname);
        registration=false;
    }

    @Override
    public void showAllCourses() {
        System.out.printf("Tutor views allcourses\n");
         for(int i=0;i<allCourses.size();++i)
        {
            System.out.printf("%d-%s\n",i+1,allCourses.get(i));
        }
    
    }

    @Override
    public String toString() {
    
        return String.format("Tutor - %s",super.toString());
    
    }

    
    
    
}
