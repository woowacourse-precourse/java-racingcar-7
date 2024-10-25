package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.NumberGenerator;

class CarTest {

    @Test
    void 자동차_생성_성공() {
        final Car car = new Car("pobi", new TestNumberGenerator(1));
        assertThat(car.toString()).isEqualTo("pobi : ");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차가_멈춘_경우(int number) {
        final Car car = new Car("pobi", new TestNumberGenerator(number));
        car.move();
        assertThat(car.toString()).isEqualTo("pobi : ");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차가_전진한_경우(int number) {
        final Car car = new Car("pobi", new TestNumberGenerator(number));
        car.move();
        assertThat(car.toString()).isEqualTo("pobi : -");
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 10, 11})
    void 값이_0미만_10이상_경우(int number) {
        assertThatThrownBy(() -> new Car("pobi", new TestNumberGenerator(number)).move())
                .isInstanceOf(IllegalArgumentException.class);
    }

    static class TestNumberGenerator implements NumberGenerator {
        private final int number;

        public TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generator() {
            return number;
        }
    }
}