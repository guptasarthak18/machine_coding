package splitwise;

import splitwise.enums.TxSplitTypes;
import splitwise.group.RoomGroup;
import splitwise.group.SplitwiseGroup;
import splitwise.model.User;
import splitwise.splitter.TxSplitter;
import splitwise.splitter.TxSplitterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    static void addUsers(SplitwiseGroup group) {
        group.addUser(new User("u1", "User1", "email", 99999999));
        group.addUser(new User("u2", "User2", "email", 99999999));
        group.addUser(new User("u3", "User3", "email", 99999999));
        group.addUser(new User("u4", "User4", "email", 99999999));
    }

    static TxSplitTypes getSplitType(String input) {
        String chunks [] = input.split(" ");
        int index =  4 + Integer.parseInt(chunks[3]);
        return TxSplitTypes.valueOf(chunks[index]);
    }

    public static void main(String[] args) throws IOException {
        SplitwiseGroup group = new RoomGroup();
        addUsers(group);
        TxSplitterFactory factory = new TxSplitterFactory();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if(input.equals("SHOW")) {
                group.showAll();
                continue;
            }

            if (input.startsWith("SHOW")) {
                String chunks [] = input.split(" ");
                group.showById(chunks[1]);
            }

            if (input.startsWith("EXPENSE")) {
                TxSplitter txSplitter = factory.getTxSplitter(getSplitType(input));
                group.addTransaction(txSplitter.parse(input));
            }
        }
    }
}
