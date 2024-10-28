package racingcar.domain.game;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.player.Player;
import racingcar.exception.game.GameException.GameEndedException;
import racingcar.exception.game.GameException.InvalidTotalRoundsException;
import racingcar.exception.player.PlayerException.PlayerExceededException;
import racingcar.exception.player.PlayerException.PlayerUnderstaffedException;
import racingcar.mock.CanMoveNumberGenerator;


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

            // expect
            Assertions.assertThatCode(() -> Game.start(players, totalRounds, movementPolicy))
                    .doesNotThrowAnyException();
        }

        @DisplayName("최소 플레이어 수 미달로 게임 생성 시도")
        @Test
        void 최소_플레이어_수_미달로_게임_생성_시도() {
            // given
            final List<Player> players = List.of();
            final int totalRounds = 5;
            MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
            final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);

            // expect
            Assertions.assertThatThrownBy(() -> Game.start(players, totalRounds, movementPolicy))
                    .isInstanceOf(PlayerUnderstaffedException.class)
                    .hasMessage("플레이어는 최소 1명 부터 참여할 수 있습니다");
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

            // expect
            Assertions.assertThatThrownBy(() -> Game.start(players, totalRounds, movementPolicy))
                    .isInstanceOf(PlayerExceededException.class)
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

            // expect
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

            // expect
            Assertions.assertThatThrownBy(() -> Game.start(players, totalRounds, movementPolicy))
                    .isInstanceOf(InvalidTotalRoundsException.class)
                    .hasMessage("라운드는 1-10 사이여야 합니다.");
        }

        @DisplayName("게임 진행하기")
        @Nested
        class 게임_진행하기 {

            @DisplayName("정상적인 라운드 진행")
            @Test
            void 정상적인_라운드_진행() {
                // given
                final List<Player> validPlayers = List.of(
                        Player.of(1L, "p1"),
                        Player.of(2L, "p2")

                );
                final int validRounds = 2;
                MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
                final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);
                Game startGame = Game.start(validPlayers, validRounds, movementPolicy);

                // expect
                Assertions.assertThatCode(() -> startGame.play())
                        .doesNotThrowAnyException();
            }

            @DisplayName("종료된 게임 진행 시도")
            @Test
            void 종료된_게임_진행_시도() {
                // given
                final List<Player> validPlayers = List.of(
                        Player.of(1L, "p1"),
                        Player.of(2L, "p2")

                );
                final int validRounds = 2;
                MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
                final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);

                // when
                Game startGame = Game.start(validPlayers, validRounds, movementPolicy);
                Game playedGame = startGame.play();
                Game endGame = playedGame.play();

                // then
                Assertions.assertThatCode(() -> endGame.play())
                        .isInstanceOf(GameEndedException.class)
                        .hasMessage("게임이 이미 종료되었습니다.");
            }
        }

        @DisplayName("게임 종료 확인하기")
        @Nested
        class 게임_종료_확인하기 {
            @DisplayName("진행 중인 게임 확인")
            @Test
            void 진행_중인_게임_확인() {
                // given
                final List<Player> validPlayers = List.of(
                        Player.of(1L, "p1"),
                        Player.of(2L, "p2")

                );
                final int validRounds = 2;
                MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
                final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);

                // when
                Game startGame = Game.start(validPlayers, validRounds, movementPolicy);
                Game playedGame = startGame.play();

                // then
                Assertions.assertThat(playedGame.isFinished()).isFalse();
            }

            @DisplayName("종료된 게임 확인")
            @Test
            void 종료된_게임_확인() {
                // given
                final List<Player> validPlayers = List.of(
                        Player.of(1L, "p1"),
                        Player.of(2L, "p2")

                );
                final int validRounds = 2;
                MovementStrategy movementStrategy = new RandomMovementStrategy(new CanMoveNumberGenerator());
                final MovementPolicy movementPolicy = new MovementPolicy(movementStrategy);

                // when
                Game startGame = Game.start(validPlayers, validRounds, movementPolicy);
                Game playedGame = startGame.play();
                Game endGame = playedGame.play();

                // then
                Assertions.assertThat(endGame.isFinished()).isTrue();
            }
        }
    }
}