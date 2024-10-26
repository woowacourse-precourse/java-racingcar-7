package racingcar.view;

import static racingcar.ExceptionMessage.CAR_MOVEMENT_COUNT_BLANK_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_MOVEMENT_COUNT_NOT_NATURAL_NUMBER_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_MOVEMENT_COUNT_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";

    public void printCarNameInputGuide() {
        System.out.println(CAR_NAME_INPUT_GUIDE);
    }

    public String getCarNameInput() {
        return Console.readLine();
    }

    public void printCarMovementCountInputGuide() {
        System.out.println(CAR_MOVEMENT_COUNT_INPUT_GUIDE);
    }

    public long getCarMovementCount() {
        String inputString = Console.readLine();
        Console.close();
        validateCarMovementCountOrThrow(inputString);
        return Long.parseLong(inputString);
    }

    private void validateCarMovementCountOrThrow(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException(CAR_MOVEMENT_COUNT_BLANK_EXCEPTION.message());
        }
        if (!isNaturalNumber(inputString)) {
            throw new IllegalArgumentException(CAR_MOVEMENT_COUNT_NOT_NATURAL_NUMBER_EXCEPTION.message());
        }
    }

    private boolean isNaturalNumber(String inputString) {
        try {
            long number = Long.parseLong(inputString);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
