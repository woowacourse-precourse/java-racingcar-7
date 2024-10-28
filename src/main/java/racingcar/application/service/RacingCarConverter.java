package racingcar.application.service;

import java.util.Arrays;
import java.util.List;
import racingcar.racing.RacingCar;
import racingcar.application.Converter;

public class RacingCarConverter implements Converter<RacingCar> {

    private final static String DEFAULT_DELIMITER = ",";

    @Override
    public List<RacingCar> toObjects(String value) {
        String[] racingCars = value.split(DEFAULT_DELIMITER);
        return Arrays.stream(racingCars)
                .map(RacingCar::from)
                .toList();
    }
}
