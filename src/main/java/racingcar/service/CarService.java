package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.GameBoard;
import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
    private final GameBoard gameBoard = new GameBoard(new ArrayList<>());
    private final List<String> winners = new ArrayList<>();
    private String[] carNames;
    private int moveCount;

    public void createGame(String carNames) {
        splitCarNames(carNames);
        for (String carName: this.carNames) {
            validateCarNames(carName);
            gameBoard.addCar(new Car(carName, 0));
        }
    }

    public void splitCarNames(String carNames) {
        this.carNames = carNames.split(",");
    }

    public void validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void playGame() {
        for (Car car : gameBoard.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
        this.moveCount = moveCount;
    }

    public void determineWinner() {
        int maxMoved = getMaxMoved();
        for (Car car : gameBoard.getCars()) {
            if (car.getCarMoved() == maxMoved) {
                winners.add(car.getCarName());
            }
        }
    }

    public int getMaxMoved() {
        int maxMoved = 0;
        for (Car car : gameBoard.getCars()) {
            maxMoved = Math.max(maxMoved, car.getCarMoved());
        }
        return maxMoved;
    }

    public List<String> getWinners() {
        return winners;
    }
}
