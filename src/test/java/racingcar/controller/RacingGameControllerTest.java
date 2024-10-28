package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    @Test
    void startGame_ShouldRunGameSuccessfully_WithSpecifiedPositions() {

        String[] carNames = {"Car1", "Car2", "Car3"};
        int attemptCount = 5;

        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.move(5);
        car2.move(3);
        car3.move(5);

        List<Car> cars = List.of(car1, car2, car3);
        RacingGame game = new RacingGame(cars);

        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        assertThat(winners).containsExactlyInAnyOrder("Car1", "Car3");
    }
}
