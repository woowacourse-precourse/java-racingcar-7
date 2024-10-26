package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public List<String> inputName(){
        String input = Console.readLine();
        String[] inputs = input.split(",");
        List<String> inputList;
        inputList = List.of(inputs);

        return inputList;
    }

}
