package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final int MAXIMUM_COUNT = 10;

    public String readNames() {
        return Console.readLine();
    }

    public int readCount() {
        try {
            int count = Integer.parseInt(Console.readLine());
            if (count > MAXIMUM_COUNT) {
                throw new IllegalArgumentException();
            }
            return count;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
