package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingCarServiceTest {
    private static RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @DisplayName("랜덤 값이 4 이상이면 car의 distance 1 증가")
    @ParameterizedTest
    @CsvSource({"4", "1"})
    void validateIncreaseDistance(Integer number) {
        Car car = new Car("test");

        car.increaseDistance(number);
        int distance = 1;
        if (number < 4) {
            distance = 0;
        }
        assertThat(car.getDistance()).isEqualTo(distance);
    }

    @ParameterizedTest
    @DisplayName("가장 멀리 이동한 자동차 찾기")
    @MethodSource("provideCars")
    void findWinners(Cars cars) {
        assertThat(racingCarService.findWinner(cars)).isEqualTo(List.of("three"));
    }

    private Stream<Arguments> provideCars() {
        Cars cars = new Cars(List.of(new Car("one"), new Car("two"), new Car("three")));
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < 3; i++) {
            Car car = carList.get(i);
            for (int j = 0; j <= i; j++) {
                car.increaseDistance(4);
            }
        }
        return Stream.of(
                Arguments.arguments(cars)
        );
    }
}