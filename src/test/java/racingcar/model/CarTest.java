package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"false,0", "true,1"}, delimiter = ',')
    void testMoveIfTrueOrFalse(boolean moveOrStop, int expectedMoveCount) {
        Car car = new Car("test");

        car.moveForward(moveOrStop);

        assertThat(car.getCurrentPosition()).isEqualTo(expectedMoveCount);
    }
}
