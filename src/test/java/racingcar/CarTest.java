package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 아무것도_입력되지_않았을때_예외확인() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 입력되지 않았습니다");
    }

    @Test
    void 공백만_입력됐을때_예외확인() {
        assertThatThrownBy(() -> new Car("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 입력되지 않았습니다");
    }

    @Test
    void 올바른이름을_줬을때_생성확인() {
        // Given
        String validName = "pobi";

        // When
        Car car = new Car(validName);

        // Then
        assertThat(car.getName()).isEqualTo(validName);
    }

    @Test
    void move_실행시_반환값이_4미만이면_position변화없고_4이상이면_position증가() {
        // Given
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        // When
        int randomNum = car.move();

        // Then
        if (randomNum < 4) {
            assertThat(car.getPosition()).isEqualTo(initialPosition);
        } else {
            assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
        }
    }

}