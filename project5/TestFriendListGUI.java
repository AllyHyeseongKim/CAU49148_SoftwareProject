package project5;

public class TestFriendListGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FriendListFile friendListFile = new FriendListFile();
		FriendList friendList = friendListFile.readFileToList("friendlist-norm.data");
		
		FriendListFrame friendListFrame = new FriendListFrame(friendList);
		AddFriendInformationFrame addfriendinformationframe = new AddFriendInformationFrame();
		
		
	}

}
