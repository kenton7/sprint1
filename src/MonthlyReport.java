import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MonthlyReport {

    Scanner scanner = new Scanner(System.in);
    private List<ReportM> reports;

    public static void main(String[] args) {}

    public MonthlyReport(List<ReportM> reports) {
        this.reports = reports;
    }

    public static MonthlyReport fromCSV(String fileName) {
        String[] lines = fileName.split("\\R");
        List<ReportM> reports = new ArrayList<>();
        String mostValuableItem = "";
        int sum = Integer.MIN_VALUE;

        for (int i = 1; i < lines.length; i++) {
            String[] fields = lines[i].split(";");
            String itemName = fields[0];
            boolean isExpense = Boolean.parseBoolean(fields[1]);
            int quantity = Integer.parseInt(fields[2]);
            int sumOfOne = Integer.parseInt(fields[3]);
            int product = quantity * sumOfOne;

            if (!isExpense && product > sum) {
                mostValuableItem = itemName;
                sum = Math.max(sum, product);
            }
        }
        System.out.println("Самый прибыльный товар: " + mostValuableItem + ". Прибыль: " + sum);
        return new MonthlyReport(reports);
    }
}
