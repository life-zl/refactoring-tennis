package cn.xpbootcamp.tennis.game1;

public abstract class AbstractScore {

    public static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    protected Player player1;
    protected Player player2;

    public AbstractScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public abstract boolean isApply();
    public abstract String getScore();

}
