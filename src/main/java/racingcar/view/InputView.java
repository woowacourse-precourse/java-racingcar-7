package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.GameException;

public class InputView {
    private final GameException gameException = new GameException();

    private static final String carDelimiter = ",";

    public List<String> inputCars() {
        try {
            String input = Console.readLine();
            List<String> splitCar = List.of(input.split(carDelimiter, -1));
            gameException.validateCar(splitCar);
            return splitCar;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    public int inputTryCount() {
        try {
            String input = Console.readLine();
            gameException.validateTryCount(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }
}
