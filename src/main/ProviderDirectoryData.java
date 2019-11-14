package main;

public class ProviderDirectoryData {
	private String[] serviceCodes;
	private String[] serviceNames;
	private float[] serviceFees;
	
	public String getServiceCodes(int i) {
		String codes = serviceCodes[i];
		return codes;
	}
	
	public String getServiceNames(int i) {
		String names = serviceNames[i];
		return names;
	}
	
	public float getServiceFees(int i) {
		float fees = serviceFees[i];
		return fees;
	}
}
