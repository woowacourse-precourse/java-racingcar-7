package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private static Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void 자동차이동_테스트() {
        car.move();
        assertThat(car.getMoveDistance()).isIn(Arrays.asList(0, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 자동차이동_테스트_멈춤_목업(int randomValue) {
        assertRandomNumberInRangeTest(() -> {
            car.move();
            assertThat(car.getMoveDistance()).isEqualTo(0);
        }, randomValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차이동_테스트_전진_목업(int randomValue) {
        assertRandomNumberInRangeTest(() -> {
            car.move();
            assertThat(car.getMoveDistance()).isEqualTo(1);
        }, randomValue);
    }
}