package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundGameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("라운드 하나의 동작의 경우 테스트")
    void playRoundTest() {
        RacingCarManager racingCarManager = new RacingCarManager();
        racingCarManager.newCar(new RacingCar("pobi"));
        racingCarManager.newCar(new RacingCar("minki"));

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    racingCarManager.playRound();

                    // then
                    List<RacingCar> cars = racingCarManager.getRacingCarList();
                    assertThat(cars.get(0).getLocation()).isEqualTo(1);
                    assertThat(cars.get(1).getLocation()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );
    }
}
