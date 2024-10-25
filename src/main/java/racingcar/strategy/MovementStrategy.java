package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementStrategy implements CarStrategy {
    @Override
    public boolean move() {
        //자동차 이동 로직 구현
        //랜덤 수가 4이상이면 true 반환
        return true;
    }

    public Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
