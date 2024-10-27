package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;


public class RacingCarGame {
    private final RoundLoopCount roundLoopCount;
    private final PlayersCar playersCar;

    private RacingCarGame(RoundLoopCount roundLoopCount, PlayersCar playersCar) {
        this.roundLoopCount = roundLoopCount;
        this.playersCar = playersCar;
    }

    public static RacingCarGame createLoopedRacingCarGame(int roundLoopCount, List<Car> playersCar) {
        return new RacingCarGame(
                RoundLoopCount.createRoundLoopCount(roundLoopCount),
                PlayersCar.createPlayersCar(playersCar)
        );
    }
}
