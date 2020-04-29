package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UploadedFile {
	private String fileName;
	private boolean uploaded = false;
	private ArrayList<Farm> farms;

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
	
	public void addFarm(String farmID, String year, String month, String day, String weight) {
		Farm newFarm = new Farm(farmID, year, month, day, weight);
		
		farms.add(newFarm);
	}
	
	public void removeFarm(String farmID, String year, String month, String day) {
		int farmConvert = Integer.parseInt(farmID);
		int yearConvert = Integer.parseInt(year);
		int monthConvert = Integer.parseInt(month);
		int dayConvert = Integer.parseInt(day);
		
		for(int i = 0; i < farms.size(); i++) {
			if(farms.get(i).getID() == farmConvert) {
				if(farms.get(i).getYear() == yearConvert) {
					if(farms.get(i).getMonth() == monthConvert) {
						if(farms.get(i).getDay() == dayConvert) {
							farms.remove(i);
							return;
						}
					}
				}
			}
		}
	}

	public void farmReport(boolean writeToFile, String farmID, String farmYear) throws NullPointerException{
		boolean isInYear = false;
		boolean exists = false;
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
			if(farm == farms.get(i).getID()) {
				exists = true;
			}
		}
		
		if(exists == false) {
			throw new NullPointerException();
		}
		
		for(int i = 0; i < farms.size(); i++) {
			if(finalYear == farms.get(i).getYear()) {
				sameYear.add(farms.get(i));
			}
		}
		
		for(int i = 0; i < sameYear.size(); i++) {
			if(farm == sameYear.get(i).getID()) {
				isInYear = true;
			}
		}
		
		if(isInYear == false) {
			throw new NullPointerException();
		}
		
		ArrayList<Farm> january = new ArrayList<Farm>();
		ArrayList<Farm> february = new ArrayList<Farm>();
		ArrayList<Farm> march = new ArrayList<Farm>();
		ArrayList<Farm> april = new ArrayList<Farm>();
		ArrayList<Farm> may = new ArrayList<Farm>();
		ArrayList<Farm> june = new ArrayList<Farm>();
		ArrayList<Farm> july = new ArrayList<Farm>();
		ArrayList<Farm> august = new ArrayList<Farm>();
		ArrayList<Farm> september = new ArrayList<Farm>();
		ArrayList<Farm> october = new ArrayList<Farm>();
		ArrayList<Farm> november = new ArrayList<Farm>();
		ArrayList<Farm> december = new ArrayList<Farm>();

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
		
		Farm jan = getFarmOfMonth(january, farm);
		Farm feb = getFarmOfMonth(february, farm);
		Farm mar = getFarmOfMonth(march, farm);
		Farm apr = getFarmOfMonth(april, farm);
		Farm ma = getFarmOfMonth(may, farm);
		Farm jun = getFarmOfMonth(june, farm);
		Farm jul = getFarmOfMonth(july, farm);
		Farm aug = getFarmOfMonth(august, farm);
		Farm sep = getFarmOfMonth(september, farm);
		Farm oct = getFarmOfMonth(october, farm);
		Farm nov = getFarmOfMonth(november, farm);
		Farm dec = getFarmOfMonth(december, farm);
		

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
		
		double janPercentWeight = getPercentTotalWeight(january, jan, janTotalWeight);
		double febPercentWeight = getPercentTotalWeight(february, feb, febTotalWeight);
		double marPercentWeight = getPercentTotalWeight(march, mar, marTotalWeight);
		double aprPercentWeight = getPercentTotalWeight(april, apr, aprTotalWeight);
		double maPercentWeight = getPercentTotalWeight(may, ma, maTotalWeight);
		double junPercentWeight = getPercentTotalWeight(june, jun, junTotalWeight);
		double julPercentWeight = getPercentTotalWeight(july, jul, julTotalWeight);
		double augPercentWeight = getPercentTotalWeight(august, aug, augTotalWeight);
		double sepPercentWeight = getPercentTotalWeight(september, sep, septTotalWeight);
		double octPercentWeight = getPercentTotalWeight(october, oct, octTotalWeight);
		double novPercentWeight = getPercentTotalWeight(november, nov, novTotalWeight);
		double decPercentWeight = getPercentTotalWeight(december, dec, decTotalWeight);
		
		
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
	
	private Farm getFarmOfMonth(ArrayList<Farm> month, int farmID) {
		Farm f = null;
		
		for(int i = 0; i < month.size(); i++) {
			if(month.get(i).getID() == farmID) {
				f = month.get(i);
			}
		}
		
		return f;
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
		
		if(farm == null) {
			return 0;
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
	
	public void annualReport(boolean writeToFile,String year) {
		int finalYear = Integer.parseInt(year);
		
		ArrayList<Farm> sameYear = new ArrayList<Farm>();
		ArrayList<ArrayList<Farm>> farmIDs = new ArrayList<ArrayList<Farm>>();
		double totalWeight = 0;
		
		for(int i = 0; i < farms.size(); i++) {
			if(finalYear == farms.get(i).getYear()) {
				sameYear.add(farms.get(i));
			}
		}
		
		totalWeight = getTotalWeight(sameYear);
		
		for(int i = 0; i < sameYear.size(); i++) {
			boolean isIn = false;
			
			ArrayList<Farm> occurrences = ocurrences(sameYear.get(i), sameYear);
			
			for(int j = 0; j < farmIDs.size(); j++) {
				if(farmIDs.get(j).get(0).getID() == occurrences.get(0).getID()) {
					isIn = true;
				}
			}
			
			if(isIn == false) {
				
				if(farmIDs.size() == 0) {
					farmIDs.add(occurrences);
					continue;
				}
				
				for(int j = 0; j < farmIDs.size(); j++) {
					
					if(occurrences.get(0).getID() > farmIDs.get(farmIDs.size() - 1).get(0).getID()) {
						farmIDs.add(occurrences);
					}
					
					else if(occurrences.get(0).getID() > farmIDs.get(j).get(0).getID()) {
						continue;
					} 
					
					else if(occurrences.get(0).getID() < farmIDs.get(j).get(0).getID()) {
						farmIDs.add(j, occurrences);
					}
					
					
					
				}
			} else {
				continue;
			}
		}
		
		for(int i = 0; i < farmIDs.size(); i++) {
			for(int j = 0; j < farmIDs.get(i).size(); j++) {
				farmIDs.get(i).get(j).setTotalWeight(getTotalWeight(farmIDs.get(i)));
			}
		}
		
		for(int i = 0; i < farmIDs.size(); i++) {
			farmIDs.get(i).get(0).setPercentageTotalWeight(
					((farmIDs.get(i).get(0).getTotalWeight() / totalWeight)) * 100);
		}
		
		if(writeToFile == true) {
			
			File file = new File("annualReport.txt");
			PrintWriter printWriter;
			
			try {
				printWriter = new PrintWriter(file);
				
				for(int i = 0; i < farmIDs.size(); i++) {
					printAnnualReport(farmIDs.get(i), printWriter);
				}
				
				printWriter.println("Total Year Weight: " + totalWeight);
				printWriter.close();
			} catch(FileNotFoundException e) {
				
			}
		}
		
		
	}
	
	private ArrayList<Farm> ocurrences(Farm farm, ArrayList<Farm> list) {
	    ArrayList<Farm> ocurrencesList = new ArrayList<>();
	    
	    for (int i = 0; i < list.size(); i++) {
	        if (farm.getID() == list.get(i).getID()) {
	            ocurrencesList.add(list.get(i));
	        }
	    }
	    return ocurrencesList;
	}
	
	private void printAnnualReport(ArrayList<Farm> occurrences, PrintWriter printer) {
		printer.print("Farm ID: " + occurrences.get(0).getID());
		printer.print(" Total Weight: " + occurrences.get(0).getTotalWeight());
		printer.println(" Percent of Total Weight: " + occurrences.get(0).getPercentTotalWeight() + "%");
	}
	
	public void monthlyReport(boolean writeToFile, String year, String month) throws IllegalArgumentException{
		int finalYear = Integer.parseInt(year);
		int monthNumber = Integer.parseInt(month);
		String monthName = null;
		
		ArrayList<Farm> sameYear = new ArrayList<Farm>();
		
		for(int i = 0; i < farms.size(); i++) {
			if(finalYear == farms.get(i).getYear()) {
				sameYear.add(farms.get(i));
			}
		}
		
		ArrayList<Farm> january = new ArrayList<Farm>();
		ArrayList<Farm> february = new ArrayList<Farm>();
		ArrayList<Farm> march = new ArrayList<Farm>();
		ArrayList<Farm> april = new ArrayList<Farm>();
		ArrayList<Farm> may = new ArrayList<Farm>();
		ArrayList<Farm> june = new ArrayList<Farm>();
		ArrayList<Farm> july = new ArrayList<Farm>();
		ArrayList<Farm> august = new ArrayList<Farm>();
		ArrayList<Farm> september = new ArrayList<Farm>();
		ArrayList<Farm> october = new ArrayList<Farm>();
		ArrayList<Farm> november = new ArrayList<Farm>();
		ArrayList<Farm> december = new ArrayList<Farm>();

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
		
		double janTotalWeight = getTotalWeight(january);
		double febTotalWeight = getTotalWeight(february);
		double marTotalWeight = getTotalWeight(march);
		double aprTotalWeight = getTotalWeight(april);
		double maTotalWeight = getTotalWeight(may);
		double junTotalWeight = getTotalWeight(june);
		double julTotalWeight = getTotalWeight(july);
		double augTotalWeight = getTotalWeight(august);
		double septTotalWeight = getTotalWeight(september);
		double octTotalWeight = getTotalWeight(october);
		double novTotalWeight = getTotalWeight(november);
		double decTotalWeight = getTotalWeight(december);
		
		if(monthNumber == 1) {
			monthPercentWeight(january, janTotalWeight);
			monthName = "January";
			printMonthlyReport(writeToFile, january, janTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 2) {
			monthPercentWeight(february, febTotalWeight);
			monthName = "February";
			printMonthlyReport(writeToFile, february, febTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 3) {
			monthPercentWeight(march, marTotalWeight);
			monthName = "March";
			printMonthlyReport(writeToFile, march, marTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 4) {
			monthPercentWeight(april, aprTotalWeight);
			monthName = "April";
			printMonthlyReport(writeToFile, april, aprTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 5) {
			monthPercentWeight(may, maTotalWeight);
			monthName = "May";
			printMonthlyReport(writeToFile, may, maTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 6) {
			monthPercentWeight(june, junTotalWeight);
			monthName = "June";
			printMonthlyReport(writeToFile, june, junTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 7) {
			monthPercentWeight(july, julTotalWeight);
			monthName = "July";
			printMonthlyReport(writeToFile, july, julTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 8) {
			monthPercentWeight(august, augTotalWeight);
			monthName = "August";
			printMonthlyReport(writeToFile, august, augTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 9) {
			monthPercentWeight(september, septTotalWeight);
			monthName = "September";
			printMonthlyReport(writeToFile, september, septTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 10) {
			monthPercentWeight(october, octTotalWeight);
			monthName = "October";
			printMonthlyReport(writeToFile, october, octTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 11) {
			monthPercentWeight(november, novTotalWeight);
			monthName = "November";
			printMonthlyReport(writeToFile, november, novTotalWeight,monthName, year);
			return;
		}
		
		if(monthNumber == 12) {
			monthPercentWeight(december, decTotalWeight);
			monthName = "December";
			printMonthlyReport(writeToFile, december, decTotalWeight,monthName, year);
			return;
		}
		
		else {
			throw new IllegalArgumentException();
		}
	}
	
	private void monthPercentWeight(ArrayList<Farm> month, double totalWeight) {
		for(int i = 0; i < month.size(); i++) {
			month.get(i).setPercentageTotalWeight((month.get(i).getWeight() / totalWeight) * 100);
		}
	}
	
	private void printMonthlyReport(boolean writeToFile, ArrayList<Farm> month, 
			double totalWeight, String monthName, String year) {
		
		if(writeToFile == true) {
			File file = new File("monthlyReport.txt");
			PrintWriter printWriter;
			
			try {
				printWriter = new PrintWriter(file);
				
				printWriter.println(monthName + " " + year);
				
				for(int i = 0; i < month.size(); i++) {
					printWriter.print("Farm ID: " + month.get(i).getID());
					printWriter.println(" Percentage of Total Weight: " + month.get(i).getPercentTotalWeight());
				}
				
				printWriter.println("Total Weight For Month: " + totalWeight);
				
				printWriter.close();
			} catch(FileNotFoundException e) {
				
			}
		}
	}
}

