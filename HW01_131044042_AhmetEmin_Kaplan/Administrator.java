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
public class Administrator extends AbstractUser {
/**
 * Administrator e ait Constructor 
 * @param _name String
 * @param _surname String
 */
    public Administrator(String _name, String _surname) {

        name = _name;
        surname = _surname;
        allUsers.add(this);
        registration = true;

    }
    /**
     * Sisteme kayit istegi yollayan kullanicilarin hepsini sisteme kayit eder
     */
    public void activateAllRequest() {

        for (int i = 0; i < registrationRequests.size(); ++i) {
            addUserToSystem(registrationRequests.get(i));
        }

    }
    /**
     * Sisteme kayitli kullanicilarin listesini return eder
     * @return ArrayList User
     */
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    /**
     * Sisteme kayitli kullanicilari liste seklinde ekrana yazdirir
     */
    public void showAllUsers() {

        for (int i = 0; i < allUsers.size(); ++i) {
            System.out.printf("%d-%s", i + 1, allUsers.get(i));
        }

    }

    /**
     * Sisteme kullanici ekler eklenmeye calisilan kullanici zaten varsa exception firlatir
     * @param param User
     * @return boolean
     */
    public boolean addUserToSystem(User param) {
        try {
            boolean flag = true;
            int index = -1;

            for (int i = 0; i < allUsers.size(); ++i) {
                if (allUsers.get(i).getName().equals(param.getName())) {
                    flag = false;
                    break;

                }
            }

            if (flag) {
                allUsers.add(param);
                param.set_registration_status();
                return true;
            }
            throw new Exception("EXCEPTION:User was already added!");

        } catch (Exception a) {

            System.out.printf("%s", a.getMessage());
            return false;
        }
    }
/**
 * Sistemden kullanici siler eger silinmek istenen kullanici sistemde zaten yoksa exception firlatir
 * @param _name String
 * @param _surname String
 * @return boolean
 */
    public boolean deleteUserFromSystem(String _name, String _surname) {

        try {
            boolean flag = false;
            User temp = new Student("temp", "temp");

            for (int i = 0; i < allUsers.size(); ++i) {
                if (allUsers.get(i).getName().equals(_name)
                        && allUsers.get(i).getSurname().equals(_surname)) {
                    flag = true;
                    temp = allUsers.get(i);
                    break;
                }
            }

            if (flag) {
                int index = allUsers.indexOf(temp);
                allUsers.remove(index);
                temp.set_registration_status();
                for (int k = 0; k < allCourses.size(); ++k) {
                    for (int z = 0; z < allCourses.get(k).getList().size(); ++z) {
                        if (allCourses.get(k).getList().get(z).getName().equals(temp.getName())
                                && allCourses.get(k).getList().get(z).getSurname().equals(temp.getSurname())) {
                            int m = z;
                            allCourses.get(k).getList().remove(m);
                        }
                    }
                }
                return true;
            }
            throw new Exception("EXCEPTION:User wasnt found!");

        } catch (Exception a) {

            System.out.printf("%s\n", a.getMessage());
            return false;
        }
    }
/**
 * Sisteme ders ekler eklenmek istenen ders zaten sistemde varsa exception firlatir
 * @param param Course
 * @return boolean
 */
    public boolean addCourseToSystem(Course param) {
        try {
            boolean flag = false;

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(param.getCourseName())) {
                    flag = true;
                    break;

                }
            }

            if (!flag) {
                allCourses.add(param);
                return true;
            } else {
                throw new Exception("Course was already added!");
            }
        } catch (Exception a) {

            System.out.printf("EXCEPTION:%s\n", a.getMessage());
            return false;
        }
    }

    /**
     * Parametre olarak aldigi ders ismini sistemde bularak dersi siler eger ders zaten yoksa
     * exception firlatir
     * @param _courseName String
     * @return boolean 
     */
    public boolean deleteCourseFromSystem(String _courseName) {

        try {

            boolean flag = false;

            int index = -1;

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_courseName)) {
                    flag = true;
                    index = i;
                    break;
                }
            }

            if (flag) {
                allCourses.remove(index);
                return true;
            } else {
                throw new Exception("Course wasn't found");
            }

        } catch (Exception a) {

            System.out.printf("EXCEPTION:%s\n", a.getMessage());
            return false;

        }
    }
/**
 * Administrator objelerini String formatinda ifade eder
 * @return String 
 */
    @Override
    public String toString() {
        return String.format("Administrator - %s %s\n", getName(), getSurname());
    }
/**
 * Sistemde bulunan butun kurslari liste biciminde ekrana yazdirir.
 */
    @Override
    public void showAllCourses() {
        System.out.printf("Administrator views allcourses\n");
        super.showAllCourses(); //To change body of generated methods, choose Tools | Templates.
    }

}
