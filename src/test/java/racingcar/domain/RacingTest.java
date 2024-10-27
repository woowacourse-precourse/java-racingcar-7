package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;

class RacingTest {

    private static final NumberSupplier ALWAYS_MOVE_NUMBER_SUPPLIER = () -> 9;
    private static final List<Car> ALWAYS_MOVING_CARS =
            List.of(new Car("one", ALWAYS_MOVE_NUMBER_SUPPLIER), new Car("two", ALWAYS_MOVE_NUMBER_SUPPLIER));

    @Test
    void validateTest_whenCarNotExist_throwException() {
        List<Car> cars = Collections.emptyList();

        assertThatThrownBy(() -> new Racing(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 1대 이상 존재해야 합니다");
    }

    @Test
    void progressTest() {
        Racing racing = new Racing(ALWAYS_MOVING_CARS);
        RoundDto expected = new RoundDto(List.of(new CarDto("one", 1), new CarDto("two", 1)));

        racing.progress();

        RoundDto actual = racing.getRoundResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findWinnerTest_whenHasSingleWinner() {
        Racing racing = new Racing(List.of(createMovedCar("one", 1), createMovedCar("two", 2)));
        List<String> expected = List.of("two");

        List<String> actual = racing.findWinner();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findWinnerTest_whenHasMultiWinner() {
        Racing racing = new Racing(List.of(
                createMovedCar("one", 1), createMovedCar("two1", 2), createMovedCar("two2", 2)));
        List<String> expected = List.of("two1", "two2");

        List<String> actual = racing.findWinner();

        assertThat(actual).isEqualTo(expected);
    }

    private Car createMovedCar(String name, int position) {
        Car car = new Car(name, ALWAYS_MOVE_NUMBER_SUPPLIER);
        for (int i = 0; i < position; i++) {
            car.move();
        }
        return car;
    }
}
