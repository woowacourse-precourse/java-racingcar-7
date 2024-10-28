package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.game.NumberGenerator;
import racingcar.domain.game.RandomNumberGenerator;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.repository.MemoryPlayerRepository;
import racingcar.repository.PlayerRepository;
import racingcar.service.GameService;
import racingcar.service.PlayerService;
import racingcar.util.IdGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController controller = createGameController();
        controller.start();
    }

    private static GameController createGameController() {

        NumberGenerator generator = new RandomNumberGenerator();
        MovementStrategy strategy = new RandomMovementStrategy(generator);
        MovementPolicy movementPolicy = new MovementPolicy(strategy);

        PlayerRepository repository = new MemoryPlayerRepository();
        IdGenerator idGenerator = new IdGenerator();

        PlayerService playerService = new PlayerService(
                repository,
                idGenerator
        );

        GameService gameService = new GameService(
                playerService,
                movementPolicy
        );

        return new GameController(
                gameService
        );
    }
}
