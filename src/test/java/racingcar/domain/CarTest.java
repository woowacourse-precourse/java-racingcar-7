package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("5자 이하의 이름을 입력할 경우 자동차 객체가 정상적으로 생성된다.")
    void create() {
        // given
        String name = "name";
        // when
        Car car = new Car(name);
        // then
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차의 이름이 5자가 넘어갈 경우 예외가 발생한다.")
    void throwTooLongNameException() {
        // given
        String name = "toolon";

        // when, then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

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