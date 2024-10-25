package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int INIT = 0;
    private static final int MAX_RANDOM_NUMBER = 10;

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> carNames = Arrays.asList(input.split(SPLIT_DELIMITER));

        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        List<String> uniqueNames = new ArrayList<>();
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차가 없습니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
            if (uniqueNames.contains(name)) {
                throw new IllegalArgumentException("같은 이름을 가진 자동차가 있습니다: " + name);
            }
            uniqueNames.add(name);
        }
    }

    private static int getNumberOfRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        int rounds;
        try {
            rounds = Integer.parseInt(scanner.nextLine());
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
        return rounds;
    }

    private static List<Integer> initializeCarPositions(int size) {
        List<Integer> carPositions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carPositions.add(INIT);
        }
        return carPositions;
    }

    private static void moveCars(List<String> carNames, List<Integer> carPositions, int numberOfRounds) {
        Random random = new Random();
        for (int i = 0; i < numberOfRounds; i++) {
            randomlyDecideMovement(carNames, carPositions, random);
            printRoundResults(carNames, carPositions);
        }
    }

    private static void randomlyDecideMovement(List<String> carNames, List<Integer> carPositions, Random random) {
        for (int i = 0; i < carNames.size(); i++) {
            if (random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_THRESHOLD) {
                carPositions.set(i, carPositions.get(i) + 1);
            }
        }
    }

    private static void showResult() {
        System.out.println("실행 결과");
    }

    private static void printRoundResults(List<String> carNames, List<Integer> carPositions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carPositions.get(i)));
        }
        System.out.print("\n");
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<String> findWinners(List<String> carNames, List<Integer> carPositions) {
        int maxDistance = Collections.max(carPositions);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions.get(i) == maxDistance) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}