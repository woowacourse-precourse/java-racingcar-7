package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RaceRounds raceRounds;
    private final ScoreBoard scoreBoard;

    public RacingGame(Cars cars, RaceRounds raceRounds, ScoreBoard scoreBoard) {
        this.cars = cars;
        this.raceRounds = raceRounds;
        this.scoreBoard = scoreBoard;
    }

    public ScoreBoard play() {
        moveCarsInRounds();
        scoreBoard.recordWinners(cars.getWinnerNames());
        return scoreBoard;
    }

    private void moveCarsInRounds() {
        raceRounds.forEach(() -> {
            cars.moveAll();
            scoreBoard.recordRound(createRoundScores());
        });
    }

    private RoundScores createRoundScores() {
        List<CarState> carStates = cars.carList().stream()
                .map(this::getCarState)
                .toList();
        return new RoundScores(carStates);
    }

    private CarState getCarState(Car car) {
        return new CarState(car.getName(), car.getPosition());
    }
}
