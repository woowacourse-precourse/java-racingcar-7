package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

import static racingcar.message.ErrorMessage.*;

public class NameRequestHandler {

    public String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawInput = Console.readLine();
        validateBlank(rawInput);
        validateSpace(rawInput);
        String[] rawNames = rawInput.split(",");
        validateNames(rawNames);
        return rawNames;
    }


    public void validateBlank(String rawInput) {
        if (rawInput == null || rawInput.isBlank()) {
            String errorMessage = BLANK_INPUT_ERROR.getMessage();
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateSpace(String rawInput) {
        if (rawInput.contains(" ")) {
            String errorMessage = CONTAINS_SPACE_ERROR.getMessage();
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validateNames(String[] rawNames) {
        Arrays.stream(rawNames)
                .filter(rawName -> rawName.isEmpty() || rawName.length() > 5)
                .findFirst()
                .ifPresent(invalidName -> {
                    String errorMessage = NAME_LENGTH_ERROR.getMessage();
                    System.out.println(errorMessage);
                    throw new IllegalArgumentException(errorMessage);
                });
    }

}
