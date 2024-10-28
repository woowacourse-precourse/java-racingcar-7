package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.validator.Validator;
import racingcar.view.GameView;

public final class GameController {
    private final GameView gameView;
    private Game game;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        gameSetup();
        doRace();
        showResult();
    }

    public void gameSetup() {
        String carNamesInput = gameView.getCarNamesInput();
        // 파싱과정에서 조건에 맞게 validate하기! -> 유효한 이름, 5글자 이하
        List<String> carNameList = parseCarNames(carNamesInput);
        
        game = new Game(readTotalRound());
        for (String carName : carNameList) {
            game.addCar(new Car(carName));
        }
    }

    public void doRace() {
        gameView.displayGameStart();

        for (int i = 0; i < game.getTotalRound(); i++) {
            game.playRound();
            displayCarsPositions();
            gameView.displayNewLine();
        }
    }

    public void showResult() {
        String winnerString = game.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        gameView.displayWinners(winnerString);
    }

    public int readTotalRound() {
        String totalRoundInput = gameView.getTotalRoundInput();

        Validator.validateTotalRoundInput(totalRoundInput);

        return Integer.parseInt(totalRoundInput);
    }

    public List<String> parseCarNames(String carNamesInput) {
        List<String> carNameList;

        carNameList = Arrays.asList(carNamesInput.split(","));

        return carNameList;
    }

    public void displayCarsPositions() {
        for (Car car : game.getCarList()) {
            gameView.displayCarPosition(car.toString());
        }
    }
}
