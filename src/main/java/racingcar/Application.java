package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        if (carNames.length < 2) {
            throw new IllegalArgumentException("자동차를 2개 이상 등록하세요.");
        }
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            } else if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        Map<String, Integer> carPositions = new HashMap<>();
        for (String carName : carNames) {
            carPositions.put(carName, 0);
        }

        for (int i = 0; i < tryCount; i++) {
            doRace(carPositions);
        }
    }

    private static void doRace(Map<String, Integer> carPositions) {
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                carPositions.put(entry.getKey(), entry.getValue() + 1);
            }
        }
    }
}
