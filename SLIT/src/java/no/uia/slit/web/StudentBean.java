/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package no.uia.slit.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import no.uia.slit.ejb.StudentPersister;
import no.uia.slit.entity.Student;

/**
 *
 * @author NicolaiJuul
 */

@Named("studentBean")
@ConversationScoped
public class StudentBean implements Serializable {
    
    @Inject private Conversation conv;
    @EJB StudentPersister studentSvc;
    
    private long id;
    private String username;
    private String fornavn;
    private String etternavn;
    private String epost;
    private int telefon;
    
    private boolean updating;
    
    public StudentBean(){}
    
    public void setProfile(long id) {
        if (conv.isTransient()) {
            conv.begin();
        }

        Student student = studentSvc.find(id);
        if (null == student) {
            // we will get here if student is not, or if
            // student is valid but there is no department with that student
            updating = false;
            username = "";
            fornavn = "";
            etternavn = "";
            epost = "";
            telefon = 0;
        }
        else {
            updating = true;
            this.id = student.getId();
            this.username = student.getUsername();
            this.fornavn = student.getFornavn();
            this.etternavn = student.getEtternavn();
            this.epost = student.getEpost();
            this.telefon = student.getTelefon();
        }
    }

    private Student createStudObject() {
        Student stud = new Student();
        stud.setId(id);
        stud.setFornavn(fornavn);
        stud.setEtternavn(etternavn);
        stud.setEpost(epost);
        stud.setTelefon(telefon);
        return stud;
    }

    public Page saveProfile() {
        Student stud = createStudObject();
        studentSvc.update(stud);
        return Page.sP;
    }
    
    public Page cancelEditProfile (){
        conv.end();
        return Page.sP;
}
   
// ------- Getters & Setters 
    public boolean isUpdating(){
        return updating;}
    
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
