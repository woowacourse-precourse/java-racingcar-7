package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int distance;

    protected Car(String name) {
        this.name = name;
        distance = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void moveCar() {
        // Random에 대한 테스트는 어떻게 진행해야 하는가?
        // 테스트를 위해서 생성자를 따로 열어두어야 하는가?
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++;
        }
    }

    public String getCarname() {
        return name;
    }

    public Integer getCarDistance() {
        return distance;
    }
}
