package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.dto.request.GameStartRequest;
import racingcar.mock.CanMoveNumberGenerator;
import racingcar.repository.MemoryPlayerRepository;
import racingcar.util.IdGenerator;


@DisplayName("게임 서비스(GaeService) 유스케이스")
class GameServiceTest {

    @DisplayName("게임 초기화하기")
    @Nested
    class 게임_초기화하기 {

        @DisplayName("정상적인 게임 초기화")
        @Test
        void 정상적인_게임_초기화() {
            // given
            PlayerService playerService = new PlayerService(
                    new MemoryPlayerRepository(),
                    new IdGenerator()
            );
            MovementPolicy movementPolicy = new MovementPolicy(
                    new RandomMovementStrategy(new CanMoveNumberGenerator())
            );

            GameService gameService = new GameService(playerService, movementPolicy);

            GameStartRequest gameStartRequest = new GameStartRequest(List.of("p1", "p2", "p3"), 5);

            // expect
            Assertions.assertThatCode(() -> gameService.initialize(gameStartRequest))
                    .doesNotThrowAnyException();
        }
    }
}