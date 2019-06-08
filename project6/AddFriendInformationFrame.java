package project6;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class AddFriendInformationFrame extends JFrame {

	private FriendListFrame mainViewFrame;
	
	private JPanel menuPanel = new JPanel();
	private JPanel labelPanel = new JPanel();
	private JPanel inputTextFieldsPanel = new JPanel();
	
	private JTextField name = new JTextField();
	private JTextField group = new JTextField();
	private JTextField phoneNumber = new JTextField();
	private JTextField emailAddress = new JTextField();
	private JTextField picture = new JTextField();
	
	private JButton done = new JButton("Done");
	
	public JTextField getNameTextField() {
		return name;
	}
	public JTextField getGroupTextField() {
		return group;
	}
	public JTextField getPhoneNumberTextField() {
		return phoneNumber;
	}
	public JTextField getEmailAddressTextField() {
		return emailAddress;
	}
	public JTextField getPictureTextField() {
		return picture;
	}
	
	public AddFriendInformationFrame(FriendListFrame mainViewFrame) {
		
		this.mainViewFrame = mainViewFrame;
		
		this.setLayout(new BorderLayout());
		this.setSize(1020, 108);
		this.setTitle("추가될 친구 정보");
		this.addFriendInformationFrameButtons();
		this.addFriendInformationFrameLabels();
		this.addInputTextFields();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void addInputTextFields() {

		inputTextFieldsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 20));
		inputTextFieldsPanel.setPreferredSize(new Dimension(960, 60));

		inputTextFieldsPanel.add(name);
		name.setPreferredSize(new Dimension(185, 20));
		name.setHorizontalAlignment(JTextField.CENTER);
		inputTextFieldsPanel.add(group);
		group.setPreferredSize(new Dimension(185, 20));
		group.setHorizontalAlignment(JTextField.CENTER);
		inputTextFieldsPanel.add(phoneNumber);
		phoneNumber.setPreferredSize(new Dimension(185, 20));
		phoneNumber.setHorizontalAlignment(JTextField.CENTER);
		inputTextFieldsPanel.add(emailAddress);
		emailAddress.setPreferredSize(new Dimension(185, 20));
		emailAddress.setHorizontalAlignment(JTextField.CENTER);
		inputTextFieldsPanel.add(picture);
		picture.setPreferredSize(new Dimension(185, 20));
		picture.setHorizontalAlignment(JTextField.CENTER);
		
		this.add(inputTextFieldsPanel, BorderLayout.CENTER);
		
	}
	
	private void addFriendInformationFrameButtons() {

		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		menuPanel.setPreferredSize(new Dimension(65,60));
		
		menuPanel.add(done);
		done.setPreferredSize(new Dimension(60,60));
		done.addActionListener(new DoneActionListener(mainViewFrame, this));
		
		this.add(menuPanel, BorderLayout.EAST);
	}
	
	private void addFriendInformationFrameLabels() {
		
		labelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,100,5));
		labelPanel.setPreferredSize(new Dimension(960, 20));
		
		JLabel name = new JLabel("이름");
		name.setPreferredSize(new Dimension(90, 15));
		labelPanel.add(name);
		JLabel group = new JLabel("그룹");
		group.setPreferredSize(new Dimension(85, 15));
		labelPanel.add(group);
		JLabel phoneNumber = new JLabel("전화번호");
		phoneNumber.setPreferredSize(new Dimension(95, 15));
		labelPanel.add(phoneNumber);
		JLabel emailAddress = new JLabel("Email");
		emailAddress.setPreferredSize(new Dimension(90, 15));
		labelPanel.add(emailAddress);
		JLabel picture = new JLabel("사진");
		picture.setPreferredSize(new Dimension(75, 15));
		labelPanel.add(picture);
		
		this.add(labelPanel, BorderLayout.NORTH);
	}
}

class DoneActionListener implements ActionListener {

	Friend newFriend = new Friend();
	FriendList friendList = new FriendList();
	FriendListFile friendListFile = new FriendListFile();
	FriendListFrame mainViewFrame;
	AddFriendInformationFrame addViewFrame;
	
	public DoneActionListener(FriendListFrame mainViewFrame, AddFriendInformationFrame addViewFrame) {
		this.mainViewFrame = mainViewFrame;
		this.addViewFrame = addViewFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Friend inputInformation = new Friend();
		
		if (!friendList.isConflictedName(addViewFrame.getNameTextField().getText())) {
			inputInformation.setName(addViewFrame.getNameTextField().getText());
			try {
				updateNewFriend();
				addViewFrame.dispose();
				mainViewFrame.dispose();
				mainViewFrame.updateFriendListFrame(mainViewFrame);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "The name of the contact, " + addViewFrame.getNameTextField().getText() + ", is conflicted.");
	}
	
	private void updateNewFriend() throws IOException {
		newFriend.setName(addViewFrame.getNameTextField().getText());
		newFriend.setGroup(Integer.parseInt(addViewFrame.getGroupTextField().getText()));
		newFriend.setPhoneNumber(addViewFrame.getPhoneNumberTextField().getText());
		newFriend.setEmailAddress(addViewFrame.getEmailAddressTextField().getText());
		newFriend.setPicture(addViewFrame.getPictureTextField().getText());
		
		mainViewFrame.addFriendInformaiton(newFriend);
	}
}
