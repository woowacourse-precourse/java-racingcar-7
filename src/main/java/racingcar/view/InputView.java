package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NAME_DELIMITER = ",";

    public String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = Console.readLine();
        return input.split(NAME_DELIMITER);
    }

    public int inputTrialCounts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
