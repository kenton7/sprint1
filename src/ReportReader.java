import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReportReader {
    public List<MonthlyReport> readMonthlyReport(int year, int[] months) {
        List<MonthlyReport> monthlyReports = new ArrayList<>();
        String monthName = "";

        for (int month = 1; month <= months.length; month++) {

            switch (month) {
                case 1: monthName = "Январь"; break;
                case 2: monthName = "Февраль"; break;
                case 3: monthName = "Март"; break;
                case 4: monthName = "Апрель"; break;
                case 5: monthName = "Май"; break;
                case 6: monthName = "Июнь"; break;
                case 7: monthName = "Июль"; break;
                case 8: monthName = "Август"; break;
                case 9: monthName = "Сентябрь"; break;
                case 10: monthName = "Октябрь"; break;
                case 11: monthName = "Ноябрь"; break;
                case 12: monthName = "Декабрь"; break;
            }

            String fileName = (month < 10)
                    ? "m." + year + "0" + month + ".csv"
                    : "m." + year + month + ".csv";

            try {
                String fileContents = Files.readString(Path.of("/Users/ilya/Documents/" + fileName));
                System.out.println("Отчет за " + monthName + " месяц:");
                monthlyReports.add(MonthlyReport.fromCSV(fileContents));
                System.out.println("Файл успешно прочитан: " + fileName);
            } catch (Exception e) {
                System.out.println("Ошибка чтения файла: " + fileName);
            }
        }
        return monthlyReports;
    }

    public YearlyReport yearlyReport(int year) {
        String fileName = "y." + year + ".csv";
        try {
            String fileContents = Files.readString(Path.of("/Users/ilya/Documents/" + fileName));
            return YearlyReport.fromCSV(fileContents);
        } catch (Exception e) {
            System.out.println("Ошибка чтения годового отчёта: " + fileName);
            return null;
        }
    }
}
