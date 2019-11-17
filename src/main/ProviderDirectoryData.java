package main;

import java.io.*;
import java.util.ArrayList;

public class ProviderDirectoryData {
	private static ArrayList<String> serviceCodes = new ArrayList<String>();
	private static ArrayList<String> serviceNames = new ArrayList<String>();
	private static ArrayList<String> serviceFees = new ArrayList<String>();
	private static String codes;
	private static String names;
	private static double fees;

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

	public static String getServiceCodes(int i) {
		codes = serviceCodes.get(i);
		return codes;
	}
	
	public static String getServiceNames(int i) {
		names = serviceNames.get(i);
		return names;
	}
	
	public static double getServiceFees(int i) {
		String f = serviceFees.get(i);
		fees = Double.parseDouble(f);
		return fees;
	}
}
