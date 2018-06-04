package clubmanager;

public class Facility {
	
	private String name;
	private String description;
	
	public Facility(String name,String description) {
		
		this.name = name;
		this.description = description;
	}
	
	public Facility(String name) {
		
		this.name = name;
		this.description = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void show() {
		System.out.println(this);
	}
	
	public String toString() {
		String facility;
		if(description == null)
		{
			facility = name;
		}
		else {
			facility = name + " (" + description + ")";
		}
			return facility;
		}
}
