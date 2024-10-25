package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    @DisplayName("생성자는 이름으로 구성된 RacingCar를 반환합니다.")
    void constructor_ReturnCorrectly() {
        // given
        String name = "aaa";

        // when
        RacingCar racingCar = new RacingCar(name);

        // then
        Assertions.assertThat(racingCar.getName())
                .isEqualTo(name);
    }

    @Test
    @DisplayName("생성자는 5자를 초과하는 이름이 들어왔을때 IllegalArgumentException을 던진다.")
    void constructor_WhenOver5LengthName_ThrowIllegalArgumentException() {
        // given
        String name = "aaaaaa";

        // when & then
        Assertions.assertThatThrownBy(() ->
                new RacingCar(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자는 빈 이름이 들어왔을 때 IllegalArgumentException을 던진다.")
    void constructor_WhenEmptyName_ThrowIllegalArgumentException() {
        // given
        String name = "";

        // when & then
        Assertions.assertThatThrownBy(() ->
                new RacingCar(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("tryMoveForward는 Randoms를 통해 임계값 이상의 값이 반환될때 distanceCovered를 1 높여야 한다.")
    void tryMoveForward_WhenMoreThreshold_Add1DistanceCovered() {
        // given
        RacingCar racingCar = new RacingCar("aaa");

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    racingCar.tryMoveForward();
                    Assertions.assertThat(racingCar.getDistanceCovered()).isEqualTo(1);
                },
                RacingCar.MOVE_FORWARD_THRESHOLD
        );
    }

    @Test
    @DisplayName("tryMoveForward는 Randoms를 통해 임계값 이상의 값이 반환될때 distanceCovered를 1 높여야 한다.")
    void tryMoveForward_WhenBelowThreshold_Nothing() {
        // given
        RacingCar racingCar = new RacingCar("aaa");

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    racingCar.tryMoveForward();
                    Assertions.assertThat(racingCar.getDistanceCovered()).isEqualTo(0);
                },
                RacingCar.MOVE_FORWARD_THRESHOLD - 1
        );
    }
}
