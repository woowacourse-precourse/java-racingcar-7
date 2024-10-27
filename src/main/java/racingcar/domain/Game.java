package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Game(Builder builder) {
        this.roundList = builder.roundList;
        this.roundCount = builder.roundCount;
        this.winner = builder.winner;
    }

    public Game() {

    }

    private int id;
    private List<Round> roundList = new ArrayList<>();
    private Car winner;
    private int roundCount;

    public int getId() {
        return this.id;
    }

    public List<Round> getRoundList() {
        return this.roundList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addRound(Round round) {
        if (!roundList.contains(round) && round.getId() != null) {
            roundList.add(round);
        }
    }


    public static class Builder {
        private int id;
        private List<Round> roundList;
        private Car winner;
        private int roundCount;

        public Builder roundList(List<Round> roundList) {
            this.roundList = roundList;
            return this;
        }

        public Builder winner(Car winner) {
            this.winner = winner;
            return this;
        }

        public Builder roundCount(int roundCount) {
            this.roundCount = roundCount;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
