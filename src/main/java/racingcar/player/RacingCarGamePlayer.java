package racingcar.player;

import racingcar.car.Car;

public class RacingCarGamePlayer {
    private final String playerName;

    private RacingCarGamePlayer(String playerName) {
        this.playerName = playerName;
    }

    public static RacingCarGamePlayer createRacingCarGamePlayer(String playerName) {
        return new RacingCarGamePlayer(playerName);
    }

    public String provideSelfName() {
        return playerName;
    }

    public Car createRacingCar() {
        return Car.createNamedCar(playerName);
    }
}
