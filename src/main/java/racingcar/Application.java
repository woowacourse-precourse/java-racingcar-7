package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsNameInput = Console.readLine();

        String[] carsNameArray = parseCarsName(carsNameInput);
        List<String> carsNameList = arrayToList(carsNameArray);
        List<String> trimmedCarsNameList = carsNameTrim(carsNameList);

        validateCarsName(trimmedCarsNameList);
    }

    private static String[] parseCarsName(String carInput) {
        return carInput.split(",");
    }

    private static List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }

    private static List<String> carsNameTrim(List<String> cars) {
        List<String> trimmedCarsName = new ArrayList<>();
        for (String car : cars) {
            trimmedCarsName.add(car.trim());
        }
        return trimmedCarsName;
    }

    private static void validateCarsName(List<String> trimmedCarsNameList) {
        for (String carName : trimmedCarsNameList) {
            // 공백, 빈값
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
