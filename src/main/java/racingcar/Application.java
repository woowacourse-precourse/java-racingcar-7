package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        validateCarNameIsNotBlank(carNamesInput);
        Map<String, Integer> carsBeforeRace = registerCars(carNamesInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String moveNumberInput = Console.readLine();
        int moveNumber = validateMoveNumber(moveNumberInput);

        System.out.println("\n실행 결과");
        Map<String, Integer> carsAfterRace = doRaceAndPrintRaceStatus(carsBeforeRace, moveNumber);

        List<String> winnerNames = findRaceWinners(carsAfterRace);
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    public static void validateCarNameIsNotBlank(String carNamesInput) {
        String carNameInputRegex = "^\\d+(,\\d+)*$";
        if (!carNamesInput.matches(carNameInputRegex)) {
            throw new IllegalArgumentException("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
        }
    }

    public static Map<String, Integer> registerCars(String carNamesInput) {
        //이름 각각에 대한 제한 사항은 아직 반영하지 않음
        Map<String, Integer> cars = new HashMap<>();
        for (String name : carNamesInput.split(",")) {
            if (cars.containsKey(name)) {
                throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
            }
            if (name.length() > 5 || name.length() < 1) {
                throw new IllegalArgumentException("이름은 1자리 이상 5자리 이하로 입력해주세요.");
            }
            cars.put(name, 0);
        }
        if (cars.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 차 이름을 입력해주세요.");
        }
        return cars;
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
            for (String carName : carNames) {
                System.out.println(carName + " : " + "-".repeat(cars.get(carName)));
            }
            System.out.println();
        }
        return cars;
    }

    public static List<String> findRaceWinners(Map<String, Integer> cars) {
        Collection<Integer> carMoveDistances = cars.values();
        int maxMoveDistance = Collections.max(carMoveDistances);
        List<String> winnerNames = new ArrayList<>();
        for (String carName : cars.keySet()) {
            if (cars.get(carName).equals(maxMoveDistance)) {
                winnerNames.add(carName);
            }
        }
        return winnerNames;
    }
}
