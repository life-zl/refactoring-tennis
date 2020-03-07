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
        else
            player2.increaseOne();
    }

    public String getScore() {
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        if (isTieScore(player1, player2)) {
            return getTieScore(scores);
        }
        if (isAdvantage(player1, player2)) {
            return "Advantage player1";
        }
        if (isAdvantage(player2, player1)) {
            return "Advantage player2";
        }
        if (isWin(player1, player2)) {
            return "Win for player1";
        }
        if (isWin(player2, player1)) {
            return "Win for player2";
        }
        return getCommonScore(scores);
    }

    private boolean isWin(Player player1, Player player2) {
        return isGreaterThan4Score() && player1.getScore() - player2.getScore() >= 2;
    }

    private boolean isAdvantage(Player player1, Player player2) {
        return isGreaterThan4Score() && player1.getScore() - player2.getScore() == 1;
    }

    private String getTieScore(String[] scores) {
        return player1.getScore() > 2 ? "Deuce" : scores[player1.getScore()] + "-All";
    }

    private String getCommonScore(String[] scores) {
        return scores[player1.getScore()] + "-" + scores[player2.getScore()];
    }

    private boolean isGreaterThan4Score() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private boolean isTieScore(Player player1, Player player2) {
        return player1.getScore() == player2.getScore();
    }

}