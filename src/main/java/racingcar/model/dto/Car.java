package racingcar.model.dto;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        setName(name);
        setDistance(distance);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        int nameLength = name.length();

        if (nameLength == 0 || nameLength > 5) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
        }

        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
        }

        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
