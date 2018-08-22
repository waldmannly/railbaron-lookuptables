//RailBarronAssistant RailBarronAssistantApp.java 06/12/2006
package railbarron;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 * The application controller.
 * <P>
 * <TABLE BORDER="0">
 * <TR>	<TD><H4>RailBarronAssistantApp.java</H4></TD>
 *	<TD><FONT SIZE=-2>Copyright 2006 Tower Games All Rights Reserved.
 *	<BR>CopyrightVersion  1.0 6/December/2006</FONT></TD></TR>
 * <TR><TD><TABLE BORDER="0">
 *	<TR><TD><FONT SIZE=-2><p><b>History</b></TD></TR>
 *	<TR><TD><FONT SIZE=-2>2006 12 06</FONT></TD><TD><FONT SIZE=-2>1.0	Created</FONT></TD></TR>
 *	</TABLE></TD>
 * <TD><TABLE BORDER="1"><TR><TD><FONT SIZE=-2>
 * This source code and any code generated from it by compilation
 * is the confidential and proprietary information of Tower Games
 * ("Confidential Information").  You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you entered into
 * with Tower Games
 * <BR>Tower Games makes no representations or warranties about the siutability of this
 * source code or any code generated from it by compilation, either expressed or implied, including
 * (but not limited to) the implied warranties of merchantability, fitness for a particular purpose,
 * or non-infringement. Tower Games shall not be liable for any damages suffered
 * by the licensee as a result of using, modifying or distributing this source code or its derivatives
 * or any code generated from it by compilation.
 * </FONT></TD></TR></TABLE></TD></TR>
 *
 * </TABLE>
 * @author Danny Stevens
 * @version 1.0
 */
public final class RailBarronAssistantApp {
	private JFrame mainFrame = null;
	
	public RailBarronAssistantApp() {
		int numberOfPlayers = getNumberOfPlayers();
		if (numberOfPlayers == -1) System.exit(0);
		
		mainFrame = new JFrame("Rail Barron Assistant");
		mainFrame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent arg0) { System.exit(0); }});
		mainFrame.setLayout(new GridLayout(1,0));
		JPanel labelsPanel = new JPanel(new GridLayout(0,1));
		labelsPanel.add(new JLabel("Player Name:   ",SwingConstants.TRAILING));
		labelsPanel.add(new JLabel("Home City:   ",SwingConstants.TRAILING));
		labelsPanel.add(new JLabel("From City:   ",SwingConstants.TRAILING));
		labelsPanel.add(new JLabel("To City:   ",SwingConstants.TRAILING));
		labelsPanel.add(new JLabel("Payout:   ",SwingConstants.TRAILING));
		labelsPanel.add(new JLabel(" ",SwingConstants.TRAILING));
		mainFrame.add(labelsPanel);
		for (int i = 0; i < numberOfPlayers; i++) {
			JLabel homeCityLabel = new JLabel("Home City Unknown");
			JLabel fromCityLabel = new JLabel("From City Unknown");
			JLabel toCityLabel = new JLabel("To City Unknown");
			JLabel payoutLabel = new JLabel("Payout Unknown");
			JButton actionButton = new JButton("Action");
			new PlayerController(homeCityLabel,fromCityLabel,toCityLabel,payoutLabel,actionButton);
			
			JPanel playerPanel = new JPanel(new GridLayout(0,1));
			playerPanel.add(getPlayerNameField(i));
			playerPanel.add(homeCityLabel);
			playerPanel.add(fromCityLabel);
			playerPanel.add(toCityLabel);
			playerPanel.add(payoutLabel);
			playerPanel.add(actionButton);
			playerPanel.setBorder(new EtchedBorder());
			mainFrame.add(playerPanel);
			 
		}
		mainFrame.pack();
		mainFrame.setVisible(true);
	} // end RailBarronAssistantApp

	/**
	 * Get a text field to type the players name into.
	 * <P>Select all text on focus.
	 * <P>
	 * @param i
	 * @return
	 */
	private JTextField getPlayerNameField(int i) {
		JTextField playerNameField = new JTextField("Name of Player "+(i+1));
		playerNameField.addFocusListener(new FocusListener() {

			/* (non-Javadoc)
			 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
			 */
			public void focusGained(FocusEvent arg0) {
				if (!arg0.isTemporary()) {
					JTextField text = (JTextField) arg0.getComponent();
					text.setCaretPosition(0);
					text.moveCaretPosition(text.getText().length());
				}
			}

			/* (non-Javadoc)
			 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
			 */
			public void focusLost(FocusEvent arg0) {}
		});
		return playerNameField;
	}

	/**
	 * Ask the user how many players to handle.
	 * <P>
	 * @return the number of players or -1 if cancel.
	 */
	private int getNumberOfPlayers() {
		Object[] possibleValues = { "1", "2", "3", "4", "5", "6" };
		String selectedValue = (String) JOptionPane.showInputDialog(null, 
		"How many players?", "Start Assistant",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		int numberOfPlayers = -1;
		if (selectedValue != null)
			numberOfPlayers = Integer.parseInt(selectedValue);
		return numberOfPlayers;
	}
	
} // End RailBarronAssistantApp