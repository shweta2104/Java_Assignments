/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

/**
 *
 * @author HP
 */
public class addstudent {
    @Stateless
public class CollegeServiceBean implements CollegeService {

    @PersistenceContext
    private EntityManager em;

    public void addStudent(Student s) {
        em.persist(s);
    }

    public void addSubject(Subject s) {
        em.persist(s);
    }

    public List<Student> getStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public List<Subject> getSubjects() {
        return em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }
}
    
}
