/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
@Local
public interface CollegeService {

    void addStudent(Student s);
    void addSubject(Subject s);

    List<Student> getStudents();
    List<Subject> getSubjects();
}
