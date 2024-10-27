package racingcar.domain;

import org.assertj.core.api.IntegerAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.from(new String[]{"test1", "test2", "test3"});
    }

    @DisplayName("n번 이동한 후 자동차의 상태는 0이상 n이하 여야 한다")
    @Test
    void validateCarsMovesNumber() {
        int moveNumber = 43;
        cars.racing(moveNumber);
        for (int i = 0; i < 3; i++) {
            new IntegerAssert(cars.getCar(i).getAdvanceNum()).isBetween(0, moveNumber);
        }
    }
}
