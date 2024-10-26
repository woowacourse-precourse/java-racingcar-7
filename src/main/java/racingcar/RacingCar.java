package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedWriter;

/**
 * carRace 에 참가하는 개별 자동차객체
 */
public class RacingCar {
    private static final String DISTANCE_CHAR = "-";
    private final String carName;
    private int carDistance;

    private void move() {
        carDistance++;
    }

    /**
     * 자동차의 한 라운드를 시뮬레이션 하는 함수
     */
    public void simulateRound() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (randomNum < 4)
            return ;
        move();
    }

    /**
     * racing car 의 현재상태를 리턴하는 함수
     * @return 출력해야되는 현재상태
     */
    public String getCurrentState() {
        return carName
                + " : "
                + DISTANCE_CHAR.repeat(carDistance);
    }


    public RacingCar(String carName) {
        this.carName = carName;
        carDistance = 0;
    }
}
