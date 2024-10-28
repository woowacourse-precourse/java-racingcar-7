package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String racingCount;

    public String getName() {
        return name;
    }

    public String getRacingCount() {
        return racingCount;
    }

    public Car(String name) {
        this.name = name;
        this.racingCount = "";
    }

    private void addCount() {
        racingCount += "-";
    }

    public void checkForward() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            addCount();
        }
    }
}
