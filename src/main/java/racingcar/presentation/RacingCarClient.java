package racingcar.presentation;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import racingcar.dto.RacingCarResponse;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;
import racingcar.service.RacingCarService;

public class RacingCarClient {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarClient(
            final InputView inputView,
            final OutputView outputView,
            final RacingCarService racingCarService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        try {
            List<String> nameValues = getNameValues();
            int roundTotal = getRoundTotal();

            RacingCarResponse racingCarResponse = racingCarService.startRacing(nameValues, roundTotal);

            outputView.printRacingCarResults(racingCarResponse);
        } finally {
            inputView.closeConsole();
        }
    }

    private List<String> getNameValues() {
        String carNamesInput = inputView.readCarNames();
        List<String> nameValues = Arrays.stream(carNamesInput.split(",", -1))
                .toList();
        validateNameValues(Objects.requireNonNull(nameValues));
        return nameValues;
    }

    private void validateNameValues(final List<String> nameValues) {
        if (nameValues.stream()
                .anyMatch(String::isBlank)
        ) {
            throw new IllegalArgumentException("자동차 이름은 공백(빈 문자열)일 수 없습니다.");
        }
    }

    private int getRoundTotal() {
        try {
            String tryCount = inputView.readTryCount();
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해 주세요.");
        }
    }

}
