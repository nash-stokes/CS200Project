package main;

import java.io.*;
import java.util.ArrayList;

public class ProviderDirectoryData {
	private static ArrayList<String> serviceCodes = new ArrayList<String>();
	private static ArrayList<String> serviceNames = new ArrayList<String>();
	private static ArrayList<String> serviceFees = new ArrayList<String>();
	private String codes;
	private String names;
	private double fees;

	public void readFile() throws IOException{
		File file =  new File("ProviderDirectory.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		line = br.readLine();
		for(String word : line.split(" ")){
			serviceNames.add(word);
		}
		line = br.readLine();
		for(String word : line.split(" ")){
			serviceCodes.add(word);
		}
		line = br.readLine();
		for(String number : line.split(" ")){
			serviceFees.add(number);
		}
		br.close();
		fr.close();
	}	

	public static int getSize() {
		return serviceCodes.size();
	}

	public String getServiceCodes(int i) {
		codes = serviceCodes.get(i);
		return codes;
	}
	
	public String getServiceNames(int i) {
		names = serviceNames.get(i);
		return names;
	}
	
	public double getServiceFees(int i) {
		String f = serviceFees.get(i);
		fees = Double.parseDouble(f);
		return fees;
	}
}
