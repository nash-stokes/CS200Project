package main;

import main.ReportController;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class MainAccountingController {
  ReportController reportController;

  void getWeeklyReport() {
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();
    DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
    if ((dayOfWeek.getValue() == 5) && (localTime.getHour() == 0)) {
      reportController.generateAccountsPayable();
      reportController.generateEFTFile();
      reportController.generateMemberReport();
      reportController.generateProviderReport();
    }
  }
}
