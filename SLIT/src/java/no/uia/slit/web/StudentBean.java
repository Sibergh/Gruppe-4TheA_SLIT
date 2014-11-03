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
    
    private long Id;
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
            // we will get here if depNo is not a valid, or if
            // depNo is valid but there is no department with that depno
            updating = false;
            Id = 0;
            username = 
            fornavn = "";
            etternavn = "";
            epost = "";
            telefon = 0;
        }
        else {
            updating = true;
            this.Id = student.getId();
            this.username = student.getUsername();
            this.fornavn = student.getFornavn();
            this.etternavn = student.getEtternavn();
            this.epost = student.getEpost();
            this.telefon = student.getTelefon();
        }
    }
    
    public boolean isUpdating(){
        return updating;
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
