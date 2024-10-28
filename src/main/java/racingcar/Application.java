package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Collections;

public class Application {
    private static List<String> getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            return Stream.of(Console.readLine().split("[\\s,]+")).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
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

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
