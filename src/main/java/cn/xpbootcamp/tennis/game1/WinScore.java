package cn.xpbootcamp.tennis.game1;

public class WinScore extends AbstractScore {


    public WinScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScore() {
        return "Win for " + (player1.isWin(player2) ? player1.getName() : player2.getName());
    }

    @Override
    public boolean isApply() {
        return player1.isWin(player2) || player2.isWin(player1);
    }
}
