package no.uia.slit.ejb;

<<<<<<< HEAD
import no.uia.slit.entity.Module;
=======
>>>>>>> parent of be203f3... .
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import no.uia.slit.entity.Module;


/**
 *
 * @author even
 */
@Stateless
<<<<<<< HEAD
public class ModulePersistenceService extends AbstractPersister<Module>{
=======
public class ModulePersistenceService {
>>>>>>> parent of be203f3... .

   @PersistenceContext
   private EntityManager em;

<<<<<<< HEAD
   @Override
    protected EntityManager getEntityManager() {
        return em;
    }
   
    public ModulePersistenceService() {
        super(Module.class);
    }
    
    public Module getDefaultModule() {
        List<Module> modList = findAll();
        if (modList != null && modList.size() > 0) {
            return modList.get(0);
        } else {
            throw new IllegalStateException("Ingen moduler tilgjengelig.");
        }
    }
    
   /** Retrieve the module with the specified id from the database */
    public Module find(long id) {
        Module mod = super.find(id);
        if (null != mod) mod.getDescription();
        return mod;
    }
    
    @Override
    public void delete(Module mod) {
        mod = em.merge(mod);
        super.delete(mod);
    }
=======
   /** Retrieve the module with the specified id from the database */
   public Module find(long id) {
       Module m = em.find(Module.class, id);
       return m;
   }

   /** Return a list of all modules defined in the database */
   public List<Module> findAll() {
      TypedQuery<Module> q = em.createQuery("select m from Module m",
              Module.class);
      List<Module> modList = q.getResultList();
      return modList;
   }

   /** Save a module in the database */
   public void saveModule(Module m) {
       em.merge(m);
   }

   /** Remove a module from the database */
   public void removeModule(Module m) {
       em.remove(m);
   }
>>>>>>> parent of be203f3... .
}
