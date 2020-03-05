package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

import static cn.xpbootcamp.tennis.PlayerConstants.PLAYER_1_NAME;

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
            if (p1Point == 0)
                score = "Love";
            if (p1Point == 1)
                score = "Fifteen";
            if (p1Point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (p1Point == p2Point && p1Point >= 3)
            score = "Deuce";

        if (p1Point > 0 && p2Point == 0) {
            String score1;
            if (p1Point == 1)
                p1Result = "Fifteen";
            if (p1Point == 2)
                p1Result = "Thirty";
            if (p1Point == 3)
                p1Result = "Forty";

            p2Result = "Love";
            score1 = p1Result + "-" + p2Result;
            score = score1;
        }
        if (p2Point > 0 && p1Point == 0) {
            String score1;
            if (p2Point == 1)
                p2Result = "Fifteen";
            if (p2Point == 2)
                p2Result = "Thirty";
            if (p2Point == 3)
                p2Result = "Forty";

            p1Result = "Love";
            score1 = p1Result + "-" + p2Result;
            score = score1;
        }

        if (p1Point > p2Point && p1Point < 4) {
            if (p1Point == 2)
                p1Result = "Thirty";
            if (p1Point == 3)
                p1Result = "Forty";
            if (p2Point == 1)
                p2Result = "Fifteen";
            if (p2Point == 2)
                p2Result = "Thirty";
            score = p1Result + "-" + p2Result;
        }
        if (p2Point > p1Point && p2Point < 4) {
            if (p2Point == 2)
                p2Result = "Thirty";
            if (p2Point == 3)
                p2Result = "Forty";
            if (p1Point == 1)
                p1Result = "Fifteen";
            if (p1Point == 2)
                p1Result = "Thirty";
            score = p1Result + "-" + p2Result;
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

    public void wonPoint(String player) {
        if (player.equals(PLAYER_1_NAME))
            p1Point++;
        else
            p2Point++;
    }
}