package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateNames(carNames);

        System.out.print("시도할 횟수는 몇 회인가요?: ");
        String attemptsInput = Console.readLine();
        int attempts = validateAttempts(attemptsInput);

        Map<String, Integer> carPositions = initializeCarPositions(carNames);

        System.out.println("\n실행 결과");
        runRace(attempts, carPositions);

        printWinners(carPositions);
    }

    private static Map<String, Integer> initializeCarPositions(String[] carNames) {
        Map<String, Integer> carPositions = new HashMap<>();
        for (String carName : carNames) {
            carPositions.put(carName.trim(), 0);
        }
        return carPositions;
    }

    private static void runRace(int attempts, Map<String, Integer> carPositions) {
        for (int i = 0; i < attempts; i++) {
            updateCarPositions(carPositions);
            printRoundResults(carPositions);
        }
    }

    private static void updateCarPositions(Map<String, Integer> carPositions) {
        for (String carName : carPositions.keySet()) {
            if (shouldMoveForward()) {
                carPositions.put(carName, carPositions.get(carName) + 1);
            }
        }
    }

    private static boolean shouldMoveForward() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum >= 4;
    }

    private static void validateNames(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("이름이 두 개 이상이어야 합니다.");
        }
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하여야 합니다: " + name);
            }
        }
    }

    private static int validateAttempts(String attemptsInput) {
        if (!isNumeric(attemptsInput) || Integer.parseInt(attemptsInput) <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 큰 숫자여야 합니다.");
        }
        return Integer.parseInt(attemptsInput);
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static void printRoundResults(Map<String, Integer> carPositions) {
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            String positionMarks = "-".repeat(entry.getValue());
            System.out.println(entry.getKey() + " : " + positionMarks);
        }
        System.out.println();
    }

    private static void printWinners(Map<String, Integer> carPositions) {
        int maxPosition = findMaxPosition(carPositions);
        String winners = findWinners(carPositions, maxPosition);
        System.out.println("최종 우승자 : " + winners);
    }

    private static int findMaxPosition(Map<String, Integer> carPositions) {
        return carPositions.values().stream().max(Integer::compareTo).orElse(0);
    }

    private static String findWinners(Map<String, Integer> carPositions, int maxPosition) {
        StringBuilder winners = new StringBuilder();
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            if (entry.getValue() == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(entry.getKey());
            }
        }
        return winners.toString();
    }
}
