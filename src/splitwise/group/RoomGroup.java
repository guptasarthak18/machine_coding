package splitwise.group;

import splitwise.model.Transaction;
import splitwise.model.User;

import java.util.HashMap;
import java.util.Map;

public class RoomGroup implements SplitwiseGroup {
    private final Map<String, User> userMap;
    private final Map<String, Map<String, Double>> txGraph;

    public RoomGroup() {
        userMap = new HashMap<>();
        txGraph = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
        txGraph.put(user.getId(), new HashMap<>());
    }

    @Override
    public void addTransaction(Transaction transaction) {
        for (Map.Entry<String, Double> borrower : transaction.getBorrowerMap().entrySet()) {
            String borrowerId = borrower.getKey();
            String lenderId = transaction.getLenderId();

            if (borrowerId.equals(lenderId))
                continue;

            double totalBorrowersDept = borrower.getValue();

            if (txGraph.get(borrowerId).containsKey(lenderId)) {
                double currentDebt = txGraph.get(borrowerId).get(lenderId);
                totalBorrowersDept += currentDebt;
            }

            double lendersDept = 0;

            if (txGraph.get(lenderId).containsKey(borrowerId)) {
                lendersDept = txGraph.get(lenderId).get(borrowerId);
            }

            if (lendersDept == 0) {
                txGraph.get(borrowerId).put(lenderId, totalBorrowersDept);
                continue;
            }

            if (totalBorrowersDept > lendersDept) {
                txGraph.get(borrowerId).put(lenderId, totalBorrowersDept - lendersDept);
                txGraph.get(lenderId).put(borrowerId, 0.0);
                continue;
            }

            txGraph.get(borrowerId).put(lenderId, 0.0);
            txGraph.get(lenderId).put(borrowerId, lendersDept - totalBorrowersDept);
        }
    }

    @Override
    public void showById(String userId) {
        int pc = 0;

        for (Map.Entry<String, Double> debt : txGraph.get(userId).entrySet()) {
            if (debt.getValue() > 0) {
                System.out.println(userMap.get(userId).getName() + " owes " + userMap.get(debt.getKey()).getName() + ": " + debt.getValue());
                pc++;
            }
        }

        for (Map.Entry<String, Map<String, Double>> debt : txGraph.entrySet()) {
            if (debt.getValue().containsKey(userId) && debt.getValue().get(userId) > 0) {
                System.out.println(userMap.get(debt.getKey()).getName() + " owes " + userMap.get(userId).getName() + ": " +
                        debt.getValue().get(userId));
                pc++;
            }
        }

        if (pc == 0)
            System.out.println("No balances");
    }

    @Override
    public void showAll() {
        int pc = 0;

        for (Map.Entry<String, Map<String, Double>> debt : txGraph.entrySet()) {
            for (Map.Entry<String, Double> userDept : debt.getValue().entrySet()) {
                if (userDept.getValue() > 0) {
                    System.out.println(userMap.get(debt.getKey()).getName() + " owes " +
                            userMap.get(userDept.getKey()).getName() + ": " +
                            userDept.getValue());
                    pc++;
                }
            }
        }

        if (pc == 0)
            System.out.println("No balances");
    }
}
