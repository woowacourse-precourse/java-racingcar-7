package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceManager {  // raceCount만큼 반복
    public boolean isCarMoving() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= 4;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
