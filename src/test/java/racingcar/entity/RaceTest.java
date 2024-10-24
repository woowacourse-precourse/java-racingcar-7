package racingcar.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestUtils;
import racingcar.exception.RaceCarValidationError;
import racingcar.util.RandomNumberGenerator;

public class RaceTest {

    @Test
    @DisplayName("자동차 등록")
    void registerCars() {
        // Given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        Race race = new Race(cars);

        // When
        String[] carNames = race.getCarNames();

        // Then
        assertArrayEquals(new String[]{"pobi", "woni"}, carNames);
    }

    @Test
    @DisplayName("자동차 등록 실패 (자동차 개수 10대 초과)")
    void failWhenExceedLimit() {
        // Given
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            cars.add(new Car("na" + i));
        }

        // When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Race(cars),
                RaceCarValidationError.CARS_EXCEED_LIMIT.getMessage());
    }

    @Test
    @DisplayName("자동차 등록 실패 (자동차 이름 중복)")
    void failWhenDuplicateNames() {
        // Given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("pobi"));
        cars.add(new Car("pobi2"));
        cars.add(new Car("pobi3"));

        // When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Race(cars),
                RaceCarValidationError.CARS_DUPLICATE_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 등록 실패 (자동차 배열이 null인 경우)")
    void failWhenCarListNull() {
        // Given & When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Race(null),
                RaceCarValidationError.CARS_NULL.getMessage());
    }

    @Test
    @DisplayName("한 라운드 진행")
    void runSingleRound() {
        // Given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        cars.add(new Car("d"));
        Race race = new Race(cars);
        RandomNumberGenerator randomNumberGenerator = TestUtils.mockRandomNumberGenerator(
                List.of(1, 2, 3, 4)
        );

        // When
        race.runSingleRound(randomNumberGenerator);

        // Then
        assertArrayEquals(new int[]{0, 0, 0, 1},
                cars.stream()
                        .mapToInt(Car::getPosition)
                        .toArray());
    }

    @Test
    @DisplayName("제일 먼 거리의 자동차들을 찾는다.")
    void findWinners() {
        // Given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        cars.add(new Car("d"));
        Race race = new Race(cars);
        RandomNumberGenerator randomNumberGenerator = TestUtils.mockRandomNumberGenerator(
                List.of(1, 2, 3, 4)
        );
        race.runSingleRound(randomNumberGenerator);

        // When
        String[] winners = race.getWinners();

        // Then
        assertArrayEquals(new String[]{"d"}, winners);
    }

    @Test
    @DisplayName("제일 먼 거리의 자동차들을 찾는다.")
    void findWinnersMultiple() {
        // Given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        cars.add(new Car("d"));
        Race race = new Race(cars);
        RandomNumberGenerator randomNumberGenerator = TestUtils.mockRandomNumberGenerator(
                List.of(1, 2, 4, 4)
        );
        race.runSingleRound(randomNumberGenerator);

        // When
        String[] winners = race.getWinners();

        // Then
        assertArrayEquals(new String[]{"c", "d"}, winners);
    }

}
