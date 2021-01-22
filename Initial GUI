package project;


import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProjectY {

	private Date dateCreated = new Date();

	public static void main(String[] args) {

		JFrame frame = new JFrame("NATIONAL CALENDAR");
		frame.setSize(850, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("NATIONAL CALENDAR");
		nameLabel.setBounds(90, 15, 130, 15);
		panel.add(nameLabel);

		JLabel infoLabel = new JLabel("For more information visit: " + "\n" + " https://nationaldaycalendar.com/ ");
		infoLabel.setBounds(450, 240, 350, 310);
		panel.add(infoLabel);

		JLabel todayLabel = new JLabel("People celebrate on:                                    ");
		todayLabel.setBounds(60, 50, 250, 15);
		panel.add(todayLabel);
		todayLabel.setVisible(true);

		JTextField firstBox = new JTextField();
		firstBox.setBounds(20, 70, 250, 30);
		panel.add(firstBox);
		firstBox.setVisible(true);

		JTextField secondBox = new JTextField();
		secondBox.setBounds(20, 100, 250, 30);
		panel.add(secondBox);
		secondBox.setVisible(true);

		JTextField thirdBox = new JTextField();
		thirdBox.setBounds(20, 130, 250, 30);
		panel.add(thirdBox);
		thirdBox.setVisible(true);

		JTextField fourthBox = new JTextField();
		fourthBox.setBounds(20, 160, 250, 30);
		panel.add(fourthBox);
		fourthBox.setVisible(true);

		JTextField fifthBox = new JTextField();
		fifthBox.setBounds(20, 190, 250, 30);
		panel.add(fifthBox);
		fifthBox.setVisible(true);

		JTextField calendar = new JTextField();
		calendar.setBounds(450, 60, 350, 300);
		panel.add(calendar);

		JButton button = new JButton("Add to national Calendar");
		button.setBounds(70, 250, 200, 30);
		panel.add(button);

		frame.setVisible(true);

	}

	public Date getDateCreated() {
		return dateCreated;
	}

}
