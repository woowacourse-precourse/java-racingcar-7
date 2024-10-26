package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {
    public static Map<String, Integer> inputCarName() {
        String carsName = Console.readLine();
        return splitInputCar(carsName);
    }

    public static int inputTryNumber() {
        int tryNumber = Integer.parseInt(Console.readLine());
        return tryNumber;
    }

    public static Map<String, Integer> splitInputCar(String carsName) {
        Map<String, Integer> cars = Arrays.stream(carsName.split(",")).collect(Collectors.toMap(s -> s, s -> 0));
        return cars;
    }
}
