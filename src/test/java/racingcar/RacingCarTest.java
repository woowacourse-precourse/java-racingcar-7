package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @DisplayName("[정상 테스트]RacingCar - 1자 이상 5자 이하의 이름")
    @Test
    void RacingCar_constructor_test() {
        RacingCar car = new RacingCar("test");
        assertThat(car.getName()).isEqualTo("test");
    }

    @DisplayName("[정상 테스트]RacingCar - 인스턴스의 전진거리가 rollDice()의 호출 횟수를 넘지 않음")
    @Test
    void RacingCar_rollDice_test() {
        RacingCar car = new RacingCar("test");
        car.rollDice();
        car.rollDice();
        car.rollDice();
        car.rollDice();
        car.rollDice();
        assertThat(car.getCount()).isBetween(0, 5);
    }

    @DisplayName("[예외 테스트]RacingCar - 이름이 5자 초과")
    @Test
    void RacingCar_exception_longName_test() {
        assertThatThrownBy(() -> new RacingCar("invalid_name"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외 테스트]RacingCar - 이름이 빈 문자열")
    @Test
    void RacingCar_exception_emptyName_test() {
        assertThatThrownBy(() -> new RacingCar(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
