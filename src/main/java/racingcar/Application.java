package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = Console.readLine();
            String[] carNames = validateCarNames(carNamesInput);
            
            // 이동 횟수 입력
            System.out.println("시도할 횟수는 몇 회인가요?");
            int numberOfAttempts = Integer.parseInt(Console.readLine());
            validateNumberOfAttempts(numberOfAttempts);

            // 자동차 초기화
            Map<String, Integer> carPositions = initializeCarPositions(carNames);

            // 자동차 이동
            System.out.println("\n실행 결과");
            for (int i = 0; i < numberOfAttempts; i++) {
                moveCars(carPositions);
                printCarPositions(carPositions);
                System.out.println();
            }

            // 우승자 출력
            printWinners(carPositions);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static String[] validateCarNames(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해야 합니다.");
        }
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (!name.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 영어 알파벳만 가능합니다.");
            }
        }
        return carNames;
    }

    static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    static Map<String, Integer> initializeCarPositions(String[] carNames) {
        Map<String, Integer> carPositions = new HashMap<>();
        for (String name : carNames) {
            carPositions.put(name, 0);
        }
        return carPositions;
    }

    static void moveCars(Map<String, Integer> carPositions) {
        for (String car : carPositions.keySet()) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            // 무작위 값이 4 이상일 경우 자동차 전진
            if (randomValue >= 4) {
                carPositions.put(car, carPositions.get(car) + 1);
            }
        }
    }

    static void printCarPositions(Map<String, Integer> carPositions) {
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
    }

    static void printWinners(Map<String, Integer> carPositions) {
        int maxPosition = carPositions.values().stream().max(Integer::compare).orElse(0);
        List<String> winners = carPositions.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
