package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car implements Vehicle {
    private String name;
    private int location;

    @Override
    public void move() {
        if (pickNumberInRange(0, 9) >= 4) {
            moveLocation();
        }
    }

    private void moveLocation() {
        location++;
    }

    public void printLocation() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());
        sb.append(" : ");
        for (int i = 0; i < location; i++) {
            sb.append('-');
        }
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
