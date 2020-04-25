import java.util.Hashtable;

/**
 * Farm - contain all milk weight data for particular farm
 *
 */
public class Farm {
	
	private final int FARM_ID;
	private Hashtable<Integer, Integer> milkWeights;
	
	/** 
     * Constructor
     * @param farmID of farm object to create
     */
	public Farm(int farmID) {
		this.FARM_ID = farmID;
		milkWeights = new Hashtable<Integer, Integer>();
	}
	
	/** 
     * Getter method for farm id
     */
	public int getFarmID() {
		return this.FARM_ID;
	}
	
	/** 
     * Helper method to return a single int representing the date
     * 
     * @param year
     * @param month
     * @param day
     * @return whole date represented as a single int
     */
	private int getHashableDate(int year, int month, int day) {
		String sYear = Integer.toString(year);
		String sMonth = Integer.toString(month);
		String sDay = Integer.toString(day);
		
		// single digit becomes double  e.g. 4 -> 04
		if(sMonth.length() == 1) {
			sMonth = "0".concat(sMonth);
		}
		if(sDay.length() == 1) {
			sDay = "0".concat(sDay);
		}
		
		return Integer.parseInt(sYear.concat(sMonth).concat(sDay));
	}
	
	/** 
     * Add key, value pair to hashtable
     *     key=date  value=weight
     * 
     * @param year contribution to date
     * @param month contribution to date
     * @param day contribution to date
     * @return true if add was successful, false otherwise
     */
	public boolean add(int year, int month, int day, int weight) {
		int date = getHashableDate(year, month, day);
		if(this.milkWeights.put(date, weight) != null) {
			return false;
		} else return true;
	}

}