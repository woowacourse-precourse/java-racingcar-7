package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public void carnameInput() {
        System.out.println("자동차 이름을 입력해 주세요.");
    }

    public void requestMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public List<String> readCarNames() {
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

}
