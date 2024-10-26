package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class CarTest {
    private NumberGenerator fixedNumberGenerator;

    @Test
    void 이동_성공() {
        // given
        fixedNumberGenerator = new FixedNumberGenerator(4);
        Car car = new Car(fixedNumberGenerator, "test");

        // when
        car.tryMove();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 이동_실패() {
        // given
        fixedNumberGenerator = new FixedNumberGenerator(3);
        Car car = new Car(fixedNumberGenerator, "test");

        // when
        car.tryMove();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름_생성_성공() {
        // given
        String name = "car";

        // when then
        assertDoesNotThrow(() -> {
            new Car(new RandomNumberGenerator(), name);
        });
    }

    @Test
    void 이름_생성_실패() {
        // given
        String longName = "car";
        String emptyName = "";

        // when then
        assertThatThrownBy(() -> {
            new Car(new RandomNumberGenerator(), longName);
            new Car(new RandomNumberGenerator(), emptyName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}