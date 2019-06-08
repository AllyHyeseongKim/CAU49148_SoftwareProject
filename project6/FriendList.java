package project6;

import java.util.ArrayList;

public class FriendList {
	
	private int numberOfContactLists = 0;
	
	private ArrayList<Friend> contactInformation = new ArrayList<Friend>();
	
	public int numFriends() {
		
		return numberOfContactLists;
	}
	
	public Friend getFriend(int i) {
		
		if (isRightIndexNumber(i)) {
			return contactInformation.get(i);
		}
		else {
			return null;
		}
	}

	public void printContactInformation() {
		for (int i = 0; i < numberOfContactLists; i++) {
			contactInformation.get(i).print();
		}
	}
	
	public void addFriendInformation(Friend parsedFriendInformation) {
		contactInformation.add(parsedFriendInformation);
		numberOfContactLists++;
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
			if (nameOfContact.equals(contactInformation.get(i).getName())) {
				System.out.println("The name of the contact is conflicted.");
				return true;
				}
			}
		return false;
	}
}