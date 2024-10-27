package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)로 구분): ");
        String input = Console.readLine();
        return InputHandler.getCarNames(input);
    }

    public static int getRaceAttempts() {
        System.out.println("시도할 횟수를 입력하세요: ");
        String input = Console.readLine();
        return InputHandler.getRaceAttempts(input);
    }
}