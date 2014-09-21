package is202.hrms.entity;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Employee class is a "data" class. The employee objects are used to
 * store data. The functionality of the application (the business logic) is
 * defined in the backing beans. We will collect all these entity classes in
 * the entity package.
 *
 * This class has input validation annotations. Adding the input validation
 * to the entity classes, rather than to the input forms,
 *
 * @author even
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    // id must have a value, and it must be zero or larger
    @Min(1)
    private long empId;

    // the employee must have a name, with at least 1 character
    @NotNull @Size(min=1)
    private String name;

    @Min(0)
    private int salary;

    @NotNull
    private String department;
    
    @NotNull @Size(min=1)
    private String hometown;
    
    public Employee() {
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long id) {
        this.empId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }
    
    public String getHometown(){
        return hometown;
    }
    
    public void setHometown(String hometown){
        this.hometown = hometown;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (empId ^ (empId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        if (empId != other.empId) return false;
        return true;
    }
}
