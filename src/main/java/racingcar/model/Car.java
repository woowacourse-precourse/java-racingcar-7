package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String SYMBOL = "-";

    private final String name;
    private int distance = 0;
    private StringBuilder sb = new StringBuilder();


    public Car(String name) {
        if (validateName(name)) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getSymbol() {
        return sb.toString();
    }

    public void drive() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            distance += 1;
            sb.append(SYMBOL);
        }
    }


    private boolean validateName(String name) {
        return name == null || name.trim().isEmpty() || name.length() >= 5;
    }
}
