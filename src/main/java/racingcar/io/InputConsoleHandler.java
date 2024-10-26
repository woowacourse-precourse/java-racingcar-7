package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputConsoleHandler {

    public static final String CARNAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUTS_SEPARATOR = ",";

    public void showCarNameGuideMessage() {
        System.out.println(CARNAME_INPUT_GUIDE_MESSAGE);
    }

    public String[] askCarName() {
        return Console.readLine().split(INPUTS_SEPARATOR);
    }

}
