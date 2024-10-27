package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import racingcar.util.FixedNumberGenerator;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class CarTest {
    private final NumberGenerator randomGenerator = new RandomNumberGenerator();
    private final NumberGenerator nineGenerator = FixedNumberGenerator.nineGenerator();
    private final NumberGenerator zeroGenerator = FixedNumberGenerator.zeroGenerator();
    private final String validCarName = "car";

    @Test
    void Car_생성() {
        assertDoesNotThrow(() -> {
            Car.of(randomGenerator, validCarName);
        });
    }

    @Test
    void 자동차의_이름은_1자이상_5자이하이다() {
        String longName = "hantol";
        String emptyName = "";

        assertThatThrownBy(() -> {
            Car.of(randomGenerator, longName);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Car.of(randomGenerator, emptyName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차는_랜덤값이_4이상이면_전진한다() {
        Car car = Car.of(nineGenerator, validCarName);

        car.tryMove();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_랜덤값이_4미만이면_전진하지_앉는다() {
        Car car = Car.of(zeroGenerator, validCarName);

        car.tryMove();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_거리_비교() {

        Car car1 = Car.of(nineGenerator, validCarName);
        Car car2 = Car.of(zeroGenerator, validCarName);
        int expected = 1;

        car1.tryMove();
        car2.tryMove();

        assertThat(car1.compareTo(car2)).isEqualTo(expected);
    }
}