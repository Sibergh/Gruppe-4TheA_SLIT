package no.uia.slit.web;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import no.uia.slit.ejb.StudentPersister;
import no.uia.slit.entity.Student;

/**
 *
 * @author nicolaijuulroberg
 */
@Named("studentListBean")
@RequestScoped
public class StudentListBean {
    @EJB
    StudentPersister studentSvc;

    public List<Student> getList() {
        List<Student> l = studentSvc.findAll();
        return l;
    }
}
