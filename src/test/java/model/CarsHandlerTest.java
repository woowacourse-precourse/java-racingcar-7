package model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsHandlerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 승자_찾기_테스트() {
        String[] names = {"pobi", "woni"};
        CarsHandler carsHandler = new CarsHandler(names);
        assertRandomNumberInRangeTest(
                () -> {
                    carsHandler.moveCars();
                    carsHandler.moveCars();

                    assertThat(carsHandler.getWinners().getFirst().getName()).contains("pobi");

                }, MOVING_FORWARD, STOP
        );
    }

}