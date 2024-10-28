package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class MoveResults {
    private final List<Boolean> moveResults = new ArrayList<>();

    public void add(Boolean isMove) {
        moveResults.add(isMove);
    }

    public int getPosition() {
        return getPositionAtSpecificCount(moveResults.size() - 1);
    }

    public int getPositionAtSpecificCount(int count) {
        int position = 0;
        for (int index = 0; index <= count; index++) {
            if (moveResults.get(index)) {
                position++;
            }
        }
        return position;
    }
}
