package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CarMovement {

    public static void moveCarsForward(List<Integer> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);

            if (randomNum >= 4) {
                carPositions.set(i, carPositions.get(i) + 1);  // 전진 거리 증가
            }
        }
    }
}
