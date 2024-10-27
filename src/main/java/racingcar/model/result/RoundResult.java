package racingcar.model.result;

import java.util.List;
import racingcar.model.car.Car;

public class RoundResult {
    List<CarRecord> roundResult;

    public RoundResult(List<CarRecord> roundResult) {
        this.roundResult = roundResult;
    }


    public List<CarRecord> getRoundResult() {
        return roundResult;
    }

    public static RoundResult from(List<Car> cars) {
        List<CarRecord> roundResult = cars.stream()
                .map(CarRecord::from)
                .toList();
        return new RoundResult(roundResult);
    }
}
