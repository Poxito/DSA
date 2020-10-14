
public class Friend {
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
}
