package racingcar.game;

import static racingcar.game.PlayersCar.*;
import static racingcar.game.RoundLoopCount.*;
import java.util.List;
import racingcar.car.RacingCar;


public class RacingCarGame {
    private final RoundLoopCount roundLoopCount;
    private final PlayersCar playersCar;

    private RacingCarGame(RoundLoopCount roundLoopCount, PlayersCar playersCar) {
        this.roundLoopCount = roundLoopCount;
        this.playersCar = playersCar;
    }

    public static RacingCarGame createLoopedRacingCarGame(int roundLoopCount, List<RacingCar> playersRacingCar) {
        return new RacingCarGame(
                createRoundLoopCount(roundLoopCount),
                createPlayersCar(playersRacingCar)
        );
    }
}
