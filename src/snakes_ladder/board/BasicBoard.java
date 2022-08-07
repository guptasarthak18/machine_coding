package snakes_ladder.board;

public class BasicBoard implements Board {
    private int [] blocks;

    public BasicBoard(int total) {
        blocks = new int [total + 1];
    }

    @Override
    public void addSnake(int start, int end) {
        if (start < end || start >= blocks.length)
            throw new RuntimeException("Invalid snake : start = " + start + ", end : " + end);

        blocks[start] = end;
    }

    @Override
    public void addLadder(int start, int end) {
        if (start > end || end >= blocks.length)
            throw new RuntimeException("Invalid ladder : start = " + start + ", end : " + end);

        blocks[start] = end;
    }

    @Override
    public int getFinalPosition(int current, int proposed) {
        if (proposed >= blocks.length) {
            return current;
        }

        while (blocks[proposed] != 0) {
            proposed = blocks[proposed];
        }
        return proposed;
    }
}
