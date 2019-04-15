import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FriendListFile {
	
	private FriendList friendList = FriendList.constructInstance();
	
	public FriendList readFileToList(String fileName) {
		
		Scanner inputFile = scanFile(fileName);
		
		if (inputFile != null) {
			while (inputFile.hasNext()) {
				String aLineOfFriendListFile = inputFile.nextLine();
				Friend parsedFriendInformation = parserOfFriendListFile(aLineOfFriendListFile);
				if (parsedFriendInformation != null) {
					try {
						friendList.addFriendInformation(parsedFriendInformation);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("The number of contacts is out of boundary.");
						System.out.println("The maximum number of contacts is 100.");
					}
				}
			}
			inputFile.close();
			return friendList;
		}
		else {
			System.out.println("The file is empty.");
			return friendList;
		}
	}
	
	private Scanner scanFile(String fileName) {
		try {
			// make a file instance
			File file = new File(fileName);
			return new Scanner(file);
		} catch(Exception e) {
			// print error message
			System.out.println("File name is unfound.");
			return null;
		}
	}
	
	private Friend parserOfFriendListFile(String aLineOfFriendListFile) {
		
		Friend parsedFriendInformation = null;
		String originalLine = aLineOfFriendListFile;
		// remove space characters
		String aLineRemovedspaceCharacters = originalLine.replace(" ", "");
		// start to parse the line if it is not an empty or a comment line
		if (!isCommentLine(aLineRemovedspaceCharacters) && !isEmptyLine(aLineRemovedspaceCharacters)) {
			parsedFriendInformation = new Friend();
			String[] splitedFriendInformationByCategory = aLineRemovedspaceCharacters.split(":");
			if (isRightInputInformation(splitedFriendInformationByCategory)) {
				parsedFriendInformation.setGroupOfContact(Integer.parseInt(splitedFriendInformationByCategory[1]));
				parsedFriendInformation.setNameOfContact(splitedFriendInformationByCategory[0]);
				parsedFriendInformation.setPhoneNumberOfContact(splitedFriendInformationByCategory[2]);
				parsedFriendInformation.setEmailAddressOfContact(splitedFriendInformationByCategory[3]);
				if(splitedFriendInformationByCategory.length == 5) {
					parsedFriendInformation.setPictureOfContact(splitedFriendInformationByCategory[4]);
				}
				else {
					if (aLineRemovedspaceCharacters.substring
							(aLineRemovedspaceCharacters.length() - 1, aLineRemovedspaceCharacters.length()) != ":") {
						System.out.println("The format of the input is wrong.");
					}
				}
			}
			return parsedFriendInformation;
		}
		else {
			return null;
		}
	}
	
	private boolean isCommentLine(String aLineRemovedspaceCharacters) {
		if (aLineRemovedspaceCharacters.startsWith("//")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isEmptyLine(String aLineRemovedspaceCharacters) {
		if (aLineRemovedspaceCharacters == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isRightInputInformation(String[] splitedFriendInformationByCategory) {
		if (splitedFriendInformationByCategory.length < 4 
				|| splitedFriendInformationByCategory.length > 5) {
			System.out.println("At least one category is omitted.");
			return false;
		}
		else if(isWrongFormat(splitedFriendInformationByCategory)) {
			return false;
		}
		return true;	
	}
	
	private boolean isWrongFormat(String[] splitedFriendInformationByCategory) {
		if(friendList.isConflictedName(splitedFriendInformationByCategory[0]) 
			|| !isIntegerGroup(splitedFriendInformationByCategory[1]) 
			|| isPhoneNumber(splitedFriendInformationByCategory[2])
			|| isEmailAddress(splitedFriendInformationByCategory[3])) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isIntegerGroup(String groupOfContact) {
		try {
			Integer.parseInt(groupOfContact);
		} catch (NumberFormatException e) {
			System.out.println("The format of the group of the contact is not a integer.");
			return false;
		}
		return true;
	}
	
	private boolean isPhoneNumber(String phoneNumberOfContact) {
		if (Pattern.matches("(\\\\d{3})-(\\\\d{3,4})-(\\\\d{4})", phoneNumberOfContact.trim())) {
			System.out.println("1");
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isEmailAddress(String emailAddressOfContact) {
		if (emailAddressOfContact == null) {
			System.out.println("Picture category is empty.");
			return true;
		}
		else if (Pattern.matches("[\\\\w\\\\~\\\\-\\\\.]+@[\\\\w\\\\~\\\\-]+(\\\\.[\\\\w\\\\~\\\\-]+)+", emailAddressOfContact.trim())) {
			System.out.println("2");
			return true;
		}
		else {
			return false;
		}
	}
}
