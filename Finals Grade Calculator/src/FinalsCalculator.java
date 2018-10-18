import javax.swing.*; //imports all classes necessary to made the graphic user interphase
import java.awt.event.*; //including jpanel, action listeners, and GUI icons
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Scanner;

/* the first part of the program that creates the GUI and creates the various buttons and action
 *  listeners for the program, it gives the user a choice between calculating what grade they need 
 *  on the final, the weight of the final, and what percent they currently have in the grade
 */
public class FinalsCalculator { // declares the finals calculator class
	public static void main(String[] args) {
		JFrame frame = new JFrame("THE FINALS CALCULATOR"); // creates the Finals Calculator GUI window
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // once the frame is closed the program terminates
		frame.setSize(300, 200); // sets the size of the window to 300x200 pixels
		JPanel panel = new JPanel(); // makes a new JPanel
		frame.add(panel); // adds the created JFrame into the finals calculator panel
		/* creates the various buttons and action listeners */
		JButton button = new JButton("Calculate My Final Grade"); // creates the Finals Calculator button
		panel.add(button);
		button.addActionListener(new Action()); // creates the action listener for the finals calculator button
		JButton button2 = new JButton("Calculate the Weight of My Final"); // creates the final weight calculator button
		panel.add(button2);
		button2.addActionListener(new FinalWeight()); // creates the action listener for the final weight button
		JButton button3 = new JButton("Calculate My Current Class Percentage"); // creates the current class % button
		panel.add(button3);
		button3.addActionListener(new ClassPoints()); // creates the action listener for the current class % button
		JButton button4 = new JButton("close"); // creates the close button that terminates the program
		panel.add(button4);
		button4.addActionListener(new Listener()); // creates action listener for the close button
	}

	/*
	 * the second part of the code, finals calculator class, which calculates the
	 * final exam score needed to achieve a desired grade
	 */
	static class Action implements ActionListener { // assigns the event listener to this class
		public void actionPerformed(ActionEvent e) {
			Scanner evan = new Scanner(System.in);
// All pictures not cited are free domain (free to use) //grade.jpg picture thanks to https://www.thoughtco.com/figurepercentage-and-letter-grade-1828610
			ImageIcon grade = new ImageIcon("grade.jpg"); // implements the various images used for icons in ImageIcon
															// thumbsup=
			new ImageIcon("thumbsup.png"); // the finals calculator class
			ImageIcon thumbsup = new ImageIcon("thumbsup.png");
			ImageIcon thumbsdown = new ImageIcon("thumbsdown.png"); // Thumbsdown.jpg picture Thanks to: Font Awesome by
																	// Dave Gandy -
																	// http://fortawesome.github.com/Font-Awesome
			ImageIcon okhand = new ImageIcon("okhand.png"); // Okhand.jpg picture Thanks to:
															// https://icons8.com/web-app/24361/okhand
			double yourPer; // creates the user’s grade percent variable and assigns it to a decimal value
			double wantPer; // creates the user’s desired grade percent variable and assigns it to a decimal
							// value
			double finalPer; // creates the final weight variable and assigns it to a decimal variable
			double answer; // creates the answer variable and assigns it to a decimal variable
			double examGrade; // created the final exam grade variable and assigns it to a decimal variable
//creates windows that ask for the user’s input
			String cg = (String) JOptionPane.showInputDialog(null, "What is your percentage in the class?",
					"Finals Calculator", JOptionPane.INFORMATION_MESSAGE, grade, null, "");
			yourPer = Double.parseDouble(cg);
			String dg = (String) JOptionPane.showInputDialog(null, "What percentage do you want in your class?",
					"Finals Calculator", JOptionPane.INFORMATION_MESSAGE, grade, null, "");
			wantPer = Double.parseDouble(dg);
			String fw = (String) JOptionPane.showInputDialog(null, "What percentage of your grade is the final worth?",
					"Finals Calculator", JOptionPane.INFORMATION_MESSAGE, grade, null, "");
			finalPer = Double.parseDouble(fw);
//the math that calculates the final exam grade needed for the desired grade
			yourPer = yourPer / 100;
			wantPer = wantPer / 100;
			finalPer = finalPer / 100;
			answer = 1 - finalPer;
			answer = wantPer - yourPer * answer;
			examGrade = answer / finalPer;
			examGrade = examGrade * 100;
			wantPer = wantPer * 100;
			/*
			 * outputs the grade required on the final and couples it with a message and an
			 * icon based on what the required final grade is
			 */
			if (examGrade >= 95) {
				JOptionPane.showMessageDialog(null,
						"You need at least a(n) " + examGrade + "% to get " + wantPer + "% in the class" + "\n"
								+ "Better hit those books!",
						"FINALS CALCULATOR", JOptionPane.INFORMATION_MESSAGE, thumbsdown);
			} else if (examGrade >= 85 && finalPer < 95) {
				JOptionPane.showMessageDialog(null,
						"You need at least a(n) " + examGrade + "% to get " + wantPer + "% in the class" + "\n"
								+ "You should be fine if you study hard!",
						"FINALS CALCUALATOR", JOptionPane.INFORMATION_MESSAGE, okhand);
			} else if (examGrade >= 50 && finalPer < 85) {
				JOptionPane.showMessageDialog(null,
						"You need at least a(n) " + examGrade + "% to get " + wantPer + "% in the class" + "\n"
								+ "Maybe just skim a few notes...?",
						"FINALS CALCULATOR", JOptionPane.INFORMATION_MESSAGE, okhand);
			} else {
				JOptionPane.showMessageDialog(null,
						"You need at least a(n) " + examGrade + "% to get " + wantPer + "% in the class" + "\n"
								+ "Don't even bother studying!!!",
						"FINALS CALCULATOR", JOptionPane.INFORMATION_MESSAGE, thumbsup);
			}
		}
	}

	/*
	 * the third part of the code that calculates the final exam weight. It creates
	 * the FinalWeight class
	 */
	static class FinalWeight implements ActionListener { // assigns the event listener for the calss
		public void actionPerformed(ActionEvent e) {
			ImageIcon finalexam = new ImageIcon("finalexam.jpg"); // implements the various pictures that will
			ImageIcon thumbsup = new ImageIcon("thumbsup.png"); // be used as icons for the class
			Scanner evan2 = new Scanner(System.in); // final exam picture thanks to:
													// https://www.test-guide.com/free-sat-practicetests.html
			double classPts; // creates the class points variable and assigns it to a decimal variable
			double finalPts; // creates the final exam points variable and assigns it to a decimal variable
			double totalPts; // creates the total points variable and assigns it to a decimal variable
			double finalWt; // creates the final weight variable and assigns it to a decimal variable
//creates the various windows that ask for the user’s input
			String cp = (String) JOptionPane.showInputDialog(null, "How many points are there TOTAL in the class?",
					"FINAL WEIGHT", JOptionPane.INFORMATION_MESSAGE, finalexam, null, "");
			classPts = Double.parseDouble(cp);
			String fp = (String) JOptionPane.showInputDialog(null, "How many points is your final?", "FINAL WEIGHT",
					JOptionPane.INFORMATION_MESSAGE, finalexam, null, "");
			finalPts = Double.parseDouble(fp);
//the math that calculates the final exam weight
			totalPts = finalPts + classPts;
			finalWt = finalPts / totalPts;
			finalWt = finalWt * 100;
//outputs the final exam weight percent in the GUI and gives it a thumbs up because the program ran
			JOptionPane.showMessageDialog(null, "Your final is worth " + finalWt + "% of your grade", "FINAL WIEGHT",
					JOptionPane.INFORMATION_MESSAGE, thumbsup);
		}
	}

	/*
	 * the fourth part of the program, the ClassPoints class, it calculates what
	 * percent the user has in the class
	 */
	static class ClassPoints implements ActionListener { // assigns the action listener to the class
		public void actionPerformed(ActionEvent r) {
			ImageIcon calculations = new ImageIcon("calculations.png"); // implements the various pictures that will be
																		// used as
			ImageIcon thumbsup = new ImageIcon("thumbsup.png"); // icons in the class
			ImageIcon thumbsdown = new ImageIcon("thumbsdown.png");
			ImageIcon okhand = new ImageIcon("okhand.png");
			Scanner evan3 = new Scanner(System.in);
			double classpts; // creates the class points variable and assigns it to a decimal variable
			double yourpts; // creates the user’s points variable and assigns it to a decimal variable
			double finalpct; // creates the class percent variable and assigns it to a decimal variable
//creates the various input windows for the user’s input
			String cp = (String) JOptionPane.showInputDialog(null, "How many points are there TOTAL in the class?",
					"CLASS %", JOptionPane.INFORMATION_MESSAGE, calculations, null, "");
			classpts = Double.parseDouble(cp);
			String yp = (String) JOptionPane.showInputDialog(null, "How many points do you have in the class?",
					"CLASS %", JOptionPane.INFORMATION_MESSAGE, calculations, null, "");
			yourpts = Double.parseDouble(yp);
//the math that calculates the percent the user has in the class
			finalpct = yourpts / classpts;
			finalpct = finalpct * 100;
			/*
			 * outputs the user’s class percent coupled with a message and a picture
			 * depending on what percent the user has in the class
			 */
			if (finalpct >= 95) {
				JOptionPane.showMessageDialog(null,
						"You currently have a " + finalpct + "% in the class" + "\n" + "good work!", "CLASS%",
						JOptionPane.INFORMATION_MESSAGE, thumbsup);
			} else if (finalpct >= 85 && finalpct < 95) {
				JOptionPane.showMessageDialog(null,
						"You currently have a " + finalpct + "% in the class" + "\n" + "things are looking good",
						"CLASS %", JOptionPane.INFORMATION_MESSAGE, okhand);
			} else if (finalpct >= 50 && finalpct < 85) {
				JOptionPane.showMessageDialog(null,
						"You currently have a " + finalpct + "% in the class" + "\n"
								+ "your grade has probably looked better",
						"CLASS %", JOptionPane.INFORMATION_MESSAGE, okhand);
			} else {
				JOptionPane.showMessageDialog(null,
						"You currently have a " + finalpct + "% in the class" + "\n"
								+ "I say you should spend more time figuring out how to hide that" + "\n"
								+ "report card from your parents",
						"CLASS %", JOptionPane.INFORMATION_MESSAGE, thumbsdown);
			}
		}
	}

//the close class, it closes the window and terminates the program when the close button is pressed
	static class Listener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			System.exit(0);
		}
	}
}