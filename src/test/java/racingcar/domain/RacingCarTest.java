package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.dto.MovementNumber;
import racingcar.exception.RacingCarException;

import java.util.List;

class RacingCarTest {

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("MovementPolicy가 null일 경우 예외가 발생한다")
        void MovementPolicy가_null일_경우_예외가_발생한다() {
            RacingCar car = new RacingCar("Tesla");
            RaceProgressManager manager = new RaceProgressManager(List.of(car));

            assertThatThrownBy(() -> car.executeForward(null, manager))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(MOVEMENT_POLICY_NULL.getMessage());
        }

        @Test
        @DisplayName("RaceProgressManager가 null일 경우 예외가 발생한다")
        void RaceProgressManager가_null일_경우_예외가_발생한다() {
            RacingCar car = new RacingCar("Tesla");
            MovementPolicy policy = new MovementPolicy(new MovementNumber(5));

            assertThatThrownBy(() -> car.executeForward(policy, null))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(RACE_PROGRESS_MANAGER_NULL.getMessage());
        }
    }

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("자동차가 MovementPolicy 조건에 따라 전진한다")
        void 자동차가_MovementPolicy_조건에_따라_전진한다() {
            RacingCar car = new RacingCar("Mini");
            RaceProgressManager manager = new RaceProgressManager(List.of(car));
            MovementPolicy policy = new MovementPolicy(new MovementNumber(4));

            car.executeForward(policy, manager);

            assertThat(manager.createRaceResult().raceProgress().get("Mini")).isEqualTo(1);
        }

        @Test
        @DisplayName("자동차가 MovementPolicy 조건에 따라 멈춘다")
        void 자동차가_MovementPolicy_조건에_따라_멈춘다() {
            RacingCar car = new RacingCar("Mini");
            RaceProgressManager manager = new RaceProgressManager(List.of(car));
            MovementPolicy policy = new MovementPolicy(new MovementNumber(3));

            car.executeForward(policy, manager);

            assertThat(manager.createRaceResult().raceProgress().get("Mini")).isEqualTo(0);
        }
    }
}
