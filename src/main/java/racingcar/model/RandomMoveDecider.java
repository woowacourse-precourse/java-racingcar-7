package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMoveDecider implements MoveDecider {
    private static final int MOVE_THRESHOLD = 4;
    private static final List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final RandomMoveDecider INSTANCE = new RandomMoveDecider();

    private RandomMoveDecider() {
    }

    public RandomMoveDecider getInstance() {
        return INSTANCE;
    }

    public boolean canMove() {
        int randomNumber = Randoms.pickNumberInList(numbers);
        return randomNumber >= MOVE_THRESHOLD;
    }
}
