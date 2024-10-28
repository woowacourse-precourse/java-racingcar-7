package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public void carnameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public List<String> readCarNames() {
        return Arrays.asList(Console.readLine().split(","));
    }

    public String readMoveCount() {
        return Console.readLine();
    }

    private int validateMoveCount(String input) {
        int count = Integer.parseInt(input);
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return count;
    }

}
