package project6;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class FriendListFrame extends JFrame {

	private FriendList friendList;

	private JPanel menuPanel = new JPanel();
	private JPanel labelPanel = new JPanel();
	private JPanel checkBoxPanel = new JPanel();
	private JPanel friendListInformationPanel = new JPanel();

	private JButton add = new JButton("Add");
	private JButton delete = new JButton("Delete");
	private JButton modify = new JButton("Modify");
	private JButton save = new JButton("Save");

	public JButton getAddButton() {
		return add;
	}
	public JButton getDeleteButton() {
		return delete;
	}
	public JButton getModifyButton() {
		return modify;
	}
	public JButton getSaveButton() {
		return save;
	}
	
	public FriendListFrame(FriendList friendList) {
		
		this.friendList = friendList;
		this.setLayout(new BorderLayout());
		this.setSize(1180, 410);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("친구 목록");
		this.addFriendListFrameButtons();
		this.addFriendListFrameLabels();
		this.addFriendListInformations();
		this.setVisible(true);
	}

	public void updateFriendListFrame(Object frameObject) {
		new FriendListFrame(this.friendList);
	}
	
	private void addFriendListInformations() {
		for (int i = 0; i < friendList.numFriends(); i++) {
			Friend friendInformation = friendList.getFriend(i);
			friendListInformationPanel.add(new FriendListInformationPanel(friendInformation));
		}

		this.add(friendListInformationPanel,BorderLayout.CENTER);
	}
	
	public void addFriendInformaiton(Friend friendInformation) {
		
		friendList.addFriendInformation(friendInformation);
		
	}

	private void addFriendListFrameButtons() {

		menuPanel.setLayout(new FlowLayout());
		menuPanel.setPreferredSize(new Dimension(60, 240));

		menuPanel.add(add, BorderLayout.EAST);
		add.setPreferredSize(new Dimension(60, 60));
		add.addActionListener(new ButtonsActionListener(this));
		menuPanel.add(delete, BorderLayout.EAST);
		delete.setPreferredSize(new Dimension(60, 60));
		delete.addActionListener(new ButtonsActionListener(this));
		menuPanel.add(modify, BorderLayout.EAST);
		modify.setPreferredSize(new Dimension(60, 60));
		modify.addActionListener(new ButtonsActionListener(this));
		menuPanel.add(save, BorderLayout.EAST);
		save.setPreferredSize(new Dimension(60, 60));
		save.addActionListener(new ButtonsActionListener(this));

		this.add(menuPanel, BorderLayout.EAST);

	}

	public void addFriendListFrameLabels() {

		labelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 130, 5));

		JLabel name = new JLabel("이름");
		labelPanel.add(name);
		name.setPreferredSize(new Dimension(23, 15));
		JLabel group = new JLabel("그룹");
		labelPanel.add(group);
		group.setPreferredSize(new Dimension(48, 15));
		JLabel phoneNumber = new JLabel("전화번호");
		labelPanel.add(phoneNumber);
		phoneNumber.setPreferredSize(new Dimension(140, 15));
		JLabel emailAddress = new JLabel("Email");
		labelPanel.add(emailAddress);
		emailAddress.setPreferredSize(new Dimension(90, 15));
		JLabel picture = new JLabel("사진");
		labelPanel.add(picture);
		picture.setPreferredSize(new Dimension(65, 15));

		this.add(labelPanel, BorderLayout.NORTH);

	}
}

class ButtonsActionListener implements ActionListener {

	FriendListFrame mainViewFrame;
	
	public ButtonsActionListener(FriendListFrame mainViewFrame) {
		this.mainViewFrame = mainViewFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mainViewFrame.getAddButton()))
			new AddFriendInformationFrame(mainViewFrame);
		else if (e.getSource().equals(mainViewFrame.getDeleteButton()))
			deleteButtonAction();
		else if (e.getSource().equals(mainViewFrame.getModifyButton()))
			modifyButtonAction();
		else if (e.getSource().equals(mainViewFrame.getSaveButton()))
			saveButtonAction();
	}
	
	private void deleteButtonAction() {
		
		mainViewFrame.dispose();
		mainViewFrame.updateFriendListFrame(mainViewFrame);
	}
	
	private void modifyButtonAction() {	
		
		mainViewFrame.dispose();
		mainViewFrame.updateFriendListFrame(mainViewFrame);
	}
	
	private void saveButtonAction() {	
		
	}
}