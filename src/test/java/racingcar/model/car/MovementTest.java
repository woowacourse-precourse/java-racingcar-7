package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.common.constant.RaceConstant.FORWARD_MOVEMENT;
import static racingcar.common.constant.RaceConstant.NO_MOVEMENT;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.config.AppConfig;

public class MovementTest {

    @AfterEach
    void resetProfile() {
        AppConfig.resetProfile();
    }

    @Test
    @DisplayName("random 값 4 : 전진")
    void moveForwardV2() {
        // given
        AppConfig.setTestProfileWithValue("4");

        // when
        int actual = MovementCondition.getCondition().getDistance();

        // then
        assertThat(actual).isEqualTo(FORWARD_MOVEMENT);
    }


    @Test
    @DisplayName("random 값 3 : 이동 하지 않음")
    void doNotMove() {
        // given
        AppConfig.setTestProfileWithValue("3");

        // when
        int actual = MovementCondition.getCondition().getDistance();

        // then
        assertThat(actual).isEqualTo(NO_MOVEMENT);
    }
}
