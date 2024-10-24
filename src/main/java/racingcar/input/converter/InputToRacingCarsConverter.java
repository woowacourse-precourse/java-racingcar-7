package racingcar.input.converter;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.LinkedList;

import static java.util.stream.Collectors.toCollection;
import static racingcar.constant.RacingConstant.CAR_NAMES_DELIMITER;
import static racingcar.constant.RacingConstant.RACING_CAR_MIN_COUNT;

public class InputToRacingCarsConverter {

    public LinkedList<RacingCar> convert(String input) {
        LinkedList<RacingCar> racingCars = convertInputToRacingCars(input);

        if (isInsufficientCarCount(racingCars)) {
            throw new IllegalArgumentException("경주에 필요한 최소 자동차 대수는 2대입니다.");
        }

        return racingCars;
    }

    private LinkedList<RacingCar> convertInputToRacingCars(String input) {
        return Arrays.stream(input.split(CAR_NAMES_DELIMITER))
                .map(RacingCar::new)
                .collect(toCollection(LinkedList::new));
    }

    private boolean isInsufficientCarCount(LinkedList<RacingCar> list) {
        return list.size() < RACING_CAR_MIN_COUNT;
    }
}
