package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNames();;
        int tryCount = getTryCount();

        runRace(carNames, tryCount);
    }
    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
        return carNames;
    }

    private static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountStr = Console.readLine();
        int tryCount;
        try {
            tryCount = Integer.parseInt(tryCountStr);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
        return tryCount;
    }

    private static void runRace(String[] carNames, int tryCount) {
        int[] positions = new int[carNames.length];
        for (int i = 0; i < tryCount; i++) {
            moveCars(carNames, positions);
            printPositions(carNames, positions);
        }
        printWinners(carNames, positions);
    }

    private static boolean shouldMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    private static void moveCars(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            if (shouldMove()) {
                positions[i]++;
            }
        }
    }

    private static void printPositions(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + " : " + "-".repeat(positions[i]));
        }
        System.out.println();
    }

    private static void printWinners(String[] carNames, int[] positions) {
        int maxPosition = Arrays.stream(positions).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPosition) {
                winners.add(carNames[i]);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
