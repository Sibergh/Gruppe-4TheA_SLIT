package is202.hrms.entity;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * The Member class is a "data" class. The member objects are used to
 * store data. The functionality of the application (the business logic) is
 * defined in the backing beans. We will collect all these entity classes in
 * the entity package.
 *
 * This class has input validation annotations. Adding the input validation
 * to the entity classes, rather than to the input forms.
 * 
 * @author Sigve
 */
public class Member implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    // id must have a value, and it must be zero or larger
    @Min(1)
    private long memberID;
    
    // the member must have a name, with at least 1 character
    @NotNull @Size(min=1)
    private String name;
    
    // the member must have a hometown, with at least 1 character
    @NotNull @Size(min=1)
    private String hometown;
    
    // the member must have an address, with at least 1 character
    @NotNull @Size(min=1)
    private String address;
    
    // the member must live in a country, with at least 1 character
    @NotNull @Size(min=1)
    private String country;

    public Member(){
    }
    
    /* GETTERS & SETTERS*/
    public long getMemberID() {
        return memberID;
    }

    public void setMemberID(long id) {
        this.memberID = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (memberID ^ (memberID >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Member other = (Member) obj;
        if (memberID != other.memberID) return false;
        return true;
    }
}


