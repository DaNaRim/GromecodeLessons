package lesson20.task2;

public class Utils {
    private int limitTransactionsPerDayCount = 10;
    private int limitTransactionPerDayAmount = 100;
    private int limitTransactionAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionPerDayAmount() {
        return limitTransactionPerDayAmount;
    }

    public int getLimitTransactionAmount() {
        return limitTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
