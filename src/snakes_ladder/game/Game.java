package snakes_ladder.game;

import snakes_ladder.player.Player;

public interface Game {
    void addPlayer(Player player);
    void addLadders(int [][] ladders);
    void addSnakes(int [][] snakes);
    void startGame();
}
