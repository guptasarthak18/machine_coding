package splitwise.group;

import splitwise.model.Transaction;
import splitwise.model.User;

public interface SplitwiseGroup {
    void addUser(User user);
    void addTransaction(Transaction transaction);
    void showById(String userId);
    void showAll();
}
