package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

import java.util.Arrays;
import java.util.List;

public class TennisGameImpl implements TennisGame {


    private Player player1;
    private Player player2;


    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getPlayerName()))
            player1.increaseOne();
        else {
            player2.increaseOne();
        }
    }

    public String getScore() {
        List<AbstractScore> scores = Arrays.asList(new TieScore(player1, player2), new AdvantageScore(player1, player2), new WinScore(player1, player2));

        return scores.stream().filter(AbstractScore::isApply).findAny().orElse(new RegularScore(player1, player2)).getScore();

    }


}