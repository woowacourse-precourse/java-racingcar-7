package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (!name.matches("[A-Za-z]{1,5}")) {
            throw new IllegalArgumentException("자동차 이름은 영어로 된 1자에서 5자 이내여야 합니다: " + name);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String displayPosition() {
        return "-".repeat(position);
    }

}
