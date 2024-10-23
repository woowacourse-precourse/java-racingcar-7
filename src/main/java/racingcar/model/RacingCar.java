package racingcar.model;

import static racingcar.util.Validator.validateOneName;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<Integer> moveRecords = new ArrayList<>();
    private String name;
    private int moveCount;

    public RacingCar(String name) {
        validateNameLength(name);
    }
    private void validateNameLength(String name) {
        validateOneName(name);
        this.name = name;
    }

    public void moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4) {
            moveCount++;
        }
        moveRecords.add(moveCount);
    }

    public String getName() {
        return name;
    }

    public int getCurrentMoveCount(int currentTrial) {
        int index = currentTrial-1;
        return moveRecords.get(index);
    }
}
