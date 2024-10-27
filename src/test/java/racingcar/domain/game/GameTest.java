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
import racingcar.exception.game.InvalidRoundsException.InvalidTotalRoundsException;
import racingcar.exception.player.InvalidPlayerCountException.PlayerCountExceededException;
import racingcar.exception.player.InvalidPlayerCountException.PlayerCountShortException;


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

        @DisplayName("최소 플레이어 수 미달로 게임 생성 시도")
        @Test
        void 최소_플레이어_수_미달로_게임_생성_시도() {
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

        @DisplayName("최대 라운드 수 초과로 게임 생성 시도")
        @Test
        void 최대_라운드_수_초과로_게임_생성_시도() {
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

        @DisplayName("최소 라운드 수 미달로 게임 생성 시도")
        @Test
        void 최소_라운드_수_미달로_게임_생성_시도() {
            // given
            final List<Player> players = List.of(
                    Player.of(1L, "p1"),
                    Player.of(2L, "p2")

            );
            final int totalRounds = 0;
            MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
            Assertions.assertThatThrownBy(() -> Game.start(players, totalRounds, movementPolicy))
                    .isInstanceOf(InvalidTotalRoundsException.class)
                    .hasMessage("라운드는 1-10 사이여야 합니다.");
        }

        @DisplayName("최대 라운드 수 초과로 게임 생성 시도")
        @Test
        void 최대_라운드_수_초과로_게임_생성시도() {
            // given
            final List<Player> players = List.of(
                    Player.of(1L, "p1"),
                    Player.of(2L, "p2")

            );
            final int totalRounds = 11;
            MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
            Assertions.assertThatThrownBy(() -> Game.start(players, totalRounds, movementPolicy))
                    .isInstanceOf(InvalidTotalRoundsException.class)
                    .hasMessage("라운드는 1-10 사이여야 합니다.");
        }


    }

}