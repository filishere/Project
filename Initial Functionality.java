package project;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ProjectYY {
	private static Date dateCreated = new Date();
	static String text;
	static String copyText1;
	static String copyText2;
	static String copyText3;
	static String copyText4;
	static String copyText5;

	public static void main(String[] args) {

		final JFrame frame = new JFrame("NATIONAL CALENDAR");
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

		JLabel dateLabel = new JLabel(dateCreated.toString());
		dateLabel.setBounds(180, 33, 70, 50);
		panel.add(dateLabel);

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

		JTextArea calendar = new JTextArea();
		calendar.setBounds(450, 60, 350, 300);
		panel.add(calendar);

		JButton button = new JButton("Add to national Calendar");
		button.setBounds(70, 250, 200, 30);
		panel.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyText1 = firstBox.getText();

				copyText2 = secondBox.getText();

				copyText3 = thirdBox.getText();

				copyText4 = fourthBox.getText();

				copyText5 = fifthBox.getText();
				text = dateCreated.toString() + "\n" + copyText1 + "\n" + copyText2 + "\n" + copyText3 + "\n"
						+ copyText4 + "\n" + copyText5;
				try {
					FileWriter myWriter = new FileWriter("filename1.txt",true);
					myWriter.write(text);
					myWriter.close();

				} catch (IOException e2) {
					System.out.println("An error occurred.");
					e2.printStackTrace();
				}

				File myObj = new File("filename1.txt");
				text = "";
				try {
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						text += myReader.nextLine() + "\n";
					}
					myReader.close();
				} catch (FileNotFoundException e1) {
					try {
						myObj.createNewFile();
					} catch (IOException e12) {
						// TODO Auto-generated catch block
						e12.printStackTrace();
					}
				}
				calendar.setText("\n" + text);

				firstBox.setText(null);
				secondBox.setText(null);
				thirdBox.setText(null);
				fourthBox.setText(null);
				fifthBox.setText(null);
			}
		});

		frame.setVisible(true);

	}

	public static Date getDateCreated() {
		return dateCreated;
	}

}

