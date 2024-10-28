package racingcar.obj;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int distance;
    private final StringBuilder sb;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        sb = new StringBuilder();
    }

    public void startRace() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance++;
            sb.append("-");
        }
        System.out.println(name + " : " + sb);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
