package snakes_ladder.dice;

import java.util.Random;

public class BasicDice implements Dice {
    private final int num;
    private final Random random = new Random();

    public BasicDice(int num) {
        this.num = num;
    }

    @Override
    public int roll() {
        return random.nextInt(num) + 1;
    }
}
