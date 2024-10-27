package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView instance;

    private InputView() {}

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    private static final String CAR_NAMES_INPUT_REQUEST_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static void printCarNamesInputRequestMessage() {
        System.out.println(CAR_NAMES_INPUT_REQUEST_TEXT);
    }

    public static String inputCarNames() {
        return Console.readLine();
    }

    private static final String RACE_ROUNDS_INPUT_REQUEST_TEXT = "시도할 횟수는 몇 회인가요?";
    public static void printRaceRoundsInputRequestMessage() {
        System.out.println(RACE_ROUNDS_INPUT_REQUEST_TEXT);
    }

    public static String inputRounds() {
        return Console.readLine();
    }

}
