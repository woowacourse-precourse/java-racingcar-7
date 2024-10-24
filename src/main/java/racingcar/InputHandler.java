package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String[] getCarNames() {
        return Console.readLine().split(",");
    }
    public int getMoveCnt() {
        return Integer.parseInt(Console.readLine());
    }
    public void validCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) throw new IllegalArgumentException();
        }
    }
    public void validMoveCnt(int moveCount) {
        if (moveCount < 0) throw new IllegalArgumentException();
    }
}
