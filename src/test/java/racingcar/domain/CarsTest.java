package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandNumGenerator;

public class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int REPEAT_TIMES = 4;

    @Test
    @DisplayName("메서드는 한 명 이상의 우승자를 찾아 String형 List로 반환한다.")
    void findWinnersTest() {
        Cars cars = new Cars("pobi,woni,jun");
        assertRandomNumberInRangeTest(
                () -> {
                    String winners = processAllRound(cars);
                    assertThat(winners).isEqualTo("[pobi, woni]");
                },
                MOVING_FORWARD, STOP, STOP,
                STOP, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    private String processAllRound(Cars cars) {
        RandNumGenerator randNumGenerator = new RandNumGenerator();
        for (int i = 0; i < REPEAT_TIMES; i++) {
            cars.roundProcess(randNumGenerator);
        }
        return cars.findWinners().toString();
    }
}
