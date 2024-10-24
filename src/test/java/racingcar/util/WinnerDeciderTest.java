package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.result.WinnerDecider;

class WinnerDeciderTest {

    @DisplayName("자동차 리스트를 입력받아 우승자를 반환한다.")
    @Test
    void decideWinners() {
        // given
        Car car1 = new Car("Car1", () -> true);
        Car car2 = new Car("Car2", () -> true);
        Car car3 = new Car("Car3", () -> true);

        car2.move();
        car2.move();
        car1.move();

        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        List<Car> winners = WinnerDecider.decideWinners(cars);

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners).contains(car2);
    }

    @DisplayName("우승자가 여러 명일 경우 모두 반환한다.")
    @Test
    void decideWinners2() {
        // given
        Car car1 = new Car("Car1", () -> true);
        Car car2 = new Car("Car2", () -> true);
        Car car3 = new Car("Car3", () -> true);

        car2.move();
        car1.move();

        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        List<Car> winners = WinnerDecider.decideWinners(cars);

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(car1, car2);
    }

}