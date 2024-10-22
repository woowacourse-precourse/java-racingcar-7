package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME_MESSAGE =
            "경주할 자동차 이름을 입력 하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String inputName() {
        printInputNameMessage();
        return Console.readLine();
    }

    private void printInputNameMessage(){
        System.out.println(INPUT_NAME_MESSAGE);
    }
}
