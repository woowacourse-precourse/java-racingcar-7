package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.GameBoard;
import racingcar.domain.RaceJudge;
import java.util.List;

public class GameService {
    private final GameBoard gameBoard;
    private final RaceJudge raceJudge;

    public GameService(GameBoard gameBoard, RaceJudge raceJudge) {
        this.gameBoard = gameBoard;
        this.raceJudge = raceJudge;
    }

    public void initializeGame(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        gameBoard.setupCars(cars);
    }

    public List<Car> gameStart() {
        gameBoard.playRound();
        return gameBoard.getCars();
    }

    public List<String> determineWinners() {
        return raceJudge.getWinners(gameBoard.getCars());
    }
}