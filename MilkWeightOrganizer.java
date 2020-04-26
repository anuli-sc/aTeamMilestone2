import java.util.Hashtable;
import java.util.Set;

/**
 * MilkWeightOrganizer - collect data from input file
 */
public class MilkWeightOrganizer {
	
	private static final int jan = 0; // index 0
	private static final int feb = 1; // index 1
	private static final int mar = 2; // index 2
	private static final int apr = 3; // index 3
	private static final int may = 4; // index 4
	private static final int jun = 5; // index 5
	private static final int jul = 6; // index 6
	private static final int aug = 7; // index 7
	private static final int sep = 8; // index 8
	private static final int oct = 9; // index 9
	private static final int nov = 10;// index 10
	private static final int dec = 11;// index 11
	
	//                FarmID  Farm
	private Hashtable<String, Farm> farms;
	
	/**
	 * MilkWeightOrganizer constructor
	 */
	public MilkWeightOrganizer() {
		farms = new Hashtable<String, Farm>();
	}
	
	public void addFarm(String farmID) {
		farms.putIfAbsent(farmID, new Farm());
	}
	
	public void addFarm(String farmID, Farm farm) {
		farms.putIfAbsent(farmID, farm);
	}
	
	/**
	 * display the total milk weight and percent of the total of all farm for each month. 
	 *     Sort, the list by month number 1-12, show total weight, 
	 *     then that farm's percent of the total milk received for each month.
	 * 
	 * @param farmID to search for
	 * @param year to search for
	 * @return 
	 * @throws Exception 
	 */
	public float[][] getFarmReport(String farmID, int year) throws Exception {
		Farm farm = farms.get(farmID);
		if(farm == null) {
			throw new Exception("Farm Not Found");
		}
		// array of size 12 (each index assigned with a month
		// each index contains array of size 2 storing total for that month and percentage for the year
		float[][] results = new float[12][2];
		
		Hashtable<Integer, Hashtable<Integer, Integer>> y = farm.getMilkWeights().get(year);
		Set<Integer> months = y.keySet();
		for(Integer m : months) {
			float monthlyTotal = (float) 0.0;
			Set<Integer> days = y.get(m).keySet();
			for(Integer d : days) {
				monthlyTotal = monthlyTotal + y.get(m).get(d);
			}
			results[m][0] = monthlyTotal;
		}
		
		float yearTotal = 0;
		for(float[] result : results) {
			yearTotal = yearTotal + result[0];
		}
		for(float[] result : results) {
			result[1] = result[0] / yearTotal;
		}
		
		return results;
	}
	
	/**
	 * display list of total weight and percent of total weight of all farms by farm for the year. 
	 *     Sort by Farm ID, or you can allow the user to select display ascending or descending by weight.
	 * 
	 * @param year to search for
	 * @return 
	 */
	public int[][] getAnnualReport(int year) {
		int[][] results = new int[2][farms.size()];
		
		
		
		return results;
	}
	
	/**
	 * display a list of totals and percent of total by farm. 
	 *     The list must be sorted by Farm ID, or you can prompt for ascending or descending by weight.
	 * 
	 * @param year to search for
	 * @param month to search for
	 * @return 
	 */
	public int[][] getMonthlyReport(int year, String month) {
		int[][] results = new int[2][farms.size()];
		
		
		
		return results;
	}
	
	/**
	 * display the total milk weight per farm and the percentage of the total for each farm over that date range. 
	 *     The list must be sorted by Farm ID, or you can prompt for ascending or descending order by weight or percentage.
	 * 
	 * @param startYear year of start date
	 * @param startMonth month of start date
	 * @param startDay day of start date
	 * @param endYear year of end date
	 * @param endMonth month of end date
	 * @param endDay day of end date
	 * @return 
	 */
	public int[][] getDateRangeReport(int startYear, String startMonth, int startDay, 
			int endYear, String endMonth, int endDay) {
		int[][] results = new int[2][farms.size()];
		
		
		
		return results;
	}
	
}