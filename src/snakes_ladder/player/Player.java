package snakes_ladder.player;

public interface Player {
    void move(int movePositions, int position);
    int getPosition();
    String getName();
}

