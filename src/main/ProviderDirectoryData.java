package main;

import java.io.*;
import java.util.ArrayList;

public class ProviderDirectoryData {
	private static final ArrayList<String> serviceCodes = new ArrayList<String>();
	private static final ArrayList<String> serviceNames = new ArrayList<String>();
	private static final ArrayList<Double> serviceFees = new ArrayList<Double>();
	private String codes;
	private String names;
	private double fees;

	public void readFile() throws IOException{
		File file =  new File("ProviderDirectory.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
			
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
		fees = serviceFees.get(i);
		return fees;
	}
}
