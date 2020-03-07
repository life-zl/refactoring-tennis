package cn.xpbootcamp.tennis.game1;

public class CommonScore extends AbstractScore {


    public CommonScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScore() {
        return scores[player1.getScore()] + "-" + scores[player2.getScore()];
    }

    @Override
    public boolean isApply() {
        return false;
    }
}
