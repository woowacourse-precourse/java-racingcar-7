package racingcar.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 전진시_출력() {
        Car car = new Car("pobi");
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.getPositionDisplay()).isEqualTo("-");
    }

    @Test
    void 글자수_5자_초과() {
        assertThatThrownBy(() -> new Car("longerThanFive"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 공백_입력_예외처리() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }
}
