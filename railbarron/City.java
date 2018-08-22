//RailBarronAssistant City.java 06/12/2006
package railbarron;

/**
 *Collection of cities on the board.
 * <P>
 * <TABLE BORDER="0">
 * <TR>	<TD><H4>City.java</H4></TD>
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
public enum City {
	 Albany("Albany")
	,Atlanta("Atlanta")
	,Baltimore("Baltimore")
	,Billings("Billings")
	,Birmingham("Birmingham")
	,Boston("Boston")
	,Buffalo("Buffalo")
	,Butte("Butte")
	,Casper("Casper")
	,Charleston("Charleston")
	,Charlotte("Charlotte")
	,Chattanooga("Chattanooga")
	,Chicago("Chicago")
	,Cincinnati("Cincinnati")
	,Cleveland("Cleveland")
	,Columbus("Columbus")
	,Dallas("Dallas")
	,Denver("Denver")
	,DesMoines("Des Moines")
	,Detroit("Detroit")
	,ElPaso("ElPaso")
	,Fargo("Fargo")
	,FortWorth("Fort Worth")
	,Houston("Houston")
	,Indianapolis("Indianapolis")
	,Jacksonville("Jacksonville")
	,KansasCity("Kansas City")
	,Knoxville("Knoxville")
	,LasVagas("Las Vagas")
	,LittleRock("Little Rock")
	,LosAngeles("Los Angeles")
	,Louisville("Louisville")
	,Memphis("Memphis")
	,Miami("Miami")
	,Milwaukee("Milwaukee")
	,Minneapolis("Minneapolis")
	,Mobile("Mobile")
	,Nashville("Nashville")
	,NewOrleans("New Orleans")
	,NewYork("New York")
	,Norfolk("Norfolk")
	,Oakland("Oakland")
	,OklahomaCity("Oklahoma City")
	,Omaha("Omaha")
	,Philadelphia("Philadelphia")
	,Phoenix("Phoenix")
	,Pittsburgh("Pittsburgh")
	,Pocatello("Pocatello")
	,PortlandME("Portland ME")
	,PortlandOR("Portland OR")
	,Pueblo("Pueblo")
	,RapidCity("Rapid City")
	,Reno("Reno")
	,Richmond("Richmond")
	,Sacramento("Sacramento")
	,SaltLakeCity("Salt Lake City")
	,SanAntonio("San Antonio")
	,SanDiego("San Diego")
	,SanFrancisco("San Francisco")
	,Seattle("Seattle")
	,Shreveport("Shreveport")
	,Spokane("Spokane")
	,StLouis("St. Louis")
	,StPaul("St. Paul")
	,Tampa("Tampa")
	,Tucumcari("Tucumcari")
	,WashingtonDC("Washington DC")
	;
	private City(String fullName) {
		this.fullName = fullName;
	}
	
	private String fullName;

	public final String getFullName() {
		return fullName;
	}
}
 // End City