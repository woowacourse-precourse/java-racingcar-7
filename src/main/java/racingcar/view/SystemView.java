package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class SystemView implements InputHandler {

    public static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRIAL_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    @Override
    public String printSystemNameInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    @Override
    public String printSystemInputTrialMessage() {
        System.out.println(TRIAL_INPUT_MESSAGE);
        return Console.readLine();
    }
}