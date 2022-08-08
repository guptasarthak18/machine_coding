package splitwise.splitter;

import splitwise.model.Transaction;

public class EqualTxSplitter implements TxSplitter {

    @Override
    public Transaction parse(String log) {
        String chunks[] = log.split(" ");

        if (chunks == null)
            throw new RuntimeException("Empty log received");

        if (chunks.length < 7)
            throw new RuntimeException("Invalid log received");

        Transaction transaction = new Transaction(chunks[1], Double.parseDouble(chunks[2]));

        int borrowerCount = Integer.parseInt(chunks[3]);
        double amount = Double.parseDouble(chunks[2]);
        int i = 4;

        while (i < 4 + borrowerCount) {
            transaction.getBorrowerMap().put(chunks[i], amount / borrowerCount);
            i++;
        }

        return transaction;
    }
}
