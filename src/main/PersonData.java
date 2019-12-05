package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The PersonData class stores attributes that are shared between members and providers.
 *
 * @author Erik Jones
 */
public class PersonData {
  /** Scanner that will be called if the user needs to re-input parameters. */
  Scanner scanner = new Scanner(System.in); // Scanner used to allow user to re-input fields
  /** Regex equation used to check if a String contains only letters and spaces. */
  Pattern onlyLetters = Pattern.compile("^[ A-Za-z]+$");
  Matcher lettersMatch;
  /** Regex equation used to check if a String contains only numbers. */
  Pattern onlyNums = Pattern.compile("[0-9]+");
  Matcher numsMatch;
  /** the name of the provider or member. */
  private String name;
  /** the street address of the provider or member. */
  private String street;
  /** the city of the provider or member. */
  private String city;
  /** the state of the provider or member. */
  private String state;
  /** the zip code of the provider or member. */
  private String ZIP;
  /** the status of the provider or member */
  private boolean status = false;
  /** List of services for the provider or member. */
  private ArrayList<ServiceData> serviceList = new ArrayList<ServiceData>();

  /** Default contructor with no paramters. */
  public PersonData() {}

  /**
   * Parameterized constructor.
   *
   * @param name the name of the provider or member
   * @param street the street address of the provider or member
   * @param city the city of the provider or member
   * @param state the state of the provider or member
   * @param ZIP the zip code of the provider or member
   */
  public PersonData(String name, String street, String city, String state, String ZIP) {
    setName(name);
    setStreet(street);
    setCity(city);
    setState(state);
    setZIP(ZIP);
  }

  /**
   * getter for name.
   *
   * @return name of the given instance
   */
  public String getName() {
    return name;
  }
  /**
   * setter for name will prompt user to re-enter if given value isn't in the correct format.
   *
   * @param name the value name is to be set to
   */
  public void setName(String name) {
    while (true) {
      lettersMatch = onlyLetters.matcher(name);
      if (name.length() > 25 || !lettersMatch.matches()) {
        System.out.print("Invalid name, please enter a valid name: ");
        name = scanner.nextLine();
      } else {
        break;
      }
    }
    this.name = name;
  }

  /**
   * getter for street.
   *
   * @return street address of the given instance
   */
  public String getStreet() {
    return street;
  }

  /**
   * setter for street. will prompt user to re-enter if given value isn't in the correct format
   *
   * @param street the value street is to be set to
   */
  public void setStreet(String street) {
    while (street.length() > 25) {
      System.out.print("Invalid street address, please enter a valid address: ");
      street = scanner.nextLine();
    }
    this.street = street;
  }

  /**
   * getter for city.
   *
   * @return city of the given instance
   */
  public String getCity() {
    return city;
  }

  /**
   * setter for city. will prompt user to re-enter if given value isn't in the correct format
   *
   * @param city the value city is to be set to
   */
  public void setCity(String city) {
    while (true) {
      lettersMatch = onlyLetters.matcher(city);
      if (city.length() > 14 || lettersMatch.matches() == false) {
        System.out.print("Invalid city, please enter a valid city: ");
        city = scanner.nextLine();
      } else {
        break;
      }
    }
    this.city = city;
  }

  /**
   * getter for state.
   *
   * @return state of the given instance
   */
  public String getState() {
    return state;
  }

  /**
   * setter for state. will prompt user to re-enter if given value isn't in the correct format
   *
   * @param state the value state is to be set to
   */
  public void setState(String state) {
    while (true) {
      lettersMatch = onlyLetters.matcher(state);
      if (state.length() > 2 || lettersMatch.matches() == false) {
        System.out.print("Invalid state, please enter a valid state: ");
        state = scanner.nextLine();
      } else {
        break;
      }
    }
    this.state = state;
  }

  /**
   * getter for ZIP.
   *
   * @return zip code of the given instance
   */
  public String getZIP() {
    return ZIP;
  }

  /**
   * setter for ZIP. will prompt user to re-enter if given value isn't in the correct format
   *
   * @param ZIP the value ZIP is to be set to
   */
  public void setZIP(String ZIP) {
    while (true) {
      numsMatch = onlyNums.matcher(ZIP);
      if (ZIP.length() != 5 || numsMatch.matches() == false) {
        System.out.print("Invalid ZIP, please enter a valid ZIP: ");
        ZIP = scanner.nextLine();
      } else {
        break;
      }
    }
    this.ZIP = ZIP;
  }

  /** setter for status. */
  public void toggleStatus() {
    status = !status;
  }

  public boolean getStatus() {
    return status;
  }

  /**
   * getter for serviceList.
   *
   * @return the service list of the given instance
   */
  public ArrayList<ServiceData> getServiceList() {
    return serviceList;
  }

  /** Add a service to serviceList. */
  public void addService(ServiceData sdata) {
    serviceList.add(sdata);
  }
}
