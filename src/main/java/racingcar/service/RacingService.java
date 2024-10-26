package racingcar.service;

import static racingcar.constant.ErrorType.CAR_NAME_TOO_LONG;
import static racingcar.constant.ErrorType.EMPTY_INPUT;
import static racingcar.constant.ErrorType.NOT_ENOUGH_CAR;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.constant.InputType;
import racingcar.domain.RacingCar;
import racingcar.util.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingService {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<String, RacingCar> racingCars = new LinkedHashMap<>();

    public RacingService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getInputCarName() {
        return requestInputString(InputType.CAR_NAME);
    }

    public String getInputTotalRound() {
        return requestInputString(InputType.TOTAL_ROUND);
    }

    public void addRacingCar(String inputCarNames) {
        String noBlankCarNames = getNotBlank(inputCarNames);
        List<String> carNames = StringSplitter.splitByComma(noBlankCarNames);
        enoughCars(carNames);
        carNames.stream().filter(this::carNameValidate)
                .forEach(carName -> racingCars.put(carName, new RacingCar(carName)));
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
        } else if (carName.isEmpty()) {
            throw new IllegalArgumentException((EMPTY_INPUT.getMessage()));
        }
        return true;
    }
}