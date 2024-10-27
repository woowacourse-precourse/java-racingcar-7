package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> racingCarNames = getRacingCarNames();
        int tryCount = getTryCount();

        Map<String, Integer> carPositions = initializeCarPositions(racingCarNames);
        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (String car : racingCarNames) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    carPositions.put(car, carPositions.get(car) + 1);
                }
            }

            for (String car : racingCarNames) {
                System.out.print(car + " : ");
                for (int j = 0; j < carPositions.get(car); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        int maxPosition = Collections.max(carPositions.values());
        List<String> winners = new ArrayList<>();

        for (String car : racingCarNames) {
            if (carPositions.get(car) == maxPosition) {
                winners.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    private static List<String> getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        List<String> racingCarNames = List.of(rawCarNames.split(","));

        for (String name : racingCarNames) {
            validateCarName(name);
        }

        return racingCarNames;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String rawTryCount = Console.readLine();
        validateNumber(rawTryCount);

        int tryCount = Integer.parseInt(rawTryCount);
        validatePositiveNumber(tryCount);

        return tryCount;
    }

    private static void validateNumber(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validatePositiveNumber(Integer number) {
        if (number < 1) {
            throw new IllegalArgumentException("1 이상의 양수만 입력 가능합니다.");
        }
    }

    private static Map<String, Integer> initializeCarPositions(List<String> carNames) {
        Map<String, Integer> carPositions = new HashMap<>();
        for (String car : carNames) {
            carPositions.put(car, 0);
        }
        return carPositions;
    }
}
