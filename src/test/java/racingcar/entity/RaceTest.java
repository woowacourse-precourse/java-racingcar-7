package racingcar.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    @DisplayName("자동차 등록")
    void shouldRegisterCarsSuccessfully() {
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
    void shouldFailToRegisterCarsWhenExceedingMaximumLimit() {
        // Given
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            cars.add(new Car("na" + i));
        }

        // When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Race(cars));
    }

    @Test
    @DisplayName("자동차 등록 실패 (자동차 이름 중복)")
    void shouldFailToRegisterCarsWithDuplicateNames() {
        // Given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("pobi"));
        cars.add(new Car("pobi2"));
        cars.add(new Car("pobi3"));

        // When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Race(cars));
    }

    @Test
    @DisplayName("자동차 등록 실패 (자동차 배열이 null인 경우)")
    void shouldFailToRegisterCarsWhenCarListIsNull() {
        // Given & When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Race(null));
    }

}
