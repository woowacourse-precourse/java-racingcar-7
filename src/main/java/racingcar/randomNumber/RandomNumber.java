package racingcar.randomNumber;

import camp.nextstep.edu.missionutils.Randoms;
public class RandomNumber {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    public RandomNumber(){
    }

    public int randomNumberGenerator(){
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

}