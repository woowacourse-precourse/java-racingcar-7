package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            String[] carNames = CarInput.inputCarNames();
            List<Car> cars = Arrays.stream(carNames)
                    .map(Car::new)
                    .collect(Collectors.toList());

            int moveCount = CarInput.inputMoveCount();

            Race race = new Race(cars);
            race.start(moveCount);

        } catch (IllegalArgumentException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
    }
}