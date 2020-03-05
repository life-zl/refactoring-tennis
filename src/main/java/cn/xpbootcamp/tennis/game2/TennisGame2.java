package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

import static cn.xpbootcamp.tennis.PlayerConstants.PLAYER_1_NAME;
import static cn.xpbootcamp.tennis.game2.ScoreConstants.*;
import static cn.xpbootcamp.tennis.game2.ScoreConstants.SCORE_S_S;
import static java.lang.String.*;

public class TennisGame2 implements TennisGame {
    public int p1Point = 0;
    public int p2Point = 0;

    public String p1Result = "";
    public String p2Result = "";

    public TennisGame2() {
    }

    public String getScore() {
        String score = "";
        if (p1Point == p2Point && p1Point < 4) {
            score = format(SCORE_S_ALL, getScoreNameByNum(p1Point));
        }
        if (p1Point == p2Point && p1Point >= 3)
            score = "Deuce";

        if (isScoreAll(p1Point, p2Point)) {
            score = format(SCORE_S_ALL, getScoreNameByNum(p1Point));
        }
        if (isScoreAll(p2Point, p1Point)) {
            score = format(SCORE_S_ALL, getScoreNameByNum(p2Point));
        }
        if (isCommonScore(p1Point, p2Point)) {
            p1Result = getScoreNameByNum(p1Point);
            p2Result = getScoreNameByNum(p2Point);
            score = format(SCORE_S_S, p1Result, p2Result);
        }

        if (isAdvantage(p1Point, p2Point)) {
            score = "Advantage player1";
        }

        if (isAdvantage(p2Point, p1Point)) {
            score = "Advantage player2";
        }

        if (isPlayerWin(p1Point, p2Point)) {
            score = "Win for player1";
        }
        if (isPlayerWin(p2Point, p1Point)) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isCommonScore(int p1Point, int p2Point) {
        return p1Point > p2Point || p2Point > p1Point && p2Point < 4;
    }

    private boolean isPlayerWin(int p1Point, int p2Point) {
        return p1Point >= 4 && p2Point >= 0 && (p1Point - p2Point) >= 2;
    }

    private boolean isScoreAll(int p1Point, int p2Point) {
        return p1Point > 0 && p2Point == 0;
    }

    private boolean isAdvantage(int p1Point, int p2Point) {
        return p1Point > p2Point && p2Point >= 3;
    }

    private String getScoreNameByNum(int point) {
        switch (point) {
            case 0:
                return SCORE_LOVE;
            case 1:
                return SCORE_FIFTEEN;
            case 2:
                return SCORE_THIRTY;
            case 3:
                return SCORE_FORTY;
        }
        return "";
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER_1_NAME))
            p1Point++;
        else
            p2Point++;
    }
}