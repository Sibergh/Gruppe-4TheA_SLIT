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
import javax.persistence.OneToOne;

/**
 *
 * @author even
 */
@Entity
@NamedQuery(name = "Student.byUsername",
        query = "select s from Student s where s.username = :username")
public class Student implements Serializable {
   @Id @GeneratedValue
   private long id;

   @Column(unique=true)
   private String username;
   
   private String fornavn;
   private String etternavn;
   
   @Column(unique=true)
   private String epost;
   
   @Column(unique=true)
   private int telefon;


   
   @Override
   public int hashCode() {
      int hash = 3;
      hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
      return hash;}

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;}
      if (getClass() != obj.getClass()) {
         return false;}
      final Student other = (Student) obj;
      if (this.id != other.id) {
         return false;}
      return true;}


// ------- Getters & Setters
    public long getId() {
      return id;}

    public void setId(long id) {
      this.id = id;}

    public String getUsername() {
      return username;}

    public void setUsername(String username) {
      this.username = username;}
   
    public String getFornavn() {
        return fornavn;}

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;}

    public String getEtternavn() {
        return etternavn;}

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;}

    public String getEpost() {
        return epost;}

    public void setEpost(String epost) {
        this.epost = epost;}

    public int getTelefon() {
        return telefon;}

    public void setTelefon(int telefon) {
        this.telefon = telefon;} 
}