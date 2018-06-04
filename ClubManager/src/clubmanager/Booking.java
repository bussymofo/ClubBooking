package clubmanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {

	private Member member;
	private Facility facility;
	private LocalDateTime startdate;
	private LocalDateTime enddate;
	
	public Booking (Member m, Facility f, LocalDateTime sd, LocalDateTime ed) throws BadBookingException {
		this.member = m;
		this.facility = f;
		this.startdate = sd;
		this.enddate = ed;
		
		if (this.member == null)
			throw new BadBookingException("Member not exist");
		if (this.facility == null)
			throw new BadBookingException("Facility not exist");
		if (this.startdate == null)
			throw new BadBookingException("Start Date not chosen");
		if (this.enddate == null)
			throw new BadBookingException("End Date not chosen");
		if (this.startdate.compareTo(this.enddate) > 0)
			throw new BadBookingException("Start Date cannot be later than End Date");
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public LocalDateTime getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	public LocalDateTime getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}
	
	public boolean overlaps(Booking b) {
		boolean isOverlap = false;
		if (this.facility.getName().equals(b.facility.getName())) {
		if (!(this.enddate.compareTo(b.startdate) < 0 || this.startdate.compareTo(b.enddate) > 0)) {
			isOverlap = true;}}
		return isOverlap;
	}
	
		public String toString() {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
			String sd = startdate.format(dtf);
			String ed = enddate.format(dtf);
			String s = member.toString() + "\n" + facility.getName() + "\n" 
		+ sd + " to " +  ed;
			return s;
		}
		
		public void show() {
			System.out.println(this);
	}
}
