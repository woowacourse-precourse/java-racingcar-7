package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private Integer id;
    private List<Car> carList = new ArrayList<>();
    private int thisRound;
    private int gameId;

    private Round(Builder builder) {
        this.thisRound = builder.thisRound;
    }

    public Integer getId() {
        return this.id;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getThisRound() {
        return thisRound;
    }

    public Integer getGameId() {
        return gameId;
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

        public Builder thisRound(int thisRound) {
            this.thisRound = thisRound;
            return this;
        }

        public Round build() {
            return new Round(this);
        }
    }
}

