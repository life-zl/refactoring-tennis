package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

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
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        if (player1.isTieScore(player2)) {
            return getTieScore(scores);
        }
        if (player1.isAdvantage(player2)) {
            return "Advantage player1";
        }
        if (player2.isAdvantage(player1)) {
            return "Advantage player2";
        }
        if (player1.isWin(player2)) {
            return "Win for player1";
        }
        if (player2.isWin(player1)) {
            return "Win for player2";
        }
        return getCommonScore(scores);
    }

    private String getTieScore(String[] scores) {
        return player1.getScore() > 2 ? "Deuce" : scores[player1.getScore()] + "-All";
    }

    private String getCommonScore(String[] scores) {
        return scores[player1.getScore()] + "-" + scores[player2.getScore()];
    }

}