package racingcar.controller;

import static racingcar.View.ViewConstants.NAME_DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.View.InputValidator;
import racingcar.model.CarRacing;

public class CarRacingController {
    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;

    public CarRacingController(InputView inputView, InputValidator inputValidator, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
    }

    public List<String> extractCarNames() {
        String input = inputView.requestCarNames();
        return splitByDelimiter(input);
    }

    private List<String> splitByDelimiter(String input) {
        return Arrays.stream(input.split(NAME_DELIMITER)).toList();
    }

    public int convertToNumber() {
        String input = inputView.requestTotalRounds();
        inputValidator.validateThatContainsOnlyDigits(input);
        return Integer.parseInt(input);
    }

    public void deliverRaceProgress(CarRacing carRacing, int totalRounds) {
        outputView.printResultPhrase();
        for (int i = 0; i < totalRounds; i++) {
            List<String> currentResults = carRacing.playARound();
            outputView.printRaceProgress(convertToString(currentResults));
        }
    }

    private String convertToString(List<String> currentResults) {
        StringBuilder output = new StringBuilder();
        for (String result : currentResults) {
            output.append(result).append(System.lineSeparator());
        }
        return output.toString();
    }

    public void deliverWinners(CarRacing carRacing) {
        outputView.printWinners(carRacing.announceWinners());
    }
}
