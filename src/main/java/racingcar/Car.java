package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public String name;
    int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void drive() {
        int randomNum;

        randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            distance++;
            return;
        }
        this.stop();
    }

    public void stop() {
        return;
    }

}
