package racingcar.service;

import java.util.List;
import racingcar.domain.game.Game;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.player.Player;
import racingcar.dto.request.GameStartRequest;

public class GameService {
    private final PlayerService playerService;
    private final MovementPolicy movementPolicy;
    private Game game;

    public GameService(
            PlayerService playerService,
            MovementPolicy movementPolicy) {
        this.playerService = playerService;
        this.movementPolicy = movementPolicy;
    }

    public void initialize(GameStartRequest request) {
        List<Player> players = playerService.register(request.playerNames());
        game = Game.start(
                players,
                request.rounds(),
                movementPolicy
        );
    }

}
