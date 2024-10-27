package racingcar.domain;

import java.util.List;

public class Round {

    private int id;
    private List<Car> carList;
    private int thisRound;
    private Game belongTo;

    private Round(Builder builder) {
        this.id = builder.id;
        this.carList = builder.carList;
        this.thisRound = builder.thisRound;
        this.belongTo = builder.belongTo;
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

        public Builder setBelongTo(Game belongTo) {
            this.belongTo = belongTo;
            return this;
        }

        public Round build() {
            return new Round(this);
        }
    }
}

