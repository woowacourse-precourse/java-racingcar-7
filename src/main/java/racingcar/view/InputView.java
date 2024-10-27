package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String RACE_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_CAR_COUNTS_INPUT = "시도할 횟수는 몇 회인가요?";

    public String readCarNames() {
        System.out.println(RACE_CAR_NAMES_INPUT);
        String carNames = Console.readLine();
        return carNames;
    }

    public String readRaceCounts() {
        System.out.println(RACE_CAR_COUNTS_INPUT);
        String raceCounts = Console.readLine();
        return raceCounts;
    }
}
