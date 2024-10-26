package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCarNames(){
        System.out.println(ConsoleMessage.INPUT_CARS_Names);
        String Input = Console.readLine();

        return Arrays.asList(Input.split(","));

    }

}

enum ConsoleMessage{
    INPUT_CARS_Names("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    private String message;
    ConsoleMessage(String message) {
        this.message = message;
    }

}
