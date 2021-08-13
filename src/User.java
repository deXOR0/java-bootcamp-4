
public class User {
	
	private String name;
	private String address;
	private String gender;
	private Integer age;
	private String profile;
	
//	Generate Setter Getter
//	Alt + Shift + S -> R
	
//	Generate Constructor
//	Alt + Shift + S -> O

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String address, String gender, Integer age, String profile) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.profile = profile;
	}

}
