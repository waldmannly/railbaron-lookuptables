//RailBarronAssistant CityChooser.java 06/12/2006
package railbarron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Selects cities randomly given a region.
 * <P>
 * <TABLE BORDER="0">
 * <TR>	<TD><H4>CityChooser.java</H4></TD>
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
public final class CityChooser {
	
	private Map<Region, RegionCityChart> charts = null;
	private static CityChooser chartMaker = null;
	
	public static City getRandomCity(Region inRegion) {
		if (chartMaker == null) {
			chartMaker = new CityChooser();
		}
		return chartMaker.getTheRandomCity(inRegion);
	}

	private CityChooser() {
		initCharts();
	}
	private City getTheRandomCity(Region inRegion) {
		RegionCityChart theChart = charts.get(inRegion);
		if (theChart == null) System.out.println("Null chart for region "+inRegion);
		
		return theChart.getRandomCity();
	}
	private void initCharts() {
		charts = new HashMap<Region, RegionCityChart>();
		charts.put(Region.NorthEast, getNEChart());
		charts.put(Region.SouthEast, getSEChart());
		charts.put(Region.NorthCentral, getNCChart());
		charts.put(Region.SouthCentral, getSCChart());
		charts.put(Region.Plains, getPChart());
		charts.put(Region.NorthWest, getNWChart());
		charts.put(Region.SouthWest, getSWChart());
	}
	
	private RegionCityChart getNEChart() {
		
		RegionCityChart theChart = new RegionCityChart();
		
		theChart.addOddCity(City.NewYork);
		theChart.addOddCity(City.NewYork);
		theChart.addOddCity(City.NewYork);
		theChart.addOddCity(City.Albany);
		theChart.addOddCity(City.Boston);
		theChart.addOddCity(City.Buffalo);
		theChart.addOddCity(City.Boston);
		theChart.addOddCity(City.PortlandME);
		theChart.addOddCity(City.NewYork);
		theChart.addOddCity(City.NewYork);
		theChart.addOddCity(City.NewYork);
		
		theChart.addEvenCity(City.NewYork);
		theChart.addEvenCity(City.WashingtonDC);
		theChart.addEvenCity(City.Pittsburgh);
		theChart.addEvenCity(City.Pittsburgh);
		theChart.addEvenCity(City.Philadelphia);
		theChart.addEvenCity(City.WashingtonDC);
		theChart.addEvenCity(City.Philadelphia);
		theChart.addEvenCity(City.Baltimore);
		theChart.addEvenCity(City.Baltimore);
		theChart.addEvenCity(City.Baltimore);
		theChart.addEvenCity(City.NewYork);
		
		theChart.checkSize();
		
		return theChart;
	}
	
	private RegionCityChart getSEChart() {
		
		RegionCityChart theChart = new RegionCityChart();
		
		theChart.addOddCity(City.Charlotte);
		theChart.addOddCity(City.Charlotte);
		theChart.addOddCity(City.Chattanooga);
		theChart.addOddCity(City.Atlanta);
		theChart.addOddCity(City.Atlanta);
		theChart.addOddCity(City.Atlanta);
		theChart.addOddCity(City.Richmond);
		theChart.addOddCity(City.Knoxville);
		theChart.addOddCity(City.Mobile);
		theChart.addOddCity(City.Knoxville);
		theChart.addOddCity(City.Mobile);
		
		theChart.addEvenCity(City.Norfolk);
		theChart.addEvenCity(City.Norfolk);
		theChart.addEvenCity(City.Norfolk);
		theChart.addEvenCity(City.Charleston);
		theChart.addEvenCity(City.Miami);
		theChart.addEvenCity(City.Jacksonville);
		theChart.addEvenCity(City.Miami);
		theChart.addEvenCity(City.Tampa);
		theChart.addEvenCity(City.Tampa);
		theChart.addEvenCity(City.Mobile);
		theChart.addEvenCity(City.Norfolk);
		
		theChart.checkSize();
		return theChart;
	}
	
	private RegionCityChart getNCChart() {
		
		RegionCityChart theChart = new RegionCityChart();
		
		theChart.addOddCity(City.Cleveland);
		theChart.addOddCity(City.Cleveland);
		theChart.addOddCity(City.Cleveland);
		theChart.addOddCity(City.Cleveland);
		theChart.addOddCity(City.Detroit);
		theChart.addOddCity(City.Detroit);
		theChart.addOddCity(City.Indianapolis);
		theChart.addOddCity(City.Milwaukee);
		theChart.addOddCity(City.Milwaukee);
		theChart.addOddCity(City.Chicago);
		theChart.addOddCity(City.Milwaukee);
		
		theChart.addEvenCity(City.Cincinnati);
		theChart.addEvenCity(City.Chicago);
		theChart.addEvenCity(City.Cincinnati);
		theChart.addEvenCity(City.Cincinnati);
		theChart.addEvenCity(City.Columbus);
		theChart.addEvenCity(City.Chicago);
		theChart.addEvenCity(City.Chicago);
		theChart.addEvenCity(City.StLouis);
		theChart.addEvenCity(City.StLouis);
		theChart.addEvenCity(City.StLouis);
		theChart.addEvenCity(City.Chicago);
		
		theChart.checkSize();
		return theChart;
	}
	
	private RegionCityChart getSCChart() {
		
		RegionCityChart theChart = new RegionCityChart();
		
		theChart.addOddCity(City.Memphis);
		theChart.addOddCity(City.Memphis);
		theChart.addOddCity(City.Memphis);
		theChart.addOddCity(City.LittleRock);
		theChart.addOddCity(City.NewOrleans);
		theChart.addOddCity(City.Birmingham);
		theChart.addOddCity(City.Louisville);
		theChart.addOddCity(City.Nashville);
		theChart.addOddCity(City.Nashville);
		theChart.addOddCity(City.Louisville);
		theChart.addOddCity(City.Memphis);
		
		theChart.addEvenCity(City.Shreveport);
		theChart.addEvenCity(City.Shreveport);
		theChart.addEvenCity(City.Dallas);
		theChart.addEvenCity(City.NewOrleans);
		theChart.addEvenCity(City.Dallas);
		theChart.addEvenCity(City.SanAntonio);
		theChart.addEvenCity(City.Houston);
		theChart.addEvenCity(City.Houston);
		theChart.addEvenCity(City.FortWorth);
		theChart.addEvenCity(City.FortWorth);
		theChart.addEvenCity(City.FortWorth);
		
		theChart.checkSize();
		return theChart;
	}
	
	private RegionCityChart getPChart() {
		
		RegionCityChart theChart = new RegionCityChart();
		
		theChart.addOddCity(City.KansasCity);
		theChart.addOddCity(City.KansasCity);
		theChart.addOddCity(City.Denver);
		theChart.addOddCity(City.Denver);
		theChart.addOddCity(City.Denver);
		theChart.addOddCity(City.KansasCity);
		theChart.addOddCity(City.KansasCity);
		theChart.addOddCity(City.KansasCity);
		theChart.addOddCity(City.Pueblo);
		theChart.addOddCity(City.Pueblo);
		theChart.addOddCity(City.OklahomaCity);
		
		theChart.addEvenCity(City.OklahomaCity);
		theChart.addEvenCity(City.StPaul);
		theChart.addEvenCity(City.Minneapolis);
		theChart.addEvenCity(City.StPaul);
		theChart.addEvenCity(City.Minneapolis);
		theChart.addEvenCity(City.OklahomaCity);
		theChart.addEvenCity(City.DesMoines);
		theChart.addEvenCity(City.Omaha);
		theChart.addEvenCity(City.Omaha);
		theChart.addEvenCity(City.Fargo);
		theChart.addEvenCity(City.Fargo);
		
		theChart.checkSize();
		return theChart;
	}
	
	private RegionCityChart getNWChart() {
		
		RegionCityChart theChart = new RegionCityChart();
		
		theChart.addOddCity(City.Spokane);
		theChart.addOddCity(City.Spokane);
		theChart.addOddCity(City.Seattle);
		theChart.addOddCity(City.Seattle);
		theChart.addOddCity(City.Seattle);
		theChart.addOddCity(City.Seattle);
		theChart.addOddCity(City.RapidCity);
		theChart.addOddCity(City.Casper);
		theChart.addOddCity(City.Billings);
		theChart.addOddCity(City.Billings);
		theChart.addOddCity(City.Spokane);
		
		theChart.addEvenCity(City.Spokane);
		theChart.addEvenCity(City.SaltLakeCity);
		theChart.addEvenCity(City.SaltLakeCity);
		theChart.addEvenCity(City.SaltLakeCity);
		theChart.addEvenCity(City.PortlandOR);
		theChart.addEvenCity(City.PortlandOR);
		theChart.addEvenCity(City.PortlandOR);
		theChart.addEvenCity(City.Pocatello);
		theChart.addEvenCity(City.Butte);
		theChart.addEvenCity(City.Butte);
		theChart.addEvenCity(City.PortlandOR);
		
		theChart.checkSize();
		return theChart;
	}
	
	private RegionCityChart getSWChart() {
		
		RegionCityChart theChart = new RegionCityChart();
		
		theChart.addOddCity(City.SanDiego);
		theChart.addOddCity(City.SanDiego);
		theChart.addOddCity(City.Reno);
		theChart.addOddCity(City.SanDiego);
		theChart.addOddCity(City.Sacramento);
		theChart.addOddCity(City.LasVagas);
		theChart.addOddCity(City.Phoenix);
		theChart.addOddCity(City.ElPaso);
		theChart.addOddCity(City.Tucumcari);
		theChart.addOddCity(City.Phoenix);
		theChart.addOddCity(City.Phoenix);
		
		theChart.addEvenCity(City.LosAngeles);
		theChart.addEvenCity(City.Oakland);
		theChart.addEvenCity(City.Oakland);
		theChart.addEvenCity(City.Oakland);
		theChart.addEvenCity(City.LosAngeles);
		theChart.addEvenCity(City.LosAngeles);
		theChart.addEvenCity(City.LosAngeles);
		theChart.addEvenCity(City.SanFrancisco);
		theChart.addEvenCity(City.SanFrancisco);
		theChart.addEvenCity(City.SanFrancisco);
		theChart.addEvenCity(City.SanFrancisco);
		
		theChart.checkSize();
		return theChart;
	}
	
	private class RegionCityChart {
		private List<City> oddList = new ArrayList<City>(11);
		private List<City> evenList = new ArrayList<City>(11);
		
		void addOddCity(City newCity) {
			oddList.add(newCity);
		}
		void addEvenCity(City newCity) {
			evenList.add(newCity);
		}
		City getRandomCity() {
			int cityIndex = Dice.roll()+Dice.roll() -2;
			if (cityIndex < 0 || cityIndex > 11) System.out.println("Bad index for city chart "+cityIndex);
			if (Dice.roll()%2 == 0) {
				return evenList.get(cityIndex);
			} else {
				return oddList.get(cityIndex);
			}
		}
		
		void checkSize() {
			if (oddList.size() != 11) System.out.println("Bad odd list size "+oddList.size());
			if (evenList.size() != 11) System.out.println("Bad even list size "+evenList.size());
		}
	}
}
 // End CityChooser