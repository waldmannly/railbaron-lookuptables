//RailBarronAssistant PlayerController.java 06/12/2006
package railbarron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Object that knows the players home, from and to regions and which fields display them.
 * <P>
 * <TABLE BORDER="0">
 * <TR>	<TD><H4>PlayerController.java</H4></TD>
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
public final class PlayerController {
	private Region homeRegion = null;
	private Region fromRegion = null;
	private Region toRegion = null;
	
	private City homeCity = null;
	private City fromCity = null;
	private City toCity = null;
	
	private JLabel homeCityLabel = null;
	private JLabel fromCityLabel = null;
	private JLabel toCityLabel = null;
	private JLabel payoutLabel = null;
	private JButton actionButton = null;
	
	/**
	 * Create a player controller to manage a players information set.
	 * @param homeCityLabel
	 * @param fromCityLabel
	 * @param toCityLabel
	 * @param payoutLabel
	 * @param actionButton
	 */
	PlayerController(JLabel homeCityLabel, JLabel fromCityLabel, JLabel toCityLabel, JLabel payoutLabel, JButton actionButton) {
		super();
		this.homeCityLabel = homeCityLabel;
		this.fromCityLabel = fromCityLabel;
		this.toCityLabel = toCityLabel;
		this.payoutLabel = payoutLabel;
		setActionButton(actionButton);
	}
	private final void setActionButton(JButton actionButton) {
		this.actionButton = actionButton;
		actionButton.setText("Choose Home City");
		actionButton.setActionCommand("button");
		actionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (homeRegion == null)
					setUpHome();
				else
					setNextDestination();
			}
			
		});
	}
	private void setUpHome() {
		Region newRegion = RegionChooser.rollOneUp();
		setHomeCity(newRegion,CityChooser.getRandomCity(newRegion));

		actionButton.setText("Next Destination");
		fromCityLabel.setText(" ");
		setToCity(homeRegion,homeCity);
	}
	private void setNextDestination() {
		Region newToRegion = RegionChooser.rollOneUp();
		if (newToRegion.equals(toRegion))
			newToRegion = getUserRegionChoice();
		City newToCity = CityChooser.getRandomCity(newToRegion);
		if (newToCity.equals(toCity)) {
			JOptionPane.showMessageDialog(actionButton, "Rolled the same city as the current location. Miss 1 turn");
		} else {
			setFromCity(toRegion,toCity);
			setToCity(newToRegion,newToCity);
			payoutLabel.setText(PayoutChart.getPayoutValueForTrip(fromCity, toCity));
		}
	}
	
	private Region getUserRegionChoice() {
		Region selectedValue = (Region) JOptionPane.showInputDialog(null, 
		"Choose Region for next destination.", "Choose Region",
		JOptionPane.INFORMATION_MESSAGE, null,
		Region.values(), toRegion);
		if (selectedValue == null)
			selectedValue = toRegion;
		return selectedValue;
	}
	
	private void setHomeCity(Region newHomeRegion, City newHomeCity) {
		homeRegion = newHomeRegion;
		homeCity = newHomeCity;
		homeCityLabel.setText(getCityLabelText(homeRegion,homeCity));
	}
	
	private void setFromCity(Region newFromRegion, City newFromCity) {
		fromRegion = newFromRegion;
		fromCity = newFromCity;
		fromCityLabel.setText(getCityLabelText(fromRegion,fromCity));
	}
	
	private void setToCity(Region newToRegion, City newToCity) {
		toRegion = newToRegion;
		toCity = newToCity;
		toCityLabel.setText(getCityLabelText(toRegion,toCity));
	}
	
	private String getCityLabelText(Region cityRegion, City city) {
		return cityRegion.getAbbreviation()+" "+city.getFullName();
	}
} // End PlayerController