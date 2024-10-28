package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RaceGame;
import racingcar.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameController {
    private static final int POSITION_INITIALIZE = 0;
    private final RaceGame raceGame;
    private final GameView gameView;

    public RaceGameController() {
        this.gameView = new GameView();
        String[] carNames = getCarNames();
        List<Car> cars = getCars(carNames);
        int roundCount = getRoundCount();

        this.raceGame = new RaceGame(cars, roundCount);
    }

    private List<Car> getCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], POSITION_INITIALIZE));
        }
        return cars;
    }

    private int getRoundCount() {
        gameView.displayInputRoundNum();
        int roundCount = Integer.parseInt(Console.readLine());
        validateRoundCount(roundCount);
        return roundCount;
    }

    private String[] getCarNames() {
        gameView.displayInputCarNames();
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    public void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("1 이상의 값을 입력헤주세요");
        }
    }

    public void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다");
            }
        }
    }

    public void startRace() {
        gameView.displayRoundStart();
        for (int i = 0; i < raceGame.getRoundCount(); i++) {
            raceGame.playRound();
            gameView.displayRoundResult(raceGame.getCars());
        }
    }

    public void announceWinners() {
        gameView.displayWinners(raceGame.getWinners());
    }

    public void run() {
        startRace();
        announceWinners();
    }
}
