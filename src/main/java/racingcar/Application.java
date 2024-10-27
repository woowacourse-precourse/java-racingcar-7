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
            // TODO: validate more
            cars.put(carName, 0);
        }

        // Temporary output
        System.out.println(cars);

        // TODO: Process iterationNumberRaw

        // TODO: Roll and output middle results

        // TODO: Output final winner
    }
}
