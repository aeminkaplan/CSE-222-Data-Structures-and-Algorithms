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
public class HW01_131044042_AhmetEmin_Kaplan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        
        /*Admin objesi olusturuldu ve constructer cagirilinca
        otomatik olarak kendini sisteme kaydediyor */
        Administrator admin1=new Administrator("ahmet","kaplan");
        
        
        
        /*Teacher objesi olusturuldu ama henuz sisteme kayitli degil*/
        Teacher Teacher1=new Teacher("erdogan","sevilgen","prof");
        
       
        /*Student objeleri olusturuldu ama henuz sisteme kayitli degiller*/
        Student student1=new Student("hasan","ceylan");
        
        Student student2=new Student("ali","demir");
        
        Student student3=new Student("mehmet","celik");
        
        Student student4=new Student("furkan","yilmaz");
        
        Student student5=new Student("burak","aslan");
        
        Tutor tutor1=new Tutor("yasin","cakir");
        
        /*Course objeleri olusturuldu ama henuz sisteme kayitli degiller*/
        Course bil102=new Course("bil102","New");
        
        Course bil104=new Course("bil104","Old");
        
        Course bil222=new Course("bil222","New");
        
        Course bil241=new Course("bil241","New");
        
        /*Document objeleri olusturuldu ama henuz bir derse ait degiller*/
        
        Document document1=new Book("introduction to cs",100,70);
        Document document2=new Slide("lectureslides",100);
        Document document3=new File("ps notes", 50,"zip");
        
        /*Assignment objeleri olusturuldu ama henuz bir derse ait degiller*/
        
        Assignment quiz1=new Quiz("quiz1",7,10);
        Assignment quiz2=new Quiz("quiz2",8,11);
        Assignment quiz4=new Quiz("quiz4",5,11);
        Assignment homework1=new Homework("hw1",4,6);
        Assignment homework2=new Homework("hw2",2,7);
        Assignment homework3=new Homework("hw3",3,9);
        
        /*Teacher1 , Student1,Student2,Student3 sisteme manuel olarak
        admin tarafindan kaydediliyor*/
        admin1.addUserToSystem(Teacher1);
        
        admin1.addUserToSystem(student1);
        
        admin1.addUserToSystem(student2);
        
        admin1.addUserToSystem(student3);
        
        admin1.addUserToSystem(tutor1);
        
        /*Student4 ve student5 sisteme henuz kayitli degiller ve kayit istegi yolluyorlar*/
        student4.sendRegistrationRequest();
        
        student5.sendRegistrationRequest();
        
        
        /*Admin course lari sisteme ekliyor*/
        admin1.addCourseToSystem(bil102);
      
        admin1.addCourseToSystem(bil104);
        
        admin1.addCourseToSystem(bil222);
        
      
        admin1.addCourseToSystem(bil241);
        
        /*Kayit istegi yollayan studentler admin tarafindan kayit ediliyor*/
        
        admin1.activateAllRequest();
        
          System.out.printf("Admin views all Users:\n*********************************\n");
          admin1.showAllUsers();
          System.out.printf("*********************************\n\n");

          
          System.out.printf("Admin views all Courses:\n//////////////////////////////////\n");
          admin1.showAllCourses();
          System.out.printf("//////////////////////////////////\n");

          
          /*burak aslan ve bil241 dersi admin  tarafindan siliniyor*/
          admin1.deleteUserFromSystem("burak","aslan");
          admin1.deleteCourseFromSystem("bil241");
          
          System.out.printf("\n\n\nAdmin views all Users after deleting:\n*********************************\n");
          admin1.showAllUsers();
          System.out.printf("*********************************\n\n");

          
          System.out.printf("Admin views all Courses after deleting:\n//////////////////////////////////\n");
          admin1.showAllCourses();
          System.out.printf("//////////////////////////////////\n");
          
          
          
         /*Teacher studentleri derslere ekliyor*/
          Teacher1.addUserToCourse("bil102",student1);
          Teacher1.addUserToCourse("bil102",student2);
          Teacher1.addUserToCourse("bil104",student3);
          Teacher1.addUserToCourse("bil104",student4);
          Teacher1.addUserToCourse("bil102",tutor1);
          
          /*Teacher derslere document eklemesi yapiyor*/
          Teacher1.addDocument("bil102", document1);
          Teacher1.addDocument("bil102", document2);
          Teacher1.addDocument("bil104", document3);
          
          /*Teacher derslere assignment eklemesi yapiyor*/
          Teacher1.addAssignment("bil102", quiz1);
          Teacher1.addAssignment("bil104", homework1);
          Teacher1.addAssignment("bil102", quiz2);
          Teacher1.addAssignment("bil104", homework2);
          Teacher1.addAssignment("bil102", quiz4);
          Teacher1.addAssignment("bil104", homework3);
          
          
          System.out.printf("\n\n\nTeacher views all members of bil102:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllMembers("bil102");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          System.out.printf("\nTeacher views all members of bil104:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllMembers("bil104");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
                    
          System.out.printf("\n\n\nTeacher views all Documents of bil102:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllDocuments("bil102");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          System.out.printf("\nTeacher views all Documents of bil104:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllDocuments("bil104");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          
                    
          System.out.printf("\n\n\nTeacher views all Assignments of bil102:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllAssignments("bil102");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          System.out.printf("\nTeacher views all Assignments of bil104:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllAssignments("bil104");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          
          
          
          
          Teacher1.deleteUserFromCourse("ali","demir","bil102");
          Teacher1.deleteUserFromCourse("furkan","yilmaz","bil104");
          Teacher1.deleteDocument("bil102","introduction to cs");
          Teacher1.deleteDocument("bil104", "lectureslides");
          Teacher1.deleteAssignment("bil102","quiz4");
          Teacher1.deleteAssignment("bil104","hw3");
          
             System.out.printf("\n\n\nTeacher views all members of bil102 after deleting:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllMembers("bil102");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          System.out.printf("\nTeacher views all members of bil104 after deleting:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllMembers("bil104");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
             System.out.printf("\n\n\nTeacher views all Documents of bil102 after deleting:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllDocuments("bil102");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          System.out.printf("\nTeacher views all Documents of bil104 after deleting:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllDocuments("bil104");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
           System.out.printf("\n\n\nTeacher views all Assignments of bil102 after deleting:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllAssignments("bil102");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          System.out.printf("\nTeacher views all Assignments of bil104 after deleting:\n+++++++++++++++++++++++++++++++++++\n");
          Teacher1.showAllAssignments("bil104");
          System.out.printf("++++++++++++++++++++++++++++++++++\n");
          
          
          /*bil102 dersine kayitli olan tek ogrenci hasan ceylan assignmentlara
          submission ekliyor*/
          
          student1.addSubmission("bil102","quiz1");
          student1.addSubmission("bil102","quiz2");
          
          /*bil104 dersine kayitli olan mehmet celik assignmentlara
          submission ekliyor*/
          
          student3.addSubmission("bil104","hw1");
          student3.addSubmission("bil104","hw2");
          
          System.out.printf("Teacher views who submitted for bil104 - hw1\n");
          Teacher1.seeWhoSubmitted("bil104","hw1");
          
          System.out.printf("---------------------------------------------------\n");
          
          System.out.printf("Teacher views who submitted for bil104 - hw2\n");  
          Teacher1.seeWhoSubmitted("bil104","hw2");
          
          System.out.printf("---------------------------------------------------\n");
          
          System.out.printf("Teacher views who submitted for bil102 - quiz1\n");
          Teacher1.seeWhoSubmitted("bil102","quiz1");
            
          System.out.printf("---------------------------------------------------\n");
          
          System.out.printf("Teacher views who submitted for bil102 - quiz2\n");
          Teacher1.seeWhoSubmitted("bil102","quiz2");
          
          System.out.printf("---------------------------------------------------\n");
          
          
          /*Dongu ile butun userlar icin polymorphic cagri yapiliyor*/
          /*Eger kisi Teacher veya tutor ise Old term kurslarida gorebilir*/
          /*Student ise goremez*/
          for(int t=0;t<admin1.getAllUsers().size();++t)
          {
              System.out.printf("\nPolymorphic Call step :%d\n",t+1);
              admin1.getAllUsers().get(t).showAllCourses();
              
          }
    }
    
}
