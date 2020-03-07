package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGameImpl implements TennisGame {

    private Player player1;
    private Player player2;


    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getPlayerName()))
            player1.increaseOne();
        else {
            player2.increaseOne();
        }
    }

    public String getScore() {
        if (isTieScore(player1.getScore(), player2.getScore())) {
            return getTieScore(player1.getScore());
        }

        if (isPlayerAdvantage(player1.getScore(), player2.getScore())) {
            return "Advantage player1";
        }
        if (isPlayerAdvantage(player2.getScore(), player1.getScore())) {
            return "Advantage player2";
        }
        if (isPlayerWin(player1.getScore(), player2.getScore())) {
            return "Win for player1";
        }

        if (isPlayerWin(player2.getScore(), player1.getScore())) {
            return "Win for player2";
        }
        return getRegularScore(player1.getScore(), player2.getScore());
    }

    private boolean isPlayerWin(int player1Score, int player2Score) {
        return isScoreGreaterThan4Score(player1Score, player2Score) && player1Score - player2Score >= 2;
    }

    private boolean isPlayerAdvantage(int player1Score, int player2Score) {
        return isScoreGreaterThan4Score(player1Score, player2Score) && player1Score - player2Score == 1;
    }

    private boolean isScoreGreaterThan4Score(int player1Score, int player2Score) {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isTieScore(int player1Score, int player2Score) {
        return player1Score == player2Score;
    }

    private String getRegularScore(int player1Score, int player2Score) {
        return SCORES[player1Score] + "-" + SCORES[player2Score];
    }

    private String getTieScore(int player1Score) {

        return player1Score >= 3 ? "Deuce" : SCORES[player1Score] + "-All";
    }
}