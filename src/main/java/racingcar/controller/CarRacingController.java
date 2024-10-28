package racingcar.controller;

import static racingcar.global.Exception.CarNameException.*;
import static racingcar.global.Exception.TotalRoundException.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.global.Exception.TotalRoundException.InvalidTotalRoundFormatException;
import racingcar.model.Car;
import racingcar.model.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {

    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";

    private final InputView inputView;
    private final OutputView outputView;
    private CarRacing carRacing;
    private int totalRound;

    public CarRacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * 자동차 경주 게임 진행
     */
    public void run() {
        setUpCarRacing();
        setUpTotalRound();
        startCarRacing();
        displayFinalWinner();
    }

    private void setUpCarRacing() {
        String carNameInput = inputView.getRacingCarNameInput();
        List<String> carNames = validateCarNameInput(carNameInput);
        List<Car> racingCars = carNames.stream().map(Car::new).toList();
        this.carRacing = new CarRacing(racingCars);
    }

    private void setUpTotalRound() {
        String totalRoundInput = inputView.getTotalRoundInput();
        validateTotalRoundInput(totalRoundInput);
    }

    private void startCarRacing() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < totalRound; i++) {
            carRacing.moverCarsForwardRandomly();
            outputView.showRoundResult(carRacing.getRacingCars());
        }
    }

    private void displayFinalWinner() {
        outputView.showFinalWinner(carRacing.getWinners());
    }

    /**
     * 자동차 이름 문자열의 유효성 검증
     */
    public List<String> validateCarNameInput(String carNameInput) {
        String trimmedCarNameInput = carNameInput.replaceAll(WHITE_SPACE, EMPTY_STRING);

        if (trimmedCarNameInput.isEmpty()) {
            throw new EmptyCarNameException();
        }
        if (!trimmedCarNameInput.contains(",")) {
            throw new InsufficientCarNamesException();
        }

        List<String> carNames = Arrays.stream(trimmedCarNameInput.split(",")).toList();
        Set<String> nameSet = new HashSet<>();
        if (carNames.size() == 1 || carNames.contains(EMPTY_STRING)) {
            throw new InsufficientCarNamesException();
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new LongCarNameException(name);
            }
            if (!nameSet.add(name)) {
                throw new DuplicatedCarNameException();
            }
        }
        return carNames;
    }

    /**
     * 시도 횟수 문자열의 유효성 검증
     */
    public void validateTotalRoundInput(String totalRoundInput) {
        if (totalRoundInput == null || totalRoundInput.trim().equals(EMPTY_STRING)) {
            throw new EmptyTotalRoundException();
        }
        try {
            totalRound = Integer.parseInt(totalRoundInput);
        } catch (NumberFormatException e) {
            throw new InvalidTotalRoundFormatException();
        }
        if (totalRound <= 0) {
            throw new NonPositiveRoundException();
        }
    }
}
