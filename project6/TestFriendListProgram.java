package project6;

public class TestFriendListProgram {

	public static void main(String[] args) {

		FriendListFile friendListFile  = new FriendListFile();
        FriendList friendList = friendListFile.readFileToList("friendlist-norm.data");
        
        friendList.printContactInformation();
		
		new FriendListFrame(friendList);
	}

}
