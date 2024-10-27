package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.provider.LinearIncrementalNumberProvider;
import racingcar.provider.NumberProvider;

class CarsTest {

    @Test
    @DisplayName("가장 많이 전진한 자동차를 우승자로 선택한다")
    void findOneWinner() {
        // given
        Cars cars = Cars.of("test1", "test2", "test3");
        NumberProvider numberProvider = new LinearIncrementalNumberProvider(1, 2);

        // when
        cars.tryMoveForward(numberProvider);
        List<Car> winnerList = cars.findWinnerList();

        // then
        assertThat(winnerList).containsExactly(Car.from("test3"));
    }

    @Test
    @DisplayName("우승자는 두 명 이상일 수 있다")
    void test() {
        // given
        Cars cars = Cars.of("test1", "test2", "test3");
        NumberProvider numberProvider = new LinearIncrementalNumberProvider(3, 2);

        // when
        cars.tryMoveForward(numberProvider);
        List<Car> winnerList = cars.findWinnerList();

        // then
        assertThat(winnerList).containsExactly(Car.from("test2"), Car.from("test3"));
    }
}