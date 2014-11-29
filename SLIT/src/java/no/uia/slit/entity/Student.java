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
import javax.persistence.NamedQuery;

/**
 *
 * @author even
 */
@Entity
@NamedQuery(name = "Student.byUsername",
        query = "select s from Student s where s.username = :username")
public class Student implements Serializable {
   @Id @GeneratedValue
   private long Id;

   @Column(unique=true)
   private String username;
   
   private String fornavn;
   private String etternavn;
   
   @Column(unique=true)
   private String epost;
   
   @Column(unique=true)
   private int telefon;

   public Student() {
   }

   public long getId() {
      return Id;
   }

   public void setId(long Id) {
      this.Id = Id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 67 * hash + (int) (this.Id ^ (this.Id >>> 32));
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Student other = (Student) obj;
      if (this.Id != other.Id) {
         return false;
      }
      return true;
   }


// -------

public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
    
}