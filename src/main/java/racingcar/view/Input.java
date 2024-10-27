package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readNames() {
        return Console.readLine();
    }

    public int readCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
