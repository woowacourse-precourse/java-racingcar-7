package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarName = Console.readLine();

        Map<String, Integer> racingCar = new HashMap<>();

        String[] splitRacingCarName = racingCarName.split(",");
        for (String eachRacingCarName : splitRacingCarName) {
            racingCar.put(eachRacingCarName, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameCount = Console.readLine();
        System.out.println("실행 결과");

        for (int i = 0; i < Integer.parseInt(gameCount); i++) {
            startGame(racingCar);
            printPerDegreeResult(racingCar);
            System.out.println();
        }

        int furthestNumber = findFurthestNumber(racingCar);
        List<String> winners = findWinners(racingCar, furthestNumber);

        printWinners(winners);
    }

    // 게임의 순서는 자동차 이름을 입력 받은 순서대로 진행한다.
    public static void startGame(Map<String, Integer> racingCar) {
        for (Entry<String, Integer> eachRacingCar : racingCar.entrySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                eachRacingCar.setValue(eachRacingCar.getValue() + 1);
            }
        }
    }

    public static void printPerDegreeResult(Map<String, Integer> racingCar) {
        for (Entry<String, Integer> eachRacingCar : racingCar.entrySet()) {
            System.out.println(eachRacingCar.getKey() + " : " + ("-".repeat(eachRacingCar.getValue())));
        }
    }

    public static int findFurthestNumber(Map<String, Integer> racingCar) {
        int max = 0;

        for (Entry<String, Integer> eachRacingCar : racingCar.entrySet()) {
            if (eachRacingCar.getValue() > max) {
                max = eachRacingCar.getValue();
            }
        }
        return max;
    }

    public static List<String> findWinners(Map<String, Integer> racingCar, int furthestNumber) {
        List<String> winners = new ArrayList<>();

        for (Entry<String, Integer> eachRacingCar : racingCar.entrySet()) {
            if (eachRacingCar.getValue() == furthestNumber) {
                winners.add(eachRacingCar.getKey());
            }
        }
        return winners;
    }

    public static void printWinners(List<String> winners) {
        String result = winners.get(0);
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + result);
            return;
        }

        for (int i = 1; i < winners.size(); i++) {
            result += ", " + winners.get(i);
        }
        System.out.println("최종 우승자 : " + result);
    }

}
