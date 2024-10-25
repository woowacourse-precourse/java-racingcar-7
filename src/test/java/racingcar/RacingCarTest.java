package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    void RacingCar_construct_test() {
        RacingCar car = new RacingCar("test");
        car.rollDice();
        car.rollDice();
        car.rollDice();
        car.rollDice();
        car.rollDice();
        assertThat(car.getCount()).isBetween(0, 5);
    }

    @DisplayName("자동차의 이름이 1자에서 5자 사이가 아니면 예외를 발생한다.")
    @Test
    void RacingCar_exception_test() {
        assertThatThrownBy(() -> new RacingCar("invalid_name"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
