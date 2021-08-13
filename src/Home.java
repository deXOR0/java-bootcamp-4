import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Home extends JFrame implements ActionListener, MenuListener{
	
	Vector<User> userVector;
	JPanel mainPanel;
	JLabel nameLabel, addressLabel, genderLabel, ageLabel, profileLabel;
	JButton backButton;
	JMenuBar homeMenuBar;
	JMenu profileMenu;
	JMenuItem logoutMenuItem;
	
	
	public Home(Vector<User> userVector) {
		// TODO Auto-generated constructor stub
		
//		Populate User Vector
		this.userVector = userVector;
		
		User user = this.userVector.get(userVector.size() - 1);
		
//		Menu Bar
		homeMenuBar = new JMenuBar();
		profileMenu = new JMenu("Profile");
		logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(this);
		
		profileMenu.add(logoutMenuItem);
		profileMenu.addMenuListener(this);
		
		homeMenuBar.add(profileMenu);
		
		mainPanel = new JPanel(new GridLayout(6, 1));
		
		nameLabel = new JLabel(user.getName());
		addressLabel = new JLabel(user.getAddress());
		genderLabel = new JLabel(user.getGender());
		ageLabel = new JLabel(String.valueOf(user.getAge()));
		profileLabel = new JLabel(user.getProfile());
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		
		mainPanel.add(nameLabel);
		mainPanel.add(addressLabel);
		mainPanel.add(genderLabel);
		mainPanel.add(ageLabel);
		mainPanel.add(profileLabel);
		mainPanel.add(backButton);
		
		add(mainPanel);
		
//		Frame Settings
		setJMenuBar(homeMenuBar);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(450, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Home");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == backButton) {
			this.dispose();
			new Register(userVector);
		}
		else if (arg0.getSource() == logoutMenuItem) {
			this.dispose();
			new Register(userVector);
		}
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == profileMenu) {
			
		}
//		JMenu myMenu = (JMenu) e.getSource();
//	    System.out.println("Menu Selected: "+myMenu.getText());
	}

}
