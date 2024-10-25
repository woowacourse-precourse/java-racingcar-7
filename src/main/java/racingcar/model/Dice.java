package racingcar.model;
import camp.nextstep.edu.missionutils.Randoms;

public class Dice {

    public Dice() {
    }

    public int roll() {
        // 1부터 6까지의 무작위 값 생성
        return Randoms.pickNumberInRange(1, 6);
    }
}
