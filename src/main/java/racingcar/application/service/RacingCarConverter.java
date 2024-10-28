package racingcar.application.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.racing.CarRacer;
import racingcar.application.ObjectConverter;

public class RacingCarConverter implements ObjectConverter<CarRacer> {

    private final static String DEFAULT_DELIMITER = ",";
    private final static String DEFAULT_DELIMITER_WITH_BLANK = ", ";

    @Override
    public List<CarRacer> toObjects(String value) {
        String[] racingCars = value.split(DEFAULT_DELIMITER);
        return Arrays.stream(racingCars)
                .map(CarRacer::from)
                .toList();
    }

    @Override
    public String toStringNames(List<CarRacer> winners) {
        return winners.stream()
                .map(CarRacer::getName)
                .collect(Collectors.joining(DEFAULT_DELIMITER_WITH_BLANK));
    }
}
