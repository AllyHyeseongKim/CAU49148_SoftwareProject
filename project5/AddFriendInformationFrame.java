package project5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddFriendInformationFrame extends JFrame {

	private JPanel menuPanel = new JPanel();
	private JPanel labelPanel = new JPanel();
	private JPanel inputTextFieldsPanel = new JPanel();
	
	private JTextField name = new JTextField();
	private JTextField group = new JTextField();
	private JTextField phoneNumber = new JTextField();
	private JTextField emailAddress = new JTextField();
	private JTextField picture = new JTextField();
	
	private JButton done = new JButton("Done");
	
private ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(done))
				System.out.println("You pushed the Done button.");
		}
	};
	
	public AddFriendInformationFrame() {
		
		this.setLayout(new BorderLayout());
		this.setSize(1020, 108);
		this.setTitle("추가될 친구 정보");
		this.addFriendInformationFrameButtons();
		this.addFriendInformationFrameLabels();
		this.addInputTextFields();
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
		
		this.add(inputTextFieldsPanel, BorderLayout.WEST);
		
	}
	
	private void addFriendInformationFrameButtons() {

		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		menuPanel.setPreferredSize(new Dimension(65,60));
		
		menuPanel.add(done);
		done.setPreferredSize(new Dimension(60,60));
		done.addActionListener(actionListener);
		
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
