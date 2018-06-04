package clubmanager;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Club {
	
	private int currentnumber = 1;
//	private static Member[] members = new Member[100];
	private static ArrayList <Member> members = new ArrayList <Member>();
	private static HashMap<String, Facility> facilities = new HashMap <String, Facility>();
	private BookingRegister bookingRegister = new BookingRegister();
	
    public void sortByMemNumber() {
    	for (int i = 0; i < members.size(); i++) {
    		for (int j = i; j < members.size(); j++) {
    			if (members.get(i).compareTo(members.get(j)) < 0) {
    				Collections.swap(members, i, j);
    			}
    		}
    	}
}
	 
    public void showBookings(String nameFacility, LocalDateTime sd, LocalDateTime ed) {
    	ArrayList<Booking> bookingList = getBookings(nameFacility, sd, ed);
    	for (int i = 0; i < bookingList.size(); i++) {
    		bookingList.get(i).show();
    	}
    }
    
    public ArrayList<Booking> getBookings(String nameFacility, LocalDateTime sd, LocalDateTime ed) {
    	Facility f = this.getFacility(nameFacility);
    	return bookingRegister.getBookings(f, sd, ed);
}
    
    public void addBooking(int memberNumber, String nameFacility, LocalDateTime sd, LocalDateTime ed) {
    	Member m = this.getMember(memberNumber);
    	Facility f = this.getFacility(nameFacility);
//    	m.show();
//    	f.show();
//    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
//    	System.out.println(sd.format(dtf));
//    	System.out.println(ed.format(dtf));
    	
//    	bookingRegister.addBooking(m, f, sd, ed);
    	
    	try {
			bookingRegister.addBooking(m, f, sd, ed);
		} catch (BadBookingException e) {
			System.out.println(e.getMessage());
		}
}
    
	public void addMember(String surname, String firstname, String secondname) {
		Member m = new Member(surname, firstname, secondname, currentnumber);
		members.add(m);
		currentnumber++;
	}
	
	public void showMember() {
		for (int i=0; i<members.size(); i++)
			{
				members.get(i).show();
			}
		}
	
	public void removeMember(int memberNumber) {
		for (int i=0; i< members.size(); i++) {
			if (members.get(i).getMembershipnumber()==memberNumber)
			{
				members.remove(i);
			}
		}
	}
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	public Member getMember(int memberNumber) {
		Member m = null;
		for (int i = 0; i < members.size(); i++)
		{
			if (members.get(i).getMembershipnumber() == memberNumber) {
				m = members.get(i);
			}
		}
		return m;
}
	
	public void addFacility(String Name, String Description) {
		Facility f = new Facility(Name, Description);
		facilities.put (Name, f);
	}
	
	public void removeFacility(String Name) {
		facilities.remove(Name);
	}	
	
	public Facility getFacility(String Name) {
		Facility f = facilities.get(Name);
		return f;
	}
	
	public Collection<Facility> getFacilities() {
		Collection<Facility> f = facilities.values();
		return f;
	}
	
	public void showFacilities() {
		Collection<Facility> f = facilities.values();
		Iterator<Facility> i = f.iterator();
		while (i.hasNext()) {
			Facility facility = i.next();
			facility.show();
		}
	}
	public void show() {
		showMember();
		showFacilities();
	}
}

