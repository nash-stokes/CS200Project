package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ServiceController;
import main.ProviderController;
import main.MemberController;
import main.ServiceData;

class AnTest {
	ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>();
	ServiceData service = new ServiceData();
	

  /**
  * use 'test' as the name, street, city, state.
  * use '00000' as the ZIP
  * use '123456788' as the member number
  * use '123456789' as the provider number
  */
  @Test
  void testAddServiceForSuccess() { 
	MemberController.addMember();
	ProviderController.addProvider();
    ServiceController.addService();
    serviceList = ServiceController.getServiceList();
    service = serviceList.get(serviceList.size() - 1);
    assertEquals(service.getServiceCode(), "300000");
  }

	@Test
  void testGetCountForSuccess() {
	//ServiceController.addService();
	serviceList = ServiceController.getServiceList();
    
    int size = ServiceController.getCountServices();
    
    assertEquals(size, 1);
  }
	
	@Test
  void testDeleteMemberForFailure() {
		
  }

}
