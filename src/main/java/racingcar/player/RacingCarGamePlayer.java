package racingcar.player;

import racingcar.car.Car;
import racingcar.game.GameNumberGenerator;

public class RacingCarGamePlayer {
    private final PlayerName playerName;

    private RacingCarGamePlayer(PlayerName playerName) {
        this.playerName = playerName;
    }

    public static RacingCarGamePlayer createRacingCarGamePlayer(String playerName) {
        return new RacingCarGamePlayer(
                PlayerName.createPlayerName(playerName)
        );
    }

    public String provideSelfName() {
        return playerName.getValue();
    }

    public Car createRacingCar() {
        return Car.createNamedCar();
    }

    public int pickGameNumber(GameNumberGenerator gameNumberGenerator) {
        return gameNumberGenerator.generate();
    }
}
