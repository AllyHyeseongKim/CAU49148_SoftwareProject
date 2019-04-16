package project3;

public class FriendList {
	
	private int maxOfContactLists = 100;
	private int numberOfContactLists = 0;
	Friend[] contactInformation = new Friend[maxOfContactLists];
	
	public int numFriends() {
		
		return numberOfContactLists;
	}
	
	public Friend getFriend(int i) {
		
		if (isRightIndexNumber(i)) {
			return contactInformation[i];
		}
		else {
			return null;
		}
	}

	public void printContactInformation() {
		for (int i = 0; i < numberOfContactLists; i++) {
			contactInformation[i].print();
		}
	}
	
	public void addFriendInformation(Friend parsedFriendInformation) {
		contactInformation[numberOfContactLists++] = parsedFriendInformation;
	}
	
	private boolean isRightIndexNumber(int index) {
		if (index >= 0 && index <= 100 && index <= numberOfContactLists) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isConflictedName(String nameOfContact) {
		for (int i = 0; i < numberOfContactLists; i++) {
			if (nameOfContact.equals(contactInformation[i].getNameOfContact())) {
				System.out.println("The name of the contact is conflicted.");
				return true;
				}
			}
		return false;
	}
}