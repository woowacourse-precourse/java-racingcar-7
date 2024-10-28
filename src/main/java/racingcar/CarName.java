package racingcar;

public class CarName {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5이하여야 하고 비어있으면 안됩니다.");
        }
        this.name = name;
    }

    public void print() {
        System.out.print(name);
    }
}
