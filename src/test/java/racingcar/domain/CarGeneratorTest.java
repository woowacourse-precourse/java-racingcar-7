package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarGeneratorTest {

    @Test
    @DisplayName("자동차 리스트 생성")
    void success_CarGenerator() {
        // Given
        String[] carNames = {"pobi", "woni", "jun"};
        int maximumGenerate = 100;
        CarGenerator generator = new CarGenerator(carNames, maximumGenerate);

        // When
        List<Car> cars = generator.generate();

        // Then
        assertThat(cars).hasSize(3);
        assertThat(cars)
            .extracting(Car::getName)
            .containsExactly("pobi", "woni", "jun");
        assertThat(cars)
            .extracting(Car::getLocation)
            .containsOnly(0);
    }

    @Test
    @DisplayName("자동차 수 초과 예외")
    void fail_ExceedNumberOfCars() {
        // Given
        String[] carNames = new String[101]; // 101개
        for (int i = 0; i < 101; i++) {
            carNames[i] = "Car" + i;
        }
        int maximumGenerate = 100;

        // When & Then
        assertThatThrownBy(() -> new CarGenerator(carNames, maximumGenerate))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("100개 이하의 자동차만 입력 가능합니다.");
    }
}