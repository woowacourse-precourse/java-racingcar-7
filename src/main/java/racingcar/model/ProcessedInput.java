package racingcar.model;

import java.math.BigInteger;
import java.util.List;

public class ProcessedInput {
    private List<Car> carList;
    private BigInteger raceRounds;

    public ProcessedInput(List<Car> carList, BigInteger raceRounds) {
        this.carList = carList;
        this.raceRounds = raceRounds;
    }
}
