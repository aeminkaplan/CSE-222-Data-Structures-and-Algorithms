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
public interface User {

   public String getName();
   public String getSurname();
   public void setName(String _name);
   public void setSurname(String _surname);
   public void showAllCourses();
   public void showCourseDetails(String CourseName);
   public int getNumberOfUserOnSystem();
   public boolean get_registration_status();
   public void set_registration_status();

}
