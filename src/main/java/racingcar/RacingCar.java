package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingCar{

    private String carName;
    private int record;

    public RacingCar(String carName){
        this.carName = carName;
        record = 0;
    }
    public void race() {
        int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        if(randomNumber < 4)
            return;
        ++record;
    }
}
