package cn.xpbootcamp.tennis.game1;

public class TieScore extends AbstractScore {

    public TieScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApply() {
        return player1.isTieScore(player2);
    }

    @Override
    public String getScore() {
        int player1Score = player1.getScore();
        return player1Score >= 3 ? "Deuce" : SCORES[player1Score] + "-All";
    }

}
