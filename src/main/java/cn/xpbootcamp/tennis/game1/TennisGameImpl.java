package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGameImpl implements TennisGame {
    public static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

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
        if (player1.isTieScore(player2)) {
            return getTieScore(player1.getScore());
        }

        if (player1.isPlayerAdvantage(player2)) {
            return "Advantage player1";
        }
        if (player2.isPlayerAdvantage(player1)) {
            return "Advantage player2";
        }
        if (player1.isPlayerWin(player2)) {
            return "Win for player1";
        }

        if (player2.isPlayerWin(player1)) {
            return "Win for player2";
        }
        return getRegularScore(player1.getScore(), player2.getScore());
    }



    private String getRegularScore(int player1Score, int player2Score) {
        return SCORES[player1Score] + "-" + SCORES[player2Score];
    }

    private String getTieScore(int player1Score) {

        return player1Score >= 3 ? "Deuce" : SCORES[player1Score] + "-All";
    }
}