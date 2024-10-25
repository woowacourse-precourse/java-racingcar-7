package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final int ADVANCE_NUMBER = 9;
    private Car car;

    @BeforeEach
    public void setCar() {
        car = new Car("sean");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차_전진_테스트(int randomNumber) {
        car.race(randomNumber);
        assertThat(car.getStatus()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차_정지_테스트(int randomNumber) {
        car.race(randomNumber);
        assertThat(car.getStatus()).isEqualTo(0);
    }

    @Test
    public void 자동차_정보_테스트_1() {
        assertThat(car.getInformation()).isEqualTo("sean : ");
    }

    @Test
    public void 자동차_정보_테스트_2() {
        car.race(ADVANCE_NUMBER);
        assertThat(car.getInformation()).isEqualTo("sean : -");
    }
}