import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YearlyReport {

    String fileContents;
    ArrayList<String[]> parsedLines = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    int currentYear = Year.now().getValue();
    private List<ReportY> reports;

    public YearlyReport(List<ReportY> reports) {
        this.reports = reports;
    }

    public static void main(String[] args) {
    }

    public static YearlyReport fromCSV(String fileName) {
        String[] lines = fileName.split(";");
        List<ReportY> reports = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String[] filelds = lines[i].split(";");
            String month = filelds[0];
            int amount = Integer.parseInt(filelds[1]);
            boolean isExpense = Boolean.parseBoolean(filelds[2]);
            reports.add(new ReportY(month, amount, isExpense));
        }
        return new YearlyReport(reports);
    }

    void getYearlyReport() {
        scanner = new Scanner(System.in);
        System.out.println("Выберите следующее действие:");
        System.out.println("1. Ввести год, за который нужно получить отчёт.");
        System.out.println("0. Вернуться назад.");
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            System.out.println("Введите год:");
            int year = scanner.nextInt();
            if (year > currentYear) {
                System.out.println("Год не может быть больше текущего.");
            } else {
                fileContents = readFileContentsOrNull("/Users/ilya/Documents/y." + year + ".csv");
            }
            if (fileContents != null) {
                String[] lines = fileContents.split("\\n");
                for (int line = 1; line < lines.length; line++) {
                    String[] lineContents = lines[line].trim().split(";");
                    parsedLines.add(lineContents);

                }
            }
        } else {
            AutoAccountant autoAccountant = new AutoAccountant();
            autoAccountant.main(null);
        }
    }

    String readFileContentsOrNull(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (Exception e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом.");
            System.out.println("Возможно, указано не верное имя файла или его расширение не .csv");
            System.out.println("Или файл с отчётом за данный месяц не найден.");
            return null;
        }
    }
}
