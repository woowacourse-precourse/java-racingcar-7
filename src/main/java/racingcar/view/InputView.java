package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String input(){
        return Console.readLine();
    }

    public int IntInput(){
        return Integer.parseInt(input());
    }
}
