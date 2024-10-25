package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("4이상의 숫자가 입력될 경우 움직인다.")
    void move() {
        // given
        String name = "car";
        Car car = new Car(name);

        // when
        car.move(new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 4;
            }
        });

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("4미만의 숫자가 입력될 경우 움직이지 않는다.")
    void doesNotMoveWhenNumberIsLessThanFour() {
        // given
        String name = "car";
        Car car = new Car(name);

        // when
        car.move(new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 3;
            }
        });

        // then
        assertThat(car.getPosition()).isZero();
    }
}