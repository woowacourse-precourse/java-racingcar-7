package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;
    private final StringBuilder displayPosition;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.displayPosition = new StringBuilder(getName()).append(" : ");
    }

    public void move() {
        if (generateRandomNumber() >= 4) {
            this.position++;
            updateDisplayPosition();
        }
    }

    // 이동의 기준이 되는 랜덤 넘버 생성
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getDisplayPosition() {
        return displayPosition.toString();
    }

    private void updateDisplayPosition() {
        displayPosition.append("-");
    }
}
