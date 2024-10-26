package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int racingRound = Integer.parseInt(readLine());
        System.out.println();

        Map<String, Integer> racingCar = new LinkedHashMap<>();

        for (String carName : carNames.split(",")) {
            racingCar.putIfAbsent(carName, 0);
        }

        int roundInNow = 0;

        System.out.println("실행 결과");
        while (roundInNow < racingRound) {
            for (String carName : racingCar.keySet()) {
                int randomDecisionNumber = pickNumberInRange(0,9);
                if (randomDecisionNumber > 3) {
                    //키가 가진 값이 하나 증가
                    int number = racingCar.get(carName);
                    racingCar.put(carName, number + 1);
                }
            }

            print(racingCar);
            roundInNow++;
        }

        printWinner(racingCar);

    }


    public static void print(Map<String, Integer> racingCar) {
        for (String carName : racingCar.keySet()) {
            int go = racingCar.get(carName);

            System.out.println(carName + " : " + "-".repeat(go) );
        }
        System.out.println();
    }


    public static void printWinner(Map<String, Integer> racingCar) {
        System.out.print("최종 우승자 : ");
        Integer maxValue = Collections.max(racingCar.values());
        for (Entry<String, Integer> entry : racingCar.entrySet()) {
            String carName = entry.getKey();
            Integer go = entry.getValue();

            if(go == maxValue) {
                System.out.print(carName);
            }
        }
    }
}
