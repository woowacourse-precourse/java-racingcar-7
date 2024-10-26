package racingcar.domain;


import static racingcar.domain.StringConstant.*;

public class Car {

    public static final int THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 등록 해야합니다.");
        }
    }

    public void moveForwardIfDigitAboveThreshold(int digit) {
        if (digit < THRESHOLD) {
            return;
        }
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public void printPosition() {
        System.out.printf("%s : %s", name, POSITION_MARK.getValue().repeat(position));
        System.out.println();
    }
}