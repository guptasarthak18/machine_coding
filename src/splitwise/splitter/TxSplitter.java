package splitwise.splitter;

import splitwise.model.Transaction;

public interface TxSplitter {
    Transaction parse(String log);
}
