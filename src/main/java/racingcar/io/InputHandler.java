package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String[] getCarNames() {
        String inputString = Console.readLine();
        return getCarNamesArray(inputString);
    }

    private String[] getCarNamesArray(String inputString) {
        return inputString.split(",");
    }

    public int getTryNum() {
        String tryNum = Console.readLine();
        return Integer.parseInt(tryNum);
    }
}
