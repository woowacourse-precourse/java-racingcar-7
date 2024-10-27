package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private static final int MOVING_MIN_VALUE = 4;

    @Test
    @DisplayName("우승자가 한 명일 때 우승자 이름을 반환하는지 테스트")
    void testSingleWinner() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("honux");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        car1.move(MOVING_MIN_VALUE);
        Winners winners = new Winners(cars);

        // then
        List<String> winnerNames = winners.getNames();
        assertThat(winnerNames).containsExactly("pobi");
    }

    @Test
    @DisplayName("모든 자동차의 위치가 1 이상이고 우승자가 여러 명일 때 이름을 반환하는지 테스트")
    void testMultipleWinners() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("honux");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        car1.move(MOVING_MIN_VALUE);
        car2.move(MOVING_MIN_VALUE);
        Winners winners = new Winners(cars);

        // then
        List<String> winnerNames = winners.getNames();
        assertThat(winnerNames).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    @DisplayName("모든 자동차의 위치가 0이고 우승자가 여러 명일 때 이름을 반환하는지 테스트")
    void testAllCarsAtZeroPosition() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("honux");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        Winners winners = new Winners(cars);

        // then
        List<String> winnerNames = winners.getNames();
        assertThat(winnerNames).containsExactlyInAnyOrder("pobi", "woni", "honux");
    }
}
