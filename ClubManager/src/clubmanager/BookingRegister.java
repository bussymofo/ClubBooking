package clubmanager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingRegister {
	
	private HashMap<Facility, ArrayList<Booking>> br = new HashMap<Facility, ArrayList<Booking>>();

	public void addBooking(Member m, Facility f, LocalDateTime sd, LocalDateTime ed) throws BadBookingException {
		
		Booking b = null;
		try {
			b = new Booking(m, f, sd, ed);
		} catch (BadBookingException e) {
			System.out.println(e.getMessage());
		}
		
		if (br.containsKey(f)) {
			ArrayList<Booking> bookingList = br.get(f);
			boolean isOverlap = false;
			for (int i = 0; i < bookingList.size(); i++) {
				if(bookingList.get(i).overlaps(b)) {
					isOverlap = true;
				}
			}
				if (isOverlap == true) {
					throw new BadBookingException("New booking overlaps with existing booking");
			}
				else
					bookingList.add(b);
					br.put(f, bookingList);
			}
			else {
				ArrayList<Booking> bookingList = new ArrayList<Booking>();
				bookingList.add(b);
				br.put(f, bookingList);	
			}
		}
		public ArrayList<Booking> getBookings(Facility f, LocalDateTime sd, LocalDateTime ed) {
			ArrayList<Booking> list = new ArrayList<Booking>();
			if(br.containsKey(f) && sd.compareTo(ed) <= 0) {
				ArrayList<Booking> bookingList = br.get(f);
				for (int i = 0; i < bookingList.size(); i++) {
					if (bookingList.get(i).getStartdate().compareTo(bookingList.get(i).getEnddate()) <= 0)
						if (bookingList.get(i).getStartdate().compareTo(sd) >= 0)
							if (bookingList.get(i).getStartdate().compareTo(ed) <= 0)
								if (bookingList.get(i).getEnddate().compareTo(sd) >= 0)
									if (bookingList.get(i).getEnddate().compareTo(ed)<= 0)
										list.add(bookingList.get(i));
				}
			}
			return list;
		}
		
		public void removeBooking(Booking b) {
			Facility f = b.getFacility();
			ArrayList<Booking> bookingList = br.get(f);
			bookingList.remove(b);
			br.put(f, bookingList);
		}
	}
