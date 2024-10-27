package racingcar.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CarStatusFormatterTest {
    private CarStatusFormatter formatter;
    private static final int FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        formatter = new CarStatusFormatter();
    }

    @Test
    @DisplayName("자동차 한 대의 상태를 포맷팅할 수 있다")
    void formatSingleCar() {
        // given
        Car car = new Car("pobi", () -> FORWARD);
        car.moveIfPossible();
        Set<Car> cars = Set.of(car);

        // when
        String result = formatter.format(cars);

        // then
        assertThat(result).contains("pobi : -");
    }

    @Test
    @DisplayName("여러 대의 자동차 상태를 포맷팅할 수 있다")
    void formatMultipleCars() {
        // given
        Set<Car> cars = new HashSet<>();
        Car car1 = new Car("pobi", () -> FORWARD);
        car1.moveIfPossible();

        Car car2 = new Car("woni", () -> FORWARD);
        car2.moveIfPossible();
        car2.moveIfPossible();

        Car car3 = new Car("jun", () -> STOP);
        car3.moveIfPossible();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // when
        String result = formatter.format(cars);

        // then
        assertThat(result).contains(
                "pobi : -",
                "woni : --",
                "jun : "
        );
        assertThat(result.lines()).hasSize(3);
    }

    @Test
    @DisplayName("빈 자동차 목록을 포맷팅하면 빈 문자열을 반환한다")
    void formatEmptyCars() {
        // given
        Set<Car> cars = new HashSet<>();

        // when
        String result = formatter.format(cars);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("position이 0인 자동차의 상태를 포맷팅할 수 있다")
    void formatCarWithZeroPosition() {
        // given
        Car car = new Car("pobi", () -> STOP);
        car.moveIfPossible();
        Set<Car> cars = Set.of(car);

        // when
        String result = formatter.format(cars);

        // then
        assertThat(result).contains("pobi : ");
    }

    @Test
    @DisplayName("position이 큰 자동차의 상태를 포맷팅할 수 있다")
    void formatCarWithLargePosition() {
        // given
        Car car = new Car("pobi", () -> FORWARD);
        for (int i = 0; i < 5; i++) {
            car.moveIfPossible();
        }
        Set<Car> cars = Set.of(car);

        // when
        String result = formatter.format(cars);

        // then
        assertThat(result).contains("pobi : -----");
    }
}