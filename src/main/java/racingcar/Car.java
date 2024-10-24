package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void roleDice(int min, int max) {
        int num = pickNumberInRange(min, max);

        if (isForward(num)) {
            this.position++;
        }
    }

    private boolean isForward(int num) {
        return  num >= RaceManager.MIN_FORWARD_NUM;
    }
}
