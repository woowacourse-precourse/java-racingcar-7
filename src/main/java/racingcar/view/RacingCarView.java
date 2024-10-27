package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {

    private static final String INPUT_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_GUIDE = "시도할 횟수는 몇 회인가요?";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_GUIDE);
        return Console.readLine();
    }

    public String inputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER_GUIDE);
        return Console.readLine();
    }
}
