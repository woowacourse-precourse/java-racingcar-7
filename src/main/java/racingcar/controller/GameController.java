package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

public final class GameController {
    private final GameView gameView;
    private Game game;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        Game game = gameSetup();
        doRace();
    }

    public Game gameSetup() {
        String carNamesInput = gameView.getCarNamesInput();
        // 파싱과정에서 조건에 맞게 validate하기! -> 유효한 이름, 5글자 이하
        List<String> carNameList = parseCarNames(carNamesInput);

        // 입력값 정수인지 validate하기
        int totalRound = Integer.parseInt(gameView.getTotalRoundInput());

        Game game = new Game(totalRound);
        for (String carName : carNameList) {
            game.addCar(new Car(carName));
        }

        return game;
    }

    public void doRace() {
        gameView.displayGameStart();

        for (int i = 0; i < game.getTotalRound(); i++) {
            game.playRound();
            displayCarsPositions();
        }
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
