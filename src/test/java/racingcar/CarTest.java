package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");

        car.move(5);
        car.move(5);
        car.move(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    void 무작위로_뽑은_값이_4_이상이면_전진한다(int value) {
        car.move(value);
        assertThat(car.getDistance()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void 무작위로_뽑은_값이_4_미만이면_전진하지않는다(int value) {
        car.move(value);
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    void 자동차의_이름과_현재_위치를_반환한다() {
        assertThat(car.getInfo()).isEqualTo("pobi : --");
    }
}