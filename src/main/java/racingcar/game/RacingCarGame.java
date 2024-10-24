package racingcar.game;

import static racingcar.game.policy.GamePlayersPolicy.GAME_MAXIMUM_PLAYERS;
import static racingcar.game.policy.GamePlayersPolicy.GAME_MINIMUM_PLAYERS;
import static racingcar.game.policy.GameRoundPolicy.GAME_MAXIMUM_ROUND;
import static racingcar.game.policy.GameRoundPolicy.GAME_MINIMUM_ROUND;

import java.util.List;
import racingcar.car.Car;
import racingcar.game.exception.GamePlayersException.MaximumPlayersExceededException;
import racingcar.game.exception.GamePlayersException.MinimumPlayersRequiredException;
import racingcar.game.exception.GameRoundException.MaximumGameRoundExceededException;
import racingcar.game.exception.GameRoundException.MinimumGameRoundRequiredException;

public class RacingCarGame {
    private final int roundLoopCount;
    private final List<Car> cars;

    private RacingCarGame(int roundLoopCount, List<Car> cars) {
        this.roundLoopCount = roundLoopCount;
        this.cars = cars;
    }

    public static RacingCarGame createLoopedRacingCarGame(int roundLoopCount, List<Car> cars) {
        if(cars.size() < GAME_MINIMUM_PLAYERS){
                throw new MinimumPlayersRequiredException();
        }

        if(cars.size() > GAME_MAXIMUM_PLAYERS){
                throw new MaximumPlayersExceededException();
        }

        if(roundLoopCount < GAME_MINIMUM_ROUND){
                throw new MinimumGameRoundRequiredException();
        }

        if(roundLoopCount > GAME_MAXIMUM_ROUND){
            throw new MaximumGameRoundExceededException();
        }

        return new RacingCarGame(roundLoopCount,cars);
    }
}
