package io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public String getInputCarName() {
        return readLine();
    }

    public int getInputRacingCount() {
        String stringCount = readLine();
        int intCount = Integer.parseInt(stringCount);

        if (intCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수 이여야합니다.");
        }

        return intCount;
    }
}
