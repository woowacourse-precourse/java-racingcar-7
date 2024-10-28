package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 1자 이상 5자 이하면 생성된다")
    void carStoresNameSuccessfully() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 경우 예외 발생")
    void carNameExceedsFiveCharacters_ShouldThrowException() {
        assertThatThrownBy(() -> new Car("longname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("전진 시 위치가 1 증가한다")
    void carMovesForward() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
