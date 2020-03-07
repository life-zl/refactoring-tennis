package cn.xpbootcamp.tennis.game1;

public class TieScore extends AbstractScore {


    public TieScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScore() {
        return player1.getScore() > 2 ? "Deuce" : scores[player1.getScore()] + "-All";
    }

    @Override
    public boolean isApply() {
        return player1.isTieScore(player2);
    }
}
