package racingcar.model;

import java.util.List;

//레코드로 변환 고려
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
