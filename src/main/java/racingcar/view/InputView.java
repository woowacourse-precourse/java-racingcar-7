package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String INPUT_CAR_NAMES_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MSG);
        String carNames = Console.readLine();
        return carNames;
    }

    public int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MSG);
        return readValidTryCount();
    }

    private int readValidTryCount() {
        String input = Console.readLine();
        while (!isValidNumber(input)) {
            System.out.println("유효한 숫자를 입력해주세요.");
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    private boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
