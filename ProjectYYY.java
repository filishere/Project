package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URISyntaxException;

public class ProjectYYY {
	private static Date dateCreated = new Date();
	static String text;
	static String copyText1;
	static String copyText2;
	static String copyText3;
	static String copyText4;
	static String copyText5;

	public static void main(String[] args) {

		final JFrame frame = new JFrame("NATIONAL CALENDAR");
		frame.setSize(1050, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setSize(300, 450);
		panel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		frame.add(panel1);
		panel1.setSize(1050, 350);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("NATIONAL CALENDAR");
		nameLabel.setBounds(90, 15, 130, 15);
		panel.add(nameLabel);

		JLabel moreInfo = new JLabel("For more information visit:" );
		moreInfo.setBounds(70, 220, 350, 310);
		panel.add(moreInfo);
		
		JLabel infoLabel = new JLabel("https://nationaldaycalendar.com/");
		infoLabel.setBounds(70, 240, 350, 310);
		panel.add(infoLabel);
		infoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		goWebsite(infoLabel);

		JLabel todayLabel = new JLabel("People celebrate on:                                    ");
		todayLabel.setBounds(60, 50, 250, 15);
		panel.add(todayLabel);
		todayLabel.setVisible(true);

		SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		currentDateLabel.setBounds(180, 33, 70, 50);
		panel.add(currentDateLabel);

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
		calendar.setBounds(650, 400, 430, 400);
		panel1.add(calendar);
		
		JScrollPane listScroller = new JScrollPane(calendar);
		listScroller.setPreferredSize(new Dimension(430, 400));
		panel1.add(listScroller);
		
		JButton button = new JButton("Add to national Calendar");
		button.setBounds(70, 250, 200, 30);
		panel.add(button);

		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(70, 300, 100, 30);
		panel.add(exitButton);

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

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyText1 = firstBox.getText();

				copyText2 = secondBox.getText();

				copyText3 = thirdBox.getText();

				copyText4 = fourthBox.getText();

				copyText5 = fifthBox.getText();
				text = currentDateLabel.getText() + "\n" + copyText1 + "\n" + copyText2 + "\n" + copyText3 + "\n"
						+ copyText4 + "\n" + copyText5;
				try {
					FileWriter myWriter = new FileWriter("filename1.txt", true);
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

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit?",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
					System.out.println("EXIT SUCCESSFUL");
				}

			}
		});
	
		frame.setVisible(true);

	}


	private static void goWebsite(JLabel infoLabel) {
		infoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://nationaldaycalendar.com/"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});
	}

	public static Date getDateCreated() {
		return dateCreated;
	}

}