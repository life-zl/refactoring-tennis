package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGameImpl implements TennisGame {


    private Player player1;
    private Player player2;



    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getPlayerName()))
            player1.increaseOne();
        else {
            player2.increaseOne();
        }
    }

    public String getScore() {
        if (new TieScore(player1).isApply(player2)) {
            return new TieScore(player1).getScore();
        }
        if (new AdvantageScore(player1).isApply(player2)) {
            return new AdvantageScore(player1).getScore();
        }
        if (new AdvantageScore(player2).isApply(player1)) {
            return new AdvantageScore(player2).getScore();
        }
        if (new WinScore(player1).isApply(player2)) {
            return new WinScore(player1).getScore();
        }

        if (new WinScore(player2).isApply(player1)) {
            return new WinScore(player2).getScore();
        }
        return new RegularScore(player1, player2).getScore();
    }


}