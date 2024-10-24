package View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public static int inputAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
