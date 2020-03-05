package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

import static cn.xpbootcamp.tennis.PlayerConstants.PLAYER_1_NAME;
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
            score = format("%s-All", getScoreNameByNum(p1Point));
        }
        if (p1Point == p2Point && p1Point >= 3)
            score = "Deuce";

        if (p1Point > 0 && p2Point == 0) {
            p1Result = getScoreNameByNum(p1Point);
            p2Result = "Love";
            score = format("%s-%s", p1Result, p2Result);
        }
        if (p2Point > 0 && p1Point == 0) {
            p2Result = getScoreNameByNum(p2Point);
            p1Result = "Love";
            score = format("%s-%s", p1Result, p2Result);
        }

        if (p1Point > p2Point && p1Point < 4) {
            p1Result = getScoreNameByNum(p1Point);
            p2Result = getScoreNameByNum(p2Point);
            score = format("%s-%s", p1Result, p2Result);
        }
        if (p2Point > p1Point && p2Point < 4) {

            p2Result = getScoreNameByNum(p2Point);
            p1Result = getScoreNameByNum(p1Point);
            score = format("%s-%s", p1Result, p2Result);
        }

        if (p1Point > p2Point && p2Point >= 3) {
            score = "Advantage player1";
        }

        if (p2Point > p1Point && p1Point >= 3) {
            score = "Advantage player2";
        }

        if (p1Point >= 4 && p2Point >= 0 && (p1Point - p2Point) >= 2) {
            score = "Win for player1";
        }
        if (p2Point >= 4 && p1Point >= 0 && (p2Point - p1Point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreNameByNum(int point) {
        switch (point) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
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