package cn.xpbootcamp.tennis.game1;

public class Player {
    private String playerName;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void increaseOne() {
        this.score++;
    }

    public boolean isTieScore(Player player) {
        return score == player.getScore();
    }

    public boolean isPlayerWin(Player player) {
        return isScoreGreaterThan4Score(player) && score - player.getScore() >= 2;
    }

    public boolean isPlayerAdvantage(Player player) {
        return isScoreGreaterThan4Score(player) && score - player.getScore() == 1;
    }

    public boolean isScoreGreaterThan4Score(Player player) {
        return score >= 4 || player.getScore() >= 4;
    }
}
