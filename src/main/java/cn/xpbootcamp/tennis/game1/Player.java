package cn.xpbootcamp.tennis.game1;

public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void increaseOne() {
        score++;
    }

    public boolean isTieScore(Player player2) {
        return score == player2.score;
    }

    public boolean isAdvantage(Player player2) {
        return isGreaterThan4Score(player2) && score - player2.getScore() == 1;
    }

    private boolean isGreaterThan4Score(Player player2) {
        return score >= 4 || player2.getScore() >= 4;
    }

    public boolean isWin(Player player2) {
        return isGreaterThan4Score(player2) && score - player2.getScore() >= 2;
    }
}
