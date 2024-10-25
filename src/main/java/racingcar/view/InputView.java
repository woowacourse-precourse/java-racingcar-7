package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_MOVEMENT_COUNT_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";

    private static final String CAR_MOVEMENT_COUNT_BLANK_EXCEPTION = "자동차 이동 횟수는 빈칸이 아니어야합니다.";
    private static final String CAR_MOVEMENT_COUNT_NOT_NATURAL_NUMBER_EXCEPTION = "자동차 이동 횟수는 자연수이어야 합니다.";

    public void printCarNameInputGuide() {
        System.out.println(CAR_NAME_INPUT_GUIDE);
    }

    public String getCarNameInput() {
        return Console.readLine();
    }

    public void printCarMovementCountInputGuide() {
        System.out.println(CAR_MOVEMENT_COUNT_INPUT_GUIDE);
    }

    public String getCarMovementCount() {
        String inputString = Console.readLine();
        validateCarMovementCountOrThrow(inputString);
        return inputString;
    }

    public void validateCarMovementCountOrThrow(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException(CAR_MOVEMENT_COUNT_BLANK_EXCEPTION);
        }
        if (!isNaturalNumber(inputString)) {
            throw new IllegalArgumentException(CAR_MOVEMENT_COUNT_NOT_NATURAL_NUMBER_EXCEPTION);
        }
    }

    public boolean isNaturalNumber(String inputString) {
        try {
            int number = Integer.parseInt(inputString);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
