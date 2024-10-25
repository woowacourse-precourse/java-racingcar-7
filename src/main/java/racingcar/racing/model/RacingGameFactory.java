package racingcar.racing.model;

public interface RacingGameFactory {
    Game createGame();
    Car createCars();
    Winner createWinners();
}
