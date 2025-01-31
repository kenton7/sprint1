import javax.xml.xpath.XPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.Year;

public class AutoAccountant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportReader reportReader = new ReportReader();
        List<MonthlyReport> monthlyReports = new ArrayList<>();
        YearlyReport yearlyReport = null;
        boolean isStared = true;
        int currentYear = Year.now().getValue();

        while (isStared) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 — Загрузить месячные отчёты");
            System.out.println("2 — Загрузить годовой отчёт");
            System.out.println("3 — Сверить отчёты");
            System.out.println("4 — Показать месячные отчёты");
            System.out.println("5 — Показать годовой отчёт");
            System.out.println("0 — Выход");

            int userInput = scanner.nextInt();
            System.out.println("Введите год, за который нужны отчёты:");
            int year = scanner.nextInt();
            if (year > currentYear) {
                System.out.println("Год не может быть больше текущего");
                isStared = false;
            }

            switch (userInput) {
                case 1 -> {
                    System.out.println("Введите номера месяцев через запятую:");
                    String month = scanner.next();
                    System.out.println("Загрузка месячных отчётов...");
                    String[] strMonth = month.replace(" ", "").split(",");
                    int[] months = new int[strMonth.length];
                    monthlyReports = reportReader.readMonthlyReport(year, months);
                    isStared = false;
                    break;
                }
                case 2 -> {
                    System.out.println("Загрузка годового отчёта...");
                    isStared = false;
                    break;
                }
                case 3 -> {
                    System.out.println(3);
                    isStared = false;
                    break;
                }
                case 4 -> {
                    System.out.println(4);
                    isStared = false;
                    break;
                }
                case 5 -> {
                    System.out.println(5);
                    isStared = false;
                    break;
                }
                case 0 -> {
                    System.out.println("Выход...");
                    isStared = false;
                    break;
                }
                default -> {
                    System.out.println("Неверная команда.");
                    isStared = false;
                    break;
                }
            }
        }

    }
}

