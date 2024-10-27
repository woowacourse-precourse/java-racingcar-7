package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = readLine().split(",");
        validateCarNames(carNameList);
        for (String carName : carNameList) {
            cars.put(carName, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(readLine());

        for (int i = 0; i < count; i++) {
            randomMoveCars(cars);
            printRoundResults(cars);
            System.out.println();
        }
        printWinner(cars);
    }

    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ExceptionCode.NAME_LENGTH_EXCEEDED.getMessage());
            }
        }
    }

    public static void printRoundResults(LinkedHashMap<String, Integer> cars) {
        for (String carName : cars.keySet()) {
            String travelDistance = "";
            for (int i = 0; i < cars.get(carName); i++) {
                travelDistance += "- ";
            }
            System.out.println(carName + " : " + travelDistance);
        }
    }

    public static void randomMoveCars(LinkedHashMap<String, Integer> cars) {
        for (String carName : cars.keySet()) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                cars.put(carName, cars.get(carName) + 1);
            }
        }
    }

    public static void printWinner(LinkedHashMap<String, Integer> cars) {
        int maxValue = Collections.max(cars.values());
        String championsList = "";

        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == maxValue) {
                championsList += car.getKey() + " ";
            }
        }
        championsList = championsList.trim().replace(" ", ", ");
        System.out.println("최종 우승자 : " + championsList);
    }
}
