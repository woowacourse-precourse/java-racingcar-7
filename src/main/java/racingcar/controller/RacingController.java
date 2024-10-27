package racingcar.controller;

import static racingcar.error.ErrorType.CAR_NAME_DUPLICATE_ERROR;
import static racingcar.error.ErrorType.INVALID_FORMAT_TRAIL_NUMBER_ERROR;
import static racingcar.error.ErrorType.MIN_TRAIL_NUMBER;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.dto.WinnerResponseDto;
import racingcar.service.RaceService;
import racingcar.service.ThresholdScoreRaceService;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final static String CAR_NAME_SPLIT_REGEX = ",";
    private final static int TRAIL_NUMBER_MIN = 0;
    private final static int CAR_POSITION_MIN = 0;
    private final RaceService raceService;

    private RacingController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public static RacingController create() {
        return new RacingController(createThresholdScoreMoveRule());
    }

    public static ThresholdScoreRaceService createThresholdScoreMoveRule() {
        return new ThresholdScoreRaceService(createNumberGenerator());
    }

    public static NumberGenerator createNumberGenerator() {
        return RandomNumberGenerator.getInstance();
    }

    public void run() {
        final String carNameInput = InputView.readCarNameInput();
        final List<String> carStrings = splitCarNameInput(carNameInput);
        final List<Car> cars = convertToCars(carStrings);
        final Racing racing = new Racing(cars);

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
        Set<String> carNames = new LinkedHashSet<>();
        return carStrings.stream()
                .map(carName -> {
                    if (!carNames.add(carName)) {
                        throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR.getMessage());
                    }
                    return Car.create(carName, CAR_POSITION_MIN);
                })
                .toList();
    }

    private int parseTrialNumber(final String trialNumberInput) {
        int trialNumber;
        try {
            trialNumber = Integer.parseInt(trialNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_FORMAT_TRAIL_NUMBER_ERROR.getMessage());
        }
        return trialNumber;
    }

    private void validateTrialNumber(final int trialNumber) {
        if (trialNumber < TRAIL_NUMBER_MIN) {
            throw new IllegalArgumentException(MIN_TRAIL_NUMBER.getMessage());
        }
    }

    private void racingGameTrials(final Racing racing, int trialNumber) {
        for (int i = 0; i < trialNumber; i++) {
            raceService.performRace(racing);
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
