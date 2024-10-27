package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.dto.MovementNumber;
import racingcar.exception.RacingCarException;

import java.util.List;

class RacingCarTest {

    private RacingCar car;
    private RaceProgressManager manager;

    @BeforeEach
    void 초기화() {
        car = new RacingCar("Mini");
        manager = new RaceProgressManager(List.of(car));
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("MovementPolicy가 null일 경우 예외가 발생한다")
        void MovementPolicy가_null일_경우_예외가_발생한다() {
            assertThatThrownBy(() -> car.executeForward(null, manager))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(MOVEMENT_POLICY_NULL.getMessage())
                    .as("MovementPolicy가 null일 때 예외가 발생해야 합니다.");
        }

        @Test
        @DisplayName("RaceProgressManager가 null일 경우 예외가 발생한다")
        void RaceProgressManager가_null일_경우_예외가_발생한다() {
            MovementPolicy policy = new MovementPolicy(new MovementNumber(5));

            assertThatThrownBy(() -> car.executeForward(policy, null))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(RACE_PROGRESS_MANAGER_NULL.getMessage())
                    .as("RaceProgressManager가 null일 때 예외가 발생해야 합니다.");
        }
    }

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("자동차가 MovementPolicy 조건에 따라 전진한다")
        void 전진_조건을_충족하면_자동차가_전진한다() {
            MovementPolicy policy = new MovementPolicy(new MovementNumber(4));

            car.executeForward(policy, manager);

            assertThat(manager.createRaceResult().raceProgress().get("Mini"))
                    .isEqualTo(1)
                    .as("전진 조건을 충족할 때 자동차는 전진해야 합니다.");
        }

        @Test
        @DisplayName("자동차가 MovementPolicy 조건에 따라 멈춘다")
        void 전진_조건을_충족하지_않으면_자동차가_멈춘다() {
            MovementPolicy policy = new MovementPolicy(new MovementNumber(3));

            car.executeForward(policy, manager);

            assertThat(manager.createRaceResult().raceProgress().get("Mini"))
                    .isEqualTo(0)
                    .as("전진 조건을 충족하지 않을 때 자동차는 멈춰야 합니다.");
        }
    }
}