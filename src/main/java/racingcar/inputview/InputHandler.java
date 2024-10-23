package racingcar.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String[] split(String input){
        return input.split(",");
    }

    public int getAttemptGameCount() {
        return Integer.parseInt(Console.readLine());
    }
}
