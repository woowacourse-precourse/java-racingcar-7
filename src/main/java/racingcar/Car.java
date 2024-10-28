package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자 이상입니다.");
        }
    }
}
