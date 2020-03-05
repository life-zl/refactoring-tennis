package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

import static cn.xpbootcamp.tennis.PlayerConstants.PLAYER_1_NAME;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1_NAME))
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        if (mScore1 == mScore2) {
            return ScoreEnum.getTieNameByScore(mScore1);
        }
        if (mScore1 >= 4 || mScore2 >= 4) {
            return showMoreThan4Scores();
        } else {
            return showCommonScore(ScoreEnum.getNameByScore(mScore1),
                    ScoreEnum.getNameByScore(mScore2));
        }
    }

    private String showMoreThan4Scores() {
        int minusResult = mScore1 - mScore2;
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

    private String showCommonScore(String score1, String score2) {
        return score1 + "-" + score2;
    }

}