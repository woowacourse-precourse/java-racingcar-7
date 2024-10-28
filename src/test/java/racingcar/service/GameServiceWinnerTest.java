package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.dto.request.GameStartRequest;
import racingcar.dto.response.Winners;
import racingcar.mock.AlternateNumberGenerator;
import racingcar.mock.CanMoveNumberGenerator;
import racingcar.repository.MemoryPlayerRepository;
import racingcar.util.IdGenerator;


@DisplayName("게임 서비스(GaeService) 승자 유스케이스")
public class GameServiceWinnerTest {
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

    private GameService createGameServiceWithAlternateNumberGenerator() {
        PlayerService playerService = new PlayerService(
                new MemoryPlayerRepository(),
                new IdGenerator()
        );
        MovementPolicy movementPolicy = new MovementPolicy(
                new RandomMovementStrategy(new AlternateNumberGenerator())
        );
        return new GameService(playerService, movementPolicy);
    }

    @DisplayName("승자들 조회하기")
    @Nested
    class 승자들_조회하기 {

        @DisplayName("단독 승자 확인")
        @Test
        void 단독_승자_확인() {
            // given
            GameService gameService = createGameServiceWithAlternateNumberGenerator();
            GameStartRequest gameStartRequest = new GameStartRequest(List.of("p1", "p2"), 3);
            gameService.initialize(gameStartRequest);
            gameService.playRound();
            gameService.playRound();
            gameService.playRound();

            // when
            Winners winners = gameService.getWinners();
            int totalWinners = winners.names().size();

            // then
            Assertions.assertThat(totalWinners).isEqualTo(1);

        }

        @DisplayName("공동 승자 확인")
        @Test
        void 공동_승자_확인() {
            // given
            GameService gameService = createGameService();
            GameStartRequest gameStartRequest = new GameStartRequest(List.of("p1", "p2", "p3"), 4);
            gameService.initialize(gameStartRequest);
            gameService.playRound();
            gameService.playRound();
            gameService.playRound();
            gameService.playRound();

            // when
            Winners winners = gameService.getWinners();
            int totalWinners = winners.names().size();

            // then
            Assertions.assertThat(totalWinners).isEqualTo(3);
        }
    }

}
