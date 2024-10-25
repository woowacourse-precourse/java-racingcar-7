package racingcar.game;

import static racingcar.game.policy.GamePlayersPolicy.GAME_MAXIMUM_PLAYERS;
import static racingcar.game.policy.GamePlayersPolicy.GAME_MINIMUM_PLAYERS;

import java.util.List;
import racingcar.car.RacingCar;
import racingcar.game.exception.GamePlayersException.MaximumPlayersExceededException;
import racingcar.game.exception.GamePlayersException.MinimumPlayersRequiredException;

public class PlayersCar {
    private final List<RacingCar> playersRacingCar;

    private PlayersCar(List<RacingCar> playersRacingCar) {
        validatePlayersCar(playersRacingCar);
        this.playersRacingCar = playersRacingCar;
    }
    public static PlayersCar createPlayersCar(List<RacingCar> playersRacingCar){
        return new PlayersCar(playersRacingCar);
    }
    private void validatePlayersCar(List<RacingCar> playersRacingCar){
        validateMinSize(playersRacingCar);
        validateMaxSize(playersRacingCar);
    }
    private void validateMinSize(List<RacingCar> playersRacingCar){
        if(playersRacingCar.size() < GAME_MINIMUM_PLAYERS){
                throw new MinimumPlayersRequiredException();
        }
    }

    private void validateMaxSize(List<RacingCar> playersRacingCar){
        if(playersRacingCar.size() > GAME_MAXIMUM_PLAYERS){
                throw new MaximumPlayersExceededException();
        }
    }

}
