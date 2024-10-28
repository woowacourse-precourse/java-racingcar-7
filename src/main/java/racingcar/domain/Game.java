package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Game(Builder builder) {
        if(!roundList.isEmpty()){
            this.roundList = builder.roundList;
        }
        this.roundCount = builder.roundCount;
    }

    private Game() {

    }

    private int id;
    private List<Round> roundList = new ArrayList<>();
    private List<Car> winnerList = new ArrayList<>();
    private int roundCount;

    public int getId() {
        return this.id;
    }

    public Integer getRoundCount(){
        return this.roundCount;
    }

    public List<Round> getRoundList() {
        return this.roundList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWinnerList(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    public void addRound(Round round) {
        if (!roundList.contains(round) && round.getId() != null) {
            roundList.add(round);
        }
    }


    public static class Builder {
        private List<Round> roundList;
        private int roundCount;

        public Builder roundCount(int roundCount) {
            this.roundCount = roundCount;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
