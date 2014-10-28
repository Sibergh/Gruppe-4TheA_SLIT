package no.uia.slit.auth;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
import javax.ejb.EJB;
=======
>>>>>>> parent of be203f3... .
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
<<<<<<< HEAD
import no.uia.slit.ejb.StudentPersister;
import no.uia.slit.ejb.TeacherPersister;
=======
>>>>>>> parent of be203f3... .

/**
 *
 * @author even
 */
@Stateless
public class AuthPersistenceService {

   @PersistenceContext
   private EntityManager em;

<<<<<<< HEAD
   @EJB
   TeacherPersister teacherSvc;

   @EJB
   StudentPersister studentSvc;

=======
>>>>>>> parent of be203f3... .
   public AuthUser findUser(String name) {
      return em.find(AuthUser.class, name);
   }

   public List<AuthUser> findAllUsers() {
      TypedQuery<AuthUser> q = em.createQuery("select u from AuthUser u",
              AuthUser.class);
      System.out.print("Retrieving users:");
      List<AuthUser> uList = q.getResultList();
      for (AuthUser u : uList) System.out.print(" "+u.getUsername()+"/"+u.getPassword());
      System.out.println();
      if (null == uList || uList.isEmpty()) createDebugData();
      return uList;
   }

   public void saveUser(AuthUser user) {
<<<<<<< HEAD
       em.merge(user);
       if (user.getGroups().contains(AuthGroup.student)) {
           studentSvc.createStudent(user.getUsername());
       }
       if (user.getGroups().contains(AuthGroup.teacher)) {
           teacherSvc.createTeacher(user.getUsername());
       }
   }

   public void removeUser(AuthUser user) {
       AuthUser u = em.merge(user);
       if (u.getGroups().contains(AuthGroup.student))
           studentSvc.delete(u.getUsername());
       if (u.getGroups().contains(AuthGroup.teacher))
           teacherSvc.delete(u.getUsername());
      em.remove(u);
=======
      em.merge(user);
   }

   public void removeUser(AuthUser user) {
      em.remove(user);
>>>>>>> parent of be203f3... .
   }

   public void createDebugData() {
       AuthUser admin = em.find(AuthUser.class, "admin");
       if (null == admin) {
           try {
               admin = new AuthUser();
               admin.setUsername("admin");
               admin.setPassword("admin");
               admin.addGroup(AuthGroup.admin);
               em.persist(admin);
           }
           catch (NoSuchAlgorithmException ex) {
               Logger.getLogger(AuthPersistenceService.class.getName()).log(Level.SEVERE,
                       null, ex);
           }
       }
   }
}