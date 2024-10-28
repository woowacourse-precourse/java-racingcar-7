package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private Integer id;
    private List<Car> carList= new ArrayList<>();
    private final int thisRound;
    private int gameId;
    private List<ScoreEntry> scoreBoard = new ArrayList<>();

    private Round(Builder builder) {
        this.thisRound = builder.thisRound;
        this.gameId = builder.gameId;
        if(builder.carList != null) {
            this.carList = builder.carList;
        }

    }

    public Integer getId() {
        return this.id;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addScoreEntry(ScoreEntry scoreEntry) {
        this.scoreBoard.add(scoreEntry);
    }

    public List<ScoreEntry> getScoreBoard(){
        return scoreBoard;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Integer getThisRound() {
        return thisRound;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addCar(Car car) {
        if (!carList.contains(car)) {
            carList.add(car);
        }
    }

    public void addGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public static class Builder {
        private int thisRound;

        private Integer gameId;

        private List<Car> carList;

        public Builder thisRound(int thisRound) {
            this.thisRound = thisRound;
            return this;
        }

        public Builder carList(List<Car> carList){
            this.carList = carList;
            return this;
        }

        public Builder gameId(Integer gameId){
            this.gameId = gameId;
            return this;
        }

        public Round build() {
            return new Round(this);
        }
    }
}

