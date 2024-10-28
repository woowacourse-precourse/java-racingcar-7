package racingcar.domain;

import java.util.List;

public class Car {
    private String carName;
    private int count;

    public Car( String carName) {

        if (carName.length() > 5) throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        this.carName = carName;
        this.count = 0;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) count++;
    }

    public String getName() {
        return carName;
    }
    public int getCount() {
        return count;
    }



}
