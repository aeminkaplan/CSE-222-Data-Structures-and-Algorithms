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
public class Student extends AbstractUser{
   /**
    * Student objeleri icin constructor
    * @param _name String
    * @param _surname String
    */
    public Student(String _name,String _surname){
        name=_name;
        surname=_surname;
        registration=false;
    }
/**
 * Verilen isimdeki dersin verilen isimdeki assignment ina submission ekler eger belirtilen ders ve
 * belirtilen assignment mevcutsa true return eder
 * @param _courseName String
 * @param targetAssignment String
 * @return boolean
 */
    public boolean addSubmission(String _courseName,String targetAssignment){
    
        Course temp=new Course("temp","temp");
        boolean flag=false;
        
       for(int i=0;i<allCourses.size();++i)
       {
           
        if(allCourses.get(i).getCourseName().equals(_courseName) 
                && allCourses.get(i).getList().contains(this) )
        {
            temp=allCourses.get(i);
            flag=true;
            break;
         }
       }
    
       if(flag){
           boolean flag2=false;
           Assignment temp2=new Homework("temp2",1,1);
           for(int j=0;j<temp.getAllAssignment().size();++j)
           {
               if(temp.getAllAssignment().get(j).getNameOfAssignment().equals(targetAssignment))
               {
                   temp2=temp.getAllAssignment().get(j);
                   flag2=true;
                   break;
               }
            }
       
           if(flag2){
               
               temp2.getSubmissions().add(this);
               return true;
           }
      }
       
       return false;
    }
    /**
     * Student objelerinin gorebildigi yani eski olmayan kurslari listeleyen metoddur
     * Courselari listelemeden once yeni mi eski mi oldugunu kontrol eder
     */
    @Override
    public void showAllCourses() {
      System.out.printf("Student views allcourses\n");
        int counter=1;
            for(int i=0;i<allCourses.size();++i)
            {   
                if(allCourses.get(i).getCourseTerm().equals("New"))
                {
                    System.out.printf("%d-%s\n",counter,allCourses.get(i));
                    ++counter;
                }
            }
    }
    /**
     * Verilni isimdeki derste teacher tarafindan eklenen butun assignmentlari listeleyen metoddur
     * @param _courseName String
     */
    public void showAllAssignments(String _courseName){
    
        Course temp=new Course("temp","temp");
        boolean flag=false;
        
       for(int i=0;i<allCourses.size();++i)
       {
          if(allCourses.get(i).getCourseName().equals(_courseName)){
             temp=allCourses.get(i);
             break;
          }
       }
       if(temp.getCourseTerm().equals("New")){
            for(int k=0;k<temp.getAllAssignment().size();++k)
            {
                System.out.printf("%d-%s",k+1,temp.getAllAssignment().get(k));
            }
       }
    }
    /**
     * Student tarafindan sisteme kayit olma istegi yollamaya yarayan metoddur
     * eger daha once istek yollanmamissa true return eder aksi durumda false return eder
     * @return boolean 
     */
    public boolean sendRegistrationRequest(){
        
        try{

     boolean flag=true;
     for(int i=0;i<registrationRequests.size();++i)
     {
         if(registrationRequests.get(i).getName().equals(getName())
                 && registrationRequests.get(i).getSurname().equals(getSurname()))
         {
             flag=false;    
             break;
         } 
     }
    if(!get_registration_status() && flag )
    {
        registrationRequests.add(this);
        return true;
    }
        throw new Exception("Registration request rejected!");
    }
        catch(Exception a){
        
        System.out.printf("%s\n",a.getMessage());
        return false;
        }
    }
    
    /**
     * Verilen isimdeki dersin detaylarini goruntuleyen metoddur
     * @param CourseName String
     */
    @Override
    public void showCourseDetails(String CourseName) {
  
       for(int i=0;i<allCourses.size();++i)
       {
           if(allCourses.get(i).getCourseName().equals(CourseName) &&
                   allCourses.get(i).getCourseTerm().equals("New"))
                  super.showCourseDetails(CourseName);
        }
    }

    /**
     * Student objelerinin String formatinda ifade edilmesini saglayan metoddur
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Student - %s %s\n",getName(),getSurname());
    }

    
}
