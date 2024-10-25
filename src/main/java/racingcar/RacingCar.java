package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String carName;
    private int carDistance;

    /**
     * 자동차의 한 라운드를 시뮬레이션 하는 함수
     */
    public void simulateRound() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (randomNum < 4)
            return ;
        carDistance++;
    }

    public RacingCar(String carName) {
        this.carName = carName;
        carDistance = 0;
    }
}
