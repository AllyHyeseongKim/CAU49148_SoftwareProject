public class FriendList {
	
	// make a constructor
	private FriendList() {
	}
	public static FriendList constructInstance() {
		return new FriendList();
	}
	
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
	
	public void addFriendInformation(Friend parsedFriendInformation) {
		contactInformation[numberOfContactLists] = parsedFriendInformation;
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
			if (contactInformation[i].getNameOfContact() != null 
					|| contactInformation[i].getNameOfContact().equals(nameOfContact)) {
				System.out.println("The name of the contact is conflicted.");
				return true;
				}
			}
		return false;
	}
}
