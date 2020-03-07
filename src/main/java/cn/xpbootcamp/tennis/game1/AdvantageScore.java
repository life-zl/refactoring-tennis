package cn.xpbootcamp.tennis.game1;

public class AdvantageScore extends AbstractScore {


    public AdvantageScore(Player player) {
        super(player);
    }

    @Override
    public boolean isApply(Player player) {
        return this.player.isPlayerAdvantage(player);
    }

    @Override
    public String getScore() {
        return "Advantage " + player.getPlayerName();
    }
}
