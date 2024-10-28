package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.GameResult;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.dto.request.GameStartRequest;
import racingcar.exception.game.GameException.GameNotInitializedException;
import racingcar.mock.CanMoveNumberGenerator;
import racingcar.repository.MemoryPlayerRepository;
import racingcar.util.IdGenerator;


@DisplayName("게임 서비스(GaeService) 유스케이스")
class GameServiceTest {

    private GameService createGameService() {
        PlayerService playerService = new PlayerService(
                new MemoryPlayerRepository(),
                new IdGenerator()
        );
        MovementPolicy movementPolicy = new MovementPolicy(
                new RandomMovementStrategy(new CanMoveNumberGenerator())
        );
        return new GameService(playerService, movementPolicy);
    }

    private GameStartRequest createGameStartRequest() {
        return new GameStartRequest(List.of("p1", "p2", "p3"), 5);
    }


    @DisplayName("게임 초기화하기")
    @Nested
    class 게임_초기화하기 {

        @DisplayName("정상적인 게임 초기화")
        @Test
        void 정상적인_게임_초기화() {
            // given
            GameStartRequest gameStartRequest = createGameStartRequest();
            GameService gameService = createGameService();

            // expect
            Assertions.assertThatCode(() -> gameService.initialize(gameStartRequest))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("라운드 진행하기")
    @Nested
    class 라운드_진행하기 {

        @DisplayName("정상적인 라운드 진행")
        @Test
        void 정상적인_라운드_진행() {
            // given
            GameStartRequest gameStartRequest = createGameStartRequest();
            GameService gameService = createGameService();

            gameService.initialize(gameStartRequest);

            // expect
            Assertions.assertThatCode(() -> gameService.playRound())
                    .doesNotThrowAnyException();

        }

        @DisplayName("정상적인 게임 결과 반환")
        @Test
        void 정상적인_게임_결과_반환() {
            // given
            GameStartRequest gameStartRequest = createGameStartRequest();
            GameService gameService = createGameService();

            gameService.initialize(gameStartRequest);

            // when
            GameResult gameResult = gameService.playRound();

            Assertions.assertThat(gameResult).isNotNull();

        }

        @DisplayName("게임 비초기화시 라운드 진행 시도")
        @Test
        void 게임_비초기화시_라운드_진행_시도() {
            // given
            GameService gameService = createGameService();

            // expect
            Assertions.assertThatCode(() -> gameService.playRound())
                    .isInstanceOf(GameNotInitializedException.class)
                    .hasMessage("게임이 초기화되지 않았습니다.");

        }

    }

}