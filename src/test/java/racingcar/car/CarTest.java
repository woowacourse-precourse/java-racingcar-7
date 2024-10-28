package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void carNameLengthExceedsLimit() {
        assertThatThrownBy(() -> new Car("exceeded5length"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차가 전진하면 progress value에 '-'가 추가된다")
    void carMovesForward() {
        Car car = new Car("pobi");
        car.moveForward();
        assertThat(car.getProgressResult()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차가 우승자로 설정되면 isWinner가 true가 된다")
    void carIsWinner() {
        Car car = new Car("pobi");
        car.win();
        assertThat(car.isWinner()).isTrue();
    }
}
