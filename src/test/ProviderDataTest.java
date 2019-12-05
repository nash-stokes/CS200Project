package test;

import main.ProviderData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * this tests the provider directory data functions.
 *
 * @author Jonathan Pence
 */
class ProviderDataTest {

  ProviderData providerData;

  @BeforeEach
  public void setUp() throws Exception {
    providerData = new ProviderData();
  }

  @Test
  public void testGetProviderNumberforSuccess() {
    providerData.setProviderNumber("123456789");
    assertEquals("123456789", providerData.getProviderNumber());
  }

  @Test
  public void testSetProviderNumberforSuccess() {
    providerData.setProviderNumber("123456789");
    String number = providerData.getProviderNumber();
    assertEquals("123456789", number);
  }

  @Test
  public void testSetProviderNumberforFailure() {
    providerData.setProviderNumber("12345678");
    String number = providerData.getProviderNumber();
    String entry = "123456789";
    int match = entry.compareTo(number);
    assertEquals(0, match);
  }
}
