package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public static InputDTO receiveValidateInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerInput = Console.readLine();
        int round = Integer.parseInt(Console.readLine());

        InputDTO inputDTO = new InputDTO(splitInput(playerInput), round);
        CheckValidInput.isValidInput(inputDTO);

        return inputDTO;
    }

    public static List<String> splitInput(final String input) {
        return Arrays.asList(input.split(","));
    }


}