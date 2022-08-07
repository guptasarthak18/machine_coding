package snakes_ladder.game;

import snakes_ladder.board.BasicBoard;
import snakes_ladder.board.Board;
import snakes_ladder.dice.BasicDice;
import snakes_ladder.dice.Dice;
import snakes_ladder.player.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicGame implements Game {
    private final List<Player> players = new LinkedList<>();
    private final Board board;
    private final Dice dice = new BasicDice(6);
    private static final int WINNING_POSITION = 100;
    private boolean isOver = false;

    public BasicGame() {
        board = new BasicBoard(100);
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void addLadders(int[][] ladders) {
        Arrays.stream(ladders).forEach(ladder -> board.addLadder(ladder[0], ladder[1]));
    }

    @Override
    public void addSnakes(int[][] snakes) {
        Arrays.stream(snakes).forEach(snake -> board.addSnake(snake[0], snake[1]));
    }

    @Override
    public void startGame() {
        while (!isOver) {
            for (Player player : players) {
                int movePositions = dice.roll();
                int proposedPositon = player.getPosition() + movePositions;
                int finalPosition = board.getFinalPosition(player.getPosition(), proposedPositon);
                player.move(movePositions, finalPosition);
                if (finalPosition == WINNING_POSITION) {
                    System.out.println(player.getName() + " wins the game");
                    isOver = true;
                    break;
                }
            }
        }
    }
}
