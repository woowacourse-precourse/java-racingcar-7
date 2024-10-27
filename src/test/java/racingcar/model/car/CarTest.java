package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
class CarTest {

    @Test
    @DisplayName("이동 전략에 따라 움직인다")
    void 성공_이동() {
        // Given
        Car car = new Car("pobi", () -> true);

        // When & Then
        assertThat(car.doesMove()).isTrue();
    }
}
