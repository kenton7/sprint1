public class ReportM {
    private String fileName;
    private boolean isExpense;
    private int quantity;
    private int sumOfOne;

    public ReportM(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.fileName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
