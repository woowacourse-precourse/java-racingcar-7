package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameInput {

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public String readCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        return Console.readLine();
    }

    public int readTryCount() {
        System.out.println(TRY_COUNT_PROMPT);
        String tryNumString = Console.readLine();
        System.out.println();
        return Integer.parseInt(tryNumString);
    }
}
