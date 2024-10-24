package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.RacingRegisterForm;
import racingcar.view.InputView;

public class RegistrationService {

    public static final String SEPARATOR = ",";

    private final InputView inputView;

    public RegistrationService() {
        inputView = new InputView();
    }

    public RacingRegisterForm register() {
        String inputCarNames = inputView.requestCarNames();
        String inputRaceRoundCount = inputView.requestRaceRoundCount();
        List<String> carNames = convertCarNames(inputCarNames);
        int raceRoundCount = convertRaceRoundCount(inputRaceRoundCount);
        return new RacingRegisterForm(carNames, raceRoundCount);
    }

    private List<String> convertCarNames(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .toList();
    }

    private int convertRaceRoundCount(String input) {
        try {
            int roundCount = Integer.parseInt(input.trim());
            if (roundCount < 1) {
                throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 해요.");
            }
            return roundCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수에 숫자가 아닌 값을 입력했어요. 1 이상의 숫자를 입력해주세요.");
        }
    }
}
