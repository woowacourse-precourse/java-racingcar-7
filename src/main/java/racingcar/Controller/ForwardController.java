package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;

public class ForwardController {
    private final String name;
    private int position;

    public ForwardController(String name) {
        this.name = name;
        this.position = 0;
    }

    // 4 이상일 경우 전진
    public void move() {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
