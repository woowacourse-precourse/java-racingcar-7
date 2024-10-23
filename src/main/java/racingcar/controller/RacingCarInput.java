package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ExceptionMessage;

import java.util.List;
import java.util.NoSuchElementException;

public class RacingCarInput {

    private static final String INPUT_NAME_MESSAGE = "자동차 이름을 입력해 주세요. 쉼표로 구분 합니다. : ";
    private static final String INPUT_NUMBER_MESSAGE = "이동할 횟수를 입력해 주세요. : ";

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
