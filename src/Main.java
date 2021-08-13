import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	
	public Vector<User> userVector = new Vector<>();

	public Main() {
		// TODO Auto-generated constructor stub
//		GUI + Java Swing
//		- Frame (Container)
//			- Panel (Container)
//				- Component
//		Layout Manager
//		- Border Layout (Default layoutnya JFrame)
//		- Flow Layout (Default JPanel)
//		- Grid Layout
//		
//		JPanel panel1 = new JPanel();
//		panel1.setLayout(new GridLayout(2, 3));
//		
//		JButton button1 = new JButton("Click Me!");
//		JButton button2 = new JButton("Click Me Too!");
//		JButton button3 = new JButton("Button 3");
//		JButton button4 = new JButton("Button 4");
//		JButton button5 = new JButton("Button 5");
//		
//		panel1.add(button1);
//		panel1.add(button2);
//		panel1.add(button3);
//		panel1.add(button4);
//		panel1.add(button5);
//		
//		add(panel1);
//		
//		setLayout(new BorderLayout());
//		setVisible(true);
//		setLocationRelativeTo(null);
//		setSize(400, 400);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
//		setTitle("My Main Frame");
		Register register = new Register(userVector);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
