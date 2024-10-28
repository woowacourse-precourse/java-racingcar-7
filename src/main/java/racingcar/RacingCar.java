package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * carRace 에 참가하는 개별 자동차객체
 */
public class RacingCar {
    private static final String DISTANCE_CHAR = "-";
    private final String name;
    private int traveledDistance;

    private void move() {
        traveledDistance++;
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
        return name
                + " : "
                + DISTANCE_CHAR.repeat(traveledDistance);
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public String getName() {
        return name;
    }

    public RacingCar(String name) {
        this.name = name;
        traveledDistance = 0;
    }
}
