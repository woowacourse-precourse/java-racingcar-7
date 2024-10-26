package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validation;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {
    public static Map<String, Integer> inputCarName() {
        String carsName = Console.readLine();
        Validation.inputBlank(carsName);
        return splitInputCar(carsName);
    }

    public static int inputTryNumber() {
        int tryNumber = Integer.parseInt(Console.readLine());
        Validation.tryNumberRange(tryNumber);
        return tryNumber;
    }

    public static Map<String, Integer> splitInputCar(String carsName) {
        Map<String, Integer> cars = new LinkedHashMap<>();
        cars = Arrays.stream(carsName.split(",")).collect(Collectors.toMap(s -> s, s -> 0));
        Validation.inputBlank(carsName);
        Validation.carNameLimit(cars);
        return cars;
    }
}
