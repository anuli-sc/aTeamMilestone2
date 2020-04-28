package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class UploadedFile {
	private String fileName;
	private boolean uploaded = false;
	private ArrayList<Farm> farms;
	private ArrayList<Farm> january = new ArrayList<Farm>();
	private ArrayList<Farm> february = new ArrayList<Farm>();
	private ArrayList<Farm> march = new ArrayList<Farm>();
	private ArrayList<Farm> april = new ArrayList<Farm>();
	private ArrayList<Farm> may = new ArrayList<Farm>();
	private ArrayList<Farm> june = new ArrayList<Farm>();
	private ArrayList<Farm> july = new ArrayList<Farm>();
	private ArrayList<Farm> august = new ArrayList<Farm>();
	private ArrayList<Farm> september = new ArrayList<Farm>();
	private ArrayList<Farm> october = new ArrayList<Farm>();
	private ArrayList<Farm> november = new ArrayList<Farm>();
	private ArrayList<Farm> december = new ArrayList<Farm>();

	public UploadedFile(String file) throws FileNotFoundException {
		this.fileName = file;

		try {
			farms = new ArrayList<Farm>();
			loadFile(fileName);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

	private void loadFile(String file) throws FileNotFoundException {

		boolean yearExists = false;
		File f = new File(file);
		String line;
		String fileSplit = ",";

		try {
			FileReader f1 = new FileReader(f);
			BufferedReader br = new BufferedReader(f1);
			try {
				while ((line = br.readLine()) != null) {

					String[] farmInput = line.split(fileSplit);

					String farmID = farmInput[0];
					String year = farmInput[1];
					String month = farmInput[2];
					String day = farmInput[3];
					String milkWeight = farmInput[4];

					Farm farm = new Farm(farmID, year, month, day, milkWeight);
					farms.add(farm);
					
					
				}

				br.close();
				
				this.uploaded = true;
			} catch (IOException e) {
				System.out.println("Cannot read this file");
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Improper file");
		}
	}
	
	public boolean confirmUpload() {
		return uploaded;
	}

	public void farmReport(boolean writeToFile, String farmID, String farmYear) {
		Farm f = null;
		double janTotalWeight = 0;
		double febTotalWeight = 0;
		double marTotalWeight = 0;
		double aprTotalWeight = 0;
		double maTotalWeight = 0;
		double junTotalWeight = 0;
		double julTotalWeight = 0;
		double augTotalWeight = 0;
		double septTotalWeight = 0;
		double octTotalWeight = 0;
		double novTotalWeight = 0;
		double decTotalWeight = 0;
		
		int farm = Integer.parseInt(farmID);
		int finalYear = Integer.parseInt(farmYear);
		
		ArrayList<Farm> sameYear = new ArrayList<Farm>();
		
		for(int i = 0; i < farms.size(); i++) {
			if(farm == farms.get(i).getID() && finalYear == farms.get(i).getYear()) {
				f = farms.get(i);
			}
		}
		
		for(int i = 0; i < farms.size(); i++) {
			if(finalYear == farms.get(i).getYear()) {
				sameYear.add(farms.get(i));
			}
		}

		for (int i = 0; i < sameYear.size(); i++) {
			if (sameYear.get(i).getMonth() == 1) {
				january.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 2) {
				february.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 3) {
				march.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 4) {
				april.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 5) {
				may.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 6) {
				june.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 7) {
				july.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 8) {
				august.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 9) {
				september.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 10) {
				october.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 11) {
				november.add(sameYear.get(i));
				continue;
			}

			if (sameYear.get(i).getMonth() == 12) {
				december.add(sameYear.get(i));
				continue;
			}
		}

		janTotalWeight = getTotalWeight(january);
		febTotalWeight = getTotalWeight(february);
		marTotalWeight = getTotalWeight(march);
		aprTotalWeight = getTotalWeight(april);
		maTotalWeight = getTotalWeight(may);
		junTotalWeight = getTotalWeight(june);
		julTotalWeight = getTotalWeight(july);
		augTotalWeight = getTotalWeight(august);
		septTotalWeight = getTotalWeight(september);
		octTotalWeight = getTotalWeight(october);
		novTotalWeight = getTotalWeight(november);
		decTotalWeight = getTotalWeight(december);
		
		double janPercentWeight = getPercentTotalWeight(january, f, janTotalWeight);
		double febPercentWeight = getPercentTotalWeight(february, f, febTotalWeight);
		double marPercentWeight = getPercentTotalWeight(march, f, marTotalWeight);
		double aprPercentWeight = getPercentTotalWeight(april, f, aprTotalWeight);
		double maPercentWeight = getPercentTotalWeight(may, f, maTotalWeight);
		double junPercentWeight = getPercentTotalWeight(june, f, junTotalWeight);
		double julPercentWeight = getPercentTotalWeight(july, f, julTotalWeight);
		double augPercentWeight = getPercentTotalWeight(august, f, augTotalWeight);
		double sepPercentWeight = getPercentTotalWeight(september, f, septTotalWeight);
		double octPercentWeight = getPercentTotalWeight(october, f, octTotalWeight);
		double novPercentWeight = getPercentTotalWeight(november, f, novTotalWeight);
		double decPercentWeight = getPercentTotalWeight(december, f, decTotalWeight);
		
		
		if (writeToFile == true) {
			File file = new File("farmReport.txt");
			PrintWriter printWriter;
			try {
				printWriter = new PrintWriter(file);

				printReport(january, 1, printWriter, janTotalWeight, janPercentWeight);
				printReport(february, 2, printWriter, febTotalWeight, febPercentWeight);
				printReport(march, 3, printWriter, marTotalWeight,marPercentWeight);
				printReport(april, 4, printWriter, aprTotalWeight,aprPercentWeight);
				printReport(may, 5, printWriter, maTotalWeight,maPercentWeight);
				printReport(june, 6, printWriter, junTotalWeight,junPercentWeight);
				printReport(july, 7, printWriter, julTotalWeight,julPercentWeight);
				printReport(august, 8, printWriter, augTotalWeight,augPercentWeight);
				printReport(september, 9, printWriter, septTotalWeight,sepPercentWeight);
				printReport(october, 10, printWriter, octTotalWeight,octPercentWeight);
				printReport(november, 11, printWriter, novTotalWeight,novPercentWeight);
				printReport(december, 12, printWriter, decTotalWeight,decPercentWeight);

				printWriter.close();
			} catch (FileNotFoundException e) {
			}
		}

	}

	private double getTotalWeight(ArrayList<Farm> farms) {
		double weight = 0;
		
		for(int i = 0; i < farms.size(); i++) {
			weight = weight + farms.get(i).getWeight();
		}
		
		return weight;
	}
	
	private double getPercentTotalWeight(ArrayList<Farm> farms, Farm farm, double totalWeight) {
		
		boolean isIn = false;
		double percentTotalWeight = 0;
		
		if(farms.size() == 0) {
			return percentTotalWeight;
		}
		
		for(int i = 0; i < farms.size(); i++) {
			if(farm.getID() == farms.get(i).getID()) {
				isIn = true;
			}
		}
		
		if(isIn == true) {
			percentTotalWeight = (farm.getWeight() / totalWeight) * 100;
			return percentTotalWeight;
		} else {
			return 0;
		}
	}
	
	private void printReport(ArrayList<Farm> month, int monthNum, 
			PrintWriter printWriter, double totalWeight, double percentTotalWeight) {

		if (monthNum == 1) {
			printWriter.println("January: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println("Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 2) {
			printWriter.println("February: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 3) {
			printWriter.println("March: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
			
		}

		if (monthNum == 4) {
			printWriter.println("April: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 5) {
			printWriter.println("May: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 6) {
			printWriter.println("June: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 7) {
			printWriter.println("July: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 8) {
			printWriter.println("August: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 9) {
			printWriter.println("September: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 10) {
			printWriter.println("October: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 11) {
			printWriter.println("November: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}

		if (monthNum == 12) {
			printWriter.println("December: ");
			for (int i = 0; i < month.size(); i++) {
				printWriter.print("Farm ID: " + month.get(i).getID());
				printWriter.print(" Year: " + month.get(i).getYear());
				printWriter.println(" Weight: " + month.get(i).getWeight());
				continue;
			}
			
			printWriter.println(" Total Weight: " + totalWeight);
			printWriter.println("Farm's percent of Total Weight: " + percentTotalWeight + "%");
		}
	}
}

