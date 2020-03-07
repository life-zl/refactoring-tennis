package cn.xpbootcamp.tennis.game1;

import java.util.Arrays;

public class RegularScore{

    private Player player1;
    private Player player2;

    public RegularScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
