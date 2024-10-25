package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ExceptionMessage;

import java.util.List;
import java.util.NoSuchElementException;

public class RacingCarInput {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> getUserInput() {
        try {
            System.out.println(INPUT_NAME_MESSAGE);
            String nameString = Console.readLine().trim();

            System.out.println(INPUT_NUMBER_MESSAGE);
            String numberString = Console.readLine().trim();

            Validator.validateUserInput(List.of(nameString, numberString));

            return List.of(nameString, numberString);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_INPUTS.getMessage());
        } finally {
            Console.close();
        }
    }

}
