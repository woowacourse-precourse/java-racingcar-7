package racingcar.view;

import static racingcar.Validator.validateEmptyOrZeroTryCount;
import static racingcar.Validator.validateEmptyString;
import static racingcar.Validator.validateNameFormat;
import static racingcar.Validator.validateNameLength;
import static racingcar.Validator.validateNotNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class InputView {
    public static List<Car> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateEmptyString(carNames);

        List<Car> cars = splitCarNames(carNames);
        return cars;
    }

    private static List<Car> splitCarNames(String carNames) {
        List<String> splitNames = Arrays.asList(carNames.split(","));

        List<Car> cars = new ArrayList<>();
        for (String inputname : splitNames) {
            inputname = inputname.trim();
            validateNameFormat(inputname);
            validateNameLength(inputname);
            Car car = new Car(inputname);
            cars.add(car);
        }
        return cars;
    }
    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        validateEmptyOrZeroTryCount(tryCount);
        validateNotNumber(tryCount);

        int inputTryCount = Integer.parseInt(tryCount);
        return inputTryCount;
    }
}
