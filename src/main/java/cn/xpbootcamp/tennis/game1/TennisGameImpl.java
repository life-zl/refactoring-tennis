package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

import java.util.stream.Stream;

public class TennisGameImpl implements TennisGame {

    private Player player1;
    private Player player2;
    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.increaseOne();
        else {
            player2.increaseOne();
        }
    }

    public String getScore() {

        return Stream.of(new TieScore(player1, player2), new AdvantageScore(player1, player2), new WinScore(player1, player2))
                .filter(AbstractScore::isApply).findAny().orElse(new CommonScore(player1, player2))
                .getScore();
    }

}