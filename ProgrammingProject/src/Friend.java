import java.util.ArrayList;
import java.lang.Comparable;

public class Friend extends Object implements Comparable{
	protected String id;
	protected String name;
	protected String lastname;
	protected String birthDate;
	protected String gender;
	protected String birthPlace;
	protected String home;
	protected String studiedAt;
	protected String workPlaces;
	protected String films;
	protected String groupCode;
	
	
	public Friend(String id) {
		this.id=id;
	}
	
	public Friend(String id, String name, String lastname, String birthdate, String gender, String birthPlace, String home, String studiedAt, String workPlaces, String films, String groupCode) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.birthDate = birthdate;
		this.gender = gender;
		this.birthPlace = birthPlace;
		this.home = home;
		this.studiedAt = studiedAt;
		this.workPlaces = workPlaces;
		this.films = films;
		this.groupCode = groupCode;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getStudiedAt() {
		return studiedAt;
	}

	public void setStudiedAt(String studiedAt) {
		this.studiedAt = studiedAt;
	}

	public String getWorkPlaces() {
		return workPlaces;
	}

	public void setWorkPlaces(String workPlaces) {
		this.workPlaces = workPlaces;
	}

	public String getFilms() {
		return films;
	}

	public void setFilms(String films) {
		this.films = films;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public String print() {
		String in = "User's Id: " + id + ", Name: " + name + ", Lastname: " + lastname + ", Birthdate: " + birthDate + ", Gender: " + gender + ", Birthplace: " + birthPlace + ", Home: " + home + ", Studied at: " + studiedAt + ", Work places: " + workPlaces + ", Films: " + films + ", Groupcode: " + groupCode;
		return in;
	}
	
	@Override
	public int compareTo(Object o) {
		Friend f1 = (Friend) o;
		int ascii1 = this.getBirthPlace().charAt(0);
		int ascii2 = f1.getBirthPlace().charAt(0);
		if(ascii1 < ascii2) {
			return -1;
		}else if(ascii1 == ascii2) {
			int ascii3 = this.getLastname().charAt(0);
			int ascii4 = f1.getLastname().charAt(0);
			if(ascii3 < ascii4) {
				return -1;
			}else if(ascii3 == ascii4) {
				int ascii5 = this.getName().charAt(0);
				int ascii6 = f1.getName().charAt(0);
				if(ascii5 < ascii6) {
					return -1;
				}else if(ascii5 == ascii6) {
					return 0;
				}else {
					return 1;
				}
			}else {
				return 1;
			}
		}else {
			return 1;
		}
	}
}
