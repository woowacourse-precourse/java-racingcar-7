package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Collections;

public class Application {
    public static void racingGame() {
        List<String> names = getRacingCarNames();
        int trial = getNumberOfTrial();

        Map<String, Integer> racing_progress = new HashMap<String, Integer>();

        // Initialize
        for (String name : names) {
            racing_progress.put(name, 0);
        }

        for (int i = 0; i < trial; i++) {
            for (String name : names) {
                tryMoveForward(name, racing_progress);
            }
            printRacingProgress(racing_progress);
            System.out.println();
        }
        printRaceWinner(racing_progress);
    }

    private static List<String> getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Stream.of(Console.readLine().split("[\\s,]+")).toList();

        for (String name : names) {
            if (name.length() > 5) throw new IllegalArgumentException();
        }
        return names;
    }

    private static int getNumberOfTrial() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void tryMoveForward(String name, Map<String, Integer> racing_progress) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            racing_progress.put(name, racing_progress.get(name) + 1);
        }
    }

    private static void printRacingProgress(Map<String, Integer> racing_progress) {
        for (String name : racing_progress.keySet()) {
            System.out.println(name + " : " + "-".repeat(racing_progress.get(name)));
        }
    }

    private static void printRaceWinner(Map<String, Integer> racing_progress) {
        int max = Collections.max(racing_progress.values());

        System.out.print("최종 우승자 : ");
        for (String key : racing_progress.keySet()) {
            if (max == racing_progress.get(key)) {
                System.out.print(key + ", ");
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        racingGame();
    }
}
