package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] inputArr = input.split(",");

        Map<String, StringBuilder> carStatus = new HashMap<>();
        for (String name : inputArr) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            carStatus.put(name, new StringBuilder());
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            racingRound(carStatus);
            printRoundResult(carStatus);
        }

        printWinners(carStatus);
    }

    public static void racingRound(Map<String, StringBuilder> carStatus) {
        for (String name : carStatus.keySet()) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                carStatus.get(name).append("-");
            }
        }
    }

    public static void printRoundResult(Map<String, StringBuilder> carStatus) {
        for (String name : carStatus.keySet()) {
            System.out.println(name + " : " + carStatus.get(name));
        }
        System.out.println();
    }

    public static void printWinners(Map<String, StringBuilder> carStatus) {
        List<String> winners = new ArrayList<>();
        int maxDistance = carStatus.values().stream().mapToInt(StringBuilder::length).max()
            .orElse(0);

        for (Map.Entry<String, StringBuilder> entry : carStatus.entrySet()) {
            if (entry.getValue().length() == maxDistance) {
                winners.add(entry.getKey());
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
