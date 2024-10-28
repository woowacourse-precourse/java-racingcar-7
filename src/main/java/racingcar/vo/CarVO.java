package racingcar.vo;

import camp.nextstep.edu.missionutils.Randoms;

public class CarVO {
    private static final int START_RANDOM_INT = 0;
    private static final int END_RANDOM_INT = 9;
    private static final int MOVE_TRIGGER_INT = 4;

    private final String carName;
    private int position;

    public CarVO(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomInt = Randoms.pickNumberInRange(START_RANDOM_INT, END_RANDOM_INT);
        if(randomInt >= MOVE_TRIGGER_INT) {
            ++position;
        }
    }

    // 현재 상태를 문자열로 반환하는 메서드
    public String getCurrentState() {
        // 이동 거리를 '-'로 표현
        StringBuilder state = new StringBuilder(carName + " : ");
        for (int i = 0; i < position; i++) {
            state.append("-");
        }
        return state.toString();
    }
}
