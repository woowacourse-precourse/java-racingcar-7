package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
    public int Generate_RandomValue(){
        return Randoms.pickNumberInRange(0,9);
    }


}
