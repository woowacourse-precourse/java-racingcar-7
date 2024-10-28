package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingController {

    static int racingCounter = InputOutputHandler.getRacingCounter();

    public static ArrayList<Boolean> setMoveCondition() {
        ArrayList<Boolean> moveCondition = new ArrayList<Boolean>();
        for (int i = 0; i < racingCounter; i++) {
            moveCondition.add(Randoms.pickNumberInRange(0, 9) >= 4);
        }
        return moveCondition;
    }
}
