package no.uia.slit.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.uia.slit.entity.Student;

/**
 *
 * @author evenal
 */
@Stateless
@Named("stp")
public class StudentPersister extends AbstractPersister<Student>{

    @PersistenceContext
    EntityManager em;


    public StudentPersister() {
        super(Student.class);
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public Student createStudent(String username) {
        Student s = new Student();
        em.persist(s);
        s.setUsername(username);
        return s;
    }

    public void delete(String username) {
        TypedQuery<Student> q = em.createNamedQuery("Student.byUsername", Student.class);
        q.setParameter("username", username);
        List<Student> ls = q.getResultList();
        if (ls.size() == 1) delete(ls.get(0));
    }
    
    public Student find(long id) {
        Student student = super.find(id);
        if (null != student) student.getFornavn();
        return student;
    }
}
