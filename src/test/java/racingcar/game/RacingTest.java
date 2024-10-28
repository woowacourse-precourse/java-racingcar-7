package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    @DisplayName("우승자 검증")
    @Test
    void validateWinner() {
        // given
        List<Car> cars = CarFactory.createCars("pobi,woni,jun");
        Racing racing = new Racing(cars, 5);

        // when
        racing.start();

        // then
        Car winner = racing.getWinner();
        assertTrue(cars.stream().allMatch(car -> car.getPosition() <= winner.getPosition()));
    }
}
