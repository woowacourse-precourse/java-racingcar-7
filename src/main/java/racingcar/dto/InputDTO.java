package racingcar.dto;

import racingcar.model.Car;

import java.util.List;

public class InputDTO {

    private final List<Car> carList;
    private final int turnCount;

    public InputDTO(List<Car> carList, int turnCount) {
        this.carList = carList;
        this.turnCount = turnCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTurnCount() {
        return turnCount;
    }
}
