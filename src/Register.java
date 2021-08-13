import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame implements ActionListener{

	Vector<User> userVector;
	JPanel mainPanel, titlePanel, formPanel, nameLabelPanel, nameTextFieldPanel, genderOptionPanel, buttonPanel;
	JLabel registerLabel, nameLabel, addressLabel, genderLabel, ageLabel, profileLabel;
	JTextField nameTextField, addressTextField, profileTextField;
	JRadioButton maleRadioButton, femaleRadioButton;
	ButtonGroup genderButtonGroup;
	JComboBox<Integer> ageComboBox;
	JButton registerButton;
	
	public Register(Vector<User> userVector) {
		// TODO Auto-generated constructor stub
		
//		Populate User Vector
		
		this.userVector = userVector;
		
//		Main Panel
		mainPanel = new JPanel(new BorderLayout());
		
//		Title Panel
		titlePanel = new JPanel();
		registerLabel = new JLabel("Register");
		registerLabel.setBorder(new EmptyBorder(30, 0, 0, 0));
		titlePanel.add(registerLabel);
		
//		Form Panel
		formPanel = new JPanel(new GridLayout(5, 2));
		
		nameLabelPanel = new JPanel();
		nameTextFieldPanel = new JPanel();
		
		nameLabel = new JLabel("Name");
		nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(150, 40));
		nameLabelPanel.add(nameLabel);
		nameTextFieldPanel.add(nameTextField);
		
		addressLabel = new JLabel("Address");
		addressTextField = new JTextField();
		
		genderLabel = new JLabel("Gender");
		genderOptionPanel = new JPanel(new GridLayout(1, 2));
		genderButtonGroup = new ButtonGroup();
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");
		genderButtonGroup.add(maleRadioButton);
		genderButtonGroup.add(femaleRadioButton);
		genderOptionPanel.add(maleRadioButton);
		genderOptionPanel.add(femaleRadioButton);
		
		ageLabel = new JLabel("Age");
		Integer[] ageArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ageComboBox = new JComboBox<Integer>(ageArray);
		
		profileLabel = new JLabel("Profile");
		profileTextField = new JTextField();
		
		formPanel.add(nameLabelPanel);
		formPanel.add(nameTextFieldPanel);
		formPanel.add(addressLabel);
		formPanel.add(addressTextField);
		formPanel.add(genderLabel);
		formPanel.add(genderOptionPanel);
		formPanel.add(ageLabel);
		formPanel.add(ageComboBox);
		formPanel.add(profileLabel);
		formPanel.add(profileTextField);
		
		
//		Button Panel
		buttonPanel = new JPanel();
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		buttonPanel.add(registerButton);
		
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		add(mainPanel);
		
//		Frame Settings
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(450, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Register");
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		if (actionEvent.getSource() == registerButton) {
			
//			Create new user
			String name = nameTextField.getText();
			String address = addressTextField.getText();
			String gender = (maleRadioButton.isSelected()) ? "Male" : "Female"; // Ternary
			Integer age = (Integer) ageComboBox.getSelectedItem();
			String profile = profileTextField.getText();
			
			if (validInput(name, address, gender, age, profile)) {				
				User newUser = new User(name, address, gender, age, profile);
				
				userVector.add(newUser);
				
				printUserVector();
				
				this.dispose();
				new Home(userVector);
			}
			
		}
		
	}
	
	public boolean validInput(String name, String address, String gender, Integer age, String profile) {
		if (!name.isEmpty()) {
			if (!address.isEmpty()) {
				if (age > 0) {
					if (!profile.isEmpty()) {
						return true;
					}
					else {
						JOptionPane.showMessageDialog(this,"Profile must be filled!","Error",JOptionPane.ERROR_MESSAGE);  
					}
				}
				else {
					JOptionPane.showMessageDialog(this,"Profile must be filled!","Error",JOptionPane.ERROR_MESSAGE);
					System.out.println("Age is invalid!");
				}
			}
			else {
				JOptionPane.showMessageDialog(this,"Address must be filled!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(this,"Name must be filled!","Error",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public void printUserVector() {
		for (User user : userVector) {
			System.out.println(user.getName());
			System.out.println(user.getAddress());
			System.out.println(user.getGender());
			System.out.println(user.getAge());
			System.out.println(user.getProfile());
			System.out.println("==============================");
		}
	}

}
