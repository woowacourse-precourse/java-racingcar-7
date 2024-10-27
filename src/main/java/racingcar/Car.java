package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * Car
 */
public class Car {

    private String name;
    private int progress;

    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException();
        this.name = name;
    }

    public void moveOrStop() {
        int randomNumber = pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            progress += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }
}
