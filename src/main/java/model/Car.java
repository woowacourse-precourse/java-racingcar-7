package model;

public class Car {
    private String name;
    private int position;


    public Car(String name) {
        this.name = name;
        this.position = 0;
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