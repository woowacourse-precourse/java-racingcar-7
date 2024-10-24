package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsNameInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String countInput = Console.readLine();

        String[] carsNameArray = parseCarsName(carsNameInput);
        List<String> carsNameList = arrayToList(carsNameArray);
        List<String> trimmedCarsNameList = carsNameTrim(carsNameList);

        validateCarsName(trimmedCarsNameList);

        validateCount(countInput);
        int count = parseInt(countInput);
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
        List<String> existCarsNameList = new ArrayList<>();
        for (String carName : trimmedCarsNameList) {
            // 공백, 빈값
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }

            // 이름에 공백
            if (carName.contains(" ")) {
                throw new IllegalArgumentException();
            }

            // 5글자 초과
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            // 중복일 때
            if (existCarsNameList.contains(carName)) {
                throw new IllegalArgumentException();
            }

            existCarsNameList.add(carName);
        }

        // 자동차 1대 이하일 때
        if (existCarsNameList.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 엄청 큰 숫자가 들어왔을 때도 고려
    private static int parseInt(String string) {
        return Integer.parseInt(string);
    }

    private static void validateCount(String countInput) {
        try {
            Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(countInput) < 1) {
            throw new IllegalArgumentException();
        }
    }
}
