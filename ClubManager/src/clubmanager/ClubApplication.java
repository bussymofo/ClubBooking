package clubmanager;

import java.time.LocalDateTime;

public class ClubApplication {
	
	public static void main(String[] args) {
//	Member m1 = new Member("Tan", "Ah", "Beg", 123456);
//	Member m2 = new Member ("Tan", "Laurel", 234567);		
//	m1.show();
//	m2.show();
	
//	Facility f1 = new Facility("Football Court 1", "Full-sized football court for league matches");
//	Facility f2 = new Facility("Basketball Court 1");		
//	f1.show();
//	f2.show();
	
	Club c = new Club();
	c.addMember("Chan", "Teck", "Seng");
	c.addMember("Tan", "Teck", "Seng");
	c.addMember("Wong", "Teck", "Seng");
	
//	c.removeMember(2);
//	c.showMember();
	
	c.addFacility("Football Court 1", "Full-sized football court for league matches");
	c.addFacility("Basketball Court 1", "Full-sized basketball court for league matches");
	c.addFacility("Tennis Court 1", "Full-sized tennis court for league matches");
	c.addFacility("Badminton Court 1", "Full-sized badminton court for league matches");

//	Member m1 = c.getMember(1);
//	Member m2 = c.getMember(2);
//	Member m3 = c.getMember(3);
//	Member m4 = c.getMember(4);
//
//	Facility f1 = c.getFacility("Football Court 1");
//	Facility f2 = c.getFacility("Basketball Court 1");
//	Facility f3 = c.getFacility("Tennis Court 1");
//	Facility f4 = c.getFacility("Badminton Court 1");
	
	LocalDateTime d1 = LocalDateTime.of(2018, 1, 12, 12, 00);
	LocalDateTime d2 = LocalDateTime.of(2018, 2, 11, 12, 00);
	LocalDateTime d3 = LocalDateTime.of(2018, 3, 10, 12, 00);
	
	c.show();
	
	c.addBooking(2, "Football Court 1", d1, d2);
	c.addBooking(3, "Football Court 1", d1, d3);
	c.addBooking(4, "Basketball Court 1", d3, d2);
	c.showBookings("Football Court 1", d1, d3);
	}
}

