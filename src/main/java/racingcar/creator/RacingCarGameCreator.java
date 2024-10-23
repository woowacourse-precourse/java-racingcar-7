package racingcar.creator;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarGameCreator {

    public static final String CAR_NAME_DELIMITERS = ",";

    private final String cars;
    private final int numOfAttempts;

    public RacingCarGameCreator(String cars, int numOfAttempts) {
        this.cars = cars;
        this.numOfAttempts = numOfAttempts;
    }

    public List<RacingCar> getCarList() {
        return Arrays.stream(cars.split(CAR_NAME_DELIMITERS))
                .map(RacingCar::new).toList();
    }

    public int getNumOfAttempts() {
        return numOfAttempts;
    }
}
