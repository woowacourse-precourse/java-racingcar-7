package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public List<String> inputCarNames() {
        System.out.println(NAME_MESSAGE);
        return List.of(Console.readLine().split(","));
    }

    public Integer inputCount() {
        System.out.println(COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());
        Console.close();
        return count;
    }


}
