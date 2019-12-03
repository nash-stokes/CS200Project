package test;

import static junit.framework.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ServiceData;

public class ServiceDataTest {
	
	ServiceData serviceData;
	
	@BeforeEach
	public void setUp() throws Exception {
		serviceData = new ServiceData();
	}

	@Test
	public void testGetServiceName() {
		serviceData.setServiceName("123123");
		fail("Strings not allowed");
	}

	@Test
	public void testSetServiceName() {
		fail("Not yet implemented"); // TODO
	}

}
