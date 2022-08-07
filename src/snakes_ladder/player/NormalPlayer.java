package snakes_ladder.player;

public class NormalPlayer implements Player {
    private final String name;
    private int position;

    public NormalPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void move(int movePositions, int position) {
        System.out.println(this.name + " rolled a " + movePositions + " and moved from " + this.position + " to " + position);
        this.position = position;
    }
}
