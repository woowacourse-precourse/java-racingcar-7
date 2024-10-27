package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String carDelimiter = ",";

    public List<String> inputCars() {
        try {
            String input = Console.readLine();
            return List.of(input.split(carDelimiter));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCars();
        }
    }

    public int inputTryCount() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }
}
