package model;

public class Car {
    private String name;
    private int position;


    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }


    public String getName() {
        return name;
    }

    public String getPositionStatus() {
        return name + " : " + "-".repeat(position);  // 위치에 따라 '-' 반복
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    public void stop() {
        // 현재 아무 동작도 하지 않음
    }

    @Override
    public String toString() {
        return name;
    }

}