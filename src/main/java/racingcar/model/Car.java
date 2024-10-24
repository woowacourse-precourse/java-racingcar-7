package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) { // 조건: 4 이상일 경우 전진
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
