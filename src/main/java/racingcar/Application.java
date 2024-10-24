package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 이름입력 기능
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        // 이름 판단
        List<String> carNameList = Validate.carName(inputCarName);

        // 시도할 횟수를 입력 받는 기능
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempts = Console.readLine();
        int attempts = Validate.attempts(inputAttempts);
    }
}
