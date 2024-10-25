package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        Map<String, Integer> carsBeforeRace = registerCars(carNamesInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String moveNumberInput = Console.readLine();
        int moveNumber = validateMoveNumber(moveNumberInput);

        System.out.println("\n실행 결과");
        Map<String, Integer> carsAfterRace = doRaceAndPrintRaceStatus(carsBeforeRace, moveNumber);

        List<String> winnerNames = findRaceWinners(carsAfterRace);
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    public static Map<String, Integer> registerCars(String carNamesInput) {
        Map<String, Integer> cars = new HashMap<>();
        for (String name : carNamesInput.split(",", -1)) {
            validateEachCarName(name);
            validateDuplication(cars, name);
            cars.put(name, 0);
        }
        validateCarsSize(cars);
        return cars;
    }

    public static void validateEachCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자리 이하로 입력해주세요.");
        }
    }

    public static void validateDuplication(Map<String, Integer> cars, String carName) {
        if (cars.containsKey(carName)) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
        }
    }

    public static void validateCarsSize(Map<String, Integer> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 차 이름을 입력해주세요.");
        }
    }

    public static int validateMoveNumber(String moveNumberInput) {
        try {
            int moveNumber = Integer.parseInt(moveNumberInput);
            if (moveNumber < 1) {
                throw new IllegalArgumentException("1회 이상의 이동 횟수를 입력해주세요.");
            }
            return moveNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 된 이동 횟수를 입력해주세요.");
        }
    }

    public static Map<String, Integer> doRaceAndPrintRaceStatus(Map<String, Integer> cars, int moveNumber) {
        for (int i = 0; i < moveNumber; i++) {
            String[] carNames = cars.keySet().toArray(new String[0]);
            for (String carName : carNames) {
                int moveDistance = cars.get(carName);
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    cars.replace(carName, moveDistance + 1);
                }
            }
            printRaceIntermediateResult(cars, carNames);
        }
        return cars;
    }

    public static void printRaceIntermediateResult(Map<String, Integer> cars, String[] carNames) {
        for (String carName : carNames) {
            System.out.println(carName + " : " + "-".repeat(cars.get(carName)));
        }
        System.out.println();
    }

    public static List<String> findRaceWinners(Map<String, Integer> cars) {
        int maxMoveDistance = Collections.max(cars.values());
        List<String> winnerNames = new ArrayList<>();
        for (String carName : cars.keySet()) {
            if (cars.get(carName).equals(maxMoveDistance)) {
                winnerNames.add(carName);
            }
        }
        return winnerNames;
    }
}
