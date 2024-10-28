package racingcar.service;

import static racingcar.constant.ErrorType.CAR_NAME_TOO_LONG;
import static racingcar.constant.ErrorType.EMPTY_INPUT;
import static racingcar.constant.ErrorType.INVALID_RACE_COUNT;
import static racingcar.constant.ErrorType.NOT_ENOUGH_CAR;
import static racingcar.util.StringSplitter.splitByComma;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.constant.InputType;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingService {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<String, RacingCar> racingCars = new LinkedHashMap<>();
    private final StringBuilder roundResultsBuilder = new StringBuilder();

    public RacingService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getInputCarName() {
        String carNames = requestInputString(InputType.CAR_NAME);
        if (isBlank(carNames)) {
            throw new IllegalArgumentException((EMPTY_INPUT.getMessage()));
        }
        return carNames;
    }

    public int getInputTotalRound() {
        String totalRound = requestInputString(InputType.TOTAL_ROUND);
        if (isBlank(totalRound)) {
            throw new IllegalArgumentException((EMPTY_INPUT.getMessage()));
        }
        if (!isInteger(totalRound)) {
            throw new IllegalArgumentException((INVALID_RACE_COUNT.getMessage()));
        }
        return Integer.parseInt(totalRound);
    }

    public void addRacingCar(String inputCarNames) {
        List<String> carNames = getValidCarNames(inputCarNames);
        carNames.forEach(carName -> racingCars.put(carName, new RacingCar(carName)));
    }

    public void playGame(int inputTotalRound) {
        if (inputTotalRound < 1) {
            throw new IllegalArgumentException((INVALID_RACE_COUNT.getMessage()));
        }

        int round = 0;
        while (round < inputTotalRound) {
            playRound();
            buildRoundResult(isLastRound(round, inputTotalRound));
            round++;
        }
        outputView.responseRoundResult(roundResultsBuilder);
    }

    public void responseGameResult() {
        List<String> winners = findWinners();
        if (winners.isEmpty()) {
            outputView.responseGameResult("우승자가 없습니다.");
        } else {
            outputView.responseGameResult(String.join(", ", winners));
        }
    }

    private List<String> getValidCarNames(String inputCarNames) {
        String noneBlankCarNames = getNoneBlank(inputCarNames);
        List<String> carNames = splitByComma(noneBlankCarNames);
        validateEnoughCars(carNames);
        carNames.forEach(this::validateCarName);
        return carNames;
    }

    private void validateEnoughCars(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAR.getMessage());
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() >= 5) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        } else if (isBlank(carName)) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private List<String> findWinners() {
        int maxScore = racingCars.values().stream().mapToInt(RacingCar::getScore).max().orElse(0);
        return racingCars.values().stream().filter(racingCar -> racingCar.getScore() == maxScore)
                .map(RacingCar::getName).collect(Collectors.toList());
    }

    private void playRound() {
        racingCars.values().forEach(racingCar -> {
            int roundScore = Randoms.pickNumberInRange(0, 9);
            if (roundScore >= 4) {
                racingCar.addScore();
            }
        });
    }

    private void buildRoundResult(boolean isLastRound) {
        racingCars.values().forEach(racingCar -> roundResultsBuilder.append(formatRoundResult(racingCar)));
        if (!isLastRound) {
            roundResultsBuilder.append("\n");
        }
    }

    private String formatRoundResult(RacingCar racingCar) {
        return racingCar.getName() + " : " + "-".repeat(racingCar.getScore()) + "\n";
    }

    private String getNoneBlank(String inputCarNames) {
        return inputCarNames.replaceAll(" ", "");
    }

    private String requestInputString(InputType inputType) {
        outputView.printAskInput(inputType);
        return inputView.read();
    }

    private boolean isLastRound(int round, int inputPlayCount) {
        return round == inputPlayCount - 1;
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}