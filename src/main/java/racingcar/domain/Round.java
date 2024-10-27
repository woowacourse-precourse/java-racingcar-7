package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private int id;
    private List<Car> carList = new ArrayList<>();
    private int thisRound;
    private Game belongTo;

    private Round(Builder builder) {
        this.id = builder.id;
        this.thisRound = builder.thisRound;
        this.belongTo = builder.belongTo;

        if (!(builder.carList == null)) {
            this.carList = builder.carList;
        }
    }

    public int getId() {
        return this.id;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getThisRound() {
        return thisRound;
    }

    public Game getBelongTo() {
        return belongTo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addCar(Car car) {
        if (!carList.contains(car)) {
            carList.add(car);
        }
    }

    public void setThisRound(int thisRound) {
        this.thisRound = thisRound;
    }

    public static class Builder {
        private int id;
        private List<Car> carList;
        private int thisRound;
        private Game belongTo;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder carList(List<Car> carList) {
            this.carList = carList;
            return this;
        }

        public Builder thisRound(int thisRound) {
            this.thisRound = thisRound;
            return this;
        }

        public Builder belongTo(Game belongTo) {
            this.belongTo = belongTo;
            return this;
        }

        public Round build() {
            return new Round(this);
        }
    }
}

