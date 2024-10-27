package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constants.Constants.Messages;

public class InputView {
    public static void printInputCarname(){
        System.out.println(Messages.INPUT_CARNAME);
    }

    public static void printInputCount(){
        System.out.println(Messages.INPUT_COUNT);
    }

    public static void checkInput(List<String> input) {
        if (input.isEmpty() || (input.size() == 1 && input.getFirst().isEmpty())){
            throw new IllegalArgumentException(Messages.NO_INPUT_ERROR);
        }
        for (String carName : input) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(Messages.INPUT_LENGTH_ERROR);
            }
        }
    }

    public static List<String> readCarNames() {
        printInputCarname();
        List<String> carNames = java.util.List.of(Console.readLine().split(","));
        checkInput(carNames);
        return carNames;
    }

    public static int readCount(){
        printInputCount();
        return Integer.parseInt(Console.readLine());
    }
}
