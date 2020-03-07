package cn.xpbootcamp.tennis.game1;

public class AdvantageScore extends AbstractScore {


    public AdvantageScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApply() {
        return player1.isPlayerAdvantage(player2) || player2.isPlayerAdvantage(player1);
    }

    @Override
    public String getScore() {
        return "Advantage " + (player1.isPlayerAdvantage(player2) ? player1.getPlayerName() : player2.getPlayerName());
    }
}
