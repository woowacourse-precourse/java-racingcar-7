package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> cars = new LinkedHashMap<>();

        // Input carNamesRaw
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesRaw = Console.readLine();

        // Parse names and register
        for (String carName : carNamesRaw.split("\\s*,\\s*")) {
            // scenario 1: process leading/trailing non-standard space
            carName = carName.strip();
            // scenario 2: long name provided
            if (carName.length() > 5) {
                throw new IllegalArgumentException(
                        MessageFormat.format(
                                "[ERROR] Length limit(5) exceeded: \"{0}\"({1})",
                                carName, carName.length()));
            }
            // scenario 3: blank name provided
            if (carName.isEmpty()) {
                continue;
            }
            // scenario 4: duplicated name provided
            if (cars.containsKey(carName)) {
                throw new IllegalArgumentException(
                        MessageFormat.format(
                                "[ERROR] Duplicated name not allowed: \"{0}\"",
                                carName));
            }
            cars.put(carName, 0);
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] You need to register at least one car.");
        }

        // input iterations
        System.out.println("시도할 횟수는 몇 회인가요?");
        String iterationNumberRaw = Console.readLine();
        iterationNumberRaw = iterationNumberRaw.strip();
        int iterationNumber;
        try {
            iterationNumber = Integer.parseInt(iterationNumberRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "[ERROR] Failed to parse \"{0}\" into integer.",
                    iterationNumberRaw));
        }
        if (iterationNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] You must enter positive integer.");
        }

        // roll and output results
        System.out.println("실행 결과");
        for (int i = 0; i < iterationNumber; i++) {
            // dice rolling
            for (Map.Entry<String, Integer> car : cars.entrySet()) {
                // condition
                if (Randoms.pickNumberInRange(0, 9) > 3) {
                    car.setValue(car.getValue() + 1);
                }
            }

            // output
            for (Map.Entry<String, Integer> car : cars.entrySet()) {
                String distanceBar = "-".repeat(car.getValue());
                System.out.println(car.getKey() + " : " + distanceBar);
            }
            System.out.println();
        }

        // final winner
        int maxDistance = Collections.max(cars.values());
        List<String> winnerCars = new ArrayList<>();

        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == maxDistance) {
                winnerCars.add(car.getKey());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerCars));
    }
}
