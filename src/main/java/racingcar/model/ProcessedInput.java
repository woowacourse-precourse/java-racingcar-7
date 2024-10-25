package racingcar.model;

import java.math.BigInteger;
import java.util.List;

public class ProcessedInput {
    private final List<Car> carList;
    private final BigInteger raceRounds;

    public ProcessedInput(List<Car> carList, BigInteger raceRounds) {
        this.carList = carList;
        this.raceRounds = raceRounds;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public BigInteger getRaceRounds() {
        return raceRounds;
    }
}
