package racingcar.domain.movement;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Distance;
import racingcar.domain.game.NumberGenerator;
import racingcar.domain.game.mock.CanMoveNumberGenerator;
import racingcar.domain.game.mock.UnMoveNumberGenerator;

@DisplayName("이동 정책(MovementPolicy) 유스케이스")
class MovementPolicyTest {

    @DisplayName("이동 여부 결정하기")
    @Nested
    class 이동_여부_결정하기 {

        @DisplayName("이동 조건 충족")
        @Test
        void 이동_조건_충족() {
            //given
            final NumberGenerator numberGenerator = new CanMoveNumberGenerator();
            final MovementStrategy movementStrategy = new RandomMovementStrategy(numberGenerator);
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
            final Distance distance = Distance.zero();

            // when
            Distance move = movementPolicy.move(distance);

            // then
            Assertions.assertThat(move.getValue()).isEqualTo(1);

        }

        @DisplayName("이동 조건 미충족")
        @Test
        void 이동_조건_미충족() {
            //given
            final NumberGenerator numberGenerator = new UnMoveNumberGenerator();
            final MovementStrategy movementStrategy = new RandomMovementStrategy(numberGenerator);
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
            final Distance distance = Distance.zero();

            // when
            Distance move = movementPolicy.move(distance);

            // then
            Assertions.assertThat(move.getValue()).isEqualTo(0);
        }

    }
}