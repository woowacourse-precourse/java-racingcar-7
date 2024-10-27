package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.InputParser;
import racingcar.utils.InputValidator;

public class InputView {
    public static final String SEPARATOR = ",";
    public static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView(){
    }

    public static List<String> getCarNames() {

        System.out.println(INPUT_MESSAGE);

        String input = Console.readLine();
        InputValidator.nameValidator(input);

        return InputParser.getNames(input);
    }

}
