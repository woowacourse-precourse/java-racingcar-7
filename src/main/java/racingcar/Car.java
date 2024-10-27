package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location = 0;

    Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void go() {
        int random_num = Randoms.pickNumberInRange(0, 9);
        if (random_num >= 4) {
            location++;
        }
    }

    public void printLocation() {
        String status = "";
        for (int i = 0; i < location; i++) {
            status += "-";
        }
        System.out.print(status);

    }
}
