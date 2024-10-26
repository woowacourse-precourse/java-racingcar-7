package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_PROMPT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_PROMPT_NUMBER = "시도할 횟수는 몇 회인가요?";

    public String getUserInputNameString(){
        System.out.println(INPUT_PROMPT_NAME);
        return Console.readLine();

    }

    public String getUserInputNumberString(){
        System.out.println(INPUT_PROMPT_NUMBER);
        return Console.readLine();
    }


}
