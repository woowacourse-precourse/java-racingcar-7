package model;

public class Car {
    private String name;
    private int position;
    private boolean isStopped;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.isStopped = true;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
        isStopped = false;
    }

    public void stop() {
        isStopped = true;
    }

    // 현재 상태를 확인
    public boolean isStopped() {
        return isStopped;
    }

    @Override
    public String toString() {
        return name;
    }

}