package cn.xpbootcamp.tennis.game1;

public class AdvantageScore extends AbstractScore {


    public AdvantageScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScore() {
        return "Advantage " + (player1.isAdvantage(player2) ? player1.getName() : player2.getName());
    }

    @Override
    public boolean isApply() {
        return player1.isAdvantage(player2) || player2.isAdvantage(player1);
    }
}
