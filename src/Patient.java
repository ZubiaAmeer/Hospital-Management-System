
public class Patient {
private String name;
private String cnic;
private String age;
private String gender;
private String contact;
private String history;
private String admissionDate;
public Patient(String name, String cnic, String age, String gender, String contact, String history,
		String admissionDate) {
	super();
	this.name = name;
	this.cnic = cnic;
	this.age = age;
	this.gender = gender;
	this.contact = contact;
	this.history = history;
	this.admissionDate = admissionDate;
}
public String getName() {
	return name;
}
public String getCnic() {
	return cnic;
}
public String getAge() {
	return age;
}
public String getGender() {
	return gender;
}
public String getContact() {
	return contact;
}
public String getHistory() {
	return history;
}
public String getAdmissionDate() {
	return admissionDate;
}


}
