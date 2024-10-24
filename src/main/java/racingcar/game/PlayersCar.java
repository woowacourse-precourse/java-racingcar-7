package racingcar.game;

import static racingcar.game.policy.GamePlayersPolicy.GAME_MAXIMUM_PLAYERS;
import static racingcar.game.policy.GamePlayersPolicy.GAME_MINIMUM_PLAYERS;

import java.util.List;
import racingcar.car.Car;
import racingcar.game.exception.GamePlayersException.MaximumPlayersExceededException;
import racingcar.game.exception.GamePlayersException.MinimumPlayersRequiredException;

public class PlayersCar {
    private final List<Car> playersCar;

    private PlayersCar(List<Car> playersCar) {
        validatePlayersCar(playersCar);
        this.playersCar = playersCar;
    }
    public static PlayersCar createPlayersCar(List<Car> playersCar){
        return new PlayersCar(playersCar);
    }
    private void validatePlayersCar(List<Car> playersCar){
        validateMinSize(playersCar);
        validateMaxSize(playersCar);
    }
    private void validateMinSize(List<Car> playersCar){
        if(playersCar.size() < GAME_MINIMUM_PLAYERS){
                throw new MinimumPlayersRequiredException();
        }
    }

    private void validateMaxSize(List<Car> playersCar){
        if(playersCar.size() > GAME_MAXIMUM_PLAYERS){
                throw new MaximumPlayersExceededException();
        }
    }

}
