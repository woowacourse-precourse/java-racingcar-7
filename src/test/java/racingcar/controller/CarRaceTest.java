package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CarRaceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void startRace_SingleWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    CarRace carRace = new CarRace("pobi,woni", "1");
                    carRace.startRace();

                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );

    }

    @Test
    void startRace_MultipleWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    CarRace carRace = new CarRace("pobi,woni,jun", "1");
                    carRace.startRace();

                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                }
                , MOVING_FORWARD, MOVING_FORWARD, STOP
        );

    }

    @Override
    protected void runMain() {

    }
}