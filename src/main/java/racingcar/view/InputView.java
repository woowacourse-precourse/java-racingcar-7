package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String getCarNames() {
        return readLineWithPrompt(GET_CAR_NAMES_MESSAGE);
    }

    private String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return readLine().strip();
    }
}
