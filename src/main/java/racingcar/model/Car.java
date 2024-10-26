package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public void go() {
        int randomResult = Randoms.pickNumberInRange(0, 9);
        if (randomResult >= 4) {
            location++;
        }

        System.out.println(getName() + " : " + locationToString());
    }

    public int getLocation() {
        return location;
    }

    public String locationToString() {
        StringBuilder location = new StringBuilder();
        for (int i = 0; i < this.location; i++) {
            location.append("-");
        }
        return location.toString();
    }

    public String getName() {
        return name;
    }
}
