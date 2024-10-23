package model;

public class Car {
    private String name;
    private int position;


    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(String name) {
        position++;
    }

    public void stop() {
        // 현재 아무 동작도 하지 않음
    }

}