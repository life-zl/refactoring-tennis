package cn.xpbootcamp.tennis;


import cn.xpbootcamp.tennis.game1.TennisGameImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

class TennisGameTest {
    public static final String PLAYER_1_NAME = "player1";
    public static final String PLAYER_2_NAME = "player2";
    private int player1Score;
    private int player2Score;
    private String expectedScore;


    static class ScoreItem{
        private int player1Score;
        private int player2Score;
        private String score;


        public ScoreItem(int player1Score, int player2Score, String score) {
            this.player1Score = player1Score;
            this.player2Score = player2Score;
            this.score = score;
        }

        public static ScoreItem create(int player1Score, int player2Score, String score){
            return new ScoreItem(player1Score, player2Score, score);
        }

    }

    public static Stream<ScoreItem> getAllScores() {
        return Stream.of(
                ScoreItem.create(0, 0, "Love-All"),
                ScoreItem.create(1, 1, "Fifteen-All"),
                ScoreItem.create(2, 2, "Thirty-All"),
                ScoreItem.create(3, 3, "Deuce"),
                ScoreItem.create(4, 4, "Deuce"),

                ScoreItem.create(1, 0, "Fifteen-Love"),
                ScoreItem.create(0, 1, "Love-Fifteen"),
                ScoreItem.create(2, 0, "Thirty-Love"),
                ScoreItem.create(0, 2, "Love-Thirty"),
                ScoreItem.create(3, 0, "Forty-Love"),
                ScoreItem.create(0, 3, "Love-Forty"),
                ScoreItem.create(4, 0, "Win for player1"),
                ScoreItem.create(0, 4, "Win for player2"),

                ScoreItem.create(2, 1, "Thirty-Fifteen"),
                ScoreItem.create(1, 2, "Fifteen-Thirty"),
                ScoreItem.create(3, 1, "Forty-Fifteen"),
                ScoreItem.create(1, 3, "Fifteen-Forty"),
                ScoreItem.create(4, 1, "Win for player1"),
                ScoreItem.create(1, 4, "Win for player2"),

                ScoreItem.create(3, 2, "Forty-Thirty"),
                ScoreItem.create(2, 3, "Thirty-Forty"),
                ScoreItem.create(4, 2, "Win for player1"),
                ScoreItem.create(2, 4, "Win for player2"),

                ScoreItem.create(4, 3, "Advantage player1"),
                ScoreItem.create(3, 4, "Advantage player2"),
                ScoreItem.create(5, 4, "Advantage player1"),
                ScoreItem.create(4, 5, "Advantage player2"),
                ScoreItem.create(15, 14, "Advantage player1"),
                ScoreItem.create(14, 15, "Advantage player2"),

                ScoreItem.create(6, 4, "Win for player1"),
                ScoreItem.create(4, 6, "Win for player2"),
                ScoreItem.create(16, 14, "Win for player1"),
                ScoreItem.create(14, 16, "Win for player2"));
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame1(ScoreItem scoreItem) {
        TennisGameImpl game = new TennisGameImpl(PLAYER_1_NAME, PLAYER_2_NAME);

        int highestScore = Math.max(scoreItem.player1Score, scoreItem.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < scoreItem.player1Score) {
                game.wonPoint(PLAYER_1_NAME);
            }
            if (i < scoreItem.player2Score) {
                game.wonPoint(PLAYER_2_NAME);
            }
        }
        assertEquals(scoreItem.score, ((TennisGame) game).getScore());
    }

}