package racingcar.service;

import static racingcar.constant.ErrorType.CAR_NAME_TOO_LONG;
import static racingcar.constant.ErrorType.EMPTY_INPUT;
import static racingcar.constant.ErrorType.NOT_ENOUGH_CAR;
import static racingcar.constant.ErrorType.RACE_COUNT_TOO_LOW;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.constant.InputType;
import racingcar.domain.RacingCar;
import racingcar.util.StringSplitter;
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
        return requestInputString(InputType.CAR_NAME);
    }

    public int getInputTotalRound() {
        String totalRound = requestInputString(InputType.TOTAL_ROUND);
        if (isBlank(totalRound)) {
            throw new IllegalArgumentException((EMPTY_INPUT.getMessage()));
        }
        return Integer.parseInt(totalRound);
    }

    public void addRacingCar(String inputCarNames) {
        String noBlankCarNames = getNotBlank(inputCarNames);
        List<String> carNames = StringSplitter.splitByComma(noBlankCarNames);
        enoughCars(carNames);
        carNames.stream().filter(this::carNameValidate)
                .forEach(carName -> racingCars.put(carName, new RacingCar(carName)));
    }

    public void playGame(int inputTotalRound) {
        if (inputTotalRound < 1) {
            throw new IllegalArgumentException((RACE_COUNT_TOO_LOW.getMessage()));
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
        int maxScore = racingCars.values().stream().mapToInt(RacingCar::getScore).max().orElse(0);
        if (maxScore != 0) {
            List<String> winners = racingCars.values().stream().filter(racingCar -> racingCar.getScore() == maxScore)
                    .map(RacingCar::getName).collect(Collectors.toList());
            outputView.responseGameResult(String.join(", ", winners));
        }
        outputView.responseGameResult("우승자가 없습니다.");
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
        racingCars.values().forEach(racingCar -> {
            String name = racingCar.getName();
            int score = racingCar.getScore();
            roundResultsBuilder.append(name).append(" : ").append("-".repeat(score)).append("\n");
        });
        if (!isLastRound) {
            roundResultsBuilder.append("\n");
        }
    }

    private String getNotBlank(String inputCarNames) {
        return inputCarNames.replaceAll(" ", "");
    }

    private String requestInputString(InputType inputType) {
        outputView.printAskInput(inputType);
        return inputView.read();
    }

    private void enoughCars(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException((NOT_ENOUGH_CAR.getMessage()));
        }
    }

    private boolean carNameValidate(String carName) {
        if (carName.length() >= 5) {
            throw new IllegalArgumentException((CAR_NAME_TOO_LONG.getMessage()));
        } else if (isBlank(carName)) {
            throw new IllegalArgumentException((EMPTY_INPUT.getMessage()));
        }
        return true;
    }

    private boolean isLastRound(int round, int inputPlayCount) {
        return round == inputPlayCount - 1;
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}