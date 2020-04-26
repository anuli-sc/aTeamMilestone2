import java.util.Hashtable;

/**
 * Farm - contain all milk weight data for particular farm
 *
 */
public class Farm {
	//                year               month              day      weight
	private Hashtable<Integer, Hashtable<Integer, Hashtable<Integer, Integer>>> milkWeights;
	
	/** 
     * Constructor
     * @param farmID of farm object to create
     */
	public Farm() {
		milkWeights = new Hashtable<Integer, Hashtable<Integer, Hashtable<Integer, Integer>>>();
	}
	
	/** 
     * getter method for milk weights
     * 
     * @return pointer to milk weights hashtable
     */
	public Hashtable<Integer, Hashtable<Integer, Hashtable<Integer, Integer>>> getMilkWeights(){
		return this.milkWeights;
	}
	
	/** 
     * Add key, value pair to hashtable
     *     key=date  value=weight
     * If duplicate entry, add weight to the previously stored weight
     * 
     * @param year contribution to date
     * @param month contribution to date
     * @param day contribution to date
     */
	public void add(int year, Integer month, int day, int weight) {
		if(milkWeights.get(year) == null) {
			milkWeights.put(year, new Hashtable<Integer, Hashtable<Integer, Integer>>(13, (float) 1.0));
		}
		Hashtable<Integer, Hashtable<Integer, Integer>> y = milkWeights.get(year);
		if(y.get(month) == null) {
			y.put(month, new Hashtable<Integer, Integer>(32, (float) 1.0));
		}
		Hashtable<Integer, Integer> m = y.get(month);
		if(m.get(day) == null) {
			m.put(day, weight);
		}
		// if entry already exists for this date, add both weights
		else m.replace(day, m.get(day) + weight);
		
	}

}