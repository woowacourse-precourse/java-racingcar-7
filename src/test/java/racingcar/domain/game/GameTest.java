package racingcar.domain.game;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.mock.CanMoveNumberGenerator;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.player.Player;
import racingcar.exception.InvalidPlayerCountException.PlayerCountExceededException;
import racingcar.exception.InvalidPlayerCountException.PlayerCountShortException;


/**
 * - [ ] 게임 시작하기 - [ ] 정상적인 게임 생성 - [ ] 부적절한 플레이어 수로 게임 생성 시도
 */
@DisplayName("게임(Game) 유스케이스")
class GameTest {

    @DisplayName("게임 시작하기")
    @Nested
    class 게임_시작하기 {

        @DisplayName("정상적인 게임 생성")
        @Test
        void 정상적인_게임_생성() {
            // given
            final List<Player> players = List.of(
                    Player.of(1L, "p1"),
                    Player.of(2L, "p2"),
                    Player.of(3L, "p3")
            );
            final int totalRounds = 5;
            MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
            Game.start(players, totalRounds, movementPolicy);
        }

        @DisplayName("부적절한 플레이어 수로 게임 생성 시도 - 미달")
        @Test
        void 부적절한_플레이어_수로_게임_생성_시도_미달() {
            // given
            final List<Player> players = List.of(
                    Player.of(1L, "p1")
            );
            final int totalRounds = 5;
            MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
            Assertions.assertThatThrownBy(() -> Game.start(players, totalRounds, movementPolicy))
                    .isInstanceOf(PlayerCountShortException.class)
                    .hasMessage("플레이어는 최소 2명 부터 참여할 수 있습니다");
        }

        @DisplayName("부적절한 플레이어 수로 게임 생성 시도 - 초과")
        @Test
        void 부적절한_플레이어_수로_게임_생성_시도_초과() {
            // given
            final List<Player> players = List.of(
                    Player.of(1L, "p"),
                    Player.of(2L, "p"),
                    Player.of(3L, "p"),
                    Player.of(4L, "p"),
                    Player.of(5L, "p"),
                    Player.of(6L, "p")

            );
            final int totalRounds = 5;
            MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
            Assertions.assertThatThrownBy(() -> Game.start(players, totalRounds, movementPolicy))
                    .isInstanceOf(PlayerCountExceededException.class)
                    .hasMessage("플레이어는 최대 5명 까지 참여할 수 있습니다");
        }

    }

}