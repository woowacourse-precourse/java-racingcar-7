package racingcar.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static racingcar.constant.RacingConstant.CAR_NAMES_DELIMITER;
import static racingcar.constant.RacingConstant.RACING_CAR_MIN_COUNT;

public class RacingCars {

    private final LinkedList<RacingCar> cars = new LinkedList<>();

    private RacingCars(String input) {
        List<RacingCar> list = toList(input);

        if (isInsufficientCarCount(list)) {
            throw new IllegalArgumentException("경주에 필요한 최소 자동차 대수는 2대입니다.");
        }

        cars.addAll(list);
    }

    public static RacingCars from(String input) {
        return new RacingCars(input);
    }

    public LinkedList<RacingCar> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return cars.stream().mapToInt(RacingCar::getPosition).max().orElse(Integer.MIN_VALUE);
    }

    private boolean isInsufficientCarCount(List<RacingCar> list) {
        return list.size() < RACING_CAR_MIN_COUNT;
    }

    private List<RacingCar> toList(String input) {
        return Arrays.stream(input.split(CAR_NAMES_DELIMITER))
                .map(RacingCar::new)
                .toList();
    }
}
