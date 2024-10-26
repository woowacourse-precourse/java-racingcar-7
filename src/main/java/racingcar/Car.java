package racingcar;

public class Car {
    public Car(String name) {
        if (isInvalid(name)) {
            throw new IllegalArgumentException("이름의 길이는 6을 넘길 수 없습니다.");
        }
    }

    private boolean isInvalid(String name) {
        return isBlank(name) || isTooLong(name);
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private boolean isTooLong(String name) {
        return 6 <= name.length();
    }
}
