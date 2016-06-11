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
abstract public class AbstractUser implements User {
    
    protected boolean registration;
    protected  String name;
    protected  String surname;
    protected  static ArrayList<User> allUsers=new ArrayList<>();
    protected static ArrayList<Course> allCourses=new ArrayList<>();
    protected static ArrayList<User> registrationRequests=new ArrayList<>();
    
    /**
     * Userlarin sisteme kayit durumunu ifade eder statuyu degistirir
     */
    @Override
    public void set_registration_status() {
        registration=!registration;
    }

    /**
     * Userlarin sisteme kayit durumunu return eder
     * @return boolean 
     */
    @Override
    public boolean get_registration_status() {
        return registration;
    }
    
    
    /**
     * Userlarin isimlerini set eder
     * @param _name String
     */
    @Override
    public void setName(String _name){
    
        name=_name;
    }
/**
 * Userlarin soyisimlerini set eder
 * @param _surname String
 */
    @Override
    public void setSurname(String _surname){
    
        surname=_surname;
    }
    /**
     * Userlarin isimlerini return eder
     * @return String
     */
    @Override
    public String getName(){
    
        return name;
    }

    /**
     * Userlarin soyisimlerini return eder
     * @return String 
     */
    @Override
    public String getSurname(){
    
        return surname;
    }
/**
 * Userlar icin sistemde kayitli olan kurslari ekrana yazdirir
 */
    @Override
    public void showAllCourses(){
    
        for(int i=0;i<allCourses.size();++i)
        {
            System.out.printf("%d-%s\n",i+1,allCourses.get(i));
        }
    
    }
    
    /**
     * Parametre olarak aldigi kurs ismine gore girilen kursun detaylarini ekrana yazdirir
     * @param CourseName String 
     */
    @Override
    public void showCourseDetails(String CourseName)
    {
        for(int i=0;i<allCourses.size();++i)
        {
            if(allCourses.get(i).getCourseName().equals(CourseName)){
            
                System.out.printf("%s",allCourses.get(i));
                return; 
            }
        }
    
        System.out.printf("%s isminde herhangi bir ders yok\n",CourseName);
    }
    
    /**
     * Sisteme kayitli user sayisini return eder
     * @return int 
     */
    @Override
    public int getNumberOfUserOnSystem(){
        return allCourses.size();
    }



}
