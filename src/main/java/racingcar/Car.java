package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private Long distance;

    public Car(String name) {
        this.name = name;
        distance = 0L;
    }

    public Long getDistance() {
        return distance;
    }

    public void updateDistance() {
        if (isCarMove()) {
            distance++;
        }
    }

    public boolean isCarMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");

        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }

        sb.append("\n");
        return sb.toString();
    }
}
