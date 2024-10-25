package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.dto.WinnerResponseDto;
import racingcar.service.MoveRule;
import racingcar.service.ThresholdScoreMoveRule;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private final static String CAR_NAME_SPLIT_REGEX = ",";
    private final static int TRAIL_NUMBER_MIN = 0;
    private final MoveRule moveRule;

    private MainController(final MoveRule moveRule) {
        this.moveRule = moveRule;
    }

    public static MainController create() {
        return new MainController(new ThresholdScoreMoveRule());
    }

    public void run() {
        final String carNameInput = InputView.readCarNameInput();
        final List<String> carStrings = splitCarNameInput(carNameInput);
        final List<Car> cars = convertToCars(carStrings);
        final Racing racing = Racing.create(cars);

        final String trialNumberInput = InputView.readTrialNumberInput();
        final int trialNumber = parseTrialNumber(trialNumberInput);
        validateTrialNumber(trialNumber);

        racingGameTrials(racing, trialNumber);
        displayWinners(racing);
    }

    private List<String> splitCarNameInput(final String carNameInput) {
        return Arrays.stream(carNameInput.split(CAR_NAME_SPLIT_REGEX))
                .map(String::trim)
                .toList();
    }

    private List<Car> convertToCars(final List<String> carStrings) {
        return carStrings.stream().map(Car::create).toList();
    }

    private int parseTrialNumber(final String trialNumberInput) {
        int trialNumber;
        try {
            trialNumber = Integer.parseInt(trialNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return trialNumber;
    }

    private void validateTrialNumber(final int trialNumber) {
        if (trialNumber < TRAIL_NUMBER_MIN) {
            throw new IllegalArgumentException();
        }
    }

    private void racingGameTrials(final Racing racing, int trialNumber) {
        for (int i = 0; i < trialNumber; i++) {
            racing.performRace(moveRule);
            List<WinnerResponseDto> result = convertToResultDtos(racing);
            OutputView.printRacingOutput(result);
        }
    }

    private void displayWinners(final Racing racing) {
        List<String> winnerResult = racing.findWinners();
        OutputView.printWinnerOutput(winnerResult);
    }

    private List<WinnerResponseDto> convertToResultDtos(final Racing racing) {
        return racing.getCars().stream()
                .map(car -> WinnerResponseDto.of(car.getName(), car.getPosition()))
                .toList();
    }

}
