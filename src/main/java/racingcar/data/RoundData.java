package racingcar.data;

import racingcar.dto.Car;

import java.util.List;

public class RoundData {
    private final List<Car> result;

    public RoundData(List<Car> cars) {
        this.result = cars;
    }

    public List<Car> getResult() {
        return result;
    }
}
