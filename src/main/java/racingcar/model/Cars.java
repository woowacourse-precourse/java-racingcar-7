package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> cars;
    private int maxMove;

    public Cars(List<Car> cars) {
        this.cars = cars;
        this.maxMove = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxMove() {
        return maxMove;
    }

    public void setMaxMove(int maxMove) {
        this.maxMove = maxMove;
    }
}
