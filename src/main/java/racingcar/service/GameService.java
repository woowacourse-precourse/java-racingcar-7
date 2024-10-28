package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    private GameService() {}

    // 0 ~ 9 사이의 난수를 발생시킨다
    public static double makeRandNumberZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 발생된 난수를 매개변수로 받아 4 이상이라면 true 를 반환하여 자동차가 움직일 수 있음을 알린다
    public static boolean isAbleToMove(double randomNumber) {
        return randomNumber >= 4;
    }
}