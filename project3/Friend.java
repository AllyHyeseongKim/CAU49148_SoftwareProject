package project3;

public class Friend {
	
	// private variables of informations of a contact
	private String nameOfContact;
	private int groupOfContact;
	private String phoneNumberOfContact;
	private String emailAddressOfContact;
	private String pictureOfContact;
	
	// make setters, getters of private variables of informations of a contact
	public void setNameOfContact(String nameOfContact) {
		this.nameOfContact = nameOfContact;
	}
	public String getNameOfContact() {
		return nameOfContact;
	}
	public void setGroupOfContact(int groupOfContact) {
		this.groupOfContact = groupOfContact;
	}
	public int getGroupOfContact() {
		return groupOfContact;
	}
	public void setPhoneNumberOfContact(String phoneNumberOfContact) {
		this.phoneNumberOfContact = phoneNumberOfContact;
	}
	public String getPhoneNumberOfContact() {
		return phoneNumberOfContact;
	}
	public void setEmailAddressOfContact(String emailAddressOfContact) {
		this.emailAddressOfContact = emailAddressOfContact;
	}
	public String getEmailAddressOfContact() {
		return emailAddressOfContact;
	}
	public void setPictureOfContact(String pictureOfContact) {
		this.pictureOfContact = pictureOfContact;
	}
	public String getPictureOfContact() {
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