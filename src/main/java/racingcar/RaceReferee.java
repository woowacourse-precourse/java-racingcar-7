package racingcar;

import java.util.Collections;
import java.util.List;

public class RaceReferee {

    private static final int MOVE_RULE = 4;
    private final int round;

    private RaceReferee(int round) {
        this.round = round;
    }

    public List<String> declareWinnerNames(List<Car> cars) {
        List<Integer> positions = cars.stream().map(Car::getPosition).toList();
        int maxPosition = Collections.max(positions);

        return cars.stream()
           .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .toList();
    }

    public static RaceReferee from(int round) {
        validateRound(round);
        return new RaceReferee(round);
    }

    private static void validateRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException("경주 횟수는 음수일 수 없습니다.");
        }
    }
}
