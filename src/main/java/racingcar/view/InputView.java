package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Car;

public class InputView {
    public static List<Car> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateEmptyString(carNames);

        List<String> splitNames = Arrays.asList(carNames.split(","));

        List<Car> cars = new ArrayList<>();
        for (String inputname : splitNames) {
            inputname = inputname.trim();
            validateNameLength(inputname);
            Car car = new Car(inputname);
            cars.add(car);
        }
        return cars;
    }

    private static void validateNameLength(String inputname) {
        if (inputname.length() > 5) {
            throw new IllegalArgumentException("5글자 이하의 이름만 입력할 수 있습니다.");
        }
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        validateEmptyString(tryCount);

        int inputTryCount = Integer.parseInt(tryCount);
        return inputTryCount;
    }

    private static void validateEmptyString(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하셨습니다");
        }
    }
}
