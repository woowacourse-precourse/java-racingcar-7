package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
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
                throw new IllegalArgumentException("[ERROR] Length limit(5) exceeded: \"" + carName + "\"");
            }
            // scenario 3: blank name provided
            if (carName.isEmpty()) {
                continue;
            }
            // scenario 4: duplicated name provided
            if (cars.containsKey(carName)) {
                throw new IllegalArgumentException("[ERROR] Duplicated name: \"" + carName + "\"");
            }
            cars.put(carName, 0);
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Nobody is in game");
        }

        // input iterations
        System.out.println("시도할 횟수는 몇 회인가요?");
        String iterationNumberRaw = Console.readLine();
        iterationNumberRaw = iterationNumberRaw.strip();
        int iterationNumber;
        try {
            iterationNumber = Integer.parseInt(iterationNumberRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Failed to parse \"" + iterationNumberRaw + "\" into integer.");
        }
        if (iterationNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] You must enter positive integer.");
        }

        // Temporary output
        System.out.println(cars);
        System.out.println(iterationNumber);

        // TODO: Process iterationNumberRaw

        // TODO: Roll and output middle results

        // TODO: Output final winner
    }
}
