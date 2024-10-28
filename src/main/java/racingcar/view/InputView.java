package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements View {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    @Override
    public void print() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public String inputCarNames() {
        return Console.readLine();
    }

    public void printInputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    public String inputAttemptCount() {
        return removeWhitespace(Console.readLine());
    }

    private String removeWhitespace(String input) {
        return input.trim().replace(" ", "");
    }
}
