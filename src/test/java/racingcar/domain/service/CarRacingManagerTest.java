package racingcar.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.infrastructure.constant.Boundary;
import racingcar.infrastructure.constant.CarConstants;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarRacingManagerTest {
    private static final int MOVING_FORWARD = Boundary.MOVE_CONDITION_MIN;
    private static final int STOP = Boundary.MOVE_CONDITION_MIN - 1;

    @Test
    @DisplayName("우승자를 출력할 수 있다.")
    void 우승자_출력() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("1,2,3");

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    carRacingManager.moveAllCar();
                    final String winners = carRacingManager.getWinners();
                    // then
                    assertThat(winners.split(CarConstants.JOIN_DELIMITER).length).isEqualTo(1);
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("우승자가 여러 명일 수 있다.")
    void 우승자_여러명() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("1, 2, 3");

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    carRacingManager.moveAllCar();
                    final String winners = carRacingManager.getWinners();
                    // then
                    assertThat(winners.split(CarConstants.JOIN_DELIMITER).length).isEqualTo(2);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}