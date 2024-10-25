package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Vehicle;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.global.validator.InputValidator.*;

public class GameController {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MINIMUM_FORWARD_THRESHOLD = 3;

    private final InputView inputView;
    private final OutputView outputView;

    private final List<Vehicle> carList = new ArrayList<>();
    private int round;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        inputCarName();
        inputGameRound();
        startGame();
        printGameWinner();
    }

    private void inputCarName() {
        outputView.printInputCarNameMessage();
        inputView.saveInput();
        validate(ValidationMode.CAR_NAME, inputView.getInput());
        registerCar(inputView.getInput());
    }

    private void registerCar(String input) {
        for (String name : input.split(",")) {
            this.carList.add(new Car(name));
        }
    }

    private void inputGameRound() {
        outputView.printInputGameRoundMessage();
        inputView.saveInput();
        validate(ValidationMode.GAME_ROUND, inputView.getInput());
        this.round = Integer.parseInt(inputView.getInput());
    }

    private void startGame() {
        while (round > 0) {
            playRound();
            printGameRoundResult();
            round--;
        }
    }

    private void playRound() {
        for (Vehicle car : carList) {
            if (isMovingForward()) {
                car.moveForward();
            }
        }
    }

    private boolean isMovingForward() {
        return generateRandomNumber() > MINIMUM_FORWARD_THRESHOLD;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    private void printGameRoundResult() {
        for (Vehicle car : carList) {
            outputView.printGameRoundResult(car.getName(), car.showMovement());
        }
        outputView.printGameRoundSeparator();
    }

    private void printGameWinner() {
        List<String> winners = getWinners();
        String result = String.join(", ", winners);
        outputView.printGameWinner(result);
    }

    private List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Vehicle::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Vehicle::getPosition)
                .max()
                .orElse(0);
    }
}
