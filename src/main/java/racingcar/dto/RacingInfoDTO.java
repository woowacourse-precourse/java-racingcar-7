package racingcar.dto;

import racingcar.model.Car;

import java.math.BigInteger;
import java.util.List;

public class RacingInfoDTO {
    private final List<Car> carList;
    private final BigInteger raceRounds;

    public RacingInfoDTO(List<Car> carList, BigInteger raceRounds) {
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
