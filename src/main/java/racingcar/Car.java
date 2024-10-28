package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name;
    }
}