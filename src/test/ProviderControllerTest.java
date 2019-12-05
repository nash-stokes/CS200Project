package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.ProviderController;
import main.ProviderData;
import org.junit.jupiter.api.Test;

/** This tests cases for provider controller.
 * @author Simon Jeon
 */

class ProviderControllerTest {

  ArrayList<ProviderData> providerList = new ArrayList<ProviderData>();
  ProviderData provider = new ProviderData();

  /**
  * use 'test' as the name, street, city, state.
  * use '00000' as the ZIP.
  * use '000000000' as the provider number.
  */
  @Test
  void testAddProviderForSuccess() { 
    ProviderController.addProvider();
    providerList = ProviderController.getProviderList();
    provider = providerList.get(providerList.size() - 1);
    assertEquals(provider.getName(), "test");
  }

  /** use 'first' as the name, street, city for the first provider.
  * use 'second as the name, street, city for the second provider.
  * use 'AL' as the state.
  * use '00000' as the ZIP.
  * use '000000000' as the first provider number.
  * use '123456789' as the second provider number.
  * delete the first provider (000000000).
  */
  @Test
  void testDeleteProviderForSuccess() {
    ProviderController.addProvider();
    ProviderController.addProvider();
    ProviderController.deleteProvider();
    
    providerList = ProviderController.getProviderList();
    String name = providerList.get(0).getName();
 
    assertEquals(name, "second");
  }

  @Test
  void testDeleteProviderForFailure() {
    ProviderController.addProvider();
    int sizeBeforeDelete = ProviderController.getProviderList().size();
    
    ProviderController.deleteProvider();
    int sizeAfterDelete = ProviderController.getProviderList().size();
    
    assertNotEquals(sizeBeforeDelete, sizeAfterDelete);
  }

}
