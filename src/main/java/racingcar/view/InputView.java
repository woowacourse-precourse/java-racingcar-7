package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        return Console.readLine();
    }

    public static int getNumberOfMoves() {
        int moves = Integer.parseInt(Console.readLine());
        if (moves <= 0) {
            throw new IllegalArgumentException();
        }
        return moves;
    }
}
