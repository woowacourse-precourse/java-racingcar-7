package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @BeforeEach
    void setUp() {
        Car.resetNames();
    }

    @Test
    void 자동차_이름이_5자초과일_경우_예외발생() {
        assertThatThrownBy(() -> new Car("CarTest"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름이_공백을_포함할_경우_예외발생() {
        assertThatThrownBy(() -> new Car("po bi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에는 공백이 포함될 수 없습니다.");
    }

    @Test
    void 자동차_이름이_중복될_경우_예외발생() {
        new Car("pobi");
        assertThatThrownBy(() -> new Car("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차_전진_기능_테스트() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_초기_위치는_0이어야_함() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_여러번_이동_테스트() {
        Car car = new Car("pobi");
        car.move();
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }
}