package racingcar.domain.winner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.entity.Car;
import racingcar.domain.road.entity.Road;
import racingcar.domain.winner.entity.Winner;
import racingcar.domain.winner.service.WinnerCalculator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.road.entity.Length.FORWARD;

class WinnerCalculatorTest {

    private final WinnerCalculator calculator = new WinnerCalculator();

    @Test
    @DisplayName("가장 멀리 이동한 자동차 한 대를 우승자로 계산한다")
    void calculateSingleWinner() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> carList = Arrays.asList(car1, car2, car3);
        car1.getRoad().addRoad(FORWARD.getValue());

        // when
        Winner winner = calculator.calculateWinner(carList);

        // then
        assertThat(winner.getWinningCars()).containsExactly(car1);
    }

    @Test
    @DisplayName("동일한 거리로 이동한 자동차 여러 대를 우승자로 계산한다")
    void calculateMultipleWinners() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> carList = Arrays.asList(car1, car2, car3);
        car1.getRoad().addRoad(FORWARD.getValue());
        car2.getRoad().addRoad(FORWARD.getValue());

        // when
        Winner winner = calculator.calculateWinner(carList);

        // then
        assertThat(winner.getWinningCars()).containsExactlyInAnyOrder(car1, car2);
    }
}
