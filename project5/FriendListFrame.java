package project5;

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

	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(add))
				System.out.println("You pushed the Add button.");
			else if (e.getSource().equals(delete))
				System.out.println("You pushed the delete button.");
			else if (e.getSource().equals(modify))
				System.out.println("You pushed the Modify button.");
			else if (e.getSource().equals(save))
				System.out.println("You pushed the Save button.");
		}
	};

	public FriendListFrame(FriendList friendList) {
		
		this.friendList = friendList;
		this.setLayout(new BorderLayout());
		this.setSize(1180, 410);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("친구 목록");
		this.addFriendListFramebuttons();
		this.addFriendListFrameLabels();
		this.addFriendListInformations();
		this.setVisible(true);
	}

	private void addFriendListInformations() {

		ArrayList<FriendListInformationPanel> friend = new ArrayList<FriendListInformationPanel>();
		for (int i = 0; i < friendList.numFriends(); i++) {
			Friend friendInformation = friendList.getFriend(i);
			friendListInformationPanel.add(new FriendListInformationPanel(friendInformation));
		}

		this.add(friendListInformationPanel,BorderLayout.CENTER);

	}

	private void addFriendListFramebuttons() {

		menuPanel.setLayout(new FlowLayout());
		menuPanel.setPreferredSize(new Dimension(60, 240));

		menuPanel.add(add, BorderLayout.EAST);
		add.setPreferredSize(new Dimension(60, 60));
		add.addActionListener(actionListener);
		menuPanel.add(delete, BorderLayout.EAST);
		delete.setPreferredSize(new Dimension(60, 60));
		delete.addActionListener(actionListener);
		menuPanel.add(modify, BorderLayout.EAST);
		modify.setPreferredSize(new Dimension(60, 60));
		modify.addActionListener(actionListener);
		menuPanel.add(save, BorderLayout.EAST);
		save.setPreferredSize(new Dimension(60, 60));
		save.addActionListener(actionListener);

		this.add(menuPanel, BorderLayout.EAST);

	}

	public void addFriendListFrameLabels() {

		labelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 130, 5));
		//labelPanel.setPreferredSize(new Dimension(960, 30));

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

/*	public void addFriendListFrameCheckBoxMargin() {

		checkBoxPanel.setLayout(new FlowLayout());
		checkBoxPanel.setPreferredSize(new Dimension(60, 15));

		JLabel margin = new JLabel(" ");
		checkBoxPanel.add(margin);
		margin.setPreferredSize(new Dimension(60, 15));

		this.add(checkBoxPanel, BorderLayout.WEST);
	}
	*/
}