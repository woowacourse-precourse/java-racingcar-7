package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RaceGame;
import racingcar.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameController {
    private final RaceGame raceGame;
    private final GameView gameView;
    private final int roundCount;

    public RaceGameController() {
        this.gameView = new GameView();
        gameView.displayInputCarNames();
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], 0));
        }
        gameView.displayInputRoundNum();
        roundCount = Integer.parseInt(Console.readLine());
        validateRoundCount(roundCount);

        this.raceGame = new RaceGame(cars);
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("1 이상의 값을 입력헤주세요");
        }
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다");
            }
        }
    }

    private void startRace() {
        gameView.displayRoundStart();
        for (int i = 0; i < roundCount; i++) {
            raceGame.playRound();
            gameView.displayRoundResult(raceGame.getCars());
        }
    }

    private void announceWinners() {
        gameView.displayWinners(raceGame.getWinners());
    }

    public void run() {
        startRace();
        announceWinners();
    }
}
