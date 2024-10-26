package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    void 자동차는_전진할_수_있다_4이상_숫자일_경우(){
        final var car = new Car();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_전진할_수_없다_4미만_숫자일_경우(){
        final var car = new Car();
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }


}