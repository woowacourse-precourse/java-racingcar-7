package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {


    public int makeNumber(){
        int number = Randoms.pickNumberInRange(0,9);
        return number;
    }


}
