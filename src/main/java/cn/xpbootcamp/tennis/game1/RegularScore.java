package cn.xpbootcamp.tennis.game1;

import java.util.Arrays;

public class RegularScore extends AbstractScore {


    public RegularScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApply() {
        return false;
    }

    public String getScore() {
        return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
