package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void attemptMove() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name
                + " : "
                + "-".repeat(position)
                + "\n";
    }

    public int getPosition() {
        return position;
    }
}
