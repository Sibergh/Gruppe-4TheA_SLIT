package is202.hrms.web;

import is202.hrms.entity.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Backing bean for employee.xhtml
 *
 * @author even
 */
@Named("empbean")
@ApplicationScoped
public class EmployeeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Employee employee;
    private HashMap<Long,Employee> employees;

    public EmployeeBean() {
        employee = new Employee();
        employees = new HashMap<Long, Employee>();
    }


    /** Return the list of employees. We are not going to insert a new
     * list, so the getter is sufficient */
    public List<Employee> getEmployees() {
        ArrayList l = new ArrayList<Employee>(employees.values());
        return l;
    }


    // if the user changes the employee id, we assume that he wants to
    // edit another employee
    public void setEmpId(long empId) {
        System.out.println("empId = "+empId);
        System.out.println("employees = "+employees);
        employee = employees.get(empId);
        if (null == employee) {
            employee = new Employee();
            employee.setEmpId((int) empId);
            employees.put(empId, employee);
        }
    }

    public long getEmpId() {
        if (null == employee) {
            return 0;
        } else {
            return employee.getEmpId();
        }
    }

    public Employee getEmployee() {
        return employee;
    }


    // We do not save the employee yet
    public void saveEmployee() {
        employees.put(employee.getEmpId(), employee);
    }

    public void deleteEmployee() {
        employees.put(employee.getEmpId(), null);
        employee = new Employee();
    }
}
