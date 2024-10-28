package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.error.ErrorStatus;

import java.util.HashMap;
import java.util.Map;

public class InputHandler {
    public static Map<String, String> consoleInput() {
        Map<String, String> inputData = new HashMap<>();

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println(carNames);
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorStatus.EMPTY_CAR_NAME);
        }
        inputData.put("carName", carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCount = Console.readLine();
        if (attemptCount == null || attemptCount.isEmpty()) {
            throw new IllegalArgumentException(ErrorStatus.EMPTY_ATTEMPTS);
        }
        inputData.put("attemptCount", attemptCount);

        return inputData;
    }
}
