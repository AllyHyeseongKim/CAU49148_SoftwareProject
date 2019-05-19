package project5;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class FriendListInformationPanel extends JPanel {

	private JLabel name = new JLabel();
	private JTextField group = new JTextField();
	private JTextField phoneNumber = new JTextField();
	private JTextField emailAddress = new JTextField();
	private JLabel picture = new JLabel();
	private JCheckBox checkBox = new JCheckBox();

	private JPanel checkBoxPanel = new JPanel();
	private JPanel informationPanel = new JPanel();
	
	public FriendListInformationPanel(Friend friend) {
		
		this.setLayout(new BorderLayout());
		checkBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		informationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 95, 5));
		//informationPanel.setPreferredSize(new Dimension(930, 30));
		
		//checkBox.setPreferredSize(new Dimension(25, 20));
		checkBoxPanel.add(checkBox);

		name.setText(friend.getName());
		informationPanel.add(name);
		name.setPreferredSize(new Dimension(80, 20));
		name.setHorizontalAlignment(JTextField.CENTER);
		group.setText(friend.getGroup() + "");
		informationPanel.add(group);
		group.setPreferredSize(new Dimension(30, 20));
		group.setHorizontalAlignment(JTextField.CENTER);
		phoneNumber.setText(friend.getPhoneNumber());
		informationPanel.add(phoneNumber);
		phoneNumber.setPreferredSize(new Dimension(160, 20));
		phoneNumber.setHorizontalAlignment(JTextField.CENTER);
		emailAddress.setText(friend.getEmailAddress());
		informationPanel.add(emailAddress);
		emailAddress.setPreferredSize(new Dimension(180, 20));
		emailAddress.setHorizontalAlignment(JTextField.CENTER);
		picture.setText(friend.getPicture());
		informationPanel.add(picture);
		picture.setPreferredSize(new Dimension(60, 20));
		picture.setHorizontalAlignment(JTextField.CENTER);
		
		this.add(checkBoxPanel, BorderLayout.WEST);
		this.add(informationPanel, BorderLayout.CENTER);
		
	}

}
