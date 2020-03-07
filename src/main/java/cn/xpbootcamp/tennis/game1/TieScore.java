package cn.xpbootcamp.tennis.game1;

public class TieScore extends AbstractScore {

    public TieScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApply() {
        return this.player1.getScore() == player2.getScore();
    }

    @Override
    public String getScore() {
        int player1Score = player1.getScore();
        return player1Score >= 3 ? "Deuce" : SCORES[player1Score] + "-All";
    }

}
