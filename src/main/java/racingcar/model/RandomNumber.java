package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    static int randomNumber (){
         return Randoms.pickNumberInRange(0,9);
    }
}
