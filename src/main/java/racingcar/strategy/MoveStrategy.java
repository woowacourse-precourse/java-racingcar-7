package racingcar.strategy;


import camp.nextstep.edu.missionutils.Randoms;

public class MoveStrategy implements  Strategy{

    @Override
    public int random() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
