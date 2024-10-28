package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private String name;
    private StringBuilder position;

    public Car(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position.toString();
    }

    public int getPositionLength() {
        return position.length();
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position.append("-");
        }
    }
}
