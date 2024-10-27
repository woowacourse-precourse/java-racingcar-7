package racingcar.creator;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarGameCreator {

    private static final String DELIMITERS_OF_CAR_ID = ",";

    private final String cars;
    private final int totalRound;

    public RacingCarGameCreator(String cars, int totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
    }

    public List<RacingCar> getCarList() {
        return Arrays.stream(cars.split(DELIMITERS_OF_CAR_ID))
                .map(RacingCar::new).toList();
    }

    public int getTotalRound() {
        return totalRound;
    }
}
