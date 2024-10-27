package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_MOVE_COUNT = 0;
    public String[] getCarNames() {
        return Console.readLine().split(",");
    }
    public int getMoveCnt() {
        return Integer.parseInt(Console.readLine());
    }
    public void validCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_CAR_NAME_LENGTH) throw new IllegalArgumentException();
            if (name.equals("")) throw new IllegalArgumentException();
        }
    }
    public void validMoveCnt(int moveCount) {
        if (moveCount < MIN_MOVE_COUNT) throw new IllegalArgumentException();
    }
}
