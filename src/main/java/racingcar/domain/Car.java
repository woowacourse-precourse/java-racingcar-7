package racingcar.domain;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 없거나 공백일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move() {
        location++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(location);
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
