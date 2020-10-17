import java.util.ArrayList;

public class Friend extends Object{
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
}
