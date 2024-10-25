package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public ArrayList<String> readCarNames(){
        String input = Console.readLine();
        validator.checkCarNameInput(input);
        String[] carNames = input.split(",");

        return Arrays.stream(carNames).collect(Collectors.toCollection(ArrayList::new));
    }

    public int readAttempts(){
        String input = Console.readLine();
        validator.checkAttemptInput(input);
        return Integer.parseInt(input);
    }
    
}
