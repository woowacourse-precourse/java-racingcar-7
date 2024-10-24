package racingcar.game;

import static racingcar.game.PlayersCar.*;
import static racingcar.game.RoundLoopCount.*;
import java.util.List;
import racingcar.car.Car;


public class RacingCarGame {
    private final RoundLoopCount roundLoopCount;
    private final PlayersCar playersCar;

    private RacingCarGame(RoundLoopCount roundLoopCount, PlayersCar playersCar) {
        this.roundLoopCount = roundLoopCount;
        this.playersCar = playersCar;
    }

    public static RacingCarGame createLoopedRacingCarGame(int roundLoopCount, List<Car> playersCar) {
        return new RacingCarGame(
                createRoundLoopCount(roundLoopCount),
                createPlayersCar(playersCar)
        );
    }
}
