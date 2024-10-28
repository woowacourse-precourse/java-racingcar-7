package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    private InputView() {}

    private static class Holder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return Holder.INSTANCE;
    }

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_PROMPT);
        return Console.readLine();
    }

    public String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_PROMPT);
        return Console.readLine();
    }
}
