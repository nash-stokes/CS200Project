package main;

import main.ProviderDirectoryData;
import main.ServiceController;
import main.ProviderController;

public class ProviderTerminal {
  boolean authenticated = false;
  ServiceController sController;
  ProviderController pController;

  void getProviderDirectory() {
    if (authenticated)
      sController.emailPDFFile();
  }

  void manageService() {

  }

  void authenticateProvider() {
    authenticated = pController.validateProvider();
  }
}
