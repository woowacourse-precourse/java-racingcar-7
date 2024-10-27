package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.IOMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.constant.IOMessage.COUNT_INPUT_MESSAGE;

public class InputHandler {

    private static final Validator validator = new Validator();

    public int inputCount() {
        try {
            String input = getInput(COUNT_INPUT_MESSAGE);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<String> inputCarName() {
        String input = getInput(CAR_NAME_INPUT_MESSAGE);
        List<String> carNameList = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validator.validateCarNames(carNameList);
        return carNameList;
    }

    private String getInput(String message) {
        System.out.println(message);
        return Console.readLine().trim();
    }
}