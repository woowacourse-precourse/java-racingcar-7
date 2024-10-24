package racingcar.game;

import static racingcar.game.policy.GamePlayersPolicy.GAME_MAXIMUM_PLAYERS;
import static racingcar.game.policy.GamePlayersPolicy.GAME_MINIMUM_PLAYERS;
import static racingcar.game.policy.GameRoundPolicy.GAME_MAXIMUM_ROUND;
import static racingcar.game.policy.GameRoundPolicy.GAME_MINIMUM_ROUND;

import java.util.List;
import racingcar.car.Car;

public class RacingCarGame {
    private final int loop;
    private final List<Car> cars;

    private RacingCarGame(int loop, List<Car> cars) {
        this.loop = loop;
        this.cars = cars;
    }

    public static RacingCarGame createLoopedRacingCarGame(int loop, List<Car> cars) {
        if(cars.size() < GAME_MINIMUM_PLAYERS){
                throw new IllegalArgumentException(String.format("자동차 최소 %d대부터 게임 가능합니다.",GAME_MINIMUM_PLAYERS));
        }

        if(cars.size() > GAME_MAXIMUM_PLAYERS){
                throw new IllegalArgumentException(String.format("자동차 최대 %d대까지 게임 가능합니다.",GAME_MAXIMUM_PLAYERS));
        }

        if(loop < GAME_MINIMUM_ROUND){
                throw new IllegalArgumentException(String.format("게임횟수 최소 1번부터 게임 가능합니다", GAME_MINIMUM_ROUND));
        }

        if(loop > GAME_MAXIMUM_ROUND){
            throw new IllegalArgumentException(String.format("게임횟수 최대 100번까지 게임 가능합니다", GAME_MAXIMUM_ROUND));
        }

        return new RacingCarGame(loop,cars);
    }
}
