package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<String> carNames;
    private static int tryCount;
    private static int[] carPositions;

    public static void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        carNames = Arrays.asList(input.split(","));
        validateCarNames();
    }

    private static void validateCarNames() {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            tryCount = Integer.parseInt(Console.readLine());
            validateTryCount();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 양의 정수여야 합니다.");
        }
    }

    private static void validateTryCount() {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 양의 정수여야 합니다.");
        }
    }

    public static void startRace() {
        carPositions = new int[carNames.size()];
        for (int i = 0; i < tryCount; i++) {
            raceTurn();
            printRaceStatus();
        }
        printWinners();
    }

    private static void raceTurn() {
        for (int j = 0; j < carNames.size(); j++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carPositions[j]++;
            }
        }
    }

    private static void printRaceStatus() {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carPositions[i]));
        }
        System.out.println();
    }

    private static void printWinners() {
        int maxPosition = Arrays.stream(carPositions).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions[i] == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void main(String[] args) {
        inputCarNames();
        inputTryCount();
        startRace();
    }
}
