package tutorial;

import java.io.Serializable;
import javax.persistence.*;
 
@Entity
public class FeedInfo implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id @GeneratedValue
    private Long pid;
 
	private String firstName;
    private String lastName;
 
    public FeedInfo() {
    }
 
    FeedInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
    @Override
    public String toString() {
        return String.format("(%s, %s)", this.firstName, this.lastName);
    }
    
    
    public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
