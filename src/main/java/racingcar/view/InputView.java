package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarString() {
        String carString = Console.readLine();
        if (carString == null) {
            throw new IllegalArgumentException();
        }
        return carString;
    }

    public String readTryCount() {
        String tryCount = Console.readLine();
        if (tryCount == null) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(tryCount);
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return tryCount;
    }
}
