package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String delimiter = ",";

    public List<String> readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.asList(readLine().split(delimiter));
    }

    public int readTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
