package model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }


    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }
}
