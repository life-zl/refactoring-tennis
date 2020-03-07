package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGameImpl implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

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

        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        if (isTieScore(player1Score, player2Score)) {
            return getTieScore(scores);
        }
        if (isAdvantage(player1Score, player2Score)) {
            return "Advantage player1";
        }
        if (isAdvantage(player2Score, player1Score)) {
            return "Advantage player2";
        }
        if (isWin(player1Score, player2Score)) {
            return "Win for player1";
        }
        if (isWin(player2Score, player1Score)) {
            return "Win for player2";
        }
        return getCommonScore(scores);
    }

    private boolean isWin(int player1Score, int player2Score) {
        return isGreaterThan4Score() && player1Score - player2Score >= 2;
    }

    private boolean isAdvantage(int player1Score, int player2Score) {
        return isGreaterThan4Score() && player1Score - player2Score == 1;
    }

    private String getTieScore(String[] scores) {
        return player1Score > 2 ? "Deuce" : scores[player1Score] + "-All";
    }

    private String getCommonScore(String[] scores) {
        return scores[player1Score] + "-" + scores[player2Score];
    }

    private boolean isGreaterThan4Score() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isTieScore(int player1Score, int player2Score) {
        return player1Score == player2Score;
    }

}