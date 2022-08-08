package splitwise.splitter;

import splitwise.enums.TxSplitTypes;

public class TxSplitterFactory {
    private final ExactTxSplitter exactTxSplitter;
    private final PercentTxSplitter percentTxSplitter;
    private final EqualTxSplitter equalTxSplitter;

    public TxSplitterFactory() {
        exactTxSplitter = new ExactTxSplitter();
        percentTxSplitter = new PercentTxSplitter();
        equalTxSplitter = new EqualTxSplitter();
    }

    public TxSplitter getTxSplitter(TxSplitTypes types) {
        switch (types) {
            case EQUAL:
                return equalTxSplitter;
            case PERCENT:
                return percentTxSplitter;
            case EXACT:
                return exactTxSplitter;
        }
        throw new RuntimeException("Invalid Tx splitter type : " + types);
    }
}
