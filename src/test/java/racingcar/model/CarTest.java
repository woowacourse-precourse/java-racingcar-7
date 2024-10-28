package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("move 메서드가 조건에 따라 자동차의 score를 증가시킨다")
    void move_ShouldIncreaseScore_WhenMoveStateValueIsFourOrMore() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getScore()).isEqualTo(1);

        car.move(5);
        assertThat(car.getScore()).isEqualTo(2);

        car.move(2);
        assertThat(car.getScore()).isEqualTo(2);
    }
}
