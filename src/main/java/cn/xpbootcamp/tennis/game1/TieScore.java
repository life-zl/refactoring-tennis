package cn.xpbootcamp.tennis.game1;

public class TieScore extends AbstractScore {


    public TieScore(Player player) {
        super(player);
    }

    @Override
    public boolean isApply(Player player) {
        return this.player.getScore() == player.getScore();
    }

    @Override
    public String getScore() {
        int player1Score = player.getScore();
        return player1Score >= 3 ? "Deuce" : SCORES[player1Score] + "-All";
    }

}
