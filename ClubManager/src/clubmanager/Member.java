package clubmanager;

public class Member extends Person implements Comparable<Member> {

	public int membershipnumber;
	
	public Member(String surname, String firstname, String secondname, int membershipnumber) {
		super (surname, firstname, secondname);
		this.membershipnumber = membershipnumber;
}
	
	public Member(String surname, String firstName, int membershipnumber) {
		super (surname, firstName);
		this.membershipnumber = membershipnumber;
	}

	public int getMembershipnumber() {
		return membershipnumber;
	}

	public void setMembershipnumber(int membershipnumber) {
		this.membershipnumber = membershipnumber;
	}
	
	public String toString() {
		String member;
		member = super.toString() + " " + this.membershipnumber;
		return member; 
		
	}
	public int compareTo (Member other) {
		return (Integer.compare(this.getMembershipnumber(), other.getMembershipnumber()));
}
}
