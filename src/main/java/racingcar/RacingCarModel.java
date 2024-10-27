package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarModel {
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
