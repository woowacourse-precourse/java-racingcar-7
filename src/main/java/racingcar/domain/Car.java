package racingcar.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        validateNameLengthUnderSix(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateNameLengthUnderSix(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
