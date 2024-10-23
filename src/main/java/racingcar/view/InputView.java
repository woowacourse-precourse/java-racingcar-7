package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private final static String COMMA = ",";
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        Console.close();
        return List.of(carNames.split(COMMA));
    }

    public String inputTrialCounts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialCounts = Console.readLine();
        Console.close();
        return trialCounts;
    }
}
