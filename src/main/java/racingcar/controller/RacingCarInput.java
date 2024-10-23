package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

public class RacingCarInput {

    private static final String INPUT_NAME_MESSAGE = "자동차 이름을 입력해 주세요. 쉼표로 구분 합니다. : ";
    private static final String INPUT_NUMBER_MESSAGE = "이동할 횟수를 입력해 주세요. : ";

    public List<String> getUserInput() {
        System.out.println(INPUT_NAME_MESSAGE);
        String nameStr = Console.readLine();

        System.out.println(INPUT_NUMBER_MESSAGE);
        String numberStr;
        try {
            numberStr = Console.readLine();
        } catch (NoSuchElementException e) {
            Console.close();
            numberStr = Console.readLine();
        } finally {
            Console.close();
        }


        return List.of(nameStr, numberStr);
    }

}
