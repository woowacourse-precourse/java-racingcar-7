package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAMES_INPUT_REQUEST_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_ROUNDS_INPUT_REQUEST_TEXT = "시도할 횟수는 몇 회인가요?";

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String inputCarNames() {
        System.out.println(CAR_NAMES_INPUT_REQUEST_TEXT);
        return Console.readLine();
    }

    public String inputRaceRounds() {
        System.out.println(RACE_ROUNDS_INPUT_REQUEST_TEXT);
        return Console.readLine();
    }
}
