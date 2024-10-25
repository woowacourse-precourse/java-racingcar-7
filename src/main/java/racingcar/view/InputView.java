package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String input;


    public String getInput() {
        return input;
    }

    public void saveInput(){
        input = Console.readLine();
    }
}
