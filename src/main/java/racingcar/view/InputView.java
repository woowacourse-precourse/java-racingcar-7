package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readLine() {
        return Console.readLine();
    }
    public void close(){
        Console.close();
    }
}