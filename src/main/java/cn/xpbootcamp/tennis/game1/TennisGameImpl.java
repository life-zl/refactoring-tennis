package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGameImpl implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    public static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isTieScore(player1Score, player2Score)) {
            return getTieScore(player1Score);
        }

        if (isScoreGreaterThan4Score(player1Score, player2Score)) {
            return isWinOrAdvantage(player1Score, player2Score);
        }
        return getRegularScore(player1Score, player2Score);
    }

    private String isWinOrAdvantage(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            return "Advantage player1";
        }
        if (minusResult == -1) {
            return "Advantage player2";
        }
        if (minusResult >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
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