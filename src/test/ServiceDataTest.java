package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ServiceData;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceDataTest {
	
	ServiceData serviceData;
	
	@BeforeEach
	public void setUp() throws Exception {
		serviceData = new ServiceData();
	}

	@Test
	public void testGetServiceNameforSuccess() {
		serviceData.setServiceName("TEST");
		assertEquals("TEST", serviceData.getServiceName());
	}

	@Test
	public void testSetServiceNameforSuccess() {
		serviceData.setServiceName("Counseling");
		String name = serviceData.getServiceName();
		assertEquals("Counseling", name);
	}

	@Test
	public void testSetServiceCodeforFailure(){
		serviceData.setServiceCode("00000");
		String code = serviceData.getServiceCode();
		String entry = "000000";
		int match = entry.compareTo(code);
		assertEquals(0, match);
	}

}
