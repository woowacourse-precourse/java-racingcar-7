package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.game.exception.GamePlayersException.MaximumPlayersExceededException;
import racingcar.domain.game.exception.GamePlayersException.MinimumPlayersRequiredException;
import racingcar.domain.game.policy.GamePlayersPolicy;

public class PlayersCar {
    private final List<Car> playersCar;

    private PlayersCar(List<Car> playersCar) {
        validatePlayersCar(playersCar);
        this.playersCar = playersCar;
    }

    public static PlayersCar createPlayersCar(List<Car> playersCar) {
        return new PlayersCar(playersCar);
    }

    private void validatePlayersCar(List<Car> playersCar) {
        validateMinSize(playersCar);
        validateMaxSize(playersCar);
    }

    private void validateMinSize(List<Car> playersCar) {
        if (playersCar.size() < GamePlayersPolicy.GAME_MINIMUM_PLAYERS) {
            throw new MinimumPlayersRequiredException();
        }
    }

    private void validateMaxSize(List<Car> playersCar) {
        if (playersCar.size() > GamePlayersPolicy.GAME_MAXIMUM_PLAYERS) {
            throw new MaximumPlayersExceededException();
        }
    }

}
