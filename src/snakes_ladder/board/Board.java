package snakes_ladder.board;

public interface Board {
    void addSnake(int start, int end);
    void addLadder(int start, int end);
    int getFinalPosition(int current, int proposed);
}
