package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> readNamesInput(){
        String nameInput = Console.readLine();
        List<String> carnames = Arrays.asList(nameInput.split(","));
        return carnames;
    }

    public static int readMoveNumInput(){
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // 예외 발생
        }
    }
}
