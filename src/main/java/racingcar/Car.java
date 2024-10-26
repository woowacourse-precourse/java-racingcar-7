package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car (String name) {
        this.name = name;
        this.position = 0;
        // TODO: 자동차 이름 검증
    }

    public void tryMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
