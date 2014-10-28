package no.uia.slit.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author even
 */
@Entity
public class Module implements Serializable {
   
   private static final long serialVersionUID = 42L;
   
   @Id
   @GeneratedValue
   private long id;
   
   @NotNull
   @Size(min = 1)
   @Column(unique=true)
   private String name;
   private String description;
//   
//   @ManyToOne
//   private Module requiredModule;
//   
   public Module() {
   }
   
   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
//
//   public Module getRequiredModule() {
//      return requiredModule;
//   }
//
//   public void setRequiredModule(Module requiredModule) {
//      this.requiredModule = requiredModule;
//   }
   
   @Override
   public int hashCode() {
      int hash = 7;
      hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
      return hash;
   }

   @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Module other = (Module) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(" ");
        sb.append(name);
        sb.append(description);
//        sb.append(" {");
//        for (Employee emp : employees) {
//            sb.append(" ");
//            sb.append(emp);
//        }
//        sb.append(" }");

        return sb.toString();
    }
}
