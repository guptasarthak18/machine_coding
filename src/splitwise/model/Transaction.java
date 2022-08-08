package splitwise.model;

import java.util.HashMap;
import java.util.Map;

public class Transaction {
    private final String lenderId;
    private final double amountPaid;
    private final Map<String, Double> borrowerMap;

    public Transaction(String lenderId, double amountPaid) {
        this.lenderId = lenderId;
        this.amountPaid = amountPaid;
        this.borrowerMap = new HashMap<>();
    }

    public String getLenderId() {
        return lenderId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public Map<String, Double> getBorrowerMap() {
        return borrowerMap;
    }
}
