package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputCarNames = Console.readLine();
        String[] carNames = inputCarNames.split(",");
        for(String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        String inputCount = Console.readLine();
        int count = -1;
        try {
            count = Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수인 숫자여야 합니다.");
        }

        Map<String, StringBuilder> result = new HashMap<>();
        for(String carName : carNames) {
            result.put(carName, new StringBuilder());
        }

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for(String carName : carNames) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    result.put(carName, result.get(carName).append("-"));
                }
            }
            for (String carName : carNames) {
                System.out.println(carName + " : " + result.get(carName));
            }
            System.out.println();
        }
    }
}
