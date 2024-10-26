package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NAME_INPUT="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_INPUT = "시도할 횟수는 몇 회인가요?";

    public String readNames(){
        System.out.println(NAME_INPUT);
        String names =Console.readLine();
        return names;
    }

    public String readTrial(){
        System.out.println(NAME_INPUT);
        String trial = Console.readLine();
        return trial;
    }


}
