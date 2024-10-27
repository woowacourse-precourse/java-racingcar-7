package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 랜덤_경주_테스트() {
        List<String> carNames = List.of("pobi", "minju");
        Cars testCars = new Cars(carNames);
        List<Integer> expectedProgress = List.of(1, 0);

        assertRandomNumberInRangeTest(
                () -> {
                    testCars.doRace();
                    for (int i = 0; i < testCars.size(); i++) {
                        Assertions.assertEquals(testCars.getCar(i).progress(), expectedProgress.get(i));
                    }
                },
                MOVING_FORWARD, STOP
        );
    }
}
