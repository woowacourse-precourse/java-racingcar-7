package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomNumber {

    static int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
