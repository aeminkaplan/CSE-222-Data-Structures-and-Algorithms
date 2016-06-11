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
public class Teacher extends AbstractUser {

    private String academicPosition;

    /**
     * Teacher objesi icin constructor
     *
     * @param _name String
     * @param _surname String
     * @param _academicP String
     */
    public Teacher(String _name, String _surname, String _academicP) {
        name = _name;
        surname = _surname;
        academicPosition = _academicP;
        registration = false;
    }

    /**
     * Teacher in academic pozisyonunu return eder
     *
     * @return String
     */
    public String getAcademicPosition() {
        return academicPosition;
    }

    /**
     * Teacher in academic pozisyonunu set eder
     *
     * @param _newAcademicPos String
     */
    public void setAcademicPosition(String _newAcademicPos) {

        academicPosition = _newAcademicPos;
    }

    /**
     * Girilen ders isminin girilen isimli assignmentina kimlerin submission
     * yaptigini listeler
     *
     * @param _courseName String
     * @param _assignmentName String
     * @return boolean
     */
    public boolean seeWhoSubmitted(String _courseName, String _assignmentName) {

        try {
            Assignment temp2 = new Homework("temp2", -1, -1);
            boolean flag = false;
            boolean flag2 = false;

            Course temp = new Course("temp", "temp");

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_courseName)) {
                    temp = allCourses.get(i);
                    flag = true;
                    break;
                }
            }

            if (flag) {

                for (int k = 0; k < temp.getAllAssignment().size(); ++k) {
                    if (temp.getAllAssignment().get(k).getNameOfAssignment().equals(_assignmentName)) {
                        flag2 = true;
                        temp2 = temp.getAllAssignment().get(k);
                        break;
                    }
                }

            }

            if (flag && flag2) {
                for (int t = 0; t < temp2.getSubmissions().size(); ++t) {
                    System.out.printf("%s", temp2.getSubmissions().get(t));
                }
                return true;
            }

            throw new Exception("Access Denied!");

        } catch (Exception a) {
            System.out.printf("%s\n", a.getMessage());
            return false;

        }
    }

    /**
     * Girilen kurs ismiyle belirtilen kursa kullanici ekleyen metoddur.Eger
     * kullanici zaten kursun uyesiyse exception firlatir
     *
     * @param _courseName String
     * @param member User
     * @return boolean
     */
    public boolean addUserToCourse(String _courseName, User member) {

        try {
            if (!registration || !member.get_registration_status()) {

                throw new Exception("Users arent members of system!");
            }

            boolean flag1 = false;
            boolean flag2 = true;

            Course temp = new Course("temp", "temp");

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_courseName)) {
                    temp = allCourses.get(i);
                    flag1 = true;
                    break;
                }
            }

            if (flag1) {
                for (int j = 0; j < temp.getList().size(); ++j) {
                    if (temp.getList().get(j).getName().equals(member.getName())
                            && temp.getList().get(j).getSurname().equals(member.getSurname())) {
                        flag2 = false;
                        break;
                    }
                }
            }

            if (flag1 && flag2) {
                temp.getList().add(member);
                return true;
            }

            throw new Exception("User wasnt added to system!");

        } catch (Exception a) {
            System.out.printf("%s\n", a.getMessage());
            return false;

        }
    }

    /**
     * Girilen user ismi ve soyismi ve ders ismi ile sistemde arama yapar
     * belirtilen derste belirtilen kisi member durumundaysa kisi silinir ve
     * true return edilir aksi durumda exception firlatilir
     *
     * @param _name String
     * @param _surname String
     * @param _courseName String
     * @return boolean
     */
    public boolean deleteUserFromCourse(String _name, String _surname, String _courseName) {

        try {
            if (!registration) {
                throw new Exception("Teacher is not member of system!");
            }

            Course temp = new Course("temp", "temp");
            User temp2 = new Student("temp2", "temp");
            boolean flag1 = false;
            boolean flag2 = false;
            int index = -1;

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_courseName)) {
                    flag1 = true;
                    temp = allCourses.get(i);
                    break;
                }
            }

            if (flag1) {
                for (int j = 0; j < temp.getList().size(); ++j) {
                    if (temp.getList().get(j).getName().equals(_name)
                            && temp.getList().get(j).getSurname().equals(_surname)) {
                        flag2 = true;
                        temp2 = temp.getList().get(j);
                        index = j;
                        break;
                    }
                }
            }

            if (flag1 && flag2) {
                //int index=temp.getList().indexOf(temp2);
                temp.getList().remove(index);
                return true;
            }
            throw new Exception("User wasnt deleted!");
        } catch (Exception a) {
            System.out.printf("%s\n", a.getMessage());
            return false;
        }
    }

    /**
     * Parametre olarak aldigi course objesinin memberlarini liste biciminde
     * ekrana yazdirir
     *
     * @param c_param Course
     */
    public void showAllMembers(Course c_param) {

        for (int i = 0; i < c_param.getList().size(); ++i) {
            System.out.printf("%d-%s", i + 1, c_param.getList().get(i));
        }
    }

    /**
     * Belirtilen isimdeki dersin uyelerine eriserek ekrana yazdiran metoddur
     *
     * @param _courseName String
     */
    public void showAllMembers(String _courseName) {

        for (int i = 0; i < allCourses.size(); ++i) {
            if (allCourses.get(i).getCourseName().equals(_courseName)) {
                showAllMembers(allCourses.get(i));

            }
        }
    }

    /**
     * Belirtilen course ismiyle sistemde arama yapar ve derse eklenmis butun
     * assignmentlari listeler
     *
     * @param _courseName String
     */
    public void showAllAssignments(String _courseName) {

        Course temp = new Course("temp", "temp");

        for (int i = 0; i < allCourses.size(); ++i) {
            if (allCourses.get(i).getCourseName().equals(_courseName)) {
                //   showAllMembers(allCourses.get(i));
                temp = allCourses.get(i);
                break;
            }
        }

        for (int k = 0; k < temp.getAllAssignment().size(); ++k) {
            System.out.printf("%d-%s", k + 1, temp.getAllAssignment().get(k));
        }

    }

    /**
     * Belirtilen isimle sistemde arama yapar belirtilen isme sahip derse
     * eklenen butun dokumanlari listeler
     *
     * @param _courseName String
     */
    public void showAllDocuments(String _courseName) {

        for (int i = 0; i < allCourses.size(); ++i) {
            if (allCourses.get(i).getCourseName().equals(_courseName)) {
                for (int j = 0; j < allCourses.get(i).getAllDocuments().size(); ++j) {
                    System.out.printf("%d-%s", j + 1, allCourses.get(i).getAllDocuments().get(j));
                }
            }
        }
    }

    /**
     * Parametre olarak aldigi ders ismini sistemde arayarak ayni isme sahip
     * derse document ekler
     *
     * @param _courseName String
     * @param param Document
     * @return boolean
     */
    public boolean addDocument(String _courseName, Document param) {

        try {
            Course temp = new Course("temp", "temp");

            boolean flag = false;

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_courseName)) {
                    temp = allCourses.get(i);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                temp.getAllDocuments().add(param);
                return true;
            }

            throw new Exception("Document wasnt added!");
        } catch (Exception a) {
            System.out.printf("%s\n", a.getMessage());

            return false;
        }
    }

    /**
     * Parametre olarak aldigi ders ismi ile document ismini bularak ders
     * iceriginden document i silen metoddur
     *
     * @param _courseName String
     * @param _documentName String
     * @return boolean
     */
    public boolean deleteDocument(String _courseName, String _documentName) {

        try {

            Course temp = new Course("temp", "temp");
            Document temp2 = new File("temp2", 1, "temp2");

            boolean flag1 = false;
            boolean flag2 = false;
            int index = -1;
            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_courseName)) {
                    temp = allCourses.get(i);
                    flag1 = true;
                    break;
                }
            }

            if (flag1 == true) {
                for (int j = 0; j < temp.getAllDocuments().size(); ++j) {
                    if (temp.getAllDocuments().get(j).getFileName().equals(_documentName)) {
                        //temp2=temp.getAllDocuments().get(j);
                        index = j;
                        flag2 = true;
                        break;
                    }
                }
            }

            if (flag1 && flag2) {

                temp.getAllDocuments().remove(index);
                return true;
            }
            throw new Exception("Document wasnt deleted!");

        } catch (Exception a) {
            System.out.printf("%s\n", a.getMessage());
            return false;
        }
    }

    /**
     * Teacher objelerini String formatinda ifade eden metoddur
     *
     * @return String
     */
    @Override
    public String toString() {

        return String.format("Teacher - %s %s %s\n", getAcademicPosition(), getName(), getSurname());

    }

    /**
     * ismi verilen dersi sistemde bulur ve o derse assignment olarak aldigi
     * parametredeki objeyi ekler Eger basarili bir ekleme yaparsa true return
     * eder aksi durumda exception firlatip false return eder
     *
     * @param _coursename String
     * @param file Assignment
     * @return boolean
     */
    public boolean addAssignment(String _coursename, Assignment file) {

        try {
            boolean flag = false;
            boolean flag2 = true;
            int index = -1;
            int index2 = -1;

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_coursename)) {
                    flag = true;
                    index = i;
                    break;
                }
            }

            if (flag) {
                for (int j = 0; j < allCourses.get(index).getAllAssignment().size(); ++j) {
                    if (allCourses.get(index).getAllAssignment().get(j).getNameOfAssignment().equals(file.getNameOfAssignment())) {
                        flag2 = false;
                        index2 = j;
                        break;
                    }

                }
            }

            if (flag && flag2) {
                allCourses.get(index).getAllAssignment().add(file);
                return true;
            }
            throw new Exception("Assignment wasnt added!");
        } catch (Exception a) {

            System.out.printf("%s\n", a.getMessage());
            return false;
        }

    }

    /**
     * Parametre olarak aldigi ders ismi ve dosya ismiyle arama yaparak
     * sistemdeki dersi ve assignmenti bulur ve siler basarili durumda true
     * return ederken basarisiz durumda false return edip exception firlatir
     *
     * @param _coursename String
     * @param _filename String
     * @return boolean
     */
    public boolean deleteAssignment(String _coursename, String _filename) {
        try {
            boolean flag = false;
            boolean flag2 = false;
            int index = -1;
            int index2 = -1;

            for (int i = 0; i < allCourses.size(); ++i) {
                if (allCourses.get(i).getCourseName().equals(_coursename)) {
                    flag = true;
                    index = i;
                    break;
                }
            }

            for (int k = 0; k < allCourses.get(index).getAllAssignment().size(); ++k) {
                if (allCourses.get(index).getAllAssignment().get(k).getNameOfAssignment().equals(_filename)) {
                    index2 = k;
                    flag2 = true;
                }
            }

            if (flag && flag2) {
                allCourses.get(index).getAllAssignment().remove(index2);
                return true;
            }

            throw new Exception("Assignment couldnt be deleted!");

        } catch (Exception a) {

            System.out.printf("%s\n", a.getMessage());
            return false;

        }
    }

    /**
     * Sisteme kayitli butun dersleri listeleyen metoddur
     */
    @Override
    public void showAllCourses() {
        System.out.printf("Teacher views allcourses\n");
        super.showAllCourses(); //To change body of generated methods, choose Tools | Templates.
    }

}
