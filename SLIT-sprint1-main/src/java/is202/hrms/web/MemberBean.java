package is202.hrms.web;

import is202.hrms.entity.Member;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Backing bean for member.xhtml
 * 
 * @author Sigve
 */

@Named("memberbean")
@ApplicationScoped
public class MemberBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Member member;
    private HashMap<Long, Member> members;
    
    
    public MemberBean(){
        //Create a new object of the Member.java class, so that we can use 
        //getters and setters in one object, "member".
        member = new Member();
        members = new HashMap<Long, Member>();
    }
    
    /** Return the list of members. We are not going to insert a new
     * list, so the getter is sufficient */
    public List<Member> getMembers() {
        ArrayList list1 = new ArrayList<Member>(members.values());
        return list1;
    }
    
    
    // if the user changes the member id, we assume that he wants to
    // edit another member
    public void setMemberID(long memberID){
        System.out.println("memberID = "+memberID);
        System.out.println("members = "+members);
        member = members.get(memberID);
        if (null == member){
            member = new Member();
            member.setMemberID((int) memberID);
            members.put(memberID, member);
        }
    }
    
    public long getMemberID(){
        if (null == member){
            return 0;
        } else{
            return member.getMemberID();
        }
    }
    
    public Member getMember(){
        return member;
    }
    
    // We do not save the member yet
    public void saveMember(){
        members.put(member.getMemberID(), member);
    }
    
    public void deleteMember(){
        members.put(member.getMemberID(), null);
        member = new Member();
    }         
}
