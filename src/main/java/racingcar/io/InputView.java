package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNameText() {
        return Console.readLine();
    }

    public int readNumberOfTimes() {
        String numberOfTimes = Console.readLine();
        validate(numberOfTimes);

        return Integer.parseInt(numberOfTimes);
    }

    private void validate(String numberOfTimes) {
        try {
            Integer.parseInt(numberOfTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(numberOfTimes) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
