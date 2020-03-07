package cn.xpbootcamp.tennis.game1;

public abstract class AbstractScore {

    public static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};


    protected Player player;

    public AbstractScore(Player player) {
        this.player = player;
    }

    public abstract boolean isApply(Player player);
    public abstract String getScore();

}
