package cn.xpbootcamp.tennis.game1;

import java.util.Arrays;

public enum ScoreEnum {
    SCORE_ZERO(0,"Love", "Love-All"),
    SCORE_ONE(1,"Fifteen", "Fifteen-All"),
    SCORE_TWO(2,"Thirty", "Thirty-All"),
    SCORE_THREE(3,"Forty", "Deuce");

    private int score;
    private String name;
    private String tieName;

    ScoreEnum(int score, String name, String tieName) {
        this.score = score;
        this.name = name;
        this.tieName = tieName;
    }

    public String getName() {
        return name;
    }

    public String getTieName() {
        return tieName;
    }

    public static String getNameByScore(int score) {
        ScoreEnum[] values = ScoreEnum.values();
        return Arrays.stream(values).filter(x -> score == x.score).findFirst().map(ScoreEnum::getName).orElse("");
    }

    public static String getTieNameByScore(int score) {
        ScoreEnum[] values = ScoreEnum.values();
        return Arrays.stream(values).filter(x -> score == x.score).findFirst().map(ScoreEnum::getTieName).orElse("Deuce");
    }



}
