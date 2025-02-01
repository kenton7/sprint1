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

//    public YearlyReport(List<ReportY> reports) {
//        this.reports = reports;
//    }

    public static void main(String[] args) {
    }

    public static ReportY fromCSV(String fileName) {
        String[] lines = fileName.split("\\R");
        ReportY report = new ReportY();
        double sumForRashod = 0;
        int counterForRashod = 0;
        double sumForDohod = 0;
        int counterForDohod = 0;

        for (int i = 1; i < lines.length; i++) {
            String[] currentFields = lines[i].split(";");
            int currentAmount = Integer.parseInt(currentFields[1]);
            String currentMonth = currentFields[0];

            if (i < lines.length - 1) {
                String[] nextFields = lines[i + 1].split(";");
                if (currentFields[0].equals(nextFields[0])) {
                    int nextAmount = Integer.parseInt(nextFields[1]);
                    int difference = currentAmount - nextAmount;
                    System.out.println("Разница между текущим и следующим значением: " + difference);
                }
            }

            if (currentFields[2].equals("true")) {
                counterForRashod++;
                sumForRashod += currentAmount;
            } else {
                counterForDohod++;
                sumForDohod += currentAmount;
            }
        }
        double averageRashod = sumForRashod / counterForRashod;
        double averageDohod = sumForDohod / counterForDohod;
        System.out.println("Средний расход за все месяцы в году: " + averageRashod);
        System.out.println("Средний доход за все месяцы в году: " + averageDohod);
        return report;
    }
}
