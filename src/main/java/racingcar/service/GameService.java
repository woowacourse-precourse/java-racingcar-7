package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.GameBoard;
import racingcar.domain.RaceJudge;
import java.util.List;

public class GameService {
    private final GameBoard gameBoard;
    private final RaceJudge raceJudge;
    private int totalRounds;

    public GameService(GameBoard gameBoard, RaceJudge raceJudge) {
        this.gameBoard = gameBoard;
        this.raceJudge = raceJudge;
    }

    public void initializeGame(List<String> carNames, int totalRounds) {
        this.totalRounds = totalRounds;
        gameBoard.setupCars(carNames);
    }

    public List<Car> gameStart() {
        for (int i = 0; i < totalRounds; i++) {
            gameBoard.playRound();
        }
        return gameBoard.getCars();
    }

    public List<String> determineWinners() {
        return raceJudge.getWinners(gameBoard.getCars());
    }
}