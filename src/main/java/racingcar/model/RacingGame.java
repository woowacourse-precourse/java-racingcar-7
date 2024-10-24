package racingcar.model;

import java.util.List;

public class RacingGame {
    private final List<Car> carList;
    private final int num;

    public RacingGame(List<Car> carList, int num) {
        this.carList = carList;
        this.num = num;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getNum() {
        return num;
    }

}
