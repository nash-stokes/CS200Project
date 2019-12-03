package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ServiceController;
import main.ServiceData;

class AnTest {
	ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>();
	ServiceData service = new ServiceData();
	
	/**
	 * use 'test' as the name, street, city, state.
	 * use '00000' as the ZIP
	 * use '000000000' as the member number
	 */
  @Test
  void testAddServiceForSuccess() { 
    ServiceController.addService();
    serviceList = ServiceController.getServiceList();
    service = serviceList.get(serviceList.size() - 1);
    assertEquals(service.getServiceCode(), "test");
  }

  /**
	 * use 'test' as the name, street, city, state.
	 * use '00000' as the ZIP
	 * use '000000000' as the member number
	 */
	@Test
  void testGetCountForSuccess() {
	ServiceController.addService();
	serviceList = ServiceController.getServiceList();
    
    int size = ServiceController.getCountServices();
    
    assertNotEquals(size, 1);
  }
	
	@Test
  void testDeleteMemberForFailure() {
		
  }

}
