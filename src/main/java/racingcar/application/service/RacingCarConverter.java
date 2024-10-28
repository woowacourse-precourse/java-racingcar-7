package racingcar.application.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.racing.RacingCar;
import racingcar.application.ObjectConverter;

public class RacingCarConverter implements ObjectConverter<RacingCar> {

    private final static String DEFAULT_DELIMITER = ",";
    private final static String DEFAULT_DELIMITER_WITH_BLANK = ", ";

    @Override
    public List<RacingCar> toObjects(String value) {
        String[] racingCars = value.split(DEFAULT_DELIMITER);
        return Arrays.stream(racingCars)
                .map(RacingCar::from)
                .toList();
    }

    @Override
    public String toStringNames(List<RacingCar> winners) {
        return winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(DEFAULT_DELIMITER_WITH_BLANK));
    }
}
