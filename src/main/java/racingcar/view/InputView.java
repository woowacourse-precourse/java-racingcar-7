package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.InputParser;
import racingcar.utils.InputValidator;

public class InputView {
    public static final String SEPARATOR = ",";

    private InputView(){
    }

    public static List<String> getName() {

        System.out.println("~~~");
        String input = Console.readLine();
        InputValidator.nameValidator(input);

       return InputParser.getNames(input);
    }
}
