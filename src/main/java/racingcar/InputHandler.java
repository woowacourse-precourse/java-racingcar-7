package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputHandler {
    public List<Car> getCarName() {
        String inputCarName = Console.readLine();
        return Arrays.stream(inputCarName.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public int getAttemtNumber() {
        String inputNumber = Console.readLine();
        return Integer.parseInt(inputNumber);
    }

}
