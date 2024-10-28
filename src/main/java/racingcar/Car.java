package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int distance;

    public Car(String carName) {
        this.carName = carName;
        isValidCarName();
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void print() {
        System.out.println(getCarName() + " : " + getDistanceAsDash());
    }

    private String getDistanceAsDash() {
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            dash.append("-");
        }
        return dash.toString();
    }

    public void goStraight() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", distance=" + distance +
                '}';
    }

    private void isValidCarName() {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(carName + "차의 이름이 5글자를 넘어갑니다.");
        }
    }
}
