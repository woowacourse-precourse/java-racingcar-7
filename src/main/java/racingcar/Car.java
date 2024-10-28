package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void moveOnceRandom() {
        int num = Randoms.pickNumberInRange(0, 9);

        if (num > 4) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getNameAndLocation() {
        String returnStr = name + " : ";
        for (int i = 0; i < location; i++) {
            returnStr += "-";
        }
        return returnStr;
    }
}
