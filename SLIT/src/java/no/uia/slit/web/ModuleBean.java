package no.uia.slit.web;

import java.io.Serializable;
<<<<<<< HEAD
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
=======
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
>>>>>>> parent of be203f3... .
import javax.inject.Named;
import no.uia.slit.ejb.ModulePersistenceService;
import no.uia.slit.entity.Module;


/**
 *
 * @author even
 */
@Named("moduleBean")
<<<<<<< HEAD
@ConversationScoped
public class ModuleBean implements Serializable {
    
    @Inject private Conversation conv;
    @EJB ModulePersistenceService moduleSvc;
    private Module module;
    private boolean updating;
    
    private long id;
    private String name;
    private String description;
    
    public ModuleBean() {
    }

    public void setId(long id) {
        if (conv.isTransient()) {
            conv.begin();
        }

        Module mod = moduleSvc.find(id);
        if (null == mod) {
            // we will get here if depNo is not a valid, or if
            // depNo is valid but there is no department with that depno
            updating = false;
            id = 0;
            name = "";
            description = "";
        }
        else {
            updating = true;
            this.id = mod.getId();
            name = mod.getName();
            description = mod.getDescription();
        }
    }

    public long getId(){
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public boolean isUpdating(){
        return updating;
    }
    
    private Module createModObject() {
        Module mod = new Module();
        mod.setId(id);
        mod.setName(name);
        mod.setDescription(description);
        return mod;
    }

    public Page saveModule() {
        Module mod = createModObject();
        moduleSvc.insert(mod);
        conv.end();
        return Page.modules;
    }
    
    public Page editModule(){
        Module mod = createModObject();
        moduleSvc.update(mod);
        conv.end();
        return Page.modules;
    }

    public Page deleteModule() {
        Module mod = createModObject();
        moduleSvc.delete(mod);
        conv.end();

        return Page.modules;
    }
    
    public Page cancelModuleCreation(){
        conv.end();
        return Page.modules;
    }
    
    public Page studentCancelModuleView(){
        conv.end();
        return Page.course;
    }
    
    public void endConv(){
        conv.end();
    }
}
=======
@SessionScoped
public class ModuleBean implements Serializable {
    @EJB private ModulePersistenceService moduleSvc;
    private Module selectedModule;

    public ModuleBean() {
    }


    public List<Module> getAllModules() {
        return moduleSvc.findAll();
    }

    /** Set up module form for adding a new module */
    public Page createModule() {
        
        
        selectedModule = new Module();
        
        return Page.module;
    }

    /** Prepare module form for editing an existing module.
     * If the requested module does not exist, a new module
     * will be created instead. */
    public Page editModule(long id) {
        selectedModule = moduleSvc.find(id);
        if (null == selectedModule) {
            selectedModule = new Module();
        }
        return Page.module;
    }

    public Page saveSelectedModule(){
        moduleSvc.saveModule(selectedModule);
        return Page.modules;
    }
    
    public Module getSelectedModule() {
        return selectedModule;
    }
}
>>>>>>> parent of be203f3... .
