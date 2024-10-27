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

    @DisplayName("n번 이동한 후 자동차의 최대 이동 횟수는 0이상 n이하 여야 한다")
    @Test
    void validateMaxAdvanceNumber() {
        // given
        int moveNumber = 234;

        // when
        cars.racing(moveNumber);
        int maxAdvanceNum = cars.getMaxAdvanceNum();

        // then
        new IntegerAssert(maxAdvanceNum).isBetween(0, moveNumber);
    }

    @DisplayName("우승자는 한명 이상이어야 한다.")
    @Test
    void validateWinners() {
        // given
        int moveNumber = 63;

        // when
        cars.racing(moveNumber);
        Winners winners = cars.determineWinner();
        int winnersNum = winners.getWinnersCount();

        // then
        new IntegerAssert(winnersNum).isGreaterThan(0);
    }
}
