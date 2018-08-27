//RailBarronAssistant RegionChooser.java 06/12/2006
package railbarron;

/**
 * Randomly chooses regions according to the dice roll rules of the game.
 * <P>
 * <TABLE BORDER="0">
 * <TR>	<TD><H4>RegionChooser.java</H4></TD>
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
public final class RegionChooser {
	private static Region[][] regionChart = new Region[][]
	{
		 {	 Region.Plains
			,Region.SouthEast
			,Region.SouthEast
			,Region.SouthEast
			,Region.NorthCentral
			,Region.NorthCentral
			,Region.NorthEast
			,Region.NorthEast
			,Region.NorthEast
			,Region.NorthEast
			,Region.NorthEast}
		,{	 Region.SouthWest
			,Region.SouthCentral
			,Region.SouthCentral
			,Region.SouthCentral
			,Region.SouthWest
			,Region.SouthWest
			,Region.Plains
			,Region.NorthWest
			,Region.NorthWest
			,Region.Plains
			,Region.NorthWest}
	};
	public static Region rollOneUp() {
		int evenOdd = (Dice.roll()%2 == 0?1:0);
		int selectRoll = Dice.roll()+Dice.roll()-2;
		return regionChart[evenOdd][selectRoll];
	}
}
 // End RegionChooser