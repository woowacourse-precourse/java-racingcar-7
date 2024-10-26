package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_TOTAL_RACE_MESSAGE = "시도할 회수는 몇회인가요?";

    public String getCarNames() {
        return readLineWithPrompt(GET_CAR_NAMES_MESSAGE);
    }

    public String getTotalRace() {
        return readLineWithPrompt(GET_TOTAL_RACE_MESSAGE);
    }

    private String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return readLine().strip();
    }
}
