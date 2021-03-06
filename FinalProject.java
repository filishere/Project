package project;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;

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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
		panel.setSize(310, 550);
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		
		JPanel panel1 = new JPanel();
		frame.add(panel1);
		panel1.setSize(1050, 510);
		panel1.setBackground(Color.CYAN);
		
		JLabel nameLabel = new JLabel("NATIONAL CALENDAR");
		nameLabel.setBounds(90, 15, 130, 15);
		panel.add(nameLabel);

		JLabel moreInfo = new JLabel("For more information visit:" );
		moreInfo.setBounds(130, 300, 250, 210);
		panel.add(moreInfo);
		
		JLabel infoLabel = new JLabel("https://nationaldaycalendar.com/");
		infoLabel.setBounds(120,330 , 250, 210);
		panel.add(infoLabel);
		infoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
              // method for hyperlink
		goWebsite(infoLabel);

		JLabel todayLabel = new JLabel("People celebrate on:                                    ");
		todayLabel.setBounds(60, 50, 250, 15);
		panel.add(todayLabel);
		todayLabel.setVisible(true);

		SimpleDateFormat ft = new SimpleDateFormat("dd. M. yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		currentDateLabel.setBounds(180, 33, 70, 50);
		panel.add(currentDateLabel);
		currentDateLabel.setForeground(Color.DARK_GRAY);

		JTextField firstBox = new JTextField();
		firstBox.setBounds(20, 65, 250, 30);
		panel.add(firstBox);
		firstBox.setVisible(true);
		Border border5 = new LineBorder(Color.BLUE, 4, true);
		firstBox.setBorder(border5);

		JTextField secondBox = new JTextField();
		secondBox.setBounds(20, 100, 250, 30);
		panel.add(secondBox);
		secondBox.setVisible(true);
		Border border4 = new LineBorder(Color.BLUE, 4, true);
		secondBox.setBorder(border4);

		JTextField thirdBox = new JTextField();
		thirdBox.setBounds(20, 135, 250, 30);
		panel.add(thirdBox);
		thirdBox.setVisible(true);
		Border border3 = new LineBorder(Color.BLUE, 4, true);
	    thirdBox.setBorder(border3);

		JTextField fourthBox = new JTextField();
		fourthBox.setBounds(20, 170, 250, 30);
		panel.add(fourthBox);
		fourthBox.setVisible(true);
		Border border2 = new LineBorder(Color.BLUE, 4, true);
		fourthBox.setBorder(border2);

		JTextField fifthBox = new JTextField();
		fifthBox.setBounds(20, 205, 250, 30);
		panel.add(fifthBox);
		fifthBox.setVisible(true);
		Border border1 = new LineBorder(Color.BLUE, 4, true);
		fifthBox.setBorder(border1);

		JTextArea calendar = new JTextArea();
		calendar.setBounds(650, 400, 410, 350);
		panel1.add(calendar);
		Border border = new LineBorder(Color.BLUE, 4, true);
		calendar.setBorder(border);
		
		// scrollbar
		JScrollPane listScroller = new JScrollPane(calendar);
		listScroller.setPreferredSize(new Dimension(410, 350));
		panel1.add(listScroller);
		
		JButton button = new JButton("Add to national Calendar");
		button.setBounds(70, 250, 200, 30);
		panel.add(button);
		button.setBackground(Color.GREEN);

		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(70, 300, 100, 30);
		panel.add(exitButton);
		exitButton.setBackground(Color.GREEN);
		
		// creating file to make the saved changes visible
		File myObj = new File("filename6.txt");
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
						+ copyText4 + "\n" + copyText5 + "\n";
					// creating file to save changes after closing gui
				try {
					FileWriter myWriter = new FileWriter("filename6.txt", true);
					myWriter.write(text);
					myWriter.close();

				} catch (IOException e2) {
					System.out.println("An error occurred.");
					e2.printStackTrace();
				}

				File myObj = new File("filename6.txt");
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
			public void actionPerformed(ActionEvent e5) {
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

	// method for the hyperlink
	private static void goWebsite(JLabel infoLabel) {
		infoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e6) {
				try {
					Desktop.getDesktop().browse(new URI("https://nationaldaycalendar.com/"));
				} catch (URISyntaxException | IOException ex) {
				
				}
			}
		});
	}

	public static Date getDateCreated() {
		return dateCreated;
	}

}
