package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public abstract class InputView {
    protected String readInput() {
        return readLine();
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = readInput();
        return Arrays.asList(input.split(","));
    }

    public int inputCount() {
        String input=inputAttemptCount();
        return validateAttemptCount(input);
    }

    private  String inputAttemptCount() {
        String count;
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            count = readInput();
            return count;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }


    private static int validateAttemptCount(String input) {
        int count=Integer.parseInt(input);
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return count;
    }
}
