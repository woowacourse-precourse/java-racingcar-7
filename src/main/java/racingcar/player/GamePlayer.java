package racingcar.player;

import racingcar.car.RacingCar;
import racingcar.game.GameNumberGenerator;

public class GamePlayer {
    private final PlayerName playerName;
    private final RacingCar racingCar;

    private GamePlayer(PlayerName playerName, RacingCar racingCar) {
        this.playerName = playerName;
        this.racingCar = racingCar;
    }

    public static GamePlayer of(String playerName) {
        return new GamePlayer(
                PlayerName.create(playerName),
                RacingCar.create()
        );
    }

    public String providePlayerName() {
        return playerName.getValue();
    }

    public int pickGameNumberBy(GameNumberGenerator gameNumberGenerator) {
        return gameNumberGenerator.generate();
    }

    public GamePlayer moveCarForward(int steps) {
        return new GamePlayer(
                this.playerName,
                racingCar.increaseDistanceBy(steps)
        );
    }
    public int provideRacingCarDistance(){
        return racingCar.provideCurrentPosition();
    }

    private RacingCar createCar() {
        return RacingCar.create();
    }

}
