//RailBarronAssistant PayoutChart.java 06/12/2006
package railbarron;

import java.util.HashMap;
import java.util.Map;

/**
 * Provide the payout value for trips between cities.
 * <P>
 * <TABLE BORDER="0">
 * <TR>	<TD><H4>PayoutChart.java</H4></TD>
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
public final class PayoutChart {
	private static PayoutChart theChart = null;
	private Map<City,Map<City, String>> city1Map = new HashMap<City,Map<City, String>>();
	
	public static final String getPayoutValueForTrip(City city1, City city2) {
		if (theChart == null)
			theChart = new PayoutChart();
		return theChart.getPayout(city1, city2);
	}
	
	private PayoutChart() {
		initPayoutChart();
	}
	private final String getPayout(City city1, City city2) {
		Map<City, String> city2Map = city1Map.get(city1);
		return city2Map.get(city2);
	}
	private final void initPayoutChart() {
		init_NE_NE();
		init_SE_NE();
		init_NC_NE();
		init_SC_NE();
		init_P_NE();
		init_NW_NE();
		init_SW_NE();
		
		init_SE_SE();
		init_NC_SE();
		init_SC_SE();
		init_P_SE();
		init_NW_SE();
		init_SW_SE();
		
		init_NC_NC();
		init_SC_NC();
		init_P_NC();
		init_NW_NC();
		init_SW_NC();
		
		init_SC_SC();
		init_P_SC();
		init_NW_SC();
		init_SW_SC();
		
		init_P_P();
		init_NW_P();
		init_SW_P();
		
		init_NW_NW();
		init_SW_NW();
		
		init_SW_SW();
		
		testChartCompleteness();
	}

	private void init_NE_NE() {
		addPayout(City.Albany,City.Albany,"-");
		addPayout(City.Albany,City.Baltimore,"3.5");
		addPayout(City.Albany,City.Boston,"2");
		addPayout(City.Albany,City.Buffalo,"3");
		addPayout(City.Albany,City.NewYork,"1.5");
		addPayout(City.Albany,City.Philadelphia,"2.5");
		addPayout(City.Albany,City.Pittsburgh,"5.5");
		addPayout(City.Albany,City.PortlandME,"3");
		addPayout(City.Albany,City.WashingtonDC,"3.5");
		
		addPayout(City.Baltimore,City.Albany,"3.5");
		addPayout(City.Baltimore,City.Baltimore,"-");
		addPayout(City.Baltimore,City.Boston,"4");
		addPayout(City.Baltimore,City.Buffalo,"4");
		addPayout(City.Baltimore,City.NewYork,"2");
		addPayout(City.Baltimore,City.Philadelphia,"1");
		addPayout(City.Baltimore,City.Pittsburgh,"3.5");
		addPayout(City.Baltimore,City.PortlandME,"5.5");
		addPayout(City.Baltimore,City.WashingtonDC,"5");
		
		addPayout(City.Boston,City.Albany,"2");
		addPayout(City.Boston,City.Baltimore,"4");
		addPayout(City.Boston,City.Boston,"-");
		addPayout(City.Boston,City.Buffalo,"5");
		addPayout(City.Boston,City.NewYork,"2.5");
		addPayout(City.Boston,City.Philadelphia,"3");
		addPayout(City.Boston,City.Pittsburgh,"6.5");
		addPayout(City.Boston,City.PortlandME,"1");
		addPayout(City.Boston,City.WashingtonDC,"4.5");
		
		addPayout(City.Buffalo,City.Albany,"3");
		addPayout(City.Buffalo,City.Baltimore,"4");
		addPayout(City.Buffalo,City.Boston,"5");
		addPayout(City.Buffalo,City.Buffalo,"-");
		addPayout(City.Buffalo,City.NewYork,"4");
		addPayout(City.Buffalo,City.Philadelphia,"4");
		addPayout(City.Buffalo,City.Pittsburgh,"2.5");
		addPayout(City.Buffalo,City.PortlandME,"6");
		addPayout(City.Buffalo,City.WashingtonDC,"4.5");
		
		addPayout(City.NewYork,City.Albany,"1.5");
		addPayout(City.NewYork,City.Baltimore,"2");
		addPayout(City.NewYork,City.Boston,"2.5");
		addPayout(City.NewYork,City.Buffalo,"4");
		addPayout(City.NewYork,City.NewYork,"-");
		addPayout(City.NewYork,City.Philadelphia,"1");
		addPayout(City.NewYork,City.Pittsburgh,"4.5");
		addPayout(City.NewYork,City.PortlandME,"3.5");
		addPayout(City.NewYork,City.WashingtonDC,"2");
		
		addPayout(City.Philadelphia,City.Albany,"2.5");
		addPayout(City.Philadelphia,City.Baltimore,"1");
		addPayout(City.Philadelphia,City.Boston,"3");
		addPayout(City.Philadelphia,City.Buffalo,"4");
		addPayout(City.Philadelphia,City.NewYork,"1");
		addPayout(City.Philadelphia,City.Philadelphia,"-");
		addPayout(City.Philadelphia,City.Pittsburgh,"3.5");
		addPayout(City.Philadelphia,City.PortlandME,"4.5");
		addPayout(City.Philadelphia,City.WashingtonDC,"1.5");
		
		addPayout(City.Pittsburgh,City.Albany,"5.5");
		addPayout(City.Pittsburgh,City.Baltimore,"3.5");
		addPayout(City.Pittsburgh,City.Boston,"6.5");
		addPayout(City.Pittsburgh,City.Buffalo,"2.5");
		addPayout(City.Pittsburgh,City.NewYork,"4.5");
		addPayout(City.Pittsburgh,City.Philadelphia,"3.5");
		addPayout(City.Pittsburgh,City.Pittsburgh,"-");
		addPayout(City.Pittsburgh,City.PortlandME,"8");
		addPayout(City.Pittsburgh,City.WashingtonDC,"3");
		
		addPayout(City.PortlandME,City.Albany,"3");
		addPayout(City.PortlandME,City.Baltimore,"5.5");
		addPayout(City.PortlandME,City.Boston,"1");
		addPayout(City.PortlandME,City.Buffalo,"6");
		addPayout(City.PortlandME,City.NewYork,"3.5");
		addPayout(City.PortlandME,City.Philadelphia,"4.5");
		addPayout(City.PortlandME,City.Pittsburgh,"8");
		addPayout(City.PortlandME,City.PortlandME,"-");
		addPayout(City.PortlandME,City.WashingtonDC,"5.5");
		
		addPayout(City.WashingtonDC,City.Albany,"3.5");
		addPayout(City.WashingtonDC,City.Baltimore,"5");
		addPayout(City.WashingtonDC,City.Boston,"4.5");
		addPayout(City.WashingtonDC,City.Buffalo,"4.5");
		addPayout(City.WashingtonDC,City.NewYork,"2");
		addPayout(City.WashingtonDC,City.Philadelphia,"1.5");
		addPayout(City.WashingtonDC,City.Pittsburgh,"3");
		addPayout(City.WashingtonDC,City.PortlandME,"5.5");
		addPayout(City.WashingtonDC,City.WashingtonDC,"-");
	}

	private void init_SE_NE() {
		addPayout(City.Atlanta,City.Albany,"10");
		addPayout(City.Atlanta,City.Baltimore,"7");
		addPayout(City.Atlanta,City.Boston,"11");
		addPayout(City.Atlanta,City.Buffalo,"9.5");
		addPayout(City.Atlanta,City.NewYork,"8.5");
		addPayout(City.Atlanta,City.Philadelphia,"7.5");
		addPayout(City.Atlanta,City.Pittsburgh,"8");
		addPayout(City.Atlanta,City.PortlandME,"12");
		addPayout(City.Atlanta,City.WashingtonDC,"6.5");
		
		addPayout(City.Charleston,City.Albany,"9.5");
		addPayout(City.Charleston,City.Baltimore,"5.5");
		addPayout(City.Charleston,City.Boston,"9.5");
		addPayout(City.Charleston,City.Buffalo,"9.5");
		addPayout(City.Charleston,City.NewYork,"7.5");
		addPayout(City.Charleston,City.Philadelphia,"8");
		addPayout(City.Charleston,City.Pittsburgh,"8");
		addPayout(City.Charleston,City.PortlandME,"11");
		addPayout(City.Charleston,City.WashingtonDC,"5");
		
		addPayout(City.Charlotte,City.Albany,"7.5");
		addPayout(City.Charlotte,City.Baltimore,"4");
		addPayout(City.Charlotte,City.Boston,"8.5");
		addPayout(City.Charlotte,City.Buffalo,"8");
		addPayout(City.Charlotte,City.NewYork,"6");
		addPayout(City.Charlotte,City.Philadelphia,"5");
		addPayout(City.Charlotte,City.Pittsburgh,"6");
		addPayout(City.Charlotte,City.PortlandME,"9.5");
		addPayout(City.Charlotte,City.WashingtonDC,"4");
		
		addPayout(City.Chattanooga,City.Albany,"10");
		addPayout(City.Chattanooga,City.Baltimore,"6.5");
		addPayout(City.Chattanooga,City.Boston,"11.5");
		addPayout(City.Chattanooga,City.Buffalo,"8");
		addPayout(City.Chattanooga,City.NewYork,"8.5");
		addPayout(City.Chattanooga,City.Philadelphia,"7.5");
		addPayout(City.Chattanooga,City.Pittsburgh,"7");
		addPayout(City.Chattanooga,City.PortlandME,"12");
		addPayout(City.Chattanooga,City.WashingtonDC,"6");
		
		addPayout(City.Jacksonville,City.Albany,"11");
		addPayout(City.Jacksonville,City.Baltimore,"8");
		addPayout(City.Jacksonville,City.Boston,"12");
		addPayout(City.Jacksonville,City.Buffalo,"12");
		addPayout(City.Jacksonville,City.NewYork,"10");
		addPayout(City.Jacksonville,City.Philadelphia,"9");
		addPayout(City.Jacksonville,City.Pittsburgh,"10.5");
		addPayout(City.Jacksonville,City.PortlandME,"13");
		addPayout(City.Jacksonville,City.WashingtonDC,"6");
		
		addPayout(City.Knoxville,City.Albany,"8.5");
		addPayout(City.Knoxville,City.Baltimore,"5.5");
		addPayout(City.Knoxville,City.Boston,"9.5");
		addPayout(City.Knoxville,City.Buffalo,"7.5");
		addPayout(City.Knoxville,City.NewYork,"7.5");
		addPayout(City.Knoxville,City.Philadelphia,"6.5");
		addPayout(City.Knoxville,City.Pittsburgh,"6");
		addPayout(City.Knoxville,City.PortlandME,"10.5");
		addPayout(City.Knoxville,City.WashingtonDC,"5");
		
		addPayout(City.Miami,City.Albany,"15");
		addPayout(City.Miami,City.Baltimore,"11.5");
		addPayout(City.Miami,City.Boston,"16");
		addPayout(City.Miami,City.Buffalo,"15.5");
		addPayout(City.Miami,City.NewYork,"13.5");
		addPayout(City.Miami,City.Philadelphia,"12.5");
		addPayout(City.Miami,City.Pittsburgh,"14");
		addPayout(City.Miami,City.PortlandME,"17");
		addPayout(City.Miami,City.WashingtonDC,"11");
		
		addPayout(City.Mobile,City.Albany,"13.5");
		addPayout(City.Mobile,City.Baltimore,"10.5");
		addPayout(City.Mobile,City.Boston,"14.5");
		addPayout(City.Mobile,City.Buffalo,"12");
		addPayout(City.Mobile,City.NewYork,"12");
		addPayout(City.Mobile,City.Philadelphia,"11");
		addPayout(City.Mobile,City.Pittsburgh,"10.5");
		addPayout(City.Mobile,City.PortlandME,"14.5");
		addPayout(City.Mobile,City.WashingtonDC,"10");
		
		addPayout(City.Norfolk,City.Albany,"6");
		addPayout(City.Norfolk,City.Baltimore,"2.5");
		addPayout(City.Norfolk,City.Boston,"7");
		addPayout(City.Norfolk,City.Buffalo,"6.5");
		addPayout(City.Norfolk,City.NewYork,"4.5");
		addPayout(City.Norfolk,City.Philadelphia,"3.5");
		addPayout(City.Norfolk,City.Pittsburgh,"5");
		addPayout(City.Norfolk,City.PortlandME,"9");
		addPayout(City.Norfolk,City.WashingtonDC,"2.5");
		
		addPayout(City.Richmond,City.Albany,"5");
		addPayout(City.Richmond,City.Baltimore,"1.5");
		addPayout(City.Richmond,City.Boston,"5.5");
		addPayout(City.Richmond,City.Buffalo,"5.5");
		addPayout(City.Richmond,City.NewYork,"3.5");
		addPayout(City.Richmond,City.Philadelphia,"2.5");
		addPayout(City.Richmond,City.Pittsburgh,"4");
		addPayout(City.Richmond,City.PortlandME,"7");
		addPayout(City.Richmond,City.WashingtonDC,"1");
		
		addPayout(City.Tampa,City.Albany,"13.5");
		addPayout(City.Tampa,City.Baltimore,"10");
		addPayout(City.Tampa,City.Boston,"14");
		addPayout(City.Tampa,City.Buffalo,"14");
		addPayout(City.Tampa,City.NewYork,"12");
		addPayout(City.Tampa,City.Philadelphia,"11");
		addPayout(City.Tampa,City.Pittsburgh,"12.5");
		addPayout(City.Tampa,City.PortlandME,"15");
		addPayout(City.Tampa,City.WashingtonDC,"9.5");
	}

	private void init_NC_NE() {
		addPayout(City.Chicago,City.Albany,"8");
		addPayout(City.Chicago,City.Baltimore,"8");
		addPayout(City.Chicago,City.Boston,"10");
		addPayout(City.Chicago,City.Buffalo,"5");
		addPayout(City.Chicago,City.NewYork,"9");
		addPayout(City.Chicago,City.Philadelphia,"8");
		addPayout(City.Chicago,City.Pittsburgh,"4.5");
		addPayout(City.Chicago,City.PortlandME,"11.5");
		addPayout(City.Chicago,City.WashingtonDC,"7.5");
		
		addPayout(City.Cincinnati,City.Albany,"7");
		addPayout(City.Cincinnati,City.Baltimore,"6");
		addPayout(City.Cincinnati,City.Boston,"9.5");
		addPayout(City.Cincinnati,City.Buffalo,"4.5");
		addPayout(City.Cincinnati,City.NewYork,"7.5");
		addPayout(City.Cincinnati,City.Philadelphia,"6.5");
		addPayout(City.Cincinnati,City.Pittsburgh,"3");
		addPayout(City.Cincinnati,City.PortlandME,"10.5");
		addPayout(City.Cincinnati,City.WashingtonDC,"5.5");
		
		addPayout(City.Cleveland,City.Albany,"5");
		addPayout(City.Cleveland,City.Baltimore,"4.5");
		addPayout(City.Cleveland,City.Boston,"7");
		addPayout(City.Cleveland,City.Buffalo,"2");
		addPayout(City.Cleveland,City.NewYork,"5.5");
		addPayout(City.Cleveland,City.Philadelphia,"5");
		addPayout(City.Cleveland,City.Pittsburgh,"1.5");
		addPayout(City.Cleveland,City.PortlandME,"8");
		addPayout(City.Cleveland,City.WashingtonDC,"4.5");
		
		addPayout(City.Columbus,City.Albany,"6");
		addPayout(City.Columbus,City.Baltimore,"5");
		addPayout(City.Columbus,City.Boston,"8");
		addPayout(City.Columbus,City.Buffalo,"3");
		addPayout(City.Columbus,City.NewYork,"6.5");
		addPayout(City.Columbus,City.Philadelphia,"5.5");
		addPayout(City.Columbus,City.Pittsburgh,"2");
		addPayout(City.Columbus,City.PortlandME,"9.5");
		addPayout(City.Columbus,City.WashingtonDC,"5");
		
		addPayout(City.Detroit,City.Albany,"5.5");
		addPayout(City.Detroit,City.Baltimore,"6");
		addPayout(City.Detroit,City.Boston,"7.5");
		addPayout(City.Detroit,City.Buffalo,"2.5");
		addPayout(City.Detroit,City.NewYork,"6.5");
		addPayout(City.Detroit,City.Philadelphia,"6.5");
		addPayout(City.Detroit,City.Pittsburgh,"3");
		addPayout(City.Detroit,City.PortlandME,"8.5");
		addPayout(City.Detroit,City.WashingtonDC,"6");
		
		addPayout(City.Indianapolis,City.Albany,"7.5");
		addPayout(City.Indianapolis,City.Baltimore,"7");
		addPayout(City.Indianapolis,City.Boston,"9.5");
		addPayout(City.Indianapolis,City.Buffalo,"4.5");
		addPayout(City.Indianapolis,City.NewYork,"8");
		addPayout(City.Indianapolis,City.Philadelphia,"7");
		addPayout(City.Indianapolis,City.Pittsburgh,"3.5");
		addPayout(City.Indianapolis,City.PortlandME,"10.5");
		addPayout(City.Indianapolis,City.WashingtonDC,"6.5");
		
		addPayout(City.Milwaukee,City.Albany,"9");
		addPayout(City.Milwaukee,City.Baltimore,"8");
		addPayout(City.Milwaukee,City.Boston,"11");
		addPayout(City.Milwaukee,City.Buffalo,"6");
		addPayout(City.Milwaukee,City.NewYork,"10");
		addPayout(City.Milwaukee,City.Philadelphia,"9");
		addPayout(City.Milwaukee,City.Pittsburgh,"5.5");
		addPayout(City.Milwaukee,City.PortlandME,"12");
		addPayout(City.Milwaukee,City.WashingtonDC,"8.5");
		
		addPayout(City.StLouis,City.Albany,"10");
		addPayout(City.StLouis,City.Baltimore,"9");
		addPayout(City.StLouis,City.Boston,"12");
		addPayout(City.StLouis,City.Buffalo,"7");
		addPayout(City.StLouis,City.NewYork,"10.5");
		addPayout(City.StLouis,City.Philadelphia,"9.5");
		addPayout(City.StLouis,City.Pittsburgh,"6");
		addPayout(City.StLouis,City.PortlandME,"13");
		addPayout(City.StLouis,City.WashingtonDC,"9");
	}

	private void init_SC_NE() {
		addPayout(City.Birmingham,City.Albany,"11");
		addPayout(City.Birmingham,City.Baltimore,"8");
		addPayout(City.Birmingham,City.Boston,"12");
		addPayout(City.Birmingham,City.Buffalo,"9");
		addPayout(City.Birmingham,City.NewYork,"10");
		addPayout(City.Birmingham,City.Philadelphia,"9");
		addPayout(City.Birmingham,City.Pittsburgh,"8");
		addPayout(City.Birmingham,City.PortlandME,"13.5");
		addPayout(City.Birmingham,City.WashingtonDC,"7.5");
		
		addPayout(City.Dallas,City.Albany,"17");
		addPayout(City.Dallas,City.Baltimore,"14.5");
		addPayout(City.Dallas,City.Boston,"18.5");
		addPayout(City.Dallas,City.Buffalo,"14");
		addPayout(City.Dallas,City.NewYork,"16");
		addPayout(City.Dallas,City.Philadelphia,"15.5");
		addPayout(City.Dallas,City.Pittsburgh,"13");
		addPayout(City.Dallas,City.PortlandME,"19.5");
		addPayout(City.Dallas,City.WashingtonDC,"14");
		
		addPayout(City.FortWorth,City.Albany,"17");
		addPayout(City.FortWorth,City.Baltimore,"14.5");
		addPayout(City.FortWorth,City.Boston,"19.5");
		addPayout(City.FortWorth,City.Buffalo,"14");
		addPayout(City.FortWorth,City.NewYork,"16.5");
		addPayout(City.FortWorth,City.Philadelphia,"15.5");
		addPayout(City.FortWorth,City.Pittsburgh,"13");
		addPayout(City.FortWorth,City.PortlandME,"20.5");
		addPayout(City.FortWorth,City.WashingtonDC,"14");
		
		addPayout(City.Houston,City.Albany,"18.5");
		addPayout(City.Houston,City.Baltimore,"15");
		addPayout(City.Houston,City.Boston,"19.5");
		addPayout(City.Houston,City.Buffalo,"15.5");
		addPayout(City.Houston,City.NewYork,"17");
		addPayout(City.Houston,City.Philadelphia,"16");
		addPayout(City.Houston,City.Pittsburgh,"14.5");
		addPayout(City.Houston,City.PortlandME,"20.5");
		addPayout(City.Houston,City.WashingtonDC,"15");
		
		addPayout(City.LittleRock,City.Albany,"13.5");
		addPayout(City.LittleRock,City.Baltimore,"11");
		addPayout(City.LittleRock,City.Boston,"15");
		addPayout(City.LittleRock,City.Buffalo,"10.5");
		addPayout(City.LittleRock,City.NewYork,"13");
		addPayout(City.LittleRock,City.Philadelphia,"12");
		addPayout(City.LittleRock,City.Pittsburgh,"9.5");
		addPayout(City.LittleRock,City.PortlandME,"18");
		addPayout(City.LittleRock,City.WashingtonDC,"10.5");
		
		addPayout(City.Louisville,City.Albany,"8.5");
		addPayout(City.Louisville,City.Baltimore,"7");
		addPayout(City.Louisville,City.Boston,"10.5");
		addPayout(City.Louisville,City.Buffalo,"5.5");
		addPayout(City.Louisville,City.NewYork,"8.5");
		addPayout(City.Louisville,City.Philadelphia,"8");
		addPayout(City.Louisville,City.Pittsburgh,"4.5");
		addPayout(City.Louisville,City.PortlandME,"11.5");
		addPayout(City.Louisville,City.WashingtonDC,"6.5");
		
		addPayout(City.Memphis,City.Albany,"12.5");
		addPayout(City.Memphis,City.Baltimore,"9.5");
		addPayout(City.Memphis,City.Boston,"14");
		addPayout(City.Memphis,City.Buffalo,"9.5");
		addPayout(City.Memphis,City.NewYork,"11.5");
		addPayout(City.Memphis,City.Philadelphia,"10.5");
		addPayout(City.Memphis,City.Pittsburgh,"8");
		addPayout(City.Memphis,City.PortlandME,"15");
		addPayout(City.Memphis,City.WashingtonDC,"9.5");
		
		addPayout(City.Nashville,City.Albany,"10.5");
		addPayout(City.Nashville,City.Baltimore,"7.5");
		addPayout(City.Nashville,City.Boston,"12");
		addPayout(City.Nashville,City.Buffalo,"7.5");
		addPayout(City.Nashville,City.NewYork,"9.5");
		addPayout(City.Nashville,City.Philadelphia,"8.5");
		addPayout(City.Nashville,City.Pittsburgh,"6");
		addPayout(City.Nashville,City.PortlandME,"13");
		addPayout(City.Nashville,City.WashingtonDC,"7");
		
		addPayout(City.NewOrleans,City.Albany,"15");
		addPayout(City.NewOrleans,City.Baltimore,"11.5");
		addPayout(City.NewOrleans,City.Boston,"15.5");
		addPayout(City.NewOrleans,City.Buffalo,"13");
		addPayout(City.NewOrleans,City.NewYork,"13.5");
		addPayout(City.NewOrleans,City.Philadelphia,"12.5");
		addPayout(City.NewOrleans,City.Pittsburgh,"11.5");
		addPayout(City.NewOrleans,City.PortlandME,"16.5");
		addPayout(City.NewOrleans,City.WashingtonDC,"11");
		
		addPayout(City.SanAntonio,City.Albany,"19.5");
		addPayout(City.SanAntonio,City.Baltimore,"17");
		addPayout(City.SanAntonio,City.Boston,"21");
		addPayout(City.SanAntonio,City.Buffalo,"16.5");
		addPayout(City.SanAntonio,City.NewYork,"19");
		addPayout(City.SanAntonio,City.Philadelphia,"18");
		addPayout(City.SanAntonio,City.Pittsburgh,"15.5");
		addPayout(City.SanAntonio,City.PortlandME,"22.5");
		addPayout(City.SanAntonio,City.WashingtonDC,"17");
		
		addPayout(City.Shreveport,City.Albany,"16");
		addPayout(City.Shreveport,City.Baltimore,"12.5");
		addPayout(City.Shreveport,City.Boston,"16.5");
		addPayout(City.Shreveport,City.Buffalo,"14");
		addPayout(City.Shreveport,City.NewYork,"15.5");
		addPayout(City.Shreveport,City.Philadelphia,"13.5");
		addPayout(City.Shreveport,City.Pittsburgh,"12");
		addPayout(City.Shreveport,City.PortlandME,"18");
		addPayout(City.Shreveport,City.WashingtonDC,"12");
	}

	private void init_P_NE() {
		addPayout(City.Denver,City.Albany,"18.5");
		addPayout(City.Denver,City.Baltimore,"18");
		addPayout(City.Denver,City.Boston,"20.5");
		addPayout(City.Denver,City.Buffalo,"15.5");
		addPayout(City.Denver,City.NewYork,"19.5");
		addPayout(City.Denver,City.Philadelphia,"18.5");
		addPayout(City.Denver,City.Pittsburgh,"15");
		addPayout(City.Denver,City.PortlandME,"21.5");
		addPayout(City.Denver,City.WashingtonDC,"18");
		
		addPayout(City.DesMoines,City.Albany,"12");
		addPayout(City.DesMoines,City.Baltimore,"11.5");
		addPayout(City.DesMoines,City.Boston,"14");
		addPayout(City.DesMoines,City.Buffalo,"9");
		addPayout(City.DesMoines,City.NewYork,"12.5");
		addPayout(City.DesMoines,City.Philadelphia,"11.5");
		addPayout(City.DesMoines,City.Pittsburgh,"8");
		addPayout(City.DesMoines,City.PortlandME,"15.5");
		addPayout(City.DesMoines,City.WashingtonDC,"11.5");
		
		addPayout(City.Fargo,City.Albany,"14.5");
		addPayout(City.Fargo,City.Baltimore,"14.5");
		addPayout(City.Fargo,City.Boston,"16.5");
		addPayout(City.Fargo,City.Buffalo,"11.5");
		addPayout(City.Fargo,City.NewYork,"15.5");
		addPayout(City.Fargo,City.Philadelphia,"14.5");
		addPayout(City.Fargo,City.Pittsburgh,"11");
		addPayout(City.Fargo,City.PortlandME,"17.5");
		addPayout(City.Fargo,City.WashingtonDC,"14");
		
		addPayout(City.KansasCity,City.Albany,"12.5");
		addPayout(City.KansasCity,City.Baltimore,"12");
		addPayout(City.KansasCity,City.Boston,"14.5");
		addPayout(City.KansasCity,City.Buffalo,"9.5");
		addPayout(City.KansasCity,City.NewYork,"13.5");
		addPayout(City.KansasCity,City.Philadelphia,"12");
		addPayout(City.KansasCity,City.Pittsburgh,"9");
		addPayout(City.KansasCity,City.PortlandME,"16");
		addPayout(City.KansasCity,City.WashingtonDC,"11.5");
		
		addPayout(City.Minneapolis,City.Albany,"12.5");
		addPayout(City.Minneapolis,City.Baltimore,"12");
		addPayout(City.Minneapolis,City.Boston,"14");
		addPayout(City.Minneapolis,City.Buffalo,"9");
		addPayout(City.Minneapolis,City.NewYork,"13");
		addPayout(City.Minneapolis,City.Philadelphia,"12");
		addPayout(City.Minneapolis,City.Pittsburgh,"8.5");
		addPayout(City.Minneapolis,City.PortlandME,"15.5");
		addPayout(City.Minneapolis,City.WashingtonDC,"11.5");
		
		addPayout(City.OklahomaCity,City.Albany,"15.5");
		addPayout(City.OklahomaCity,City.Baltimore,"14.5");
		addPayout(City.OklahomaCity,City.Boston,"17.5");
		addPayout(City.OklahomaCity,City.Buffalo,"12.5");
		addPayout(City.OklahomaCity,City.NewYork,"16");
		addPayout(City.OklahomaCity,City.Philadelphia,"15");
		addPayout(City.OklahomaCity,City.Pittsburgh,"11.5");
		addPayout(City.OklahomaCity,City.PortlandME,"18.5");
		addPayout(City.OklahomaCity,City.WashingtonDC,"14");
		
		addPayout(City.Omaha,City.Albany,"13");
		addPayout(City.Omaha,City.Baltimore,"13");
		addPayout(City.Omaha,City.Boston,"15");
		addPayout(City.Omaha,City.Buffalo,"10");
		addPayout(City.Omaha,City.NewYork,"14");
		addPayout(City.Omaha,City.Philadelphia,"13");
		addPayout(City.Omaha,City.Pittsburgh,"9.5");
		addPayout(City.Omaha,City.PortlandME,"16");
		addPayout(City.Omaha,City.WashingtonDC,"12.5");
		
		addPayout(City.Pueblo,City.Albany,"18.5");
		addPayout(City.Pueblo,City.Baltimore,"18");
		addPayout(City.Pueblo,City.Boston,"21");
		addPayout(City.Pueblo,City.Buffalo,"15.5");
		addPayout(City.Pueblo,City.NewYork,"19.5");
		addPayout(City.Pueblo,City.Philadelphia,"18.5");
		addPayout(City.Pueblo,City.Pittsburgh,"15");
		addPayout(City.Pueblo,City.PortlandME,"22");
		addPayout(City.Pueblo,City.WashingtonDC,"18");
		
		addPayout(City.StPaul,City.Albany,"12");
		addPayout(City.StPaul,City.Baltimore,"12");
		addPayout(City.StPaul,City.Boston,"14");
		addPayout(City.StPaul,City.Buffalo,"9");
		addPayout(City.StPaul,City.NewYork,"13");
		addPayout(City.StPaul,City.Philadelphia,"12");
		addPayout(City.StPaul,City.Pittsburgh,"8.5");
		addPayout(City.StPaul,City.PortlandME,"15.5");
		addPayout(City.StPaul,City.WashingtonDC,"11.5");
	}

	private void init_NW_NE() {
		addPayout(City.Billings,City.Albany,"21");
		addPayout(City.Billings,City.Baltimore,"21");
		addPayout(City.Billings,City.Boston,"23");
		addPayout(City.Billings,City.Buffalo,"18");
		addPayout(City.Billings,City.NewYork,"22");
		addPayout(City.Billings,City.Philadelphia,"21");
		addPayout(City.Billings,City.Pittsburgh,"17.5");
		addPayout(City.Billings,City.PortlandME,"24");
		addPayout(City.Billings,City.WashingtonDC,"20.5");
		
		addPayout(City.Butte,City.Albany,"23.5");
		addPayout(City.Butte,City.Baltimore,"23");
		addPayout(City.Butte,City.Boston,"25.5");
		addPayout(City.Butte,City.Buffalo,"20.5");
		addPayout(City.Butte,City.NewYork,"24");
		addPayout(City.Butte,City.Philadelphia,"23.5");
		addPayout(City.Butte,City.Pittsburgh,"20");
		addPayout(City.Butte,City.PortlandME,"26.5");
		addPayout(City.Butte,City.WashingtonDC,"22.5");
		
		addPayout(City.Casper,City.Albany,"18");
		addPayout(City.Casper,City.Baltimore,"18");
		addPayout(City.Casper,City.Boston,"20");
		addPayout(City.Casper,City.Buffalo,"15");
		addPayout(City.Casper,City.NewYork,"19");
		addPayout(City.Casper,City.Philadelphia,"18");
		addPayout(City.Casper,City.Pittsburgh,"14.5");
		addPayout(City.Casper,City.PortlandME,"21.5");
		addPayout(City.Casper,City.WashingtonDC,"17.5");
		
		addPayout(City.Pocatello,City.Albany,"23.5");
		addPayout(City.Pocatello,City.Baltimore,"23.5");
		addPayout(City.Pocatello,City.Boston,"25.5");
		addPayout(City.Pocatello,City.Buffalo,"20.5");
		addPayout(City.Pocatello,City.NewYork,"24.5");
		addPayout(City.Pocatello,City.Philadelphia,"23.5");
		addPayout(City.Pocatello,City.Pittsburgh,"20");
		addPayout(City.Pocatello,City.PortlandME,"27");
		addPayout(City.Pocatello,City.WashingtonDC,"23");
		
		addPayout(City.PortlandOR,City.Albany,"30");
		addPayout(City.PortlandOR,City.Baltimore,"30.5");
		addPayout(City.PortlandOR,City.Boston,"32");
		addPayout(City.PortlandOR,City.Buffalo,"27");
		addPayout(City.PortlandOR,City.NewYork,"31");
		addPayout(City.PortlandOR,City.Philadelphia,"30");
		addPayout(City.PortlandOR,City.Pittsburgh,"26.5");
		addPayout(City.PortlandOR,City.PortlandME,"33.5");
		addPayout(City.PortlandOR,City.WashingtonDC,"30");
		
		addPayout(City.RapidCity,City.Albany,"17");
		addPayout(City.RapidCity,City.Baltimore,"17");
		addPayout(City.RapidCity,City.Boston,"20.5");
		addPayout(City.RapidCity,City.Buffalo,"14");
		addPayout(City.RapidCity,City.NewYork,"18");
		addPayout(City.RapidCity,City.Philadelphia,"17");
		addPayout(City.RapidCity,City.Pittsburgh,"13.5");
		addPayout(City.RapidCity,City.PortlandME,"21.5");
		addPayout(City.RapidCity,City.WashingtonDC,"18");
		
		addPayout(City.SaltLakeCity,City.Albany,"23.5");
		addPayout(City.SaltLakeCity,City.Baltimore,"23");
		addPayout(City.SaltLakeCity,City.Boston,"25.5");
		addPayout(City.SaltLakeCity,City.Buffalo,"20.5");
		addPayout(City.SaltLakeCity,City.NewYork,"24");
		addPayout(City.SaltLakeCity,City.Philadelphia,"23.5");
		addPayout(City.SaltLakeCity,City.Pittsburgh,"20");
		addPayout(City.SaltLakeCity,City.PortlandME,"26.5");
		addPayout(City.SaltLakeCity,City.WashingtonDC,"23");
		
		addPayout(City.Seattle,City.Albany,"31.5");
		addPayout(City.Seattle,City.Baltimore,"29.5");
		addPayout(City.Seattle,City.Boston,"31.5");
		addPayout(City.Seattle,City.Buffalo,"26.5");
		addPayout(City.Seattle,City.NewYork,"30.5");
		addPayout(City.Seattle,City.Philadelphia,"29.5");
		addPayout(City.Seattle,City.Pittsburgh,"26");
		addPayout(City.Seattle,City.PortlandME,"32.5");
		addPayout(City.Seattle,City.WashingtonDC,"29");
		
		addPayout(City.Spokane,City.Albany,"26.5");
		addPayout(City.Spokane,City.Baltimore,"26.5");
		addPayout(City.Spokane,City.Boston,"28.5");
		addPayout(City.Spokane,City.Buffalo,"23.5");
		addPayout(City.Spokane,City.NewYork,"27.5");
		addPayout(City.Spokane,City.Philadelphia,"26.5");
		addPayout(City.Spokane,City.Pittsburgh,"23");
		addPayout(City.Spokane,City.PortlandME,"29.5");
		addPayout(City.Spokane,City.WashingtonDC,"26");
	}

	private void init_SW_NE() {
		addPayout(City.ElPaso,City.Albany,"22");
		addPayout(City.ElPaso,City.Baltimore,"21");
		addPayout(City.ElPaso,City.Boston,"24");
		addPayout(City.ElPaso,City.Buffalo,"19");
		addPayout(City.ElPaso,City.NewYork,"23");
		addPayout(City.ElPaso,City.Philadelphia,"22");
		addPayout(City.ElPaso,City.Pittsburgh,"18.5");
		addPayout(City.ElPaso,City.PortlandME,"25.5");
		addPayout(City.ElPaso,City.WashingtonDC,"20.5");
		
		addPayout(City.LasVagas,City.Albany,"28");
		addPayout(City.LasVagas,City.Baltimore,"27.5");
		addPayout(City.LasVagas,City.Boston,"30");
		addPayout(City.LasVagas,City.Buffalo,"25");
		addPayout(City.LasVagas,City.NewYork,"28");
		addPayout(City.LasVagas,City.Philadelphia,"28");
		addPayout(City.LasVagas,City.Pittsburgh,"24.5");
		addPayout(City.LasVagas,City.PortlandME,"26");
		addPayout(City.LasVagas,City.WashingtonDC,"27.5");
		
		addPayout(City.LosAngeles,City.Albany,"30.5");
		addPayout(City.LosAngeles,City.Baltimore,"29");
		addPayout(City.LosAngeles,City.Boston,"32.5");
		addPayout(City.LosAngeles,City.Buffalo,"27.5");
		addPayout(City.LosAngeles,City.NewYork,"31");
		addPayout(City.LosAngeles,City.Philadelphia,"30");
		addPayout(City.LosAngeles,City.Pittsburgh,"26.5");
		addPayout(City.LosAngeles,City.PortlandME,"33.5");
		addPayout(City.LosAngeles,City.WashingtonDC,"29");
		
		addPayout(City.Oakland,City.Albany,"31");
		addPayout(City.Oakland,City.Baltimore,"30.5");
		addPayout(City.Oakland,City.Boston,"33");
		addPayout(City.Oakland,City.Buffalo,"28");
		addPayout(City.Oakland,City.NewYork,"31.5");
		addPayout(City.Oakland,City.Philadelphia,"31");
		addPayout(City.Oakland,City.Pittsburgh,"27.5");
		addPayout(City.Oakland,City.PortlandME,"34");
		addPayout(City.Oakland,City.WashingtonDC,"30.5");
		
		addPayout(City.Phoenix,City.Albany,"27.5");
		addPayout(City.Phoenix,City.Baltimore,"27");
		addPayout(City.Phoenix,City.Boston,"29.5");
		addPayout(City.Phoenix,City.Buffalo,"2.5");
		addPayout(City.Phoenix,City.NewYork,"28");
		addPayout(City.Phoenix,City.Philadelphia,"27");
		addPayout(City.Phoenix,City.Pittsburgh,"23.5");
		addPayout(City.Phoenix,City.PortlandME,"30.5");
		addPayout(City.Phoenix,City.WashingtonDC,"26.5");
		
		addPayout(City.Reno,City.Albany,"25.5");
		addPayout(City.Reno,City.Baltimore,"28.5");
		addPayout(City.Reno,City.Boston,"30.5");
		addPayout(City.Reno,City.Buffalo,"25.5");
		addPayout(City.Reno,City.NewYork,"29.5");
		addPayout(City.Reno,City.Philadelphia,"28.5");
		addPayout(City.Reno,City.Pittsburgh,"25");
		addPayout(City.Reno,City.PortlandME,"31.5");
		addPayout(City.Reno,City.WashingtonDC,"28");
		
		addPayout(City.Sacramento,City.Albany,"27");
		addPayout(City.Sacramento,City.Baltimore,"30");
		addPayout(City.Sacramento,City.Boston,"32");
		addPayout(City.Sacramento,City.Buffalo,"27");
		addPayout(City.Sacramento,City.NewYork,"31");
		addPayout(City.Sacramento,City.Philadelphia,"30");
		addPayout(City.Sacramento,City.Pittsburgh,"26.5");
		addPayout(City.Sacramento,City.PortlandME,"33.5");
		addPayout(City.Sacramento,City.WashingtonDC,"29.5");
		
		addPayout(City.SanDiego,City.Albany,"31.5");
		addPayout(City.SanDiego,City.Baltimore,"28.5");
		addPayout(City.SanDiego,City.Boston,"32.5");
		addPayout(City.SanDiego,City.Buffalo,"27");
		addPayout(City.SanDiego,City.NewYork,"30.5");
		addPayout(City.SanDiego,City.Philadelphia,"29.5");
		addPayout(City.SanDiego,City.Pittsburgh,"26");
		addPayout(City.SanDiego,City.PortlandME,"33.5");
		addPayout(City.SanDiego,City.WashingtonDC,"28.5");
		
		addPayout(City.SanFrancisco,City.Albany,"31");
		addPayout(City.SanFrancisco,City.Baltimore,"30.5");
		addPayout(City.SanFrancisco,City.Boston,"33");
		addPayout(City.SanFrancisco,City.Buffalo,"28");
		addPayout(City.SanFrancisco,City.NewYork,"31.5");
		addPayout(City.SanFrancisco,City.Philadelphia,"31");
		addPayout(City.SanFrancisco,City.Pittsburgh,"27.5");
		addPayout(City.SanFrancisco,City.PortlandME,"34");
		addPayout(City.SanFrancisco,City.WashingtonDC,"30.5");
		
		addPayout(City.Tucumcari,City.Albany,"18.5");
		addPayout(City.Tucumcari,City.Baltimore,"18.5");
		addPayout(City.Tucumcari,City.Boston,"21");
		addPayout(City.Tucumcari,City.Buffalo,"16.5");
		addPayout(City.Tucumcari,City.NewYork,"20");
		addPayout(City.Tucumcari,City.Philadelphia,"19");
		addPayout(City.Tucumcari,City.Pittsburgh,"15.5");
		addPayout(City.Tucumcari,City.PortlandME,"22");
		addPayout(City.Tucumcari,City.WashingtonDC,"18");
	}

	private void init_SE_SE() {
		addPayout(City.Atlanta,City.Atlanta,"-");
		addPayout(City.Atlanta,City.Charleston,"3");
		addPayout(City.Atlanta,City.Charlotte,"2.5");
		addPayout(City.Atlanta,City.Chattanooga,"1.5");
		addPayout(City.Atlanta,City.Jacksonville,"3.5");
		addPayout(City.Atlanta,City.Knoxville,"2");
		addPayout(City.Atlanta,City.Miami,"7");
		addPayout(City.Atlanta,City.Mobile,"3.5");
		addPayout(City.Atlanta,City.Norfolk,"5.5");
		addPayout(City.Atlanta,City.Richmond,"6");
		addPayout(City.Atlanta,City.Tampa,"5.5");
		
		addPayout(City.Charleston,City.Atlanta,"3");
		addPayout(City.Charleston,City.Charleston,"-");
		addPayout(City.Charleston,City.Charlotte,"2.5");
		addPayout(City.Charleston,City.Chattanooga,"4.5");
		addPayout(City.Charleston,City.Jacksonville,"2.5");
		addPayout(City.Charleston,City.Knoxville,"4");
		addPayout(City.Charleston,City.Miami,"6");
		addPayout(City.Charleston,City.Mobile,"6");
		addPayout(City.Charleston,City.Norfolk,"4.5");
		addPayout(City.Charleston,City.Richmond,"4");
		addPayout(City.Charleston,City.Tampa,"4.5");
		
		addPayout(City.Charlotte,City.Atlanta,"2.5");
		addPayout(City.Charlotte,City.Charleston,"2.5");
		addPayout(City.Charlotte,City.Charlotte,"-");
		addPayout(City.Charlotte,City.Chattanooga,"4");
		addPayout(City.Charlotte,City.Jacksonville,"4");
		addPayout(City.Charlotte,City.Knoxville,"2.5");
		addPayout(City.Charlotte,City.Miami,"7.5");
		addPayout(City.Charlotte,City.Mobile,"6");
		addPayout(City.Charlotte,City.Norfolk,"4");
		addPayout(City.Charlotte,City.Richmond,"3.5");
		addPayout(City.Charlotte,City.Tampa,"6");
		
		addPayout(City.Chattanooga,City.Atlanta,"1.5");
		addPayout(City.Chattanooga,City.Charleston,"4.5");
		addPayout(City.Chattanooga,City.Charlotte,"4");
		addPayout(City.Chattanooga,City.Chattanooga,"-");
		addPayout(City.Chattanooga,City.Jacksonville,"5");
		addPayout(City.Chattanooga,City.Knoxville,"1");
		addPayout(City.Chattanooga,City.Miami,"8.5");
		addPayout(City.Chattanooga,City.Mobile,"5");
		addPayout(City.Chattanooga,City.Norfolk,"6.5");
		addPayout(City.Chattanooga,City.Richmond,"6");
		addPayout(City.Chattanooga,City.Tampa,"2");
		
		addPayout(City.Jacksonville,City.Atlanta,"3.5");
		addPayout(City.Jacksonville,City.Charleston,"2.5");
		addPayout(City.Jacksonville,City.Charlotte,"4");
		addPayout(City.Jacksonville,City.Chattanooga,"5");
		addPayout(City.Jacksonville,City.Jacksonville,"-");
		addPayout(City.Jacksonville,City.Knoxville,"5.5");
		addPayout(City.Jacksonville,City.Miami,"3.5");
		addPayout(City.Jacksonville,City.Mobile,"4");
		addPayout(City.Jacksonville,City.Norfolk,"6");
		addPayout(City.Jacksonville,City.Richmond,"6.5");
		addPayout(City.Jacksonville,City.Tampa,"2");
		
		addPayout(City.Knoxville,City.Atlanta,"2");
		addPayout(City.Knoxville,City.Charleston,"4");
		addPayout(City.Knoxville,City.Charlotte,"2.5");
		addPayout(City.Knoxville,City.Chattanooga,"1");
		addPayout(City.Knoxville,City.Jacksonville,"5.5");
		addPayout(City.Knoxville,City.Knoxville,"-");
		addPayout(City.Knoxville,City.Miami,"9");
		addPayout(City.Knoxville,City.Mobile,"5.5");
		addPayout(City.Knoxville,City.Norfolk,"5.5");
		addPayout(City.Knoxville,City.Richmond,"5");
		addPayout(City.Knoxville,City.Tampa,"7");
		
		addPayout(City.Miami,City.Atlanta,"7");
		addPayout(City.Miami,City.Charleston,"6");
		addPayout(City.Miami,City.Charlotte,"7.5");
		addPayout(City.Miami,City.Chattanooga,"8.5");
		addPayout(City.Miami,City.Jacksonville,"3");
		addPayout(City.Miami,City.Knoxville,"9");
		addPayout(City.Miami,City.Miami,"-");
		addPayout(City.Miami,City.Mobile,"8.5");
		addPayout(City.Miami,City.Norfolk,"9.5");
		addPayout(City.Miami,City.Richmond,"10");
		addPayout(City.Miami,City.Tampa,"2");
		
		addPayout(City.Mobile,City.Atlanta,"3.5");
		addPayout(City.Mobile,City.Charleston,"6");
		addPayout(City.Mobile,City.Charlotte,"6");
		addPayout(City.Mobile,City.Chattanooga,"5");
		addPayout(City.Mobile,City.Jacksonville,"4");
		addPayout(City.Mobile,City.Knoxville,"5.5");
		addPayout(City.Mobile,City.Miami,"8.5");
		addPayout(City.Mobile,City.Mobile,"-");
		addPayout(City.Mobile,City.Norfolk,"9.5");
		addPayout(City.Mobile,City.Richmond,"9.5");
		addPayout(City.Mobile,City.Tampa,"6.5");
		
		addPayout(City.Norfolk,City.Atlanta,"5.5");
		addPayout(City.Norfolk,City.Charleston,"4.5");
		addPayout(City.Norfolk,City.Charlotte,"4");
		addPayout(City.Norfolk,City.Chattanooga,"6.5");
		addPayout(City.Norfolk,City.Jacksonville,"6");
		addPayout(City.Norfolk,City.Knoxville,"5.5");
		addPayout(City.Norfolk,City.Miami,"9.5");
		addPayout(City.Norfolk,City.Mobile,"9.5");
		addPayout(City.Norfolk,City.Norfolk,"-");
		addPayout(City.Norfolk,City.Richmond,"1");
		addPayout(City.Norfolk,City.Tampa,"8");
		
		addPayout(City.Richmond,City.Atlanta,"6");
		addPayout(City.Richmond,City.Charleston,"4");
		addPayout(City.Richmond,City.Charlotte,"3.5");
		addPayout(City.Richmond,City.Chattanooga,"6");
		addPayout(City.Richmond,City.Jacksonville,"6.5");
		addPayout(City.Richmond,City.Knoxville,"5");
		addPayout(City.Richmond,City.Miami,"10");
		addPayout(City.Richmond,City.Mobile,"9.5");
		addPayout(City.Richmond,City.Norfolk,"1");
		addPayout(City.Richmond,City.Richmond,"-");
		addPayout(City.Richmond,City.Tampa,"8.5");
		
		addPayout(City.Tampa,City.Atlanta,"5.5");
		addPayout(City.Tampa,City.Charleston,"4.5");
		addPayout(City.Tampa,City.Charlotte,"6");
		addPayout(City.Tampa,City.Chattanooga,"2");
		addPayout(City.Tampa,City.Jacksonville,"2");
		addPayout(City.Tampa,City.Knoxville,"7");
		addPayout(City.Tampa,City.Miami,"2");
		addPayout(City.Tampa,City.Mobile,"6.5");
		addPayout(City.Tampa,City.Norfolk,"8");
		addPayout(City.Tampa,City.Richmond,"8.5");
		addPayout(City.Tampa,City.Tampa,"-");
	}
	
	private void init_NC_SE() {
		
		addPayout(City.Chicago,City.Atlanta,"7.5");
		addPayout(City.Chicago,City.Charleston,"10");
		addPayout(City.Chicago,City.Charlotte,"8.5");
		addPayout(City.Chicago,City.Chattanooga,"6");
		addPayout(City.Chicago,City.Jacksonville,"11");
		addPayout(City.Chicago,City.Knoxville,"5.5");
		addPayout(City.Chicago,City.Miami,"14.5");
		addPayout(City.Chicago,City.Mobile,"8.5");
		addPayout(City.Chicago,City.Norfolk,"9.5");
		addPayout(City.Chicago,City.Richmond,"8.5");
		addPayout(City.Chicago,City.Tampa,"12.5");
		
		addPayout(City.Cincinnati,City.Atlanta,"5");
		addPayout(City.Cincinnati,City.Charleston,"7");
		addPayout(City.Cincinnati,City.Charlotte,"5.5");
		addPayout(City.Cincinnati,City.Chattanooga,"3.5");
		addPayout(City.Cincinnati,City.Jacksonville,"8.5");
		addPayout(City.Cincinnati,City.Knoxville,"3.5");
		addPayout(City.Cincinnati,City.Miami,"12");
		addPayout(City.Cincinnati,City.Mobile,"7.5");
		addPayout(City.Cincinnati,City.Norfolk,"7");
		addPayout(City.Cincinnati,City.Richmond,"6");
		addPayout(City.Cincinnati,City.Tampa,"10");
		
		addPayout(City.Cleveland,City.Atlanta,"7.5");
		addPayout(City.Cleveland,City.Charleston,"9.5");
		addPayout(City.Cleveland,City.Charlotte,"6.5");
		addPayout(City.Cleveland,City.Chattanooga,"6");
		addPayout(City.Cleveland,City.Jacksonville,"11");
		addPayout(City.Cleveland,City.Knoxville,"5.5");
		addPayout(City.Cleveland,City.Miami,"14.5");
		addPayout(City.Cleveland,City.Mobile,"10");
		addPayout(City.Cleveland,City.Norfolk,"6.5");
		addPayout(City.Cleveland,City.Richmond,"5.5");
		addPayout(City.Cleveland,City.Tampa,"12.5");
		
		addPayout(City.Columbus,City.Atlanta,"6");
		addPayout(City.Columbus,City.Charleston,"8.5");
		addPayout(City.Columbus,City.Charlotte,"6");
		addPayout(City.Columbus,City.Chattanooga,"4.5");
		addPayout(City.Columbus,City.Jacksonville,"9.5");
		addPayout(City.Columbus,City.Knoxville,"4");
		addPayout(City.Columbus,City.Miami,"13");
		addPayout(City.Columbus,City.Mobile,"8");
		addPayout(City.Columbus,City.Norfolk,"7");
		addPayout(City.Columbus,City.Richmond,"5.5");
		addPayout(City.Columbus,City.Tampa,"11.5");
		
		addPayout(City.Detroit,City.Atlanta,"7.5");
		addPayout(City.Detroit,City.Charleston,"10");
		addPayout(City.Detroit,City.Charlotte,"8");
		addPayout(City.Detroit,City.Chattanooga,"6");
		addPayout(City.Detroit,City.Jacksonville,"11");
		addPayout(City.Detroit,City.Knoxville,"5");
		addPayout(City.Detroit,City.Miami,"14.5");
		addPayout(City.Detroit,City.Mobile,"10");
		addPayout(City.Detroit,City.Norfolk,"8");
		addPayout(City.Detroit,City.Richmond,"7");
		addPayout(City.Detroit,City.Tampa,"12.5");
		
		addPayout(City.Indianapolis,City.Atlanta,"6");
		addPayout(City.Indianapolis,City.Charleston,"8");
		addPayout(City.Indianapolis,City.Charlotte,"6.5");
		addPayout(City.Indianapolis,City.Chattanooga,"4.5");
		addPayout(City.Indianapolis,City.Jacksonville,"9.5");
		addPayout(City.Indianapolis,City.Knoxville,"4");
		addPayout(City.Indianapolis,City.Miami,"13");
		addPayout(City.Indianapolis,City.Mobile,"8");
		addPayout(City.Indianapolis,City.Norfolk,"8");
		addPayout(City.Indianapolis,City.Richmond,"7");
		addPayout(City.Indianapolis,City.Tampa,"11");
		
		addPayout(City.Milwaukee,City.Atlanta,"8");
		addPayout(City.Milwaukee,City.Charleston,"11");
		addPayout(City.Milwaukee,City.Charlotte,"9.5");
		addPayout(City.Milwaukee,City.Chattanooga,"7");
		addPayout(City.Milwaukee,City.Jacksonville,"11.5");
		addPayout(City.Milwaukee,City.Knoxville,"6.5");
		addPayout(City.Milwaukee,City.Miami,"15.5");
		addPayout(City.Milwaukee,City.Mobile,"9");
		addPayout(City.Milwaukee,City.Norfolk,"10.5");
		addPayout(City.Milwaukee,City.Richmond,"9.5");
		addPayout(City.Milwaukee,City.Tampa,"13.5");
		
		addPayout(City.StLouis,City.Atlanta,"6");
		addPayout(City.StLouis,City.Charleston,"9");
		addPayout(City.StLouis,City.Charlotte,"8");
		addPayout(City.StLouis,City.Chattanooga,"4.5");
		addPayout(City.StLouis,City.Jacksonville,"9");
		addPayout(City.StLouis,City.Knoxville,"5.5");
		addPayout(City.StLouis,City.Miami,"13");
		addPayout(City.StLouis,City.Mobile,"6.5");
		addPayout(City.StLouis,City.Norfolk,"10");
		addPayout(City.StLouis,City.Richmond,"9");
		addPayout(City.StLouis,City.Tampa,"11");
	}
	private void init_SC_SE() {
		
		addPayout(City.Birmingham,City.Atlanta,"1.5");
		addPayout(City.Birmingham,City.Charleston,"5");
		addPayout(City.Birmingham,City.Charlotte,"4");
		addPayout(City.Birmingham,City.Chattanooga,"1.5");
		addPayout(City.Birmingham,City.Jacksonville,"4.5");
		addPayout(City.Birmingham,City.Knoxville,"2.5");
		addPayout(City.Birmingham,City.Miami,"8");
		addPayout(City.Birmingham,City.Mobile,"3");
		addPayout(City.Birmingham,City.Norfolk,"7");
		addPayout(City.Birmingham,City.Richmond,"7.5");
		addPayout(City.Birmingham,City.Tampa,"6");
		
		addPayout(City.Dallas,City.Atlanta,"8");
		addPayout(City.Dallas,City.Charleston,"11.5");
		addPayout(City.Dallas,City.Charlotte,"11");
		addPayout(City.Dallas,City.Chattanooga,"9");
		addPayout(City.Dallas,City.Jacksonville,"11");
		addPayout(City.Dallas,City.Knoxville,"9");
		addPayout(City.Dallas,City.Miami,"14.5");
		addPayout(City.Dallas,City.Mobile,"6");
		addPayout(City.Dallas,City.Norfolk,"14");
		addPayout(City.Dallas,City.Richmond,"14");
		addPayout(City.Dallas,City.Tampa,"12.5");
		
		addPayout(City.FortWorth,City.Atlanta,"8");
		addPayout(City.FortWorth,City.Charleston,"11.5");
		addPayout(City.FortWorth,City.Charlotte,"11");
		addPayout(City.FortWorth,City.Chattanooga,"9");
		addPayout(City.FortWorth,City.Jacksonville,"11");
		addPayout(City.FortWorth,City.Knoxville,"9");
		addPayout(City.FortWorth,City.Miami,"14.5");
		addPayout(City.FortWorth,City.Mobile,"6");
		addPayout(City.FortWorth,City.Norfolk,"14");
		addPayout(City.FortWorth,City.Richmond,"14");
		addPayout(City.FortWorth,City.Tampa,"12.5");
		
		addPayout(City.Houston,City.Atlanta,"8.5");
		addPayout(City.Houston,City.Charleston,"11.5");
		addPayout(City.Houston,City.Charlotte,"11");
		addPayout(City.Houston,City.Chattanooga,"8.5");
		addPayout(City.Houston,City.Jacksonville,"9.5");
		addPayout(City.Houston,City.Knoxville,"9.5");
		addPayout(City.Houston,City.Miami,"13.5");
		addPayout(City.Houston,City.Mobile,"5");
		addPayout(City.Houston,City.Norfolk,"14.5");
		addPayout(City.Houston,City.Richmond,"14.5");
		addPayout(City.Houston,City.Tampa,"11.5");
		
		addPayout(City.LittleRock,City.Atlanta,"5.5");
		addPayout(City.LittleRock,City.Charleston,"8.5");
		addPayout(City.LittleRock,City.Charlotte,"8.5");
		addPayout(City.LittleRock,City.Chattanooga,"5.5");
		addPayout(City.LittleRock,City.Jacksonville,"8");
		addPayout(City.LittleRock,City.Knoxville,"5.5");
		addPayout(City.LittleRock,City.Miami,"11.5");
		addPayout(City.LittleRock,City.Mobile,"5");
		addPayout(City.LittleRock,City.Norfolk,"11.5");
		addPayout(City.LittleRock,City.Richmond,"10.5");
		addPayout(City.LittleRock,City.Tampa,"9.5");
		
		addPayout(City.Louisville,City.Atlanta,"4.5");
		addPayout(City.Louisville,City.Charleston,"7");
		addPayout(City.Louisville,City.Charlotte,"5.5");
		addPayout(City.Louisville,City.Chattanooga,"3");
		addPayout(City.Louisville,City.Jacksonville,"8");
		addPayout(City.Louisville,City.Knoxville,"3");
		addPayout(City.Louisville,City.Miami,"12");
		addPayout(City.Louisville,City.Mobile,"5.5");
		addPayout(City.Louisville,City.Norfolk,"8");
		addPayout(City.Louisville,City.Richmond,"7");
		addPayout(City.Louisville,City.Tampa,"10");
		
		addPayout(City.Memphis,City.Atlanta,"4");
		addPayout(City.Memphis,City.Charleston,"7.5");
		addPayout(City.Memphis,City.Charlotte,"7");
		addPayout(City.Memphis,City.Chattanooga,"4");
		addPayout(City.Memphis,City.Jacksonville,"7");
		addPayout(City.Memphis,City.Knoxville,"4");
		addPayout(City.Memphis,City.Miami,"10.5");
		addPayout(City.Memphis,City.Mobile,"3.5");
		addPayout(City.Memphis,City.Norfolk,"9.5");
		addPayout(City.Memphis,City.Richmond,"9");
		addPayout(City.Memphis,City.Tampa,"8.5");
		
		addPayout(City.Nashville,City.Atlanta,"3");
		addPayout(City.Nashville,City.Charleston,"6");
		addPayout(City.Nashville,City.Charlotte,"5");
		addPayout(City.Nashville,City.Chattanooga,"1.5");
		addPayout(City.Nashville,City.Jacksonville,"6.5");
		addPayout(City.Nashville,City.Knoxville,"2");
		addPayout(City.Nashville,City.Miami,"10");
		addPayout(City.Nashville,City.Mobile,"5");
		addPayout(City.Nashville,City.Norfolk,"8");
		addPayout(City.Nashville,City.Richmond,"7");
		addPayout(City.Nashville,City.Tampa,"8");
		
		addPayout(City.NewOrleans,City.Atlanta,"5");
		addPayout(City.NewOrleans,City.Charleston,"7.5");
		addPayout(City.NewOrleans,City.Charlotte,"7.5");
		addPayout(City.NewOrleans,City.Chattanooga,"6.5");
		addPayout(City.NewOrleans,City.Jacksonville,"6");
		addPayout(City.NewOrleans,City.Knoxville,"6");
		addPayout(City.NewOrleans,City.Miami,"10");
		addPayout(City.NewOrleans,City.Mobile,"1.5");
		addPayout(City.NewOrleans,City.Norfolk,"10");
		addPayout(City.NewOrleans,City.Richmond,"10.5");
		addPayout(City.NewOrleans,City.Tampa,"8");
		
		addPayout(City.SanAntonio,City.Atlanta,"10.5");
		addPayout(City.SanAntonio,City.Charleston,"13.5");
		addPayout(City.SanAntonio,City.Charlotte,"13.5");
		addPayout(City.SanAntonio,City.Chattanooga,"10.5");
		addPayout(City.SanAntonio,City.Jacksonville,"12");
		addPayout(City.SanAntonio,City.Knoxville,"11.5");
		addPayout(City.SanAntonio,City.Miami,"15.5");
		addPayout(City.SanAntonio,City.Mobile,"7");
		addPayout(City.SanAntonio,City.Norfolk,"16");
		addPayout(City.SanAntonio,City.Richmond,"16.5");
		addPayout(City.SanAntonio,City.Tampa,"13.5");
		
		addPayout(City.Shreveport,City.Atlanta,"6.5");
		addPayout(City.Shreveport,City.Charleston,"9.5");
		addPayout(City.Shreveport,City.Charlotte,"9");
		addPayout(City.Shreveport,City.Chattanooga,"7");
		addPayout(City.Shreveport,City.Jacksonville,"9");
		addPayout(City.Shreveport,City.Knoxville,"8");
		addPayout(City.Shreveport,City.Miami,"12.5");
		addPayout(City.Shreveport,City.Mobile,"4.5");
		addPayout(City.Shreveport,City.Norfolk,"12");
		addPayout(City.Shreveport,City.Richmond,"12");
		addPayout(City.Shreveport,City.Tampa,"11");
		
	}
	
	private void init_P_SE() {
		
		addPayout(City.Denver,City.Atlanta,"15.5");
		addPayout(City.Denver,City.Charleston,"18.5");
		addPayout(City.Denver,City.Charlotte,"18");
		addPayout(City.Denver,City.Chattanooga,"14");
		addPayout(City.Denver,City.Jacksonville,"18");
		addPayout(City.Denver,City.Knoxville,"14.5");
		addPayout(City.Denver,City.Miami,"22");
		addPayout(City.Denver,City.Mobile,"15");
		addPayout(City.Denver,City.Norfolk,"19");
		addPayout(City.Denver,City.Richmond,"18.5");
		addPayout(City.Denver,City.Tampa,"20");
		
		addPayout(City.DesMoines,City.Atlanta,"9.5");
		addPayout(City.DesMoines,City.Charleston,"13");
		addPayout(City.DesMoines,City.Charlotte,"11.5");
		addPayout(City.DesMoines,City.Chattanooga,"8");
		addPayout(City.DesMoines,City.Jacksonville,"13");
		addPayout(City.DesMoines,City.Knoxville,"9");
		addPayout(City.DesMoines,City.Miami,"16.5");
		addPayout(City.DesMoines,City.Mobile,"10");
		addPayout(City.DesMoines,City.Norfolk,"13");
		addPayout(City.DesMoines,City.Richmond,"12");
		addPayout(City.DesMoines,City.Tampa,"14.5");
		
		addPayout(City.Fargo,City.Atlanta,"13.5");
		addPayout(City.Fargo,City.Charleston,"16.5");
		addPayout(City.Fargo,City.Charlotte,"15");
		addPayout(City.Fargo,City.Chattanooga,"12.5");
		addPayout(City.Fargo,City.Jacksonville,"17");
		addPayout(City.Fargo,City.Knoxville,"12");
		addPayout(City.Fargo,City.Miami,"21");
		addPayout(City.Fargo,City.Mobile,"14.5");
		addPayout(City.Fargo,City.Norfolk,"16");
		addPayout(City.Fargo,City.Richmond,"15");
		addPayout(City.Fargo,City.Tampa,"19");
		
		addPayout(City.KansasCity,City.Atlanta,"9");
		addPayout(City.KansasCity,City.Charleston,"12");
		addPayout(City.KansasCity,City.Charlotte,"11");
		addPayout(City.KansasCity,City.Chattanooga,"7.5");
		addPayout(City.KansasCity,City.Jacksonville,"11.5");
		addPayout(City.KansasCity,City.Knoxville,"8");
		addPayout(City.KansasCity,City.Miami,"15.5");
		addPayout(City.KansasCity,City.Mobile,"8.5");
		addPayout(City.KansasCity,City.Norfolk,"13");
		addPayout(City.KansasCity,City.Richmond,"12");
		addPayout(City.KansasCity,City.Tampa,"13.5");
		
		addPayout(City.Minneapolis,City.Atlanta,"11.5");
		addPayout(City.Minneapolis,City.Charleston,"14");
		addPayout(City.Minneapolis,City.Charlotte,"12.5");
		addPayout(City.Minneapolis,City.Chattanooga,"10");
		addPayout(City.Minneapolis,City.Jacksonville,"15");
		addPayout(City.Minneapolis,City.Knoxville,"9.5");
		addPayout(City.Minneapolis,City.Miami,"18.5");
		addPayout(City.Minneapolis,City.Mobile,"12.5");
		addPayout(City.Minneapolis,City.Norfolk,"13.5");
		addPayout(City.Minneapolis,City.Richmond,"12.5");
		addPayout(City.Minneapolis,City.Tampa,"16.5");
		
		addPayout(City.OklahomaCity,City.Atlanta,"9");
		addPayout(City.OklahomaCity,City.Charleston,"12");
		addPayout(City.OklahomaCity,City.Charlotte,"11.5");
		addPayout(City.OklahomaCity,City.Chattanooga,"9");
		addPayout(City.OklahomaCity,City.Jacksonville,"12");
		addPayout(City.OklahomaCity,City.Knoxville,"9");
		addPayout(City.OklahomaCity,City.Miami,"15.5");
		addPayout(City.OklahomaCity,City.Mobile,"8");
		addPayout(City.OklahomaCity,City.Norfolk,"15");
		addPayout(City.OklahomaCity,City.Richmond,"14");
		addPayout(City.OklahomaCity,City.Tampa,"13.5");
		
		addPayout(City.Omaha,City.Atlanta,"10");
		addPayout(City.Omaha,City.Charleston,"13.5");
		addPayout(City.Omaha,City.Charlotte,"12.5");
		addPayout(City.Omaha,City.Chattanooga,"9");
		addPayout(City.Omaha,City.Jacksonville,"13.5");
		addPayout(City.Omaha,City.Knoxville,"9");
		addPayout(City.Omaha,City.Miami,"17");
		addPayout(City.Omaha,City.Mobile,"10.5");
		addPayout(City.Omaha,City.Norfolk,"14");
		addPayout(City.Omaha,City.Richmond,"13.5");
		addPayout(City.Omaha,City.Tampa,"15");
		
		addPayout(City.Pueblo,City.Atlanta,"15");
		addPayout(City.Pueblo,City.Charleston,"18.5");
		addPayout(City.Pueblo,City.Charlotte,"18");
		addPayout(City.Pueblo,City.Chattanooga,"14");
		addPayout(City.Pueblo,City.Jacksonville,"18");
		addPayout(City.Pueblo,City.Knoxville,"14.5");
		addPayout(City.Pueblo,City.Miami,"21.5");
		addPayout(City.Pueblo,City.Mobile,"14");
		addPayout(City.Pueblo,City.Norfolk,"19");
		addPayout(City.Pueblo,City.Richmond,"18.5");
		addPayout(City.Pueblo,City.Tampa,"20");
		
		addPayout(City.StPaul,City.Atlanta,"11.5");
		addPayout(City.StPaul,City.Charleston,"14");
		addPayout(City.StPaul,City.Charlotte,"12.5");
		addPayout(City.StPaul,City.Chattanooga,"10");
		addPayout(City.StPaul,City.Jacksonville,"15");
		addPayout(City.StPaul,City.Knoxville,"9.5");
		addPayout(City.StPaul,City.Miami,"18.5");
		addPayout(City.StPaul,City.Mobile,"12.5");
		addPayout(City.StPaul,City.Norfolk,"13.5");
		addPayout(City.StPaul,City.Richmond,"12.5");
		addPayout(City.StPaul,City.Tampa,"16.5");
	}
	
	private void init_NW_SE() {
		
		addPayout(City.Billings,City.Atlanta,"19");
		addPayout(City.Billings,City.Charleston,"22.5");
		addPayout(City.Billings,City.Charlotte,"21");
		addPayout(City.Billings,City.Chattanooga,"16");
		addPayout(City.Billings,City.Jacksonville,"22.5");
		addPayout(City.Billings,City.Knoxville,"18.5");
		addPayout(City.Billings,City.Miami,"26");
		addPayout(City.Billings,City.Mobile,"19");
		addPayout(City.Billings,City.Norfolk,"22");
		addPayout(City.Billings,City.Richmond,"21.5");
		addPayout(City.Billings,City.Tampa,"24");
		
		addPayout(City.Butte,City.Atlanta,"21.5");
		addPayout(City.Butte,City.Charleston,"26");
		addPayout(City.Butte,City.Charlotte,"17.5");
		addPayout(City.Butte,City.Chattanooga,"14");
		addPayout(City.Butte,City.Jacksonville,"24.5");
		addPayout(City.Butte,City.Knoxville,"21");
		addPayout(City.Butte,City.Miami,"28.5");
		addPayout(City.Butte,City.Mobile,"21");
		addPayout(City.Butte,City.Norfolk,"25");
		addPayout(City.Butte,City.Richmond,"23.5");
		addPayout(City.Butte,City.Tampa,"26.5");
		
		addPayout(City.Casper,City.Atlanta,"25.5");
		addPayout(City.Casper,City.Charleston,"19");
		addPayout(City.Casper,City.Charlotte,"17.5");
		addPayout(City.Casper,City.Chattanooga,"14");
		addPayout(City.Casper,City.Jacksonville,"18.5");
		addPayout(City.Casper,City.Knoxville,"14.5");
		addPayout(City.Casper,City.Miami,"22");
		addPayout(City.Casper,City.Mobile,"15.5");
		addPayout(City.Casper,City.Norfolk,"19");
		addPayout(City.Casper,City.Richmond,"18.5");
		addPayout(City.Casper,City.Tampa,"15");
		
		addPayout(City.Pocatello,City.Atlanta,"21");
		addPayout(City.Pocatello,City.Charleston,"24");
		addPayout(City.Pocatello,City.Charlotte,"23");
		addPayout(City.Pocatello,City.Chattanooga,"21.5");
		addPayout(City.Pocatello,City.Jacksonville,"23.5");
		addPayout(City.Pocatello,City.Knoxville,"20.5");
		addPayout(City.Pocatello,City.Miami,"27.5");
		addPayout(City.Pocatello,City.Mobile,"22.5");
		addPayout(City.Pocatello,City.Norfolk,"24.5");
		addPayout(City.Pocatello,City.Richmond,"24");
		addPayout(City.Pocatello,City.Tampa,"25.5");
		
		addPayout(City.PortlandOR,City.Atlanta,"28");
		addPayout(City.PortlandOR,City.Charleston,"31");
		addPayout(City.PortlandOR,City.Charlotte,"30.5");
		addPayout(City.PortlandOR,City.Chattanooga,"26.5");
		addPayout(City.PortlandOR,City.Jacksonville,"31.5");
		addPayout(City.PortlandOR,City.Knoxville,"27.5");
		addPayout(City.PortlandOR,City.Miami,"35");
		addPayout(City.PortlandOR,City.Mobile,"28.5");
		addPayout(City.PortlandOR,City.Norfolk,"32");
		addPayout(City.PortlandOR,City.Richmond,"31");
		addPayout(City.PortlandOR,City.Tampa,"33");
		
		addPayout(City.RapidCity,City.Atlanta,"16");
		addPayout(City.RapidCity,City.Charleston,"19");
		addPayout(City.RapidCity,City.Charlotte,"18");
		addPayout(City.RapidCity,City.Chattanooga,"14.5");
		addPayout(City.RapidCity,City.Jacksonville,"19");
		addPayout(City.RapidCity,City.Knoxville,"15");
		addPayout(City.RapidCity,City.Miami,"22.5");
		addPayout(City.RapidCity,City.Mobile,"16");
		addPayout(City.RapidCity,City.Norfolk,"19.5");
		addPayout(City.RapidCity,City.Richmond,"19");
		addPayout(City.RapidCity,City.Tampa,"20.5");
		
		addPayout(City.SaltLakeCity,City.Atlanta,"20.5");
		addPayout(City.SaltLakeCity,City.Charleston,"23.5");
		addPayout(City.SaltLakeCity,City.Charlotte,"22.5");
		addPayout(City.SaltLakeCity,City.Chattanooga,"20.5");
		addPayout(City.SaltLakeCity,City.Jacksonville,"23.5");
		addPayout(City.SaltLakeCity,City.Knoxville,"20");
		addPayout(City.SaltLakeCity,City.Miami,"27");
		addPayout(City.SaltLakeCity,City.Mobile,"19.5");
		addPayout(City.SaltLakeCity,City.Norfolk,"24.5");
		addPayout(City.SaltLakeCity,City.Richmond,"23.5");
		addPayout(City.SaltLakeCity,City.Tampa,"25");
		
		addPayout(City.Seattle,City.Atlanta,"28");
		addPayout(City.Seattle,City.Charleston,"31.5");
		addPayout(City.Seattle,City.Charlotte,"30");
		addPayout(City.Seattle,City.Chattanooga,"27");
		addPayout(City.Seattle,City.Jacksonville,"31.5");
		addPayout(City.Seattle,City.Knoxville,"27");
		addPayout(City.Seattle,City.Miami,"35");
		addPayout(City.Seattle,City.Mobile,"28");
		addPayout(City.Seattle,City.Norfolk,"31");
		addPayout(City.Seattle,City.Richmond,"30");
		addPayout(City.Seattle,City.Tampa,"33");
		
		addPayout(City.Spokane,City.Atlanta,"28");
		addPayout(City.Spokane,City.Charleston,"28");
		addPayout(City.Spokane,City.Charlotte,"27");
		addPayout(City.Spokane,City.Chattanooga,"18.5");
		addPayout(City.Spokane,City.Jacksonville,"28");
		addPayout(City.Spokane,City.Knoxville,"24");
		addPayout(City.Spokane,City.Miami,"32");
		addPayout(City.Spokane,City.Mobile,"25");
		addPayout(City.Spokane,City.Norfolk,"28");
		addPayout(City.Spokane,City.Richmond,"27");
		addPayout(City.Spokane,City.Tampa,"30");
	}
	private void init_SW_SE() {
		
		addPayout(City.ElPaso,City.Atlanta,"14.5");
		addPayout(City.ElPaso,City.Charleston,"19");
		addPayout(City.ElPaso,City.Charlotte,"17.5");
		addPayout(City.ElPaso,City.Chattanooga,"15.5");
		addPayout(City.ElPaso,City.Jacksonville,"17.5");
		addPayout(City.ElPaso,City.Knoxville,"15.5");
		addPayout(City.ElPaso,City.Miami,"21.5");
		addPayout(City.ElPaso,City.Mobile,"13");
		addPayout(City.ElPaso,City.Norfolk,"21");
		addPayout(City.ElPaso,City.Richmond,"20.5");
		addPayout(City.ElPaso,City.Tampa,"19.5");
		
		addPayout(City.LasVagas,City.Atlanta,"23");
		addPayout(City.LasVagas,City.Charleston,"26.5");
		addPayout(City.LasVagas,City.Charlotte,"26");
		addPayout(City.LasVagas,City.Chattanooga,"24");
		addPayout(City.LasVagas,City.Jacksonville,"26");
		addPayout(City.LasVagas,City.Knoxville,"24.5");
		addPayout(City.LasVagas,City.Miami,"30");
		addPayout(City.LasVagas,City.Mobile,"21.5");
		addPayout(City.LasVagas,City.Norfolk,"29");
		addPayout(City.LasVagas,City.Richmond,"28");
		addPayout(City.LasVagas,City.Tampa,"28.5");
		
		addPayout(City.LosAngeles,City.Atlanta,"23");
		addPayout(City.LosAngeles,City.Charleston,"26");
		addPayout(City.LosAngeles,City.Charlotte,"25.5");
		addPayout(City.LosAngeles,City.Chattanooga,"23.5");
		addPayout(City.LosAngeles,City.Jacksonville,"26");
		addPayout(City.LosAngeles,City.Knoxville,"23.5");
		addPayout(City.LosAngeles,City.Miami,"29.5");
		addPayout(City.LosAngeles,City.Mobile,"21");
		addPayout(City.LosAngeles,City.Norfolk,"29.5");
		addPayout(City.LosAngeles,City.Richmond,"28.5");
		addPayout(City.LosAngeles,City.Tampa,"27.5");
		
		addPayout(City.Oakland,City.Atlanta,"27");
		addPayout(City.Oakland,City.Charleston,"30.5");
		addPayout(City.Oakland,City.Charlotte,"30");
		addPayout(City.Oakland,City.Chattanooga,"27");
		addPayout(City.Oakland,City.Jacksonville,"30");
		addPayout(City.Oakland,City.Knoxville,"27");
		addPayout(City.Oakland,City.Miami,"33.5");
		addPayout(City.Oakland,City.Mobile,"26");
		addPayout(City.Oakland,City.Norfolk,"32");
		addPayout(City.Oakland,City.Richmond,"31");
		addPayout(City.Oakland,City.Tampa,"31.5");
		
		addPayout(City.Phoenix,City.Atlanta,"19");
		addPayout(City.Phoenix,City.Charleston,"22.5");
		addPayout(City.Phoenix,City.Charlotte,"24");
		addPayout(City.Phoenix,City.Chattanooga,"19");
		addPayout(City.Phoenix,City.Jacksonville,"22");
		addPayout(City.Phoenix,City.Knoxville,"21.5");
		addPayout(City.Phoenix,City.Miami,"26");
		addPayout(City.Phoenix,City.Mobile,"17.5");
		addPayout(City.Phoenix,City.Norfolk,"26.5");
		addPayout(City.Phoenix,City.Richmond,"26.5");
		addPayout(City.Phoenix,City.Tampa,"24");
		
		addPayout(City.Reno,City.Atlanta,"26");
		addPayout(City.Reno,City.Charleston,"29.5");
		addPayout(City.Reno,City.Charlotte,"27.5");
		addPayout(City.Reno,City.Chattanooga,"24.5");
		addPayout(City.Reno,City.Jacksonville,"27.5");
		addPayout(City.Reno,City.Knoxville,"25");
		addPayout(City.Reno,City.Miami,"33");
		addPayout(City.Reno,City.Mobile,"25");
		addPayout(City.Reno,City.Norfolk,"28.5");
		addPayout(City.Reno,City.Richmond,"28");
		addPayout(City.Reno,City.Tampa,"31");
		
		addPayout(City.Sacramento,City.Atlanta,"27");
		addPayout(City.Sacramento,City.Charleston,"31");
		addPayout(City.Sacramento,City.Charlotte,"29");
		addPayout(City.Sacramento,City.Chattanooga,"26");
		addPayout(City.Sacramento,City.Jacksonville,"29");
		addPayout(City.Sacramento,City.Knoxville,"26.5");
		addPayout(City.Sacramento,City.Miami,"33.5");
		addPayout(City.Sacramento,City.Mobile,"26");
		addPayout(City.Sacramento,City.Norfolk,"31");
		addPayout(City.Sacramento,City.Richmond,"30.5");
		addPayout(City.Sacramento,City.Tampa,"31.5");
		
		addPayout(City.SanDiego,City.Atlanta,"22.5");
		addPayout(City.SanDiego,City.Charleston,"26.5");
		addPayout(City.SanDiego,City.Charlotte,"25");
		addPayout(City.SanDiego,City.Chattanooga,"23.5");
		addPayout(City.SanDiego,City.Jacksonville,"25.5");
		addPayout(City.SanDiego,City.Knoxville,"23.5");
		addPayout(City.SanDiego,City.Miami,"29");
		addPayout(City.SanDiego,City.Mobile,"21");
		addPayout(City.SanDiego,City.Norfolk,"28");
		addPayout(City.SanDiego,City.Richmond,"28.5");
		addPayout(City.SanDiego,City.Tampa,"27");
		
		addPayout(City.SanFrancisco,City.Atlanta,"27");
		addPayout(City.SanFrancisco,City.Charleston,"30.5");
		addPayout(City.SanFrancisco,City.Charlotte,"30");
		addPayout(City.SanFrancisco,City.Chattanooga,"27");
		addPayout(City.SanFrancisco,City.Jacksonville,"30");
		addPayout(City.SanFrancisco,City.Knoxville,"27");
		addPayout(City.SanFrancisco,City.Miami,"33.5");
		addPayout(City.SanFrancisco,City.Mobile,"26");
		addPayout(City.SanFrancisco,City.Norfolk,"32");
		addPayout(City.SanFrancisco,City.Richmond,"31");
		addPayout(City.SanFrancisco,City.Tampa,"31.5");
		
		addPayout(City.Tucumcari,City.Atlanta,"13");
		addPayout(City.Tucumcari,City.Charleston,"16");
		addPayout(City.Tucumcari,City.Charlotte,"15.5");
		addPayout(City.Tucumcari,City.Chattanooga,"13");
		addPayout(City.Tucumcari,City.Jacksonville,"16");
		addPayout(City.Tucumcari,City.Knoxville,"13");
		addPayout(City.Tucumcari,City.Miami,"19.5");
		addPayout(City.Tucumcari,City.Mobile,"11.5");
		addPayout(City.Tucumcari,City.Norfolk,"18.5");
		addPayout(City.Tucumcari,City.Richmond,"18");
		addPayout(City.Tucumcari,City.Tampa,"17.5");
	}
	
	private void init_NC_NC() {
		
		addPayout(City.Chicago,City.Chicago,"-");
		addPayout(City.Chicago,City.Cincinnati,"3");
		addPayout(City.Chicago,City.Cleveland,"3.5");
		addPayout(City.Chicago,City.Columbus,"3.5");
		addPayout(City.Chicago,City.Detroit,"2.5");
		addPayout(City.Chicago,City.Indianapolis,"2");
		addPayout(City.Chicago,City.Milwaukee,"1");
		addPayout(City.Chicago,City.StLouis,"3");
		
		addPayout(City.Cincinnati,City.Chicago,"3");
		addPayout(City.Cincinnati,City.Cincinnati,"-");
		addPayout(City.Cincinnati,City.Cleveland,"2.5");
		addPayout(City.Cincinnati,City.Columbus,"1");
		addPayout(City.Cincinnati,City.Detroit,"2.5");
		addPayout(City.Cincinnati,City.Indianapolis,"1");
		addPayout(City.Cincinnati,City.Milwaukee,"3.5");
		addPayout(City.Cincinnati,City.StLouis,"3.5");
		
		addPayout(City.Cleveland,City.Chicago,"3.5");
		addPayout(City.Cleveland,City.Cincinnati,"2.5");
		addPayout(City.Cleveland,City.Cleveland,"-");
		addPayout(City.Cleveland,City.Columbus,"1.5");
		addPayout(City.Cleveland,City.Detroit,"1.5");
		addPayout(City.Cleveland,City.Indianapolis,"3");
		addPayout(City.Cleveland,City.Milwaukee,"4");
		addPayout(City.Cleveland,City.StLouis,"5");
		
		addPayout(City.Columbus,City.Chicago,"3.5");
		addPayout(City.Columbus,City.Cincinnati,"1");
		addPayout(City.Columbus,City.Cleveland,"1.5");
		addPayout(City.Columbus,City.Columbus,"-");
		addPayout(City.Columbus,City.Detroit,"2");
		addPayout(City.Columbus,City.Indianapolis,"1.5");
		addPayout(City.Columbus,City.Milwaukee,"4");
		addPayout(City.Columbus,City.StLouis,"4");
		
		addPayout(City.Detroit,City.Chicago,"2.5");
		addPayout(City.Detroit,City.Cincinnati,"2.5");
		addPayout(City.Detroit,City.Cleveland,"1.5");
		addPayout(City.Detroit,City.Columbus,"2");
		addPayout(City.Detroit,City.Detroit,"-");
		addPayout(City.Detroit,City.Indianapolis,"3");
		addPayout(City.Detroit,City.Milwaukee,"3.5");
		addPayout(City.Detroit,City.StLouis,"5");
		
		addPayout(City.Indianapolis,City.Chicago,"2");
		addPayout(City.Indianapolis,City.Cincinnati,"1");
		addPayout(City.Indianapolis,City.Cleveland,"3");
		addPayout(City.Indianapolis,City.Columbus,"1.5");
		addPayout(City.Indianapolis,City.Detroit,"3");
		addPayout(City.Indianapolis,City.Indianapolis,"-");
		addPayout(City.Indianapolis,City.Milwaukee,"2.5");
		addPayout(City.Indianapolis,City.StLouis,"2.5");
		
		addPayout(City.Milwaukee,City.Chicago,"1");
		addPayout(City.Milwaukee,City.Cincinnati,"3.5");
		addPayout(City.Milwaukee,City.Cleveland,"4");
		addPayout(City.Milwaukee,City.Columbus,"4");
		addPayout(City.Milwaukee,City.Detroit,"3.5");
		addPayout(City.Milwaukee,City.Indianapolis,"2.5");
		addPayout(City.Milwaukee,City.Milwaukee,"-");
		addPayout(City.Milwaukee,City.StLouis,"3.5");
		
		addPayout(City.StLouis,City.Chicago,"3");
		addPayout(City.StLouis,City.Cincinnati,"3.5");
		addPayout(City.StLouis,City.Cleveland,"5");
		addPayout(City.StLouis,City.Columbus,"4");
		addPayout(City.StLouis,City.Detroit,"5");
		addPayout(City.StLouis,City.Indianapolis,"2.5");
		addPayout(City.StLouis,City.Milwaukee,"3.5");
		addPayout(City.StLouis,City.StLouis,"-");
		
	}
	private void init_SC_NC() {
		
		addPayout(City.Birmingham,City.Chicago,"6.5");
		addPayout(City.Birmingham,City.Cincinnati,"5");
		addPayout(City.Birmingham,City.Cleveland,"7.5");
		addPayout(City.Birmingham,City.Columbus,"6");
		addPayout(City.Birmingham,City.Detroit,"7.5");
		addPayout(City.Birmingham,City.Indianapolis,"5");
		addPayout(City.Birmingham,City.Milwaukee,"7.5");
		addPayout(City.Birmingham,City.StLouis,"5");
		
		addPayout(City.Dallas,City.Chicago,"9.5");
		addPayout(City.Dallas,City.Cincinnati,"9.5");
		addPayout(City.Dallas,City.Cleveland,"12.5");
		addPayout(City.Dallas,City.Columbus,"11");
		addPayout(City.Dallas,City.Detroit,"12");
		addPayout(City.Dallas,City.Indianapolis,"9.5");
		addPayout(City.Dallas,City.Milwaukee,"10.5");
		addPayout(City.Dallas,City.StLouis,"7");
		
		addPayout(City.FortWorth,City.Chicago,"9.5");
		addPayout(City.FortWorth,City.Cincinnati,"9.5");
		addPayout(City.FortWorth,City.Cleveland,"12.5");
		addPayout(City.FortWorth,City.Columbus,"11");
		addPayout(City.FortWorth,City.Detroit,"12");
		addPayout(City.FortWorth,City.Indianapolis,"9.5");
		addPayout(City.FortWorth,City.Milwaukee,"10.5");
		addPayout(City.FortWorth,City.StLouis,"7");
		
		addPayout(City.Houston,City.Chicago,"12");
		addPayout(City.Houston,City.Cincinnati,"12.5");
		addPayout(City.Houston,City.Cleveland,"13.5");
		addPayout(City.Houston,City.Columbus,"13");
		addPayout(City.Houston,City.Detroit,"13.5");
		addPayout(City.Houston,City.Indianapolis,"11");
		addPayout(City.Houston,City.Milwaukee,"11");
		addPayout(City.Houston,City.StLouis,"9");
		
		addPayout(City.LittleRock,City.Chicago,"6.5");
		addPayout(City.LittleRock,City.Cincinnati,"6.5");
		addPayout(City.LittleRock,City.Cleveland,"9");
		addPayout(City.LittleRock,City.Columbus,"6.5");
		addPayout(City.LittleRock,City.Detroit,"9");
		addPayout(City.LittleRock,City.Indianapolis,"5");
		addPayout(City.LittleRock,City.Milwaukee,"7.5");
		addPayout(City.LittleRock,City.StLouis,"3.5");
		
		addPayout(City.Louisville,City.Chicago,"3");
		addPayout(City.Louisville,City.Cincinnati,"1");
		addPayout(City.Louisville,City.Cleveland,"3.5");
		addPayout(City.Louisville,City.Columbus,"2.5");
		addPayout(City.Louisville,City.Detroit,"3.5");
		addPayout(City.Louisville,City.Indianapolis,"1");
		addPayout(City.Louisville,City.Milwaukee,"4");
		addPayout(City.Louisville,City.StLouis,"2.5");
		
		addPayout(City.Memphis,City.Chicago,"5.5");
		addPayout(City.Memphis,City.Cincinnati,"5");
		addPayout(City.Memphis,City.Cleveland,"7");
		addPayout(City.Memphis,City.Columbus,"6");
		addPayout(City.Memphis,City.Detroit,"7.5");
		addPayout(City.Memphis,City.Indianapolis,"5");
		addPayout(City.Memphis,City.Milwaukee,"6");
		addPayout(City.Memphis,City.StLouis,"3");
		
		addPayout(City.Nashville,City.Chicago,"4.5");
		addPayout(City.Nashville,City.Cincinnati,"3");
		addPayout(City.Nashville,City.Cleveland,"5.5");
		addPayout(City.Nashville,City.Columbus,"4");
		addPayout(City.Nashville,City.Detroit,"5.5");
		addPayout(City.Nashville,City.Indianapolis,"3");
		addPayout(City.Nashville,City.Milwaukee,"5.5");
		addPayout(City.Nashville,City.StLouis,"3");
		
		addPayout(City.NewOrleans,City.Chicago,"9");
		addPayout(City.NewOrleans,City.Cincinnati,"8.5");
		addPayout(City.NewOrleans,City.Cleveland,"11");
		addPayout(City.NewOrleans,City.Columbus,"9.5");
		addPayout(City.NewOrleans,City.Detroit,"11");
		addPayout(City.NewOrleans,City.Indianapolis,"8.5");
		addPayout(City.NewOrleans,City.Milwaukee,"10");
		addPayout(City.NewOrleans,City.StLouis,"7");
		
		addPayout(City.SanAntonio,City.Chicago,"12");
		addPayout(City.SanAntonio,City.Cincinnati,"12.5");
		addPayout(City.SanAntonio,City.Cleveland,"14.5");
		addPayout(City.SanAntonio,City.Columbus,"13.5");
		addPayout(City.SanAntonio,City.Detroit,"14");
		addPayout(City.SanAntonio,City.Indianapolis,"11.5");
		addPayout(City.SanAntonio,City.Milwaukee,"13");
		addPayout(City.SanAntonio,City.StLouis,"9");
		
		addPayout(City.Shreveport,City.Chicago,"8.5");
		addPayout(City.Shreveport,City.Cincinnati,"8.5");
		addPayout(City.Shreveport,City.Cleveland,"11");
		addPayout(City.Shreveport,City.Columbus,"11.5");
		addPayout(City.Shreveport,City.Detroit,"10.5");
		addPayout(City.Shreveport,City.Indianapolis,"9");
		addPayout(City.Shreveport,City.Milwaukee,"8.5");
		addPayout(City.Shreveport,City.StLouis,"8.5");
		
	}
	private void init_P_NC() {
		
		addPayout(City.Denver,City.Chicago,"10.5");
		addPayout(City.Denver,City.Cincinnati,"12.5");
		addPayout(City.Denver,City.Cleveland,"13.5");
		addPayout(City.Denver,City.Columbus,"13");
		addPayout(City.Denver,City.Detroit,"13");
		addPayout(City.Denver,City.Indianapolis,"11.5");
		addPayout(City.Denver,City.Milwaukee,"10.5");
		addPayout(City.Denver,City.StLouis,"9");
		
		addPayout(City.DesMoines,City.Chicago,"3.5");
		addPayout(City.DesMoines,City.Cincinnati,"6.5");
		addPayout(City.DesMoines,City.Cleveland,"7");
		addPayout(City.DesMoines,City.Columbus,"7");
		addPayout(City.DesMoines,City.Detroit,"6.5");
		addPayout(City.DesMoines,City.Indianapolis,"5.5");
		addPayout(City.DesMoines,City.Milwaukee,"3.5");
		addPayout(City.DesMoines,City.StLouis,"3.5");
		
		addPayout(City.Fargo,City.Chicago,"6.5");
		addPayout(City.Fargo,City.Cincinnati,"9");
		addPayout(City.Fargo,City.Cleveland,"10");
		addPayout(City.Fargo,City.Columbus,"9.5");
		addPayout(City.Fargo,City.Detroit,"9");
		addPayout(City.Fargo,City.Indianapolis,"8");
		addPayout(City.Fargo,City.Milwaukee,"5.5");
		addPayout(City.Fargo,City.StLouis,"8");
		
		addPayout(City.KansasCity,City.Chicago,"4.5");
		addPayout(City.KansasCity,City.Cincinnati,"6");
		addPayout(City.KansasCity,City.Cleveland,"8");
		addPayout(City.KansasCity,City.Columbus,"6.5");
		addPayout(City.KansasCity,City.Detroit,"7");
		addPayout(City.KansasCity,City.Indianapolis,"5");
		addPayout(City.KansasCity,City.Milwaukee,"5.5");
		addPayout(City.KansasCity,City.StLouis,"3");
		
		addPayout(City.Minneapolis,City.Chicago,"4");
		addPayout(City.Minneapolis,City.Cincinnati,"7");
		addPayout(City.Minneapolis,City.Cleveland,"7.5");
		addPayout(City.Minneapolis,City.Columbus,"7.5");
		addPayout(City.Minneapolis,City.Detroit,"6.5");
		addPayout(City.Minneapolis,City.Indianapolis,"6");
		addPayout(City.Minneapolis,City.Milwaukee,"3.5");
		addPayout(City.Minneapolis,City.StLouis,"5.5");
		
		addPayout(City.OklahomaCity,City.Chicago,"8");
		addPayout(City.OklahomaCity,City.Cincinnati,"9");
		addPayout(City.OklahomaCity,City.Cleveland,"10.5");
		addPayout(City.OklahomaCity,City.Columbus,"10");
		addPayout(City.OklahomaCity,City.Detroit,"10.5");
		addPayout(City.OklahomaCity,City.Indianapolis,"7.5");
		addPayout(City.OklahomaCity,City.Milwaukee,"8.5");
		addPayout(City.OklahomaCity,City.StLouis,"5.5");
		
		addPayout(City.Omaha,City.Chicago,"5");
		addPayout(City.Omaha,City.Cincinnati,"7.5");
		addPayout(City.Omaha,City.Cleveland,"8.5");
		addPayout(City.Omaha,City.Columbus,"8");
		addPayout(City.Omaha,City.Detroit,"7.5");
		addPayout(City.Omaha,City.Indianapolis,"6.5");
		addPayout(City.Omaha,City.Milwaukee,"5");
		addPayout(City.Omaha,City.StLouis,"4");
		
		addPayout(City.Pueblo,City.Chicago,"10.5");
		addPayout(City.Pueblo,City.Cincinnati,"12.5");
		addPayout(City.Pueblo,City.Cleveland,"13.5");
		addPayout(City.Pueblo,City.Columbus,"13");
		addPayout(City.Pueblo,City.Detroit,"13");
		addPayout(City.Pueblo,City.Indianapolis,"11.5");
		addPayout(City.Pueblo,City.Milwaukee,"11.5");
		addPayout(City.Pueblo,City.StLouis,"9");
		
		addPayout(City.StPaul,City.Chicago,"4");
		addPayout(City.StPaul,City.Cincinnati,"7");
		addPayout(City.StPaul,City.Cleveland,"7.5");
		addPayout(City.StPaul,City.Columbus,"7.5");
		addPayout(City.StPaul,City.Detroit,"6.5");
		addPayout(City.StPaul,City.Indianapolis,"6");
		addPayout(City.StPaul,City.Milwaukee,"3.5");
		addPayout(City.StPaul,City.StLouis,"5.5");
		
	}
	private void init_NW_NC() {
		
		addPayout(City.Billings,City.Chicago,"13");
		addPayout(City.Billings,City.Cincinnati,"15.5");
		addPayout(City.Billings,City.Cleveland,"16");
		addPayout(City.Billings,City.Columbus,"16");
		addPayout(City.Billings,City.Detroit,"15.5");
		addPayout(City.Billings,City.Indianapolis,"14.5");
		addPayout(City.Billings,City.Milwaukee,"12");
		addPayout(City.Billings,City.StLouis,"13");
		
		addPayout(City.Butte,City.Chicago,"15");
		addPayout(City.Butte,City.Cincinnati,"18");
		addPayout(City.Butte,City.Cleveland,"18.5");
		addPayout(City.Butte,City.Columbus,"18.5");
		addPayout(City.Butte,City.Detroit,"18");
		addPayout(City.Butte,City.Indianapolis,"17");
		addPayout(City.Butte,City.Milwaukee,"14.5");
		addPayout(City.Butte,City.StLouis,"15.5");
		
		addPayout(City.Casper,City.Chicago,"10");
		addPayout(City.Casper,City.Cincinnati,"12.5");
		addPayout(City.Casper,City.Cleveland,"13.5");
		addPayout(City.Casper,City.Columbus,"13");
		addPayout(City.Casper,City.Detroit,"12.5");
		addPayout(City.Casper,City.Indianapolis,"11.5");
		addPayout(City.Casper,City.Milwaukee,"10");
		addPayout(City.Casper,City.StLouis,"10");
		
		addPayout(City.Pocatello,City.Chicago,"15");
		addPayout(City.Pocatello,City.Cincinnati,"18");
		addPayout(City.Pocatello,City.Cleveland,"19");
		addPayout(City.Pocatello,City.Columbus,"18.5");
		addPayout(City.Pocatello,City.Detroit,"18");
		addPayout(City.Pocatello,City.Indianapolis,"17");
		addPayout(City.Pocatello,City.Milwaukee,"15.5");
		addPayout(City.Pocatello,City.StLouis,"14.5");
		
		addPayout(City.PortlandOR,City.Chicago,"22");
		addPayout(City.PortlandOR,City.Cincinnati,"24.5");
		addPayout(City.PortlandOR,City.Cleveland,"25.5");
		addPayout(City.PortlandOR,City.Columbus,"25.5");
		addPayout(City.PortlandOR,City.Detroit,"25");
		addPayout(City.PortlandOR,City.Indianapolis,"24.5");
		addPayout(City.PortlandOR,City.Milwaukee,"21.5");
		addPayout(City.PortlandOR,City.StLouis,"22");
		
		addPayout(City.RapidCity,City.Chicago,"9");
		addPayout(City.RapidCity,City.Cincinnati,"12");
		addPayout(City.RapidCity,City.Cleveland,"12.5");
		addPayout(City.RapidCity,City.Columbus,"13.5");
		addPayout(City.RapidCity,City.Detroit,"13");
		addPayout(City.RapidCity,City.Indianapolis,"11");
		addPayout(City.RapidCity,City.Milwaukee,"9");
		addPayout(City.RapidCity,City.StLouis,"9.5");
		
		addPayout(City.SaltLakeCity,City.Chicago,"15");
		addPayout(City.SaltLakeCity,City.Cincinnati,"18");
		addPayout(City.SaltLakeCity,City.Cleveland,"18.5");
		addPayout(City.SaltLakeCity,City.Columbus,"18");
		addPayout(City.SaltLakeCity,City.Detroit,"18");
		addPayout(City.SaltLakeCity,City.Indianapolis,"17");
		addPayout(City.SaltLakeCity,City.Milwaukee,"15");
		addPayout(City.SaltLakeCity,City.StLouis,"14.5");
		
		addPayout(City.Seattle,City.Chicago,"21.5");
		addPayout(City.Seattle,City.Cincinnati,"24");
		addPayout(City.Seattle,City.Cleveland,"25");
		addPayout(City.Seattle,City.Columbus,"25");
		addPayout(City.Seattle,City.Detroit,"24");
		addPayout(City.Seattle,City.Indianapolis,"23");
		addPayout(City.Seattle,City.Milwaukee,"21");
		addPayout(City.Seattle,City.StLouis,"22");
		
		addPayout(City.Spokane,City.Chicago,"18.5");
		addPayout(City.Spokane,City.Cincinnati,"21");
		addPayout(City.Spokane,City.Cleveland,"21.5");
		addPayout(City.Spokane,City.Columbus,"21.5");
		addPayout(City.Spokane,City.Detroit,"21");
		addPayout(City.Spokane,City.Indianapolis,"20");
		addPayout(City.Spokane,City.Milwaukee,"18");
		addPayout(City.Spokane,City.StLouis,"19");
		
	}
	private void init_SW_NC() {
		
		addPayout(City.ElPaso,City.Chicago,"14");
		addPayout(City.ElPaso,City.Cincinnati,"15.5");
		addPayout(City.ElPaso,City.Cleveland,"17.5");
		addPayout(City.ElPaso,City.Columbus,"17");
		addPayout(City.ElPaso,City.Detroit,"16.5");
		addPayout(City.ElPaso,City.Indianapolis,"15");
		addPayout(City.ElPaso,City.Milwaukee,"14.5");
		addPayout(City.ElPaso,City.StLouis,"12");
		
		addPayout(City.LasVagas,City.Chicago,"19.5");
		addPayout(City.LasVagas,City.Cincinnati,"22.5");
		addPayout(City.LasVagas,City.Cleveland,"23");
		addPayout(City.LasVagas,City.Columbus,"22.5");
		addPayout(City.LasVagas,City.Detroit,"22.5");
		addPayout(City.LasVagas,City.Indianapolis,"21.5");
		addPayout(City.LasVagas,City.Milwaukee,"19.5");
		addPayout(City.LasVagas,City.StLouis,"19");
		
		addPayout(City.LosAngeles,City.Chicago,"22.5");
		addPayout(City.LosAngeles,City.Cincinnati,"23.5");
		addPayout(City.LosAngeles,City.Cleveland,"25.5");
		addPayout(City.LosAngeles,City.Columbus,"24");
		addPayout(City.LosAngeles,City.Detroit,"25");
		addPayout(City.LosAngeles,City.Indianapolis,"22.5");
		addPayout(City.LosAngeles,City.Milwaukee,"22.5");
		addPayout(City.LosAngeles,City.StLouis,"20.5");
		
		addPayout(City.Oakland,City.Chicago,"22.5");
		addPayout(City.Oakland,City.Cincinnati,"25.5");
		addPayout(City.Oakland,City.Cleveland,"26");
		addPayout(City.Oakland,City.Columbus,"26.5");
		addPayout(City.Oakland,City.Detroit,"25.5");
		addPayout(City.Oakland,City.Indianapolis,"24.5");
		addPayout(City.Oakland,City.Milwaukee,"22.5");
		addPayout(City.Oakland,City.StLouis,"22");
		
		addPayout(City.Phoenix,City.Chicago,"19.5");
		addPayout(City.Phoenix,City.Cincinnati,"21");
		addPayout(City.Phoenix,City.Cleveland,"22.5");
		addPayout(City.Phoenix,City.Columbus,"21.5");
		addPayout(City.Phoenix,City.Detroit,"22");
		addPayout(City.Phoenix,City.Indianapolis,"20");
		addPayout(City.Phoenix,City.Milwaukee,"19.5");
		addPayout(City.Phoenix,City.StLouis,"18");
		
		addPayout(City.Reno,City.Chicago,"20");
		addPayout(City.Reno,City.Cincinnati,"23");
		addPayout(City.Reno,City.Cleveland,"23.5");
		addPayout(City.Reno,City.Columbus,"23.5");
		addPayout(City.Reno,City.Detroit,"23");
		addPayout(City.Reno,City.Indianapolis,"22");
		addPayout(City.Reno,City.Milwaukee,"20.5");
		addPayout(City.Reno,City.StLouis,"20.5");
		
		addPayout(City.Sacramento,City.Chicago,"22");
		addPayout(City.Sacramento,City.Cincinnati,"24.5");
		addPayout(City.Sacramento,City.Cleveland,"25");
		addPayout(City.Sacramento,City.Columbus,"25");
		addPayout(City.Sacramento,City.Detroit,"24.5");
		addPayout(City.Sacramento,City.Indianapolis,"23.5");
		addPayout(City.Sacramento,City.Milwaukee,"22");
		addPayout(City.Sacramento,City.StLouis,"21");
		
		addPayout(City.SanDiego,City.Chicago,"22");
		addPayout(City.SanDiego,City.Cincinnati,"23.5");
		addPayout(City.SanDiego,City.Cleveland,"25");
		addPayout(City.SanDiego,City.Columbus,"24");
		addPayout(City.SanDiego,City.Detroit,"24.5");
		addPayout(City.SanDiego,City.Indianapolis,"22.5");
		addPayout(City.SanDiego,City.Milwaukee,"23");
		addPayout(City.SanDiego,City.StLouis,"20");
		
		addPayout(City.SanFrancisco,City.Chicago,"22");
		addPayout(City.SanFrancisco,City.Cincinnati,"25.5");
		addPayout(City.SanFrancisco,City.Cleveland,"26");
		addPayout(City.SanFrancisco,City.Columbus,"26.5");
		addPayout(City.SanFrancisco,City.Detroit,"25.5");
		addPayout(City.SanFrancisco,City.Indianapolis,"24.5");
		addPayout(City.SanFrancisco,City.Milwaukee,"22.5");
		addPayout(City.SanFrancisco,City.StLouis,"22");
		
		addPayout(City.Tucumcari,City.Chicago,"11");
		addPayout(City.Tucumcari,City.Cincinnati,"12.5");
		addPayout(City.Tucumcari,City.Cleveland,"14.5");
		addPayout(City.Tucumcari,City.Columbus,"14");
		addPayout(City.Tucumcari,City.Detroit,"14");
		addPayout(City.Tucumcari,City.Indianapolis,"11.5");
		addPayout(City.Tucumcari,City.Milwaukee,"11");
		addPayout(City.Tucumcari,City.StLouis,"9.5");
		
	}
	private void init_SC_SC() {
		addPayout(City.Birmingham,City.Birmingham,"-");
		addPayout(City.Birmingham,City.Dallas,"6.5");
		addPayout(City.Birmingham,City.FortWorth,"6.5");
		addPayout(City.Birmingham,City.Houston,"7");
		addPayout(City.Birmingham,City.LittleRock,"4");
		addPayout(City.Birmingham,City.Louisville,"4");
		addPayout(City.Birmingham,City.Memphis,"2.5");
		addPayout(City.Birmingham,City.Nashville,"2");
		addPayout(City.Birmingham,City.NewOrleans,"3.5");
		addPayout(City.Birmingham,City.SanAntonio,"9.5");
		addPayout(City.Birmingham,City.Shreveport,"4.5");
		
		addPayout(City.Dallas,City.Birmingham,"6.5");
		addPayout(City.Dallas,City.Dallas,"-");
		addPayout(City.Dallas,City.FortWorth,"5");
		addPayout(City.Dallas,City.Houston,"2.5");
		addPayout(City.Dallas,City.LittleRock,"3.5");
		addPayout(City.Dallas,City.Louisville,"8.5");
		addPayout(City.Dallas,City.Memphis,"9");
		addPayout(City.Dallas,City.Nashville,"7");
		addPayout(City.Dallas,City.NewOrleans,"5");
		addPayout(City.Dallas,City.SanAntonio,"2.5");
		addPayout(City.Dallas,City.Shreveport,"2");
		
		addPayout(City.FortWorth,City.Birmingham,"6.5");
		addPayout(City.FortWorth,City.Dallas,"5");
		addPayout(City.FortWorth,City.FortWorth,"-");
		addPayout(City.FortWorth,City.Houston,"2.5");
		addPayout(City.FortWorth,City.LittleRock,"4");
		addPayout(City.FortWorth,City.Louisville,"8.5");
		addPayout(City.FortWorth,City.Memphis,"9");
		addPayout(City.FortWorth,City.Nashville,"7");
		addPayout(City.FortWorth,City.NewOrleans,"5");
		addPayout(City.FortWorth,City.SanAntonio,"2.5");
		addPayout(City.FortWorth,City.Shreveport,"2");
		
		addPayout(City.Houston,City.Birmingham,"7");
		addPayout(City.Houston,City.Dallas,"2.5");
		addPayout(City.Houston,City.FortWorth,"2.5");
		addPayout(City.Houston,City.Houston,"-");
		addPayout(City.Houston,City.LittleRock,"4.5");
		addPayout(City.Houston,City.Louisville,"10");
		addPayout(City.Houston,City.Memphis,"6");
		addPayout(City.Houston,City.Nashville,"8.5");
		addPayout(City.Houston,City.NewOrleans,"3.5");
		addPayout(City.Houston,City.SanAntonio,"2");
		addPayout(City.Houston,City.Shreveport,"2.5");
		
		addPayout(City.LittleRock,City.Birmingham,"4");
		addPayout(City.LittleRock,City.Dallas,"3.5");
		addPayout(City.LittleRock,City.FortWorth,"4");
		addPayout(City.LittleRock,City.Houston,"4.5");
		addPayout(City.LittleRock,City.LittleRock,"-");
		addPayout(City.LittleRock,City.Louisville,"5");
		addPayout(City.LittleRock,City.Memphis,"1.5");
		addPayout(City.LittleRock,City.Nashville,"3.5");
		addPayout(City.LittleRock,City.NewOrleans,"4.5");
		addPayout(City.LittleRock,City.SanAntonio,"6");
		addPayout(City.LittleRock,City.Shreveport,"2");
		
		addPayout(City.Louisville,City.Birmingham,"4");
		addPayout(City.Louisville,City.Dallas,"8.5");
		addPayout(City.Louisville,City.FortWorth,"8.5");
		addPayout(City.Louisville,City.Houston,"10");
		addPayout(City.Louisville,City.LittleRock,"5");
		addPayout(City.Louisville,City.Louisville,"-");
		addPayout(City.Louisville,City.Memphis,"4");
		addPayout(City.Louisville,City.Nashville,"2");
		addPayout(City.Louisville,City.NewOrleans,"7.5");
		addPayout(City.Louisville,City.SanAntonio,"11.5");
		addPayout(City.Louisville,City.Shreveport,"8");
		
		addPayout(City.Memphis,City.Birmingham,"2.5");
		addPayout(City.Memphis,City.Dallas,"9");
		addPayout(City.Memphis,City.FortWorth,"9");
		addPayout(City.Memphis,City.Houston,"6");
		addPayout(City.Memphis,City.LittleRock,"1.5");
		addPayout(City.Memphis,City.Louisville,"4");
		addPayout(City.Memphis,City.Memphis,"-");
		addPayout(City.Memphis,City.Nashville,"2.5");
		addPayout(City.Memphis,City.NewOrleans,"4");
		addPayout(City.Memphis,City.SanAntonio,"7.5");
		addPayout(City.Memphis,City.Shreveport,"4");
		
		addPayout(City.Nashville,City.Birmingham,"2");
		addPayout(City.Nashville,City.Dallas,"7");
		addPayout(City.Nashville,City.FortWorth,"7");
		addPayout(City.Nashville,City.Houston,"8.5");
		addPayout(City.Nashville,City.LittleRock,"3.5");
		addPayout(City.Nashville,City.Louisville,"2");
		addPayout(City.Nashville,City.Memphis,"2.5");
		addPayout(City.Nashville,City.Nashville,"-");
		addPayout(City.Nashville,City.NewOrleans,"5.5");
		addPayout(City.Nashville,City.SanAntonio,"10");
		addPayout(City.Nashville,City.Shreveport,"6.5");
		
		addPayout(City.NewOrleans,City.Birmingham,"3.5");
		addPayout(City.NewOrleans,City.Dallas,"5");
		addPayout(City.NewOrleans,City.FortWorth,"5");
		addPayout(City.NewOrleans,City.Houston,"3.5");
		addPayout(City.NewOrleans,City.LittleRock,"4.5");
		addPayout(City.NewOrleans,City.Louisville,"7.5");
		addPayout(City.NewOrleans,City.Memphis,"4");
		addPayout(City.NewOrleans,City.Nashville,"5.5");
		addPayout(City.NewOrleans,City.NewOrleans,"-");
		addPayout(City.NewOrleans,City.SanAntonio,"5.5");
		addPayout(City.NewOrleans,City.Shreveport,"3");
		
		addPayout(City.SanAntonio,City.Birmingham,"9.5");
		addPayout(City.SanAntonio,City.Dallas,"2.5");
		addPayout(City.SanAntonio,City.FortWorth,"2.5");
		addPayout(City.SanAntonio,City.Houston,"2");
		addPayout(City.SanAntonio,City.LittleRock,"6");
		addPayout(City.SanAntonio,City.Louisville,"11.5");
		addPayout(City.SanAntonio,City.Memphis,"7.5");
		addPayout(City.SanAntonio,City.Nashville,"10");
		addPayout(City.SanAntonio,City.NewOrleans,"5.5");
		addPayout(City.SanAntonio,City.SanAntonio,"-");
		addPayout(City.SanAntonio,City.Shreveport,"5");
		
		addPayout(City.Shreveport,City.Birmingham,"4.5");
		addPayout(City.Shreveport,City.Dallas,"2");
		addPayout(City.Shreveport,City.FortWorth,"2");
		addPayout(City.Shreveport,City.Houston,"2.5");
		addPayout(City.Shreveport,City.LittleRock,"2");
		addPayout(City.Shreveport,City.Louisville,"8");
		addPayout(City.Shreveport,City.Memphis,"4");
		addPayout(City.Shreveport,City.Nashville,"6.5");
		addPayout(City.Shreveport,City.NewOrleans,"3");
		addPayout(City.Shreveport,City.SanAntonio,"5");
		addPayout(City.Shreveport,City.Shreveport,"-");
		
	}
	private void init_P_SC() {
		
		addPayout(City.Denver,City.Birmingham,"13.5");
		addPayout(City.Denver,City.Dallas,"8.5");
		addPayout(City.Denver,City.FortWorth,"8.5");
		addPayout(City.Denver,City.Houston,"11");
		addPayout(City.Denver,City.LittleRock,"11");
		addPayout(City.Denver,City.Louisville,"12");
		addPayout(City.Denver,City.Memphis,"11");
		addPayout(City.Denver,City.Nashville,"12.5");
		addPayout(City.Denver,City.NewOrleans,"13.5");
		addPayout(City.Denver,City.SanAntonio,"11");
		addPayout(City.Denver,City.Shreveport,"10");
		
		addPayout(City.DesMoines,City.Birmingham,"8");
		addPayout(City.DesMoines,City.Dallas,"7.5");
		addPayout(City.DesMoines,City.FortWorth,"7.5");
		addPayout(City.DesMoines,City.Houston,"10");
		addPayout(City.DesMoines,City.LittleRock,"7");
		addPayout(City.DesMoines,City.Louisville,"6");
		addPayout(City.DesMoines,City.Memphis,"6.5");
		addPayout(City.DesMoines,City.Nashville,"6.5");
		addPayout(City.DesMoines,City.NewOrleans,"10.5");
		addPayout(City.DesMoines,City.SanAntonio,"10");
		addPayout(City.DesMoines,City.Shreveport,"8");
		
		addPayout(City.Fargo,City.Birmingham,"13");
		addPayout(City.Fargo,City.Dallas,"12.5");
		addPayout(City.Fargo,City.FortWorth,"12.5");
		addPayout(City.Fargo,City.Houston,"15");
		addPayout(City.Fargo,City.LittleRock,"12");
		addPayout(City.Fargo,City.Louisville,"9.5");
		addPayout(City.Fargo,City.Memphis,"11");
		addPayout(City.Fargo,City.Nashville,"11");
		addPayout(City.Fargo,City.NewOrleans,"15");
		addPayout(City.Fargo,City.SanAntonio,"15");
		addPayout(City.Fargo,City.Shreveport,"13");
		
		addPayout(City.KansasCity,City.Birmingham,"7.5");
		addPayout(City.KansasCity,City.Dallas,"5");
		addPayout(City.KansasCity,City.FortWorth,"5");
		addPayout(City.KansasCity,City.Houston,"8");
		addPayout(City.KansasCity,City.LittleRock,"5");
		addPayout(City.KansasCity,City.Louisville,"5.5");
		addPayout(City.KansasCity,City.Memphis,"5");
		addPayout(City.KansasCity,City.Nashville,"6");
		addPayout(City.KansasCity,City.NewOrleans,"8.5");
		addPayout(City.KansasCity,City.SanAntonio,"8");
		addPayout(City.KansasCity,City.Shreveport,"5.5");
		
		addPayout(City.Minneapolis,City.Birmingham,"10.5");
		addPayout(City.Minneapolis,City.Dallas,"10");
		addPayout(City.Minneapolis,City.FortWorth,"10");
		addPayout(City.Minneapolis,City.Houston,"12.5");
		addPayout(City.Minneapolis,City.LittleRock,"9.5");
		addPayout(City.Minneapolis,City.Louisville,"7");
		addPayout(City.Minneapolis,City.Memphis,"9");
		addPayout(City.Minneapolis,City.Nashville,"8.5");
		addPayout(City.Minneapolis,City.NewOrleans,"12.5");
		addPayout(City.Minneapolis,City.SanAntonio,"12.5");
		addPayout(City.Minneapolis,City.Shreveport,"8");
		
		addPayout(City.OklahomaCity,City.Birmingham,"7.5");
		addPayout(City.OklahomaCity,City.Dallas,"2.5");
		addPayout(City.OklahomaCity,City.FortWorth,"2.5");
		addPayout(City.OklahomaCity,City.Houston,"5");
		addPayout(City.OklahomaCity,City.LittleRock,"3.5");
		addPayout(City.OklahomaCity,City.Louisville,"8.5");
		addPayout(City.OklahomaCity,City.Memphis,"5");
		addPayout(City.OklahomaCity,City.Nashville,"7.5");
		addPayout(City.OklahomaCity,City.NewOrleans,"7.5");
		addPayout(City.OklahomaCity,City.SanAntonio,"5");
		addPayout(City.OklahomaCity,City.Shreveport,"10.5");
		
		addPayout(City.Omaha,City.Birmingham,"9");
		addPayout(City.Omaha,City.Dallas,"7");
		addPayout(City.Omaha,City.FortWorth,"7");
		addPayout(City.Omaha,City.Houston,"9.5");
		addPayout(City.Omaha,City.LittleRock,"7");
		addPayout(City.Omaha,City.Louisville,"7");
		addPayout(City.Omaha,City.Memphis,"6.5");
		addPayout(City.Omaha,City.Nashville,"7.5");
		addPayout(City.Omaha,City.NewOrleans,"10.5");
		addPayout(City.Omaha,City.SanAntonio,"10");
		addPayout(City.Omaha,City.Shreveport,"7.5");
		
		addPayout(City.Pueblo,City.Birmingham,"13.5");
		addPayout(City.Pueblo,City.Dallas,"7.5");
		addPayout(City.Pueblo,City.FortWorth,"7.5");
		addPayout(City.Pueblo,City.Houston,"10");
		addPayout(City.Pueblo,City.LittleRock,"10");
		addPayout(City.Pueblo,City.Louisville,"12");
		addPayout(City.Pueblo,City.Memphis,"11");
		addPayout(City.Pueblo,City.Nashville,"12.5");
		addPayout(City.Pueblo,City.NewOrleans,"13.5");
		addPayout(City.Pueblo,City.SanAntonio,"9.5");
		addPayout(City.Pueblo,City.Shreveport,"10");
		
		addPayout(City.StPaul,City.Birmingham,"10.5");
		addPayout(City.StPaul,City.Dallas,"10");
		addPayout(City.StPaul,City.FortWorth,"10");
		addPayout(City.StPaul,City.Houston,"12.5");
		addPayout(City.StPaul,City.LittleRock,"9.5");
		addPayout(City.StPaul,City.Louisville,"7");
		addPayout(City.StPaul,City.Memphis,"9");
		addPayout(City.StPaul,City.Nashville,"8.5");
		addPayout(City.StPaul,City.NewOrleans,"12.5");
		addPayout(City.StPaul,City.SanAntonio,"12.5");
		addPayout(City.StPaul,City.Shreveport,"10.5");
		
	}
	private void init_NW_SC() {
		
		addPayout(City.Billings,City.Birmingham,"18");
		addPayout(City.Billings,City.Dallas,"15");
		addPayout(City.Billings,City.FortWorth,"15");
		addPayout(City.Billings,City.Houston,"17.5");
		addPayout(City.Billings,City.LittleRock,"15.5");
		addPayout(City.Billings,City.Louisville,"16");
		addPayout(City.Billings,City.Memphis,"15.5");
		addPayout(City.Billings,City.Nashville,"16.5");
		addPayout(City.Billings,City.NewOrleans,"19");
		addPayout(City.Billings,City.SanAntonio,"17.5");
		addPayout(City.Billings,City.Shreveport,"16");
		
		addPayout(City.Butte,City.Birmingham,"20");
		addPayout(City.Butte,City.Dallas,"17.5");
		addPayout(City.Butte,City.FortWorth,"17.5");
		addPayout(City.Butte,City.Houston,"20");
		addPayout(City.Butte,City.LittleRock,"18");
		addPayout(City.Butte,City.Louisville,"18");
		addPayout(City.Butte,City.Memphis,"17.5");
		addPayout(City.Butte,City.Nashville,"18.5");
		addPayout(City.Butte,City.NewOrleans,"21.5");
		addPayout(City.Butte,City.SanAntonio,"19.5");
		addPayout(City.Butte,City.Shreveport,"18.5");
		
		addPayout(City.Casper,City.Birmingham,"14");
		addPayout(City.Casper,City.Dallas,"11.5");
		addPayout(City.Casper,City.FortWorth,"11.5");
		addPayout(City.Casper,City.Houston,"14.5");
		addPayout(City.Casper,City.LittleRock,"11.5");
		addPayout(City.Casper,City.Louisville,"12");
		addPayout(City.Casper,City.Memphis,"12");
		addPayout(City.Casper,City.Nashville,"12.5");
		addPayout(City.Casper,City.NewOrleans,"15.5");
		addPayout(City.Casper,City.SanAntonio,"14");
		addPayout(City.Casper,City.Shreveport,"12.5");
		
		addPayout(City.Pocatello,City.Birmingham,"20.5");
		addPayout(City.Pocatello,City.Dallas,"15");
		addPayout(City.Pocatello,City.FortWorth,"15");
		addPayout(City.Pocatello,City.Houston,"17.5");
		addPayout(City.Pocatello,City.LittleRock,"16");
		addPayout(City.Pocatello,City.Louisville,"17.5");
		addPayout(City.Pocatello,City.Memphis,"17");
		addPayout(City.Pocatello,City.Nashville,"19");
		addPayout(City.Pocatello,City.NewOrleans,"18.5");
		addPayout(City.Pocatello,City.SanAntonio,"17.5");
		addPayout(City.Pocatello,City.Shreveport,"15.5");
		
		addPayout(City.PortlandOR,City.Birmingham,"26.5");
		addPayout(City.PortlandOR,City.Dallas,"22.5");
		addPayout(City.PortlandOR,City.FortWorth,"22.5");
		addPayout(City.PortlandOR,City.Houston,"25");
		addPayout(City.PortlandOR,City.LittleRock,"24.5");
		addPayout(City.PortlandOR,City.Louisville,"24.5");
		addPayout(City.PortlandOR,City.Memphis,"25");
		addPayout(City.PortlandOR,City.Nashville,"25");
		addPayout(City.PortlandOR,City.NewOrleans,"27.5");
		addPayout(City.PortlandOR,City.SanAntonio,"25");
		addPayout(City.PortlandOR,City.Shreveport,"24");
		
		addPayout(City.RapidCity,City.Birmingham,"14.5");
		addPayout(City.RapidCity,City.Dallas,"12.5");
		addPayout(City.RapidCity,City.FortWorth,"12.5");
		addPayout(City.RapidCity,City.Houston,"15.5");
		addPayout(City.RapidCity,City.LittleRock,"12.5");
		addPayout(City.RapidCity,City.Louisville,"12.5");
		addPayout(City.RapidCity,City.Memphis,"12.5");
		addPayout(City.RapidCity,City.Nashville,"13");
		addPayout(City.RapidCity,City.NewOrleans,"15.5");
		addPayout(City.RapidCity,City.SanAntonio,"15");
		addPayout(City.RapidCity,City.Shreveport,"13");
		
		addPayout(City.SaltLakeCity,City.Birmingham,"19");
		addPayout(City.SaltLakeCity,City.Dallas,"13.5");
		addPayout(City.SaltLakeCity,City.FortWorth,"13.5");
		addPayout(City.SaltLakeCity,City.Houston,"16");
		addPayout(City.SaltLakeCity,City.LittleRock,"16");
		addPayout(City.SaltLakeCity,City.Louisville,"17");
		addPayout(City.SaltLakeCity,City.Memphis,"16.5");
		addPayout(City.SaltLakeCity,City.Nashville,"19");
		addPayout(City.SaltLakeCity,City.NewOrleans,"18.5");
		addPayout(City.SaltLakeCity,City.SanAntonio,"16");
		addPayout(City.SaltLakeCity,City.Shreveport,"15");
		
		addPayout(City.Seattle,City.Birmingham,"27");
		addPayout(City.Seattle,City.Dallas,"24");
		addPayout(City.Seattle,City.FortWorth,"24");
		addPayout(City.Seattle,City.Houston,"26.5");
		addPayout(City.Seattle,City.LittleRock,"26.5");
		addPayout(City.Seattle,City.Louisville,"25");
		addPayout(City.Seattle,City.Memphis,"24.5");
		addPayout(City.Seattle,City.Nashville,"25.5");
		addPayout(City.Seattle,City.NewOrleans,"29");
		addPayout(City.Seattle,City.SanAntonio,"26.5");
		addPayout(City.Seattle,City.Shreveport,"26");
		
		addPayout(City.Spokane,City.Birmingham,"24");
		addPayout(City.Spokane,City.Dallas,"21");
		addPayout(City.Spokane,City.FortWorth,"21");
		addPayout(City.Spokane,City.Houston,"23.5");
		addPayout(City.Spokane,City.LittleRock,"23");
		addPayout(City.Spokane,City.Louisville,"22");
		addPayout(City.Spokane,City.Memphis,"21.5");
		addPayout(City.Spokane,City.Nashville,"22.5");
		addPayout(City.Spokane,City.NewOrleans,"26");
		addPayout(City.Spokane,City.SanAntonio,"23.5");
		addPayout(City.Spokane,City.Shreveport,"22.5");
	}
	private void init_SW_SC() {
		
		addPayout(City.ElPaso,City.Birmingham,"13");
		addPayout(City.ElPaso,City.Dallas,"6.5");
		addPayout(City.ElPaso,City.FortWorth,"6.5");
		addPayout(City.ElPaso,City.Houston,"8.5");
		addPayout(City.ElPaso,City.LittleRock,"10");
		addPayout(City.ElPaso,City.Louisville,"15");
		addPayout(City.ElPaso,City.Memphis,"11.5");
		addPayout(City.ElPaso,City.Nashville,"13.5");
		addPayout(City.ElPaso,City.NewOrleans,"11.5");
		addPayout(City.ElPaso,City.SanAntonio,"6");
		addPayout(City.ElPaso,City.Shreveport,"8.5");
		
		addPayout(City.LasVagas,City.Birmingham,"23.5");
		addPayout(City.LasVagas,City.Dallas,"16");
		addPayout(City.LasVagas,City.FortWorth,"16");
		addPayout(City.LasVagas,City.Houston,"17");
		addPayout(City.LasVagas,City.LittleRock,"19");
		addPayout(City.LasVagas,City.Louisville,"21.5");
		addPayout(City.LasVagas,City.Memphis,"21");
		addPayout(City.LasVagas,City.Nashville,"22");
		addPayout(City.LasVagas,City.NewOrleans,"20");
		addPayout(City.LasVagas,City.SanAntonio,"14.5");
		addPayout(City.LasVagas,City.Shreveport,"17");
		
		addPayout(City.LosAngeles,City.Birmingham,"21");
		addPayout(City.LosAngeles,City.Dallas,"14.5");
		addPayout(City.LosAngeles,City.FortWorth,"14.5");
		addPayout(City.LosAngeles,City.Houston,"16.5");
		addPayout(City.LosAngeles,City.LittleRock,"18.5");
		addPayout(City.LosAngeles,City.Louisville,"23");
		addPayout(City.LosAngeles,City.Memphis,"19.5");
		addPayout(City.LosAngeles,City.Nashville,"22");
		addPayout(City.LosAngeles,City.NewOrleans,"19.5");
		addPayout(City.LosAngeles,City.SanAntonio,"14.5");
		addPayout(City.LosAngeles,City.Shreveport,"16.5");
		
		addPayout(City.Oakland,City.Birmingham,"25.5");
		addPayout(City.Oakland,City.Dallas,"19.5");
		addPayout(City.Oakland,City.FortWorth,"19.5");
		addPayout(City.Oakland,City.Houston,"21");
		addPayout(City.Oakland,City.LittleRock,"21.5");
		addPayout(City.Oakland,City.Louisville,"24.5");
		addPayout(City.Oakland,City.Memphis,"23");
		addPayout(City.Oakland,City.Nashville,"25.5");
		addPayout(City.Oakland,City.NewOrleans,"24.5");
		addPayout(City.Oakland,City.SanAntonio,"19");
		addPayout(City.Oakland,City.Shreveport,"21.5");
		
		addPayout(City.Phoenix,City.Birmingham,"17.5");
		addPayout(City.Phoenix,City.Dallas,"11");
		addPayout(City.Phoenix,City.FortWorth,"11");
		addPayout(City.Phoenix,City.Houston,"13");
		addPayout(City.Phoenix,City.LittleRock,"16");
		addPayout(City.Phoenix,City.Louisville,"22.5");
		addPayout(City.Phoenix,City.Memphis,"17.5");
		addPayout(City.Phoenix,City.Nashville,"19.5");
		addPayout(City.Phoenix,City.NewOrleans,"16");
		addPayout(City.Phoenix,City.SanAntonio,"10.5");
		addPayout(City.Phoenix,City.Shreveport,"13");
		
		addPayout(City.Reno,City.Birmingham,"23");
		addPayout(City.Reno,City.Dallas,"19");
		addPayout(City.Reno,City.FortWorth,"19");
		addPayout(City.Reno,City.Houston,"22");
		addPayout(City.Reno,City.LittleRock,"21.5");
		addPayout(City.Reno,City.Louisville,"22.5");
		addPayout(City.Reno,City.Memphis,"20.5");
		addPayout(City.Reno,City.Nashville,"23");
		addPayout(City.Reno,City.NewOrleans,"22");
		addPayout(City.Reno,City.SanAntonio,"20");
		addPayout(City.Reno,City.Shreveport,"21");
		
		addPayout(City.Sacramento,City.Birmingham,"24");
		addPayout(City.Sacramento,City.Dallas,"19.5");
		addPayout(City.Sacramento,City.FortWorth,"19.5");
		addPayout(City.Sacramento,City.Houston,"21");
		addPayout(City.Sacramento,City.LittleRock,"21.5");
		addPayout(City.Sacramento,City.Louisville,"24");
		addPayout(City.Sacramento,City.Memphis,"22");
		addPayout(City.Sacramento,City.Nashville,"24.5");
		addPayout(City.Sacramento,City.NewOrleans,"23.5");
		addPayout(City.Sacramento,City.SanAntonio,"19");
		addPayout(City.Sacramento,City.Shreveport,"21.5");
		
		addPayout(City.SanDiego,City.Birmingham,"21");
		addPayout(City.SanDiego,City.Dallas,"14.5");
		addPayout(City.SanDiego,City.FortWorth,"14.5");
		addPayout(City.SanDiego,City.Houston,"16");
		addPayout(City.SanDiego,City.LittleRock,"18");
		addPayout(City.SanDiego,City.Louisville,"22.5");
		addPayout(City.SanDiego,City.Memphis,"19");
		addPayout(City.SanDiego,City.Nashville,"21.5");
		addPayout(City.SanDiego,City.NewOrleans,"19.5");
		addPayout(City.SanDiego,City.SanAntonio,"17");
		addPayout(City.SanDiego,City.Shreveport,"16.5");
		
		addPayout(City.SanFrancisco,City.Birmingham,"25.5");
		addPayout(City.SanFrancisco,City.Dallas,"19.5");
		addPayout(City.SanFrancisco,City.FortWorth,"19.5");
		addPayout(City.SanFrancisco,City.Houston,"21");
		addPayout(City.SanFrancisco,City.LittleRock,"21.5");
		addPayout(City.SanFrancisco,City.Louisville,"24.5");
		addPayout(City.SanFrancisco,City.Memphis,"23");
		addPayout(City.SanFrancisco,City.Nashville,"25.5");
		addPayout(City.SanFrancisco,City.NewOrleans,"24.5");
		addPayout(City.SanFrancisco,City.SanAntonio,"19");
		addPayout(City.SanFrancisco,City.Shreveport,"21.5");
		
		addPayout(City.Tucumcari,City.Birmingham,"11.5");
		addPayout(City.Tucumcari,City.Dallas,"5");
		addPayout(City.Tucumcari,City.FortWorth,"5");
		addPayout(City.Tucumcari,City.Houston,"8");
		addPayout(City.Tucumcari,City.LittleRock,"7.5");
		addPayout(City.Tucumcari,City.Louisville,"12");
		addPayout(City.Tucumcari,City.Memphis,"8.5");
		addPayout(City.Tucumcari,City.Nashville,"11");
		addPayout(City.Tucumcari,City.NewOrleans,"10");
		addPayout(City.Tucumcari,City.SanAntonio,"7");
		addPayout(City.Tucumcari,City.Shreveport,"6.5");
		
	}
	private void init_P_P() {
		
		addPayout(City.Denver,City.Denver,"-");
		addPayout(City.Denver,City.DesMoines,"7");
		addPayout(City.Denver,City.Fargo,"11.5");
		addPayout(City.Denver,City.KansasCity,"6.5");
		addPayout(City.Denver,City.Minneapolis,"9");
		addPayout(City.Denver,City.OklahomaCity,"7.5");
		addPayout(City.Denver,City.Omaha,"5.5");
		addPayout(City.Denver,City.Pueblo,"1");
		addPayout(City.Denver,City.StPaul,"9");
		
		addPayout(City.DesMoines,City.Denver,"7");
		addPayout(City.DesMoines,City.DesMoines,"-");
		addPayout(City.DesMoines,City.Fargo,"5");
		addPayout(City.DesMoines,City.KansasCity,"2");
		addPayout(City.DesMoines,City.Minneapolis,"2.5");
		addPayout(City.DesMoines,City.OklahomaCity,"5.5");
		addPayout(City.DesMoines,City.Omaha,"1.5");
		addPayout(City.DesMoines,City.Pueblo,"7");
		addPayout(City.DesMoines,City.StPaul,"2.5");
		
		addPayout(City.Fargo,City.Denver,"11.5");
		addPayout(City.Fargo,City.DesMoines,"5");
		addPayout(City.Fargo,City.Fargo,"-");
		addPayout(City.Fargo,City.KansasCity,"7");
		addPayout(City.Fargo,City.Minneapolis,"2.5");
		addPayout(City.Fargo,City.OklahomaCity,"10.5");
		addPayout(City.Fargo,City.Omaha,"6");
		addPayout(City.Fargo,City.Pueblo,"12.5");
		addPayout(City.Fargo,City.StPaul,"2.5");
		
		addPayout(City.KansasCity,City.Denver,"6.5");
		addPayout(City.KansasCity,City.DesMoines,"2");
		addPayout(City.KansasCity,City.Fargo,"7");
		addPayout(City.KansasCity,City.KansasCity,"-");
		addPayout(City.KansasCity,City.Minneapolis,"5");
		addPayout(City.KansasCity,City.OklahomaCity,"3.5");
		addPayout(City.KansasCity,City.Omaha,"2");
		addPayout(City.KansasCity,City.Pueblo,"6");
		addPayout(City.KansasCity,City.StPaul,"5");
		
		addPayout(City.Minneapolis,City.Denver,"9");
		addPayout(City.Minneapolis,City.DesMoines,"2.5");
		addPayout(City.Minneapolis,City.Fargo,"2.5");
		addPayout(City.Minneapolis,City.KansasCity,"5");
		addPayout(City.Minneapolis,City.Minneapolis,"-");
		addPayout(City.Minneapolis,City.OklahomaCity,"8");
		addPayout(City.Minneapolis,City.Omaha,"3.5");
		addPayout(City.Minneapolis,City.Pueblo,"9.5");
		addPayout(City.Minneapolis,City.StPaul,"0");
		
		addPayout(City.OklahomaCity,City.Denver,"7.5");
		addPayout(City.OklahomaCity,City.DesMoines,"5.5");
		addPayout(City.OklahomaCity,City.Fargo,"10.5");
		addPayout(City.OklahomaCity,City.KansasCity,"3.5");
		addPayout(City.OklahomaCity,City.Minneapolis,"8");
		addPayout(City.OklahomaCity,City.OklahomaCity,"-");
		addPayout(City.OklahomaCity,City.Omaha,"5.5");
		addPayout(City.OklahomaCity,City.Pueblo,"7");
		addPayout(City.OklahomaCity,City.StPaul,"8");
		
		addPayout(City.Omaha,City.Denver,"5.5");
		addPayout(City.Omaha,City.DesMoines,"1.5");
		addPayout(City.Omaha,City.Fargo,"6");
		addPayout(City.Omaha,City.KansasCity,"2");
		addPayout(City.Omaha,City.Minneapolis,"3.5");
		addPayout(City.Omaha,City.OklahomaCity,"5.5");
		addPayout(City.Omaha,City.Omaha,"-");
		addPayout(City.Omaha,City.Pueblo,"5.5");
		addPayout(City.Omaha,City.StPaul,"3.5");
		
		addPayout(City.Pueblo,City.Denver,"1");
		addPayout(City.Pueblo,City.DesMoines,"7");
		addPayout(City.Pueblo,City.Fargo,"12.5");
		addPayout(City.Pueblo,City.KansasCity,"6");
		addPayout(City.Pueblo,City.Minneapolis,"9.5");
		addPayout(City.Pueblo,City.OklahomaCity,"7");
		addPayout(City.Pueblo,City.Omaha,"5.5");
		addPayout(City.Pueblo,City.Pueblo,"-");
		addPayout(City.Pueblo,City.StPaul,"9.5");
		
		addPayout(City.StPaul,City.Denver,"9");
		addPayout(City.StPaul,City.DesMoines,"2.5");
		addPayout(City.StPaul,City.Fargo,"2.5");
		addPayout(City.StPaul,City.KansasCity,"5");
		addPayout(City.StPaul,City.Minneapolis,"0");
		addPayout(City.StPaul,City.OklahomaCity,"8");
		addPayout(City.StPaul,City.Omaha,"3.5");
		addPayout(City.StPaul,City.Pueblo,"9.5");
		addPayout(City.StPaul,City.StPaul,"-");
	}
	private void init_NW_P() {
		
		addPayout(City.Billings,City.Denver,"6.5");
		addPayout(City.Billings,City.DesMoines,"10.5");
		addPayout(City.Billings,City.Fargo,"6.5");
		addPayout(City.Billings,City.KansasCity,"10.5");
		addPayout(City.Billings,City.Minneapolis,"9");
		addPayout(City.Billings,City.OklahomaCity,"14");
		addPayout(City.Billings,City.Omaha,"9");
		addPayout(City.Billings,City.Pueblo,"7.5");
		addPayout(City.Billings,City.StPaul,"9");
		
		addPayout(City.Butte,City.Denver,"9");
		addPayout(City.Butte,City.DesMoines,"14");
		addPayout(City.Butte,City.Fargo,"9");
		addPayout(City.Butte,City.KansasCity,"13");
		addPayout(City.Butte,City.Minneapolis,"11");
		addPayout(City.Butte,City.OklahomaCity,"16.5");
		addPayout(City.Butte,City.Omaha,"11.5");
		addPayout(City.Butte,City.Pueblo,"10");
		addPayout(City.Butte,City.StPaul,"11");
		
		addPayout(City.Casper,City.Denver,"3.5");
		addPayout(City.Casper,City.DesMoines,"6.5");
		addPayout(City.Casper,City.Fargo,"7.5");
		addPayout(City.Casper,City.KansasCity,"7");
		addPayout(City.Casper,City.Minneapolis,"8");
		addPayout(City.Casper,City.OklahomaCity,"10.5");
		addPayout(City.Casper,City.Omaha,"5");
		addPayout(City.Casper,City.Pueblo,"4.5");
		addPayout(City.Casper,City.StPaul,"8");
		
		addPayout(City.Pocatello,City.Denver,"6");
		addPayout(City.Pocatello,City.DesMoines,"12");
		addPayout(City.Pocatello,City.Fargo,"13.5");
		addPayout(City.Pocatello,City.KansasCity,"12.5");
		addPayout(City.Pocatello,City.Minneapolis,"13.5");
		addPayout(City.Pocatello,City.OklahomaCity,"12.5");
		addPayout(City.Pocatello,City.Omaha,"10.5");
		addPayout(City.Pocatello,City.Pueblo,"7.5");
		addPayout(City.Pocatello,City.StPaul,"13.5");
		
		addPayout(City.PortlandOR,City.Denver,"13.5");
		addPayout(City.PortlandOR,City.DesMoines,"19");
		addPayout(City.PortlandOR,City.Fargo,"16");
		addPayout(City.PortlandOR,City.KansasCity,"19.5");
		addPayout(City.PortlandOR,City.Minneapolis,"18");
		addPayout(City.PortlandOR,City.OklahomaCity,"21.5");
		addPayout(City.PortlandOR,City.Omaha,"17.5");
		addPayout(City.PortlandOR,City.Pueblo,"14.5");
		addPayout(City.PortlandOR,City.StPaul,"18");
		
		addPayout(City.RapidCity,City.Denver,"5.5");
		addPayout(City.RapidCity,City.DesMoines,"7");
		addPayout(City.RapidCity,City.Fargo,"4.5");
		addPayout(City.RapidCity,City.KansasCity,"7.5");
		addPayout(City.RapidCity,City.Minneapolis,"5");
		addPayout(City.RapidCity,City.OklahomaCity,"9");
		addPayout(City.RapidCity,City.Omaha,"5.5");
		addPayout(City.RapidCity,City.Pueblo,"6.5");
		addPayout(City.RapidCity,City.StPaul,"5");
		
		addPayout(City.SaltLakeCity,City.Denver,"5.5");
		addPayout(City.SaltLakeCity,City.DesMoines,"11.5");
		addPayout(City.SaltLakeCity,City.Fargo,"13");
		addPayout(City.SaltLakeCity,City.KansasCity,"12");
		addPayout(City.SaltLakeCity,City.Minneapolis,"13.5");
		addPayout(City.SaltLakeCity,City.OklahomaCity,"12.5");
		addPayout(City.SaltLakeCity,City.Omaha,"10.5");
		addPayout(City.SaltLakeCity,City.Pueblo,"6.5");
		addPayout(City.SaltLakeCity,City.StPaul,"13.5");
		
		addPayout(City.Seattle,City.Denver,"15.5");
		addPayout(City.Seattle,City.DesMoines,"19.5");
		addPayout(City.Seattle,City.Fargo,"15");
		addPayout(City.Seattle,City.KansasCity,"19.5");
		addPayout(City.Seattle,City.Minneapolis,"17.5");
		addPayout(City.Seattle,City.OklahomaCity,"23");
		addPayout(City.Seattle,City.Omaha,"18");
		addPayout(City.Seattle,City.Pueblo,"16");
		addPayout(City.Seattle,City.StPaul,"17.5");
		
		addPayout(City.Spokane,City.Denver,"12.5");
		addPayout(City.Spokane,City.DesMoines,"16.5");
		addPayout(City.Spokane,City.Fargo,"12");
		addPayout(City.Spokane,City.KansasCity,"16.5");
		addPayout(City.Spokane,City.Minneapolis,"14.5");
		addPayout(City.Spokane,City.OklahomaCity,"20");
		addPayout(City.Spokane,City.Omaha,"15");
		addPayout(City.Spokane,City.Pueblo,"13");
		addPayout(City.Spokane,City.StPaul,"14.5");
	}
	private void init_SW_P() {
		
		addPayout(City.ElPaso,City.Denver,"7.5");
		addPayout(City.ElPaso,City.DesMoines,"11.5");
		addPayout(City.ElPaso,City.Fargo,"16.5");
		addPayout(City.ElPaso,City.KansasCity,"9.5");
		addPayout(City.ElPaso,City.Minneapolis,"14");
		addPayout(City.ElPaso,City.OklahomaCity,"7");
		addPayout(City.ElPaso,City.Omaha,"11.5");
		addPayout(City.ElPaso,City.Pueblo,"6");
		addPayout(City.ElPaso,City.StPaul,"14");
		
		addPayout(City.LasVagas,City.Denver,"10");
		addPayout(City.LasVagas,City.DesMoines,"16");
		addPayout(City.LasVagas,City.Fargo,"17.5");
		addPayout(City.LasVagas,City.KansasCity,"16");
		addPayout(City.LasVagas,City.Minneapolis,"18");
		addPayout(City.LasVagas,City.OklahomaCity,"15.5");
		addPayout(City.LasVagas,City.Omaha,"15");
		addPayout(City.LasVagas,City.Pueblo,"11");
		addPayout(City.LasVagas,City.StPaul,"18");
		
		addPayout(City.LosAngeles,City.Denver,"13.5");
		addPayout(City.LosAngeles,City.DesMoines,"19.5");
		addPayout(City.LosAngeles,City.Fargo,"21");
		addPayout(City.LosAngeles,City.KansasCity,"17.5");
		addPayout(City.LosAngeles,City.Minneapolis,"21.5");
		addPayout(City.LosAngeles,City.OklahomaCity,"15");
		addPayout(City.LosAngeles,City.Omaha,"18");
		addPayout(City.LosAngeles,City.Pueblo,"13.5");
		addPayout(City.LosAngeles,City.StPaul,"21.5");
		
		addPayout(City.Oakland,City.Denver,"13.5");
		addPayout(City.Oakland,City.DesMoines,"19");
		addPayout(City.Oakland,City.Fargo,"20.5");
		addPayout(City.Oakland,City.KansasCity,"19.5");
		addPayout(City.Oakland,City.Minneapolis,"21");
		addPayout(City.Oakland,City.OklahomaCity,"18");
		addPayout(City.Oakland,City.Omaha,"17.5");
		addPayout(City.Oakland,City.Pueblo,"14");
		addPayout(City.Oakland,City.StPaul,"21");
		
		addPayout(City.Phoenix,City.Denver,"10.5");
		addPayout(City.Phoenix,City.DesMoines,"17");
		addPayout(City.Phoenix,City.Fargo,"22");
		addPayout(City.Phoenix,City.KansasCity,"15");
		addPayout(City.Phoenix,City.Minneapolis,"19.5");
		addPayout(City.Phoenix,City.OklahomaCity,"12.5");
		addPayout(City.Phoenix,City.Omaha,"16");
		addPayout(City.Phoenix,City.Pueblo,"9.5");
		addPayout(City.Phoenix,City.StPaul,"19.5");
		
		addPayout(City.Reno,City.Denver,"11.5");
		addPayout(City.Reno,City.DesMoines,"17");
		addPayout(City.Reno,City.Fargo,"15");
		addPayout(City.Reno,City.KansasCity,"17.5");
		addPayout(City.Reno,City.Minneapolis,"19");
		addPayout(City.Reno,City.OklahomaCity,"16");
		addPayout(City.Reno,City.Omaha,"15.5");
		addPayout(City.Reno,City.Pueblo,"12");
		addPayout(City.Reno,City.StPaul,"19");
		
		addPayout(City.Sacramento,City.Denver,"13");
		addPayout(City.Sacramento,City.DesMoines,"18");
		addPayout(City.Sacramento,City.Fargo,"20");
		addPayout(City.Sacramento,City.KansasCity,"19");
		addPayout(City.Sacramento,City.Minneapolis,"20.5");
		addPayout(City.Sacramento,City.OklahomaCity,"17.5");
		addPayout(City.Sacramento,City.Omaha,"17");
		addPayout(City.Sacramento,City.Pueblo,"13.5");
		addPayout(City.Sacramento,City.StPaul,"20.5");
		
		addPayout(City.SanDiego,City.Denver,"14.5");
		addPayout(City.SanDiego,City.DesMoines,"20.5");
		addPayout(City.SanDiego,City.Fargo,"22");
		addPayout(City.SanDiego,City.KansasCity,"17.5");
		addPayout(City.SanDiego,City.Minneapolis,"22.5");
		addPayout(City.SanDiego,City.OklahomaCity,"14.5");
		addPayout(City.SanDiego,City.Omaha,"19");
		addPayout(City.SanDiego,City.Pueblo,"13.5");
		addPayout(City.SanDiego,City.StPaul,"22.5");
		
		addPayout(City.SanFrancisco,City.Denver,"13.5");
		addPayout(City.SanFrancisco,City.DesMoines,"19");
		addPayout(City.SanFrancisco,City.Fargo,"20.5");
		addPayout(City.SanFrancisco,City.KansasCity,"19.5");
		addPayout(City.SanFrancisco,City.Minneapolis,"21");
		addPayout(City.SanFrancisco,City.OklahomaCity,"18");
		addPayout(City.SanFrancisco,City.Omaha,"17.5");
		addPayout(City.SanFrancisco,City.Pueblo,"14");
		addPayout(City.SanFrancisco,City.StPaul,"21");
		
		addPayout(City.Tucumcari,City.Denver,"4.5");
		addPayout(City.Tucumcari,City.DesMoines,"9");
		addPayout(City.Tucumcari,City.Fargo,"14");
		addPayout(City.Tucumcari,City.KansasCity,"6.5");
		addPayout(City.Tucumcari,City.Minneapolis,"11.5");
		addPayout(City.Tucumcari,City.OklahomaCity,"4");
		addPayout(City.Tucumcari,City.Omaha,"8.5");
		addPayout(City.Tucumcari,City.Pueblo,"3.5");
		addPayout(City.Tucumcari,City.StPaul,"11");
		
	}
	private void init_NW_NW() {
		
		addPayout(City.Billings,City.Billings,"-");
		addPayout(City.Billings,City.Butte,"2.5");
		addPayout(City.Billings,City.Casper,"3.5");
		addPayout(City.Billings,City.Pocatello,"5");
		addPayout(City.Billings,City.PortlandOR,"9.5");
		addPayout(City.Billings,City.RapidCity,"5");
		addPayout(City.Billings,City.SaltLakeCity,"6.5");
		addPayout(City.Billings,City.Seattle,"9");
		addPayout(City.Billings,City.Spokane,"6");
		
		addPayout(City.Butte,City.Billings,"2.5");
		addPayout(City.Butte,City.Butte,"-");
		addPayout(City.Butte,City.Casper,"5.5");
		addPayout(City.Butte,City.Pocatello,"2.5");
		addPayout(City.Butte,City.PortlandOR,"7");
		addPayout(City.Butte,City.RapidCity,"7.5");
		addPayout(City.Butte,City.SaltLakeCity,"4.5");
		addPayout(City.Butte,City.Seattle,"6.5");
		addPayout(City.Butte,City.Spokane,"3.5");
		
		addPayout(City.Casper,City.Billings,"3.5");
		addPayout(City.Casper,City.Butte,"5.5");
		addPayout(City.Casper,City.Casper,"-");
		addPayout(City.Casper,City.Pocatello,"7.5");
		addPayout(City.Casper,City.PortlandOR,"13");
		addPayout(City.Casper,City.RapidCity,"3");
		addPayout(City.Casper,City.SaltLakeCity,"7.5");
		addPayout(City.Casper,City.Seattle,"12.5");
		addPayout(City.Casper,City.Spokane,"9");
		
		addPayout(City.Pocatello,City.Billings,"5");
		addPayout(City.Pocatello,City.Butte,"2.5");
		addPayout(City.Pocatello,City.Casper,"7.5");
		addPayout(City.Pocatello,City.Pocatello,"-");
		addPayout(City.Pocatello,City.PortlandOR,"7");
		addPayout(City.Pocatello,City.RapidCity,"10");
		addPayout(City.Pocatello,City.SaltLakeCity,"1.5");
		addPayout(City.Pocatello,City.Seattle,"9");
		addPayout(City.Pocatello,City.Spokane,"6");
		
		addPayout(City.PortlandOR,City.Billings,"9.5");
		addPayout(City.PortlandOR,City.Butte,"7");
		addPayout(City.PortlandOR,City.Casper,"13");
		addPayout(City.PortlandOR,City.Pocatello,"7");
		addPayout(City.PortlandOR,City.PortlandOR,"-");
		addPayout(City.PortlandOR,City.RapidCity,"14.5");
		addPayout(City.PortlandOR,City.SaltLakeCity,"9");
		addPayout(City.PortlandOR,City.Seattle,"2");
		addPayout(City.PortlandOR,City.Spokane,"3.5");
		
		addPayout(City.RapidCity,City.Billings,"5");
		addPayout(City.RapidCity,City.Butte,"7.5");
		addPayout(City.RapidCity,City.Casper,"3");
		addPayout(City.RapidCity,City.Pocatello,"10");
		addPayout(City.RapidCity,City.PortlandOR,"14.5");
		addPayout(City.RapidCity,City.RapidCity,"-");
		addPayout(City.RapidCity,City.SaltLakeCity,"9.5");
		addPayout(City.RapidCity,City.Seattle,"14");
		addPayout(City.RapidCity,City.Spokane,"11");
		
		addPayout(City.SaltLakeCity,City.Billings,"6.5");
		addPayout(City.SaltLakeCity,City.Butte,"4.5");
		addPayout(City.SaltLakeCity,City.Casper,"7.5");
		addPayout(City.SaltLakeCity,City.Pocatello,"1.5");
		addPayout(City.SaltLakeCity,City.PortlandOR,"9");
		addPayout(City.SaltLakeCity,City.RapidCity,"9.5");
		addPayout(City.SaltLakeCity,City.SaltLakeCity,"-");
		addPayout(City.SaltLakeCity,City.Seattle,"10.5");
		addPayout(City.SaltLakeCity,City.Spokane,"8");
		
		addPayout(City.Seattle,City.Billings,"9");
		addPayout(City.Seattle,City.Butte,"6.5");
		addPayout(City.Seattle,City.Casper,"12.5");
		addPayout(City.Seattle,City.Pocatello,"9");
		addPayout(City.Seattle,City.PortlandOR,"2");
		addPayout(City.Seattle,City.RapidCity,"14");
		addPayout(City.Seattle,City.SaltLakeCity,"10.5");
		addPayout(City.Seattle,City.Seattle,"-");
		addPayout(City.Seattle,City.Spokane,"3");
		
		addPayout(City.Spokane,City.Billings,"6");
		addPayout(City.Spokane,City.Butte,"3.5");
		addPayout(City.Spokane,City.Casper,"9");
		addPayout(City.Spokane,City.Pocatello,"6");
		addPayout(City.Spokane,City.PortlandOR,"3.5");
		addPayout(City.Spokane,City.RapidCity,"11");
		addPayout(City.Spokane,City.SaltLakeCity,"8");
		addPayout(City.Spokane,City.Seattle,"3");
		addPayout(City.Spokane,City.Spokane,"-");
		
	}
	private void init_SW_NW() {
		
		addPayout(City.ElPaso,City.Billings,"14");
		addPayout(City.ElPaso,City.Butte,"16");
		addPayout(City.ElPaso,City.Casper,"9.5");
		addPayout(City.ElPaso,City.Pocatello,"13.5");
		addPayout(City.ElPaso,City.PortlandOR,"20");
		addPayout(City.ElPaso,City.RapidCity,"13");
		addPayout(City.ElPaso,City.SaltLakeCity,"12.5");
		addPayout(City.ElPaso,City.Seattle,"22");
		addPayout(City.ElPaso,City.Spokane,"20");
		
		addPayout(City.LasVagas,City.Billings,"11");
		addPayout(City.LasVagas,City.Butte,"9");
		addPayout(City.LasVagas,City.Casper,"12");
		addPayout(City.LasVagas,City.Pocatello,"6");
		addPayout(City.LasVagas,City.PortlandOR,"13.5");
		addPayout(City.LasVagas,City.RapidCity,"14");
		addPayout(City.LasVagas,City.SaltLakeCity,"4.5");
		addPayout(City.LasVagas,City.Seattle,"15");
		addPayout(City.LasVagas,City.Spokane,"17");
		
		addPayout(City.LosAngeles,City.Billings,"14.5");
		addPayout(City.LosAngeles,City.Butte,"12");
		addPayout(City.LosAngeles,City.Casper,"15");
		addPayout(City.LosAngeles,City.Pocatello,"9");
		addPayout(City.LosAngeles,City.PortlandOR,"12");
		addPayout(City.LosAngeles,City.RapidCity,"17.5");
		addPayout(City.LosAngeles,City.SaltLakeCity,"8");
		addPayout(City.LosAngeles,City.Seattle,"13.5");
		addPayout(City.LosAngeles,City.Spokane,"15.5");
		
		addPayout(City.Oakland,City.Billings,"14");
		addPayout(City.Oakland,City.Butte,"12");
		addPayout(City.Oakland,City.Casper,"15");
		addPayout(City.Oakland,City.Pocatello,"9");
		addPayout(City.Oakland,City.PortlandOR,"7");
		addPayout(City.Oakland,City.RapidCity,"17.5");
		addPayout(City.Oakland,City.SaltLakeCity,"8");
		addPayout(City.Oakland,City.Seattle,"9");
		addPayout(City.Oakland,City.Spokane,"11");
		
		addPayout(City.Phoenix,City.Billings,"19");
		addPayout(City.Phoenix,City.Butte,"16.5");
		addPayout(City.Phoenix,City.Casper,"14");
		addPayout(City.Phoenix,City.Pocatello,"14");
		addPayout(City.Phoenix,City.PortlandOR,"16");
		addPayout(City.Phoenix,City.RapidCity,"16");
		addPayout(City.Phoenix,City.SaltLakeCity,"12");
		addPayout(City.Phoenix,City.Seattle,"18");
		addPayout(City.Phoenix,City.Spokane,"20");
		
		addPayout(City.Reno,City.Billings,"12");
		addPayout(City.Reno,City.Butte,"9.5");
		addPayout(City.Reno,City.Casper,"12.5");
		addPayout(City.Reno,City.Pocatello,"7");
		addPayout(City.Reno,City.PortlandOR,"7.5");
		addPayout(City.Reno,City.RapidCity,"15.5");
		addPayout(City.Reno,City.SaltLakeCity,"5.5");
		addPayout(City.Reno,City.Seattle,"9.5");
		addPayout(City.Reno,City.Spokane,"11");
		
		addPayout(City.Sacramento,City.Billings,"13.5");
		addPayout(City.Sacramento,City.Butte,"11");
		addPayout(City.Sacramento,City.Casper,"14");
		addPayout(City.Sacramento,City.Pocatello,"8.5");
		addPayout(City.Sacramento,City.PortlandOR,"6.5");
		addPayout(City.Sacramento,City.RapidCity,"17");
		addPayout(City.Sacramento,City.SaltLakeCity,"7");
		addPayout(City.Sacramento,City.Seattle,"8.5");
		addPayout(City.Sacramento,City.Spokane,"10");
		
		addPayout(City.SanDiego,City.Billings,"15.5");
		addPayout(City.SanDiego,City.Butte,"13");
		addPayout(City.SanDiego,City.Casper,"16.5");
		addPayout(City.SanDiego,City.Pocatello,"11");
		addPayout(City.SanDiego,City.PortlandOR,"13");
		addPayout(City.SanDiego,City.RapidCity,"18.5");
		addPayout(City.SanDiego,City.SaltLakeCity,"9");
		addPayout(City.SanDiego,City.Seattle,"15");
		addPayout(City.SanDiego,City.Spokane,"17");
		
		addPayout(City.SanFrancisco,City.Billings,"14");
		addPayout(City.SanFrancisco,City.Butte,"12");
		addPayout(City.SanFrancisco,City.Casper,"15");
		addPayout(City.SanFrancisco,City.Pocatello,"9");
		addPayout(City.SanFrancisco,City.PortlandOR,"7");
		addPayout(City.SanFrancisco,City.RapidCity,"17.5");
		addPayout(City.SanFrancisco,City.SaltLakeCity,"8");
		addPayout(City.SanFrancisco,City.Seattle,"9");
		addPayout(City.SanFrancisco,City.Spokane,"11");
		
		addPayout(City.Tucumcari,City.Billings,"11");
		addPayout(City.Tucumcari,City.Butte,"13");
		addPayout(City.Tucumcari,City.Casper,"8");
		addPayout(City.Tucumcari,City.Pocatello,"11");
		addPayout(City.Tucumcari,City.PortlandOR,"18.5");
		addPayout(City.Tucumcari,City.RapidCity,"11");
		addPayout(City.Tucumcari,City.SaltLakeCity,"9.5");
		addPayout(City.Tucumcari,City.Seattle,"20.5");
		addPayout(City.Tucumcari,City.Spokane,"17.5");
		
	}
	private void init_SW_SW() {
		
		addPayout(City.ElPaso,City.ElPaso,"-");
		addPayout(City.ElPaso,City.LasVagas,"13");
		addPayout(City.ElPaso,City.LosAngeles,"8");
		addPayout(City.ElPaso,City.Oakland,"13");
		addPayout(City.ElPaso,City.Phoenix,"4.5");
		addPayout(City.ElPaso,City.Reno,"10.5");
		addPayout(City.ElPaso,City.Sacramento,"12");
		addPayout(City.ElPaso,City.SanDiego,"8");
		addPayout(City.ElPaso,City.SanFrancisco,"13");
		addPayout(City.ElPaso,City.Tucumcari,"3.5");
		
		addPayout(City.LasVagas,City.ElPaso,"13");
		addPayout(City.LasVagas,City.LasVagas,"-");
		addPayout(City.LasVagas,City.LosAngeles,"3");
		addPayout(City.LasVagas,City.Oakland,"6.5");
		addPayout(City.LasVagas,City.Phoenix,"7.5");
		addPayout(City.LasVagas,City.Reno,"8");
		addPayout(City.LasVagas,City.Sacramento,"6.5");
		addPayout(City.LasVagas,City.SanDiego,"4.5");
		addPayout(City.LasVagas,City.SanFrancisco,"6.5");
		addPayout(City.LasVagas,City.Tucumcari,"9.5");
		
		addPayout(City.LosAngeles,City.ElPaso,"8");
		addPayout(City.LosAngeles,City.LasVagas,"3");
		addPayout(City.LosAngeles,City.LosAngeles,"-");
		addPayout(City.LosAngeles,City.Oakland,"4.5");
		addPayout(City.LosAngeles,City.Phoenix,"4.5");
		addPayout(City.LosAngeles,City.Reno,"6");
		addPayout(City.LosAngeles,City.Sacramento,"5");
		addPayout(City.LosAngeles,City.SanDiego,"1.5");
		addPayout(City.LosAngeles,City.SanFrancisco,"4.5");
		addPayout(City.LosAngeles,City.Tucumcari,"11.5");
		
		addPayout(City.Oakland,City.ElPaso,"13");
		addPayout(City.Oakland,City.LasVagas,"6.5");
		addPayout(City.Oakland,City.LosAngeles,"4.5");
		addPayout(City.Oakland,City.Oakland,"-");
		addPayout(City.Oakland,City.Phoenix,"9");
		addPayout(City.Oakland,City.Reno,"2.5");
		addPayout(City.Oakland,City.Sacramento,"1");
		addPayout(City.Oakland,City.SanDiego,"6");
		addPayout(City.Oakland,City.SanFrancisco,"0");
		addPayout(City.Oakland,City.Tucumcari,"14.5");
		
		addPayout(City.Phoenix,City.ElPaso,"4.5");
		addPayout(City.Phoenix,City.LasVagas,"7.5");
		addPayout(City.Phoenix,City.LosAngeles,"4.5");
		addPayout(City.Phoenix,City.Oakland,"9");
		addPayout(City.Phoenix,City.Phoenix,"-");
		addPayout(City.Phoenix,City.Reno,"10.5");
		addPayout(City.Phoenix,City.Sacramento,"9");
		addPayout(City.Phoenix,City.SanDiego,"4");
		addPayout(City.Phoenix,City.SanFrancisco,"9");
		addPayout(City.Phoenix,City.Tucumcari,"8.5");
		
		addPayout(City.Reno,City.ElPaso,"10.5");
		addPayout(City.Reno,City.LasVagas,"8");
		addPayout(City.Reno,City.LosAngeles,"6");
		addPayout(City.Reno,City.Oakland,"2.5");
		addPayout(City.Reno,City.Phoenix,"10.5");
		addPayout(City.Reno,City.Reno,"-");
		addPayout(City.Reno,City.Sacramento,"1.5");
		addPayout(City.Reno,City.SanDiego,"8.5");
		addPayout(City.Reno,City.SanFrancisco,"2.5");
		addPayout(City.Reno,City.Tucumcari,"15.5");
		
		addPayout(City.Sacramento,City.ElPaso,"12");
		addPayout(City.Sacramento,City.LasVagas,"6.5");
		addPayout(City.Sacramento,City.LosAngeles,"5");
		addPayout(City.Sacramento,City.Oakland,"1");
		addPayout(City.Sacramento,City.Phoenix,"9");
		addPayout(City.Sacramento,City.Reno,"1.5");
		addPayout(City.Sacramento,City.Sacramento,"-");
		addPayout(City.Sacramento,City.SanDiego,"6.5");
		addPayout(City.Sacramento,City.SanFrancisco,"1");
		addPayout(City.Sacramento,City.Tucumcari,"14.5");
		
		addPayout(City.SanDiego,City.ElPaso,"8");
		addPayout(City.SanDiego,City.LasVagas,"4.5");
		addPayout(City.SanDiego,City.LosAngeles,"1.5");
		addPayout(City.SanDiego,City.Oakland,"6");
		addPayout(City.SanDiego,City.Phoenix,"4");
		addPayout(City.SanDiego,City.Reno,"8.5");
		addPayout(City.SanDiego,City.Sacramento,"6.5");
		addPayout(City.SanDiego,City.SanDiego,"-");
		addPayout(City.SanDiego,City.SanFrancisco,"6");
		addPayout(City.SanDiego,City.Tucumcari,"11");
		
		addPayout(City.SanFrancisco,City.ElPaso,"13");
		addPayout(City.SanFrancisco,City.LasVagas,"6.5");
		addPayout(City.SanFrancisco,City.LosAngeles,"4.5");
		addPayout(City.SanFrancisco,City.Oakland,"0");
		addPayout(City.SanFrancisco,City.Phoenix,"9");
		addPayout(City.SanFrancisco,City.Reno,"2.5");
		addPayout(City.SanFrancisco,City.Sacramento,"1");
		addPayout(City.SanFrancisco,City.SanDiego,"6");
		addPayout(City.SanFrancisco,City.SanFrancisco,"-");
		addPayout(City.SanFrancisco,City.Tucumcari,"14.5");
		
		addPayout(City.Tucumcari,City.ElPaso,"3.5");
		addPayout(City.Tucumcari,City.LasVagas,"9.5");
		addPayout(City.Tucumcari,City.LosAngeles,"11.5");
		addPayout(City.Tucumcari,City.Oakland,"14.5");
		addPayout(City.Tucumcari,City.Phoenix,"8.5");
		addPayout(City.Tucumcari,City.Reno,"15.5");
		addPayout(City.Tucumcari,City.Sacramento,"14.5");
		addPayout(City.Tucumcari,City.SanDiego,"11");
		addPayout(City.Tucumcari,City.SanFrancisco,"14.5");
		addPayout(City.Tucumcari,City.Tucumcari,"-");
		
	}
	
	private final void addPayout(City city1, City city2, String payoutValue) {
		addSinglePayout(city1,city2,payoutValue);
		addSinglePayout(city2,city1,payoutValue);
	}
	private final void addSinglePayout(City city1, City city2, String payoutValue) {
		Map<City, String> city2Map = city1Map.get(city1);
		if (city2Map == null) {
			city2Map = new HashMap<City, String>();
			city1Map.put(city1, city2Map);
		}
		city2Map.put(city2, payoutValue);
	}
	
	private final void testChartCompleteness() {
		for (City city1 : City.values()) {
			for (City city2 : City.values()) {
				try {
					if (getPayout(city1, city2) == null)
						throw new NullPointerException();
				} catch (Throwable e) {
					System.out.println("Incomplete chart for "+city1+" : "+city2);
				}
			}
		}
	}
}
 // End PayoutChart