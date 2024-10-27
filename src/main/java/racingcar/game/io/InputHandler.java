package racingcar.game.io;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.game.constant.ExceptionMessage.CAR_NAME_IS_BLANK;
import static racingcar.game.constant.ExceptionMessage.INVALID_RACING_COUNT_TYPE;

public class InputHandler {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public String getCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String inputCarNames = Console.readLine();
        validateInputCarNames(inputCarNames);
        return inputCarNames;
    }

    public Integer getRacingCount() {
        System.out.println(RACING_COUNT_INPUT_MESSAGE);
        String inputRacingCount = Console.readLine();
        return convertToInteger(inputRacingCount);
    }

    public Integer convertToInteger(String inputRacingCount) {
        try {
            Integer racingCount = Integer.parseInt(inputRacingCount.trim());
            return racingCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RACING_COUNT_TYPE.getMessage());
        }
    }

    public void validateInputCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_IS_BLANK.getMessage());
        }
    }
}
