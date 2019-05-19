package project5;

public class Friend {

	// private variables of informations of a contact
	private String nameOfContact;
	private int groupOfContact;
	private String phoneNumberOfContact;
	private String emailAddressOfContact;
	private String pictureOfContact;

	// make setters, getters of private variables of informations of a contact
	public void setName(String nameOfContact) {
		this.nameOfContact = nameOfContact;
	}
	public String getName() {
		return nameOfContact;
	}
	public void setGroup(int groupOfContact) {
		this.groupOfContact = groupOfContact;
	}
	public int getGroup() {
		return groupOfContact;
	}
	public void setPhoneNumber(String phoneNumberOfContact) {
		this.phoneNumberOfContact = phoneNumberOfContact;
	}
	public String getPhoneNumber() {
		return phoneNumberOfContact;
	}
	public void setEmailAddress(String emailAddressOfContact) {
		this.emailAddressOfContact = emailAddressOfContact;
	}
	public String getEmailAddress() {
		return emailAddressOfContact;
	}
	public void setPicture(String pictureOfContact) {
		this.pictureOfContact = pictureOfContact;
	}
	public String getPicture() {
		return pictureOfContact;
	}

	// make a form of information of a contact
	public String formOfInformation() {
		return (nameOfContact + ":" + groupOfContact + ":" + phoneNumberOfContact
				+ ":" + emailAddressOfContact + ":" + pictureOfContact);
	}
	public void print() {
		System.out.println(this.formOfInformation());
	}
}