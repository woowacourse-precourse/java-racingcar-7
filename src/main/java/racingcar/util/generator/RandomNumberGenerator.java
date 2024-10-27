package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    final static int MIN_RANDOM_NUMBER = 0;
    final static int MAX_RANDOM_NUMBER = 9;
    public int generateNumber(){
        int number = Randoms.pickNumberInRange(0, 9);
        validateRandomNumber(number);
        return number;
    }

    private void validateRandomNumber(int number){
        if(number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER){
            throw new IllegalArgumentException("허용되지 않은 랜덤한 숫자 범위입니다.");
        }
    }
}
