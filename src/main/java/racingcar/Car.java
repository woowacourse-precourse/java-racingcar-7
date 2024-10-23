package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다: " + name);
        }
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    // 현재 위치 반환
    public int getPosition() {
        return position;
    }

    // 자동차 이름 반환
    public String getName() {
        return name;
    }

}
