package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        validateName(name);
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance++;
        }
    }

    public void showRaceProgress() {
        System.out.print(name + " : ");

        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
