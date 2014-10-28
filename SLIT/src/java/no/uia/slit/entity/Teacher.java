/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
=======
>>>>>>> parent of be203f3... .

/**
 *
 * @author even
 */
@Entity
<<<<<<< HEAD
@NamedQuery(name = "Teacher.byUsername",
        query = "select t from Teacher t where t.username = :username")
public class Teacher implements Serializable {
   @Id @GeneratedValue
   private long id;

   @Column(unique=true)
   private String username;

   @OneToOne
   private DownloadableFile cv;

=======
public class Teacher implements Serializable {
   @Id @GeneratedValue
   private long id;
   
   @Column(unique=true)
   private String username;

>>>>>>> parent of be203f3... .
   public Teacher() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }
<<<<<<< HEAD

    public DownloadableFile getCv() {
        return cv;
    }

    public void setCv(DownloadableFile cv) {
        this.cv = cv;
    }
=======
>>>>>>> parent of be203f3... .
}
