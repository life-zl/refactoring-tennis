package cn.xpbootcamp.tennis.game1;

public class WinScore extends AbstractScore {
    public WinScore(Player player) {
        super(player);
    }

    @Override
    public boolean isApply(Player player) {
        return this.player.isPlayerWin(player);
    }

    @Override
    public String getScore() {
        return "Win for " + player.getPlayerName();
    }
}
