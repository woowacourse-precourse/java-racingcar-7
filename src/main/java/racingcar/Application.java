package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
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

        Set<String> nameSet = new HashSet<>();
        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            } else if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
            } else if (!nameSet.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
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
        printWinners(carPositions);
    }

    private static void doRace(Map<String, Integer> carPositions) {
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                carPositions.put(entry.getKey(), entry.getValue() + 1);
            }
        }
        raceStatus(carPositions);
    }

    private static void raceStatus(Map<String, Integer> carPositions) {
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }

    private static void printWinners(Map<String, Integer> carPositions) {
        int maxPosition = 0;
        for (int position : carPositions.values()) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            if (entry.getValue() == maxPosition) {
                winners.add(entry.getKey());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
