package clubmanager;

public class Person {

	protected String surname; 
	protected String firstname; 
	protected String secondname;
	
	public Person(String surname, String firstname, String secondname) {
		this.surname = surname;
		this.firstname = firstname;
		this.secondname = secondname;
	}
	
	public Person(String surname, String firstName)
	{
		this.surname = surname;
		this.firstname = firstName;
		this.secondname = null;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	
	public void show() {
		System.out.println(this);
	}
	
	public String toString() {
		String person;
		if (secondname == null)
		{
			person = surname + " " + firstname;
		}
		else
		{
			person = surname + " " + firstname + " " + secondname;
		}
		return person;
	}
}