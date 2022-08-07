package snakes_ladder;

import snakes_ladder.dice.BasicDice;
import snakes_ladder.dice.Dice;
import snakes_ladder.game.BasicGame;
import snakes_ladder.game.Game;
import snakes_ladder.player.NormalPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c1 = Integer.parseInt(br.readLine());
        int [][] snakes = new int [c1][2];
        for (int i = 0; i < c1; i++) {
            String s1 = br.readLine();
            String arr[] = s1.split(" ");
            snakes[i][0] = Integer.parseInt(arr[0]);
            snakes[i][1] = Integer.parseInt(arr[1]);
        }

        int c2 = Integer.parseInt(br.readLine());
        int [][] ladders = new int [c2][2];
        for (int i = 0; i < c2; i++) {
            String s1 = br.readLine();
            String arr[] = s1.split(" ");
            ladders[i][0] = Integer.parseInt(arr[0]);
            ladders[i][1] = Integer.parseInt(arr[1]);
        }

        Game game = new BasicGame();
        game.addLadders(ladders);
        game.addSnakes(snakes);

        int c3 = Integer.parseInt(br.readLine());

        for (int i = 0; i < c3; i++) {
            String s1 = br.readLine();
            game.addPlayer(new NormalPlayer(s1));
        }

        game.startGame();
    }
}
